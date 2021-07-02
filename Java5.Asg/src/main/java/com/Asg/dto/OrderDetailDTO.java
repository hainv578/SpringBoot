package com.Asg.dto;

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
public class OrderDetailDTO {

	private Integer id;

	@NotNull
	private Integer quantity;

	@NotNull
	private Integer price;
	
	@NotNull
	private Integer order_id;
	
	@NotNull
	private Integer product_id;
}
