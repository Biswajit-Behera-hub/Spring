package com.bs.contoller;

import java.util.List;

import com.bs.dto.EmployeeDTO;
import com.bs.service.EmployeeManagmentService;

import lombok.AllArgsConstructor;
@AllArgsConstructor
public class MainController {
  private EmployeeManagmentService service;
  
  public List<EmployeeDTO>fetchByDesg(String desg1,String desg2)throws Exception{
	  List<EmployeeDTO> listDTO=null;
	  //use Service
	  listDTO=service.fetchEmpsByDesgs(desg1, desg2);
	  return listDTO;
	  
  }
  
  
}
