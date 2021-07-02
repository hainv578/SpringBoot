package com.Asg.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.Asg.entities.ChiMucGioHang;
import com.Asg.entities.ChiTietDonHang;
import com.Asg.entities.DonHang;
import com.Asg.entities.GioHang;
import com.Asg.entities.NguoiDung;
import com.Asg.entities.SanPham;
import com.Asg.service.ChiMucGioHangService;
import com.Asg.service.ChiTietDonHangService;
import com.Asg.service.DonHangService;
import com.Asg.service.GioHangService;
import com.Asg.service.NguoiDungService;
import com.Asg.service.SanPhamService;

@Controller
@SessionAttributes("loggedInUser")
public class CheckOutController {
	
	@Autowired
	private SanPhamService sanPhamService;
	@Autowired
	private NguoiDungService nguoiDungService;
	@Autowired
	private GioHangService gioHangService;
	@Autowired
	private ChiMucGioHangService chiMucGioHangService;
	@Autowired
	private DonHangService donHangService;
	@Autowired
	private ChiTietDonHangService chiTietDonHangService;

	@ModelAttribute("loggedInUser")
	public NguoiDung loggedInUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return nguoiDungService.findByEmail(auth.getName());
	}
	
	public NguoiDung getSessionUser(HttpServletRequest request) {
		return (NguoiDung) request.getSession().getAttribute("loggedInUser");
	}
	
	@GetMapping("/checkout")
	public String checkoutPage(HttpServletRequest res,Model model) {
		NguoiDung currentUser = getSessionUser(res);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Map<Long,String> quanity = new HashMap<Long,String>();
		List<SanPham> listsp = new ArrayList<SanPham>();
				
		if(auth == null || auth.getPrincipal() == "anonymousUser")     //Lay tu cookie
		{
			Cookie cl[] = res.getCookies();		
			Set<Long> idList = new HashSet<Long>();
			for(int i=0; i< cl.length; i++)
			{
				if(cl[i].getName().matches("[0-9]+"))
				{
					idList.add(Long.parseLong(cl[i].getName()));
					quanity.put(Long.parseLong(cl[i].getName()), cl[i].getValue());  
				}
				
			}
			listsp = sanPhamService.getAllSanPhamByList(idList);
		}else     //Lay tu database
		{
			GioHang g = gioHangService.getGioHangByNguoiDung(currentUser);
			if(g != null)
			{
				List<ChiMucGioHang> listchimuc = chiMucGioHangService.getChiMucGioHangByGioHang(g);
				
				for(ChiMucGioHang c: listchimuc)
				{
					
					listsp.add(c.getSanPham());
					quanity.put(c.getSanPham().getId(), Integer.toString(c.getSo_luong()));
									
				}
			}
		}
		
		model.addAttribute("cart",listsp);
		model.addAttribute("quanity",quanity);
		model.addAttribute("user", currentUser);
		model.addAttribute("donhang", new DonHang());
		
		return "client/checkout";
	}
	
	@PostMapping(value="/thankyou")
	public String thankyouPage(@ModelAttribute("donhang") DonHang donhang ,HttpServletRequest req,HttpServletResponse response ,Model model){
		
		return "client/thankYou";
	}
	
	
	
}
