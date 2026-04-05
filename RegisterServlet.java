import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

import model.User;
import model.DataStore;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter ("password");
		
		if (DataStore.users.containsKey (username)) {
			response.getWriter().println("User already exists!");
			return;
		}
	
	User newUser = new User (username, password);
	DataStore.users.put (username, newUser);
	
	response.getWriter().println("Registration successful!");

	

}
}
