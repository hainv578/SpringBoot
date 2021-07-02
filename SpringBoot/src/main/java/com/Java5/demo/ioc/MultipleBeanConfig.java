package com.Java5.demo.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.Java5.entity.User;

@Configuration
public class MultipleBeanConfig {
	@Bean("beanTienNH21")
	public User getUser1()
	{
		User myUser = new User();
		
		myUser.setUsername("TienNH21");
		
		return myUser;
	}

	@Bean("beanDungNA29")
	public User getUser2()
	{
		User myUser = new User();
		
		myUser.setUsername("DungNA29");
		
		return myUser;
	}
}