package com.Asg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Asg.entities.ChiMucGioHang;
import com.Asg.entities.GioHang;
import com.Asg.entities.SanPham;

public interface ChiMucGioHangRepository extends JpaRepository<ChiMucGioHang, Long>{
	
	ChiMucGioHang findBySanPhamAndGioHang(SanPham sp,GioHang g);
	
	List<ChiMucGioHang> findByGioHang(GioHang g);
}
