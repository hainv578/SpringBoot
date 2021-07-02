package com.Java5.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	//	@Column(name = "user_id")
    //	private Integer user_id;
	
	@Column(name = "create_Date")
	private Date createDate;
	
	
	@Column(name = "address")
	private String address;
	
	@ManyToOne()
	@JoinColumn(
		name = "user_id",
		referencedColumnName = "id"
			)
	private User user;

}

