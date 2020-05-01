package com.bs.test;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.bs.contoller.MainController;
import com.bs.dto.EmployeeDTO;

public class NestedBeanFactoryTest {

	public static void main(String[] args) {
		DefaultListableBeanFactory pFactory=null,cFactory=null;
		XmlBeanDefinitionReader pReader=null,cReader=null;
		MainController controller=null;
		List<EmployeeDTO> listDTO=null;
		// Create Container
		pFactory=new DefaultListableBeanFactory();
		pReader=new XmlBeanDefinitionReader(pFactory);
		pReader.loadBeanDefinitions("com/bs/cfgs/bussiness-tier-beans.xml");
		//Create Child Container
		cFactory=new DefaultListableBeanFactory(pFactory);
		cReader=new XmlBeanDefinitionReader(cFactory);
		cReader.loadBeanDefinitions("com/bs/cfgs/presentation-tier-beans.xml");
		//get Controller class Objects
		controller=cFactory.getBean("controller",MainController.class);
		//invoke the methods
		try {
			listDTO=controller.fetchByDesg("CLERK", "MANAGER");
			listDTO.forEach(dto->{
				System.out.println(dto);
			});
		}//try
		catch (Exception e) {
			e.printStackTrace();
		}


	}//main

}//class
