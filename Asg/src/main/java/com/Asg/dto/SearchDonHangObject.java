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
public class SearchDonHangObject {

	private String trangThaiDon;
	private String tuNgay;
	private String denNgay;

	
	@Override
	public String toString() {
		return "SearchDonHangObject [trangThaiDon=" + trangThaiDon + ", tuNgay=" + tuNgay + ", denNgay=" + denNgay
				+ "]";
	}
	
	
}
