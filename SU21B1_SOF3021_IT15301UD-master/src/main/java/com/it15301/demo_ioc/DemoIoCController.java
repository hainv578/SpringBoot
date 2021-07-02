package com.it15301.demo_ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.it15301.dto.UserDTO;

@Controller
public class DemoIoCController {
	@Autowired
	@Qualifier("beanTienNH21")
	private UserDTO myUser;

	@GetMapping("/demo-ioc")
	public String hello(Model model)
	{
		System.out.println("MyUser: " + this.myUser.getUsername());
//		model.addAttribute("message", message);
		return "hello";
	}
}
