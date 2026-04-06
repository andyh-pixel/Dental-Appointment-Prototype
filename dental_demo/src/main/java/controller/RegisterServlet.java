package controller;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLEncoder;

import service.BookingService;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter ("password");
		
        StringBuilder errortext = new StringBuilder();
        if (BookingService.register(username, password, errortext)) {            
            response.getWriter().println(username);
			response.getWriter().println("Registration successful!");
            response.sendRedirect(request.getContextPath() + "/success.html?action=" + URLEncoder.encode("Register", "UTF-8"));
        } else {
            response.getWriter().println("Registration failed");
            response.getWriter().println(errortext.toString());
            response.sendRedirect("register.html?error=" + URLEncoder.encode(errortext.toString(), "UTF-8"));
        }
}
}
