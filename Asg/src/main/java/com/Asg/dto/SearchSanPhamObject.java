package com.Asg.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SearchSanPhamObject {
	private String danhMucId;
	private String hangSXId;
	private String donGia;
	
	// sap xep theo gia
	private String sapXepTheoGia;
	private String[] keyword;
	private String sort;
	
	// sap xep theo danhmuc va hangsx
	private String brand;
	private String manufactor;
	
	// theo ram, pin, OS
	private String os;
	private String ram;
	private String pin;

	

	@Override
	public String toString() {
		return "SearchObject [danhMucId=" + danhMucId + ", hangSXId=" + hangSXId + ", price=" + donGia + "]";
	}
}
