package com.Java.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Java.entities.ChiMucGioHang;
import com.Java.entities.GioHang;
import com.Java.entities.SanPham;

public interface ChiMucGioHangRepository extends JpaRepository<ChiMucGioHang, Long>{
	
	ChiMucGioHang findBySanPhamAndGioHang(SanPham sp,GioHang g);
	
	List<ChiMucGioHang> findByGioHang(GioHang g);
}
