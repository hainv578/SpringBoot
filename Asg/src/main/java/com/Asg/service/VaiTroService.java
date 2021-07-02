package com.Asg.service;

import java.util.List;

import com.Asg.entities.VaiTro;

public interface VaiTroService {

	VaiTro findByTenVaiTro(String tenVaiTro);
	List<VaiTro> findAllVaiTro();
}
