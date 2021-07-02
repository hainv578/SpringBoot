package com.Asg.dto;

import java.sql.Date;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {

	private Integer id;

	@NotNull
	private Date createDate;

	@NotNull
	private String address;

	@NotNull
	private Integer user_id;
}
