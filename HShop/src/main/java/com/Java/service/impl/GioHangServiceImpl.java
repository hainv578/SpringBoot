package com.Java.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Java.entities.GioHang;
import com.Java.entities.NguoiDung;
import com.Java.repository.GioHangRepository;
import com.Java.service.GioHangService;

@Service
public class GioHangServiceImpl implements GioHangService{
	
	@Autowired
	private GioHangRepository repo;
	
	@Override
	public GioHang getGioHangByNguoiDung(NguoiDung n)
	{
		return repo.findByNguoiDung(n);
	}
	
	@Override
	public GioHang save(GioHang g)
	{
		return repo.save(g);
	}

}
