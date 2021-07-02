package com.Java.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Java.entities.VaiTro;

public interface VaiTroRepository extends JpaRepository<VaiTro, Long> {

	VaiTro findByTenVaiTro(String tenVaiTro);
}
