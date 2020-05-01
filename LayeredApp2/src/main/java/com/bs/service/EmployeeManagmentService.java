package com.bs.service;

import java.util.List;

import com.bs.dto.EmployeeDTO;

public interface EmployeeManagmentService {
	
	public List<EmployeeDTO>fetchEmpsByDesgs(String desg1,String desg2)throws Exception;

}
