package com.Asg.entities;

import java.util.Date;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseObject {

	private Object data;
	private Map<String, String> errorMessages = null ;
	private String status;


	@Override
	public String toString() {
		return "ResponseObject [status=" + status + "]";
	}

}
