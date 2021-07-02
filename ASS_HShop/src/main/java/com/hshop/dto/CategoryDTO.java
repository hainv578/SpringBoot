package com.hshop.dto;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO implements Serializable{
	
	
	private Long categoryId;
	
	@NotEmpty
	@Length(min = 5)
	private String name;
	
	private Boolean isEdit = false;
}
