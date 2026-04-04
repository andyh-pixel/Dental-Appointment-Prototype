public class Appointment {
private static int counter =1;
	
	private int id;
	private String username;
	private String date;
	private String time;
	
	public Appointment (String username, String date, String time) {
		this.id = counter++;
		this.username = username;
		this.date = date;
		this.time = time;
	}
	public int getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public String getDate() {
		return date;
	}
	public String getTime() {
		return time;
	}
	public void update (String date, String time) {
		this.date = date;
		this.time = time;
	}
	@Override
	public String toString() {
		return "ID: "+id + "| Date: "+ date + "| Time: "+time;
	}
}
