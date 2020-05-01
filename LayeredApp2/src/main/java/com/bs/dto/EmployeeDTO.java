package com.bs.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EmployeeDTO implements Serializable {
	private int srNo;
	private int empNo;
	private String ename;
	private String job;
	private float sal;
	private int deptNo;
	private int mgr;

}
