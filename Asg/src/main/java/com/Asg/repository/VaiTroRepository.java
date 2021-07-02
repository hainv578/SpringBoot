package com.Asg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Asg.entities.VaiTro;

public interface VaiTroRepository extends JpaRepository<VaiTro, Long> {

	VaiTro findByTenVaiTro(String tenVaiTro);
}
