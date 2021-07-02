package com.Asg.dto;

import java.sql.Date;

import javax.persistence.Column;
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
	
	private Integer id;

	@NotNull
	private String name;

	@NotNull
	private String image;

	@NotNull
	private Integer price;

	@NotNull
	private Date createDate;

	@NotNull
	private Integer available;

	@NotNull
	private Integer category_id;
}
