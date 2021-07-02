package com.Java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Java.entities.VaiTro;
import com.Java.repository.VaiTroRepository;
import com.Java.service.VaiTroService;

@Service
public class VaiTroServiceImpl implements VaiTroService{
	

	@Autowired
	private VaiTroRepository repo;

	@Override
	public VaiTro findByTenVaiTro(String tenVaiTro) {
		return repo.findByTenVaiTro(tenVaiTro);
	}

	@Override
	public List<VaiTro> findAllVaiTro() {
		return repo.findAll();
	}


}
