package service;

import dao.UserDAO;
import dao.UserDAOImpl;
import model.User;

public class BookingService {
    private static UserDAO userDAO = new UserDAOImpl();

    public static boolean login(String username, String password, StringBuilder errortext) {
        User user = userDAO.findByUsername(username, errortext);
        if (user == null) {
            errortext.append("BookingService: User not found").append(System.lineSeparator());
            return false;
        }
        return (user.validatePassword(password));
    }

    public static boolean register(String username, String password, StringBuilder errortext) {
        User user = new User(username, password);
        errortext.append("BookingService: register: ").append(user.getUsername()).append(System.lineSeparator());
        return userDAO.save(user, errortext);
    }
}
