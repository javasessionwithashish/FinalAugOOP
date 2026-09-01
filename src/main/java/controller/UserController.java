package controller;

public interface UserController {
	
	
	void signupUser(String username, String password);
	
	boolean loginUser(String username, String password);

}
