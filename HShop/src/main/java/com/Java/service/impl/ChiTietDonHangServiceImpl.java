package com.Java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Java.entities.ChiTietDonHang;
import com.Java.repository.ChiMucGioHangRepository;
import com.Java.repository.ChiTietDonHangRepository;
import com.Java.service.ChiTietDonHangService;

@Service
public class ChiTietDonHangServiceImpl implements ChiTietDonHangService{
	
	@Autowired
	private ChiTietDonHangRepository repo;
	
	@Override
	public List<ChiTietDonHang> save(List<ChiTietDonHang> list)
	{	
		return repo.saveAll(list);
	}
}
