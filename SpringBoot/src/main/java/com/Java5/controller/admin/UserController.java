package com.Java5.controller.admin;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.SpringVersion;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.Java5.dto.*;
import com.Java5.entity.User;
import com.Java5.mappers.UserMapper;
import com.Java5.repositories.UserRepository;

@Controller
@RequestMapping(value = "/admin/users")
public class UserController {
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private UserMapper mapper;

	@GetMapping()
	public String index(Model model) {
		List<User> listuser = this.userRepo.findAll();
		model.addAttribute("listUser",listuser);
		return "admin/users/index";
	}

	@GetMapping(value = "{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		User entity = this.userRepo.getOne(id);
		UserDto userDTO = mapper.convertToDTO(entity);
		return "admin/users/show";
	}

	@GetMapping(value = "/create")
	public String create() {
		return "admin/users/create";
	}

	@PostMapping(value = "/store")
	public String store() {
		return "redirect:/admin/users";
	}

	@GetMapping(value = "/edit/{id}")
	public String edit(Model model) {
		UserDto user = new UserDto();

		model.addAttribute("user", user);

		System.out.println("Version: " + SpringVersion.getVersion());

		return "admin/users/edit";
	}

	@PostMapping(value = "/update/{id}")
	public String update(Model model, @Valid UserDto user, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println("CO loi");
//			return "redirect:/admin/users/edit/1";

			model.addAttribute("errors", result.getAllErrors());
			return "admin/users/edit";
		} else {
			System.out.println("Khog CO loi");
			return "redirect:/admin/users";
		}

	}

	@PostMapping(value = "/delete/{id}")
	public String delete() {
		return "redirect:/admin/users";
	}
}
