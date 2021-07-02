package com.Asg.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

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
public class DanhMuc {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotEmpty(message="Tên danh mục không được trống")
	private String tenDanhMuc;

	@JsonIgnore
	@OneToMany(mappedBy = "danhMuc")
	private List<SanPham> listSanPham;
	
//	public DanhMuc(long id, String tenDanhMuc) {
//		this.id = id;
//		this.tenDanhMuc = tenDanhMuc;
//	}
	

}
