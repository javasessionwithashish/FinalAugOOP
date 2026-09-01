package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

	
	public void loginUser(String username, String password) {

		
	}

}
