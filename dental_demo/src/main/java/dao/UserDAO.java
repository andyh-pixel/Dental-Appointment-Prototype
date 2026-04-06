package dao;

import model.User;

public interface UserDAO {
    boolean isUserExists(String username, StringBuilder errortext);
    User findByUsername(String username, StringBuilder errortext);
    boolean save(User user, StringBuilder errortext);
}
