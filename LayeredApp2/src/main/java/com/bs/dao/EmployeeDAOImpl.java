package com.bs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.bs.bo.EmployeeBO;





public class EmployeeDAOImpl implements EmployeeDAO {
	private static final String GET_EMPS_BY_DESGS="SELECT EMPNO.ENAME,JOB,SAL,DEPTNO,MGR FROM EMP WHERE JOB IN(?,?)";
	private DataSource ds;

	public EmployeeDAOImpl(DataSource ds) {
		
		this.ds = ds;
	}

	@Override
	public List<EmployeeBO> getEmpsByDesgs(String desg1, String desg2) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<EmployeeBO>listBO=null;
		EmployeeBO bo=null;
		try {
			//get pooled JDBC con Object
			con=ds.getConnection();
			//Create PrepraedStatement Object
			ps=con.prepareCall(GET_EMPS_BY_DESGS);
			//set Query Param Value
			ps.setString(1, desg1);
			ps.setString(2, desg2);
			//execute the query
			rs=ps.executeQuery();
			//copy RS record to list of BO Object
			listBO=new ArrayList();
			while(rs.next()) {
				//copy each record of rs to BO class Object
				bo=new EmployeeBO();
				bo.setEmpNo(rs.getInt(1));
				bo.setEname(rs.getString(2));
				bo.setJob(rs.getString(3));
				bo.setSal(rs.getFloat(4));
				bo.setDeptNo(rs.getInt(5));
				bo.setMgr(rs.getInt(6));
				//add each BO class Object to list BO
				listBO.add(bo);
				 
			}//while
			
		}//try
		
		catch(SQLException se){
			se.printStackTrace();
			throw se;
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		finally {
			//close jdbc objects
			try {
				if(rs!=null)
					rs.close();
			}
			catch(SQLException se) {
				 se.printStackTrace();
			}
			try {
				if(ps!=null)
					ps.close();
			}
			catch(SQLException se) {
				 se.printStackTrace();
			}
			try {
				if(con!=null)
					con.close();
			}
			catch(SQLException se) {
				 se.printStackTrace();
			}
		}//end finally
		
		return listBO;
	}//method

}//class
