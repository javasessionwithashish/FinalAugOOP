package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.codec.digest.DigestUtils;







public class UserControllerImplements implements UserController {

	Connection conn=null;
	
	public UserControllerImplements() {
		
	try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
	conn = DriverManager.getConnection("jdbc:mysql://gateway01.ap-southeast-1.prod.aws.tidbcloud.com:4000/test","2ATvEziS4umbQX3.root","CvWP4B6HQb214Zut");
	
	}
	catch(ClassNotFoundException | SQLException	e)
	{
		e.printStackTrace();
	}
	
	}
	
	
	public void signupUser(String username, String password) {
	
		String sql = "insert into user_tbl(username,password) values (?,?);";	
		
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			
		String hashPassword=	DigestUtils.sha256Hex(password.getBytes());
		System.out.println(hashPassword);
			
			pstm.setString(1, username);
			pstm.setString(2, hashPassword);
			
			
	
			
			pstm.executeUpdate();
			
			
		} catch (SQLException e) {
			
		}
		
	}

	
	public boolean loginUser(String username, String password) {
		
		String sql = "select * from user_tbl where username=? and password=?;";
		
		String hashPassword = DigestUtils.sha256Hex(password.getBytes());
		
		try
		{
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, username);
		pstm.setString(2, hashPassword);
		
		ResultSet rs=	pstm.executeQuery();
		
		//executeUpdate is used for insert, delete ,etc , this type of operations
		//executeQuery is needed for select operational queries
		
		if(rs.next())
		{
			return true;
		}
		
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

		return false;
	}

}
