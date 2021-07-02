package com.Asg.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class VaiTro {

	@Id
	@GeneratedValue
	private long id;
	
	private String tenVaiTro;

	@JsonIgnore
	@ManyToMany(mappedBy = "vaiTro")
	private Set<NguoiDung> nguoiDung;

	
}
