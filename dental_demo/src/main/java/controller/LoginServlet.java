package controller;

import javax.servlet.*;
import javax.servlet.http.*;

import service.BookingService;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        StringBuilder errortext = new StringBuilder();
        if (BookingService.login(username, password, errortext)) {
            response.getWriter().println(errortext.toString());
            response.getWriter().println("Login successful");            
            response.sendRedirect(request.getContextPath() + "/success.html?action=" + URLEncoder.encode("Login", "UTF-8"));
        } else {
            response.getWriter().println("Login failed");
            response.sendRedirect("login.html?error=" + URLEncoder.encode(errortext.toString(), "UTF-8"));
        }
    }
}