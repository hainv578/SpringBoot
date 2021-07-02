package com.shoplap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/admin")
public class AdminController {

	@GetMapping()
	public String index(Model model)
	{
		
		return"";
	}
	
	@GetMapping()
	public String show(Model model)
	{
		
		return"";
	}
	@PostMapping()
	public String update(Model model)
	{
		
		return"";
	}
	@GetMapping()
	public String delete(Model model)
	{
		
		return"";
	}
	@GetMapping()
	public String edit(Model model)
	{
		
		return"";
	}
	@GetMapping()
	public String store(Model model)
	{
		
		return"";
	}
}
