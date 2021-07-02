package com.Java5.dto;


import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	@Null
	private Integer id;
	
	@NotNull
	@NotBlank
	private String name;

	
	@NotNull
	@NotBlank
	@Email
	private String email;
	
	@NotNull
	@NotBlank
	private String password;
	
//	@NotNull
//	@NotBlank
//	private String passwordConfirm;
	
	@NotNull
	private Date dob;
	
	@NotNull
	@NotBlank
	private String avatar;
	
	@NotNull
	private Integer role;
	
	@NotNull
	private Integer gender;
	
	@NotNull
	private Integer status;
}
