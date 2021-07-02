package com.Asg.service;

import com.Asg.entities.GioHang;
import com.Asg.entities.NguoiDung;

public interface GioHangService {
	
	GioHang getGioHangByNguoiDung(NguoiDung n);
	
	GioHang save(GioHang g);
}
