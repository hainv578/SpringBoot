package com.Asg.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CapNhatDonHangShipper {
	
	private long idDonHang;
	private String ghiChuShipper;
	private List<CapNhatChiTietDon> danhSachCapNhatChiTietDon;


	public static class CapNhatChiTietDon {
		private long idChiTiet;
		private int soLuongNhanHang;

	
	}

	


}
