package com.shoplap.dto;

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
public class OrderDetailDTO {

	@NotNull
	@NotBlank
	private Integer id;

	@NotNull
	@NotBlank
	private Integer quantity;

	@NotNull
	@NotBlank
	private Integer price;
}
