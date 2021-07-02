package com.hshop.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartItem implements Serializable{
	private int productId;
	private String name;
	private int quantity;
	private double unitPrice;
}
