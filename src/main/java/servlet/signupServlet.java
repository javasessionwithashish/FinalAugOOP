package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.UserControllerImplements;


@WebServlet("/signup")
public class signupServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	request.getRequestDispatcher("signup.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String username= request.getParameter("username");
		String password= request.getParameter("password");
		
		//Call the controller for the operations
		//We use servlet only for request parameters and responses only
			
		UserControllerImplements uc = new UserControllerImplements();
		
		uc.signupUser(username, password);
	
	request.getRequestDispatcher("login.jsp").forward(request, response);
		
	}

}
