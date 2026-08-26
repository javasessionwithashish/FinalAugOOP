package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
	
				
		
	}

	
	public void loginUser(String username, String password) {

		
	}

}
