package com.Java.service;

public interface SecurityService {

	String findLoggedInUsername();

	void autologin(String email, String password);

}
