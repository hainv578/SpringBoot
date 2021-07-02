package com.Asg.dto;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import com.Asg.dto.CapNhatDonHangShipper.CapNhatChiTietDon;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LienHeDTO {

	@Override
	public String toString() {
		return "LienHeDTO [id=" + id + ", noiDungTraLoi=" + noiDungTraLoi + ", tieuDe=" + tieuDe + ", diaChiDen="
				+ diaChiDen + ", ngayTraLoi=" + ngayTraLoi + "]";
	}

	private long id;
	
	@NotEmpty(message="Nội dung trả lời không được trống")
	private String noiDungTraLoi;
	
	private String tieuDe;
	private String diaChiDen;
	
	private Date ngayTraLoi;

	
}
