package com.Asg.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Asg.entities.GioHang;
import com.Asg.entities.NguoiDung;
import com.Asg.repository.GioHangRepository;
import com.Asg.service.GioHangService;

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
