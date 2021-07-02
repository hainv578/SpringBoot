package com.Java5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Java5.entity.User;

@Controller
public class HelloController {
@RequestMapping("/hello") public String index(Model model) {
	User u = new User();
//	u.setName("Ngo van Hai");
	model.addAttribute("message", u);
	return "index";
}
}
