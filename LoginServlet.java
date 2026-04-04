import javax.servlet.*;
import javax.servlet.http.*;

import service.BookingService;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (BookingService.login(username, password)) {
            response.sendRedirect("schedule.html");
        } else {
            response.getWriter().println("Login failed");
        }
    }
	

}
