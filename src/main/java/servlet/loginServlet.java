package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.UserController;
import controller.UserControllerImplements;


@WebServlet("/login")
public class loginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
	request.getRequestDispatcher("login.jsp").forward(request, response);
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
	//form ko data servlet ma read garna
		//request.getParameter() use garchhau
		//form ma name="username1" chha bhane
		//request.getParameter("username1")
		
		
		String username= request.getParameter("username");
	String password=request.getParameter("password");
	
	UserControllerImplements uc = new UserControllerImplements();
	
	if(uc.loginUser(username, password)==true)
	{
		//Create Http Session
		
		HttpSession session = request.getSession();
		
		session.setAttribute("username", username);
		
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}
	else
	{
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
	
	
	}

}
