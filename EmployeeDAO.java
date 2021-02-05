package com.CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

	public static Connection getConnection() {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee?useSSL=false", "root", "root");
			
		}catch(ClassNotFoundException ex) {
			System.out.println(ex);
		}catch(SQLException se) {
			System.out.println(se);
		}
		return con;
		
	}
	
	public static int registerEmployee(Employee emp) {
	
		int result = 0;
		try {
		Connection con = EmployeeDAO.getConnection();
		
		String query = "insert into emp_info value(?,?,?,?,?)";
		
		PreparedStatement stmt = con.prepareStatement(query);
		
		stmt.setInt(1, emp.getId());
		stmt.setString(2, emp.getName());
		stmt.setString(3, emp.getPassword());
		stmt.setString(4, emp.getEmail());
		stmt.setString(5, emp.getCountry());
		
		result = stmt.executeUpdate();
		
		con.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static 	List<Employee> getAllEmployees(){
		
		List<Employee> list = new ArrayList <Employee> ();
		
		try {
			
			Connection con = EmployeeDAO.getConnection();
			PreparedStatement stmt = con.prepareStatement("select * from emp_info");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				
				Employee e = new Employee();
				
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setPassword(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setCountry(rs.getString(5));
				
				list.add(e);
			}
			
			con.close();
		}catch(Exception e) {
			System.out.println(e);
		}
			
		return list;
		}
	
	
	public static int delete(int id) {
		
		int result = 0;
		
		try {
				Connection con =  EmployeeDAO.getConnection();
				PreparedStatement stmt = con.prepareStatement("delete from emp_info where id = ?");
				stmt.setInt(1, id);
				
				 result = stmt.executeUpdate();
				 con.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		return result;
				
	}
	
	public static int update(Employee emp) {
		
		int result = 0;
		
		try {
				Connection con = EmployeeDAO.getConnection();
				
				String update = "update emp_info set name=?,password=?,email=?,country=? where id =?";
				
				PreparedStatement stmt = con.prepareStatement(update);
				
				stmt.setString(1, emp.getName());
				stmt.setString(2, emp.getPassword());
				stmt.setString(3, emp.getEmail());
				stmt.setString(4, emp.getCountry());
				stmt.setInt(5, emp.getId());
				
				result = stmt.executeUpdate();
				
				con.close();
				
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return result;
		}
	
	public static Employee getEmployeeById(int id) {
		
		int result = 0;
		
		Employee e = new Employee();
		
		try{
			Connection con = EmployeeDAO.getConnection();
			PreparedStatement stmt = con.prepareStatement("select * from emp_info where id = ?");
			
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setPassword(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setCountry(rs.getString(5));
			}
			con.close();
		}catch(Exception ex) {
			System.out.println(ex);
		}
		
		return e;
		
	}
	
	
	
}
