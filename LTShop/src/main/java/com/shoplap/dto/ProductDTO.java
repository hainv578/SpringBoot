package com.shoplap.dto;

import java.sql.Date;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
	
	@NotNull
	@NotBlank
	private Integer id;
	
	@NotNull
	@NotBlank
	private String name;
	
	@NotNull
	@NotBlank
	private String image;
	
	@NotNull
	@NotBlank
	private Integer price;
	
	@NotNull
	private Date createDate;
	
	@NotNull
	private Integer available;
}
