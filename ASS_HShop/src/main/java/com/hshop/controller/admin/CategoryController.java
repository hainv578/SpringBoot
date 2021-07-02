package com.hshop.controller.admin;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hshop.dto.CategoryDTO;
import com.hshop.entity.Category;
import com.hshop.service.CategoryService;
import com.hshop.dto.CategoryDTO;
import com.hshop.entity.Category;
import com.hshop.repository.CategoryRepository;
import com.hshop.utils.HashUtil;

@Controller
@RequestMapping("admin/category")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("add")
	public String add(Model model) {
		model.addAttribute("category", new Category());
		return "admin/category/add";
	}
	
	@GetMapping("edit/{categoryId}")
	public ModelAndView edit(ModelMap model, @PathVariable("categoryId") Long categoryId) {
		Optional<Category> opt = categoryService.findById(categoryId);
	
		CategoryDTO dto = new CategoryDTO();
		
		
		if(opt.isPresent()) { //neu có DL sẽ lấy ra và chuyen tu entity -> dto và chuyển sag view
			Category entity = opt.get();
			
			//chuyen DL Từ  entity sag dto 
			BeanUtils.copyProperties(entity, dto);
			
			dto.setIsEdit(true);
			model.addAttribute("catogery", dto);
			
			return new ModelAndView ("admin/category/add",model);
			
		}
		//neu ko có dl se thong bao và trả vè return
		
		model.addAttribute("message", "Category khong ton tai ");
		
		return new ModelAndView ("redirect:/admin/category",model);
	}
	
	@GetMapping("delete/{categoryId}")
	public ModelAndView delete(ModelMap model,
			 @PathVariable("categoryId") Long categoryId) {
		categoryService.deleteById(categoryId);
		model.addAttribute("message", "Xoa thanh cong");
		return new ModelAndView("forward:/admin/category/search",model);
	}
	
	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model,
			@Valid @ModelAttribute("category") CategoryDTO dto , BindingResult result) {
		
		if(result.hasErrors()) {
			
			return new ModelAndView("admin/category/add");
		}
		
		//tạo oj
		Category entity = new Category();
		
		//chuyen DL Từ dto sag entity
		BeanUtils.copyProperties(dto, entity);
		
		categoryService.save(entity);
		
		model.addAttribute("message", "Save thanh cong");
		
		return new ModelAndView ("forward:/admin/category",model);
	}
	
	@RequestMapping("")
	public String list(ModelMap model) {
		List<Category> list= categoryService.findAll();
		model.addAttribute("categories", list);
		return "admin/category/list";
	}
	@GetMapping("search")
	public String search(ModelMap model,
			@RequestParam(name = "name", required = false) String name) {
		
		List<Category> list = null;
		
		if(StringUtils.hasText(name)) {
			list=categoryService.findByNameContaining(name);
		}else {
			list = categoryService.findAll();
			
		}
		model.addAttribute("categories", list);
		return "admin/category/search";
	}
	@GetMapping("searchpaginated")
	public String search(ModelMap model,
			@RequestParam(name = "name", required = false) String name,
			@RequestParam("page") Optional<Integer> page,
			@RequestParam("size") Optional<Integer> size) {
		
		int currentPage = page.orElse(1);
		int pageSize = size.orElse(5);
		
		Pageable pageable = PageRequest.of(currentPage, pageSize,Sort.by("name"));
		Page<Category> resultPage = null;
		
		
		
		if(StringUtils.hasText(name)) {
			resultPage=categoryService.findByNameContaining(name,pageable);
			model.addAttribute("name",name);
		}else {
			resultPage = categoryService.findAll(pageable);
			
		}
		int totalPages = resultPage.getTotalPages();
		if(totalPages>0) {
			int start = Math.max(1, currentPage-2);
			int end = Math.min(currentPage+2,totalPages);

			if(totalPages>5) {
				if(end==totalPages) {
					start = end -5;
				}else if(start == 1){
					end= start+5;
				}
			}
		List<Integer> pageNumbers = IntStream.rangeClosed(start, end)
				.boxed()
				.collect(Collectors.toList());
		model.addAttribute("pageNumbers", pageNumbers);
		}
		
		model.addAttribute("categoryPage", resultPage);
		return "admin/category/searchpaginated";
	}
}
