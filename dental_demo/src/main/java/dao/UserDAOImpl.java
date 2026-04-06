package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class UserDAOImpl implements UserDAO {
    private static final String URL = "jdbc:sqlite:/Users/farnaz/Servers/tomcat9/webapps/db/dental_demo.db";

    private void registerSqliteClass() {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean isUserExists(String username, StringBuilder errortext) {
        String sql = "SELECT * FROM users WHERE username = ?;";
        registerSqliteClass();
        try (Connection conn = DriverManager.getConnection(URL);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Error searching user: " + e.getMessage());
            errortext.append("UserDAOImpl: Error searching user:").append(e.getMessage())
                    .append(System.lineSeparator());
        }
        return false;
    }

    @Override
    public User findByUsername(String username, StringBuilder errortext) {
        String sql = "SELECT * FROM users WHERE username = ?;";
        registerSqliteClass();
        try (Connection conn = DriverManager.getConnection(URL);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new User(rs.getString("username"), rs.getString("password"));
            }
        } catch (SQLException e) {
            System.err.println("Error finding user: " + e.getMessage());
            errortext.append("UserDAOImpl: Error finding user:").append(e.getMessage()).append(System.lineSeparator());
        }
        return null;
    }

    @Override
    public boolean save(User user, StringBuilder errortext) {
        String sql = "INSERT INTO users(username, password) VALUES(?, ?);";
        registerSqliteClass();
        try (Connection conn = DriverManager.getConnection(URL);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Error saving user: " + e.getMessage());
            errortext.append("UserDAOImpl: Error saving user: ").append(e.getMessage()).append(System.lineSeparator());
        }
        return false;
    }
}
