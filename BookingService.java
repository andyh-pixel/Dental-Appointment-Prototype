import java.util.*;
public class BookingService {
	static HashMap<String, String> users = new HashMap<>();

    public static boolean login(String username, String password) {
        return users.containsKey(username) &&
               users.get(username).equals(password);
    }
    
    public static boolean register(String username, String password) {
        if (users.containsKey(username)) return false;
        users.put(username, password);
        return true;
    }
}
