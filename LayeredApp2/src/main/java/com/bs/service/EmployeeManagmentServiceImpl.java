package com.bs.service;

import java.util.List;

import org.springframework.beans.BeanUtils;

import com.bs.bo.EmployeeBO;
import com.bs.dao.EmployeeDAO;
import com.bs.dto.EmployeeDTO;

import lombok.AllArgsConstructor;
@AllArgsConstructor
public class EmployeeManagmentServiceImpl implements EmployeeManagmentService {
	private EmployeeDAO dao;

	@Override
	public List<EmployeeDTO> fetchEmpsByDesgs(String Desg1, String Desg2) throws Exception {
		List<EmployeeDTO>listDTO=null;
		List<EmployeeBO>listBO=null;
		// use dao
		listBO=dao.getEmpsByDesgs(Desg1, Desg2);
		//copy listBO to listDTO
		listBO.forEach(bo->{
			EmployeeDTO dto = new EmployeeDTO();
			BeanUtils.copyProperties(bo, dto);
			dto.setSrNo(listDTO.size()+1);
			listDTO.add(dto);
			
		});
		return listDTO;
	}//method

}//class
