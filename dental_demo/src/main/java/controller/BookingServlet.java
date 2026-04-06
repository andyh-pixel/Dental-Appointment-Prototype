package controller;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

import model.Appointment;
import model.DataStore;

@WebServlet ("/booking")
public class BookingServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException
	{
		String action = request.getParameter("action");
		if (action == null) {
			response.getWriter().println("No action provided");
			return;
		}
		switch (action) {
		case "book":
			handleBooking (request, response);
			break;
		case "cancel":
			handleCancel (request, response);
			break;
		case "change":
			handleChange (request, response);
			break;
		default:
			response.getWriter().println("Invalid action");
		}
		
	}
	private void handleBooking (HttpServletRequest request, HttpServletResponse response)
	 throws IOException
	{
		String username = request.getParameter ("username");
		String date = request.getParameter ("date");
		String time = request.getParameter ("time");
		
		Appointment appointment = new Appointment (username, date, time);
		DataStore.appointments.add (appointment);
		response.getWriter().println("Booked! ID: "+appointment.getId());
	}
	private void handleCancel (HttpServletRequest request, HttpServletResponse response)
	throws IOException {
		int id = Integer.parseInt (request.getParameter("id"));
		
		for (Appointment a: DataStore.appointments) {
			if (a.getId() == id) {
				DataStore.appointments.remove(a);
				response.getWriter().println("Appointment cancelled");
				return;
			}
		}
		response.getWriter().println("Appointment not found");
	}
	private void handleChange(HttpServletRequest request, HttpServletResponse response)
	throws IOException{
		int id = Integer.parseInt (request.getParameter("id"));
		String newdate = request.getParameter("date");
		String newTime = request.getParameter("time");
		
		for (Appointment a: DataStore.appointments) {
			if (a.getId() == id) {
				a.update (newdate, newTime);
				response.getWriter().println("Appointment updated");
				return;
			}
		}
		response.getWriter().println("Appoinrmenr not found");
	}
	
}
