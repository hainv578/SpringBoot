package com.Asg.entities;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

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
public class NguoiDung {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String email;
	
	@JsonIgnore
	private String password;
	
	@Transient
	@JsonIgnore
	private String confirmPassword;
	private String hoTen;
	private String soDienThoai;
	private String diaChi;
	
	@ManyToMany
	@JoinTable(name="nguoidung_vaitro",
	           joinColumns=@JoinColumn(name="ma_nguoi_dung"), 
	           inverseJoinColumns=@JoinColumn(name="ma_vai_tro"))
	private Set<VaiTro> vaiTro;
	
	@Transient
	@JsonIgnore
	private List<DonHang> listDonHang;
	
	
	@Override
	public String toString() {
		return "NguoiDung [id=" + id + ", email=" + email + ", password=" + password + ", confirmPassword="
				+ confirmPassword + ", hoTen=" + hoTen + ", soDienThoai=" + soDienThoai + ", diaChi=" + diaChi;
	}	
}
