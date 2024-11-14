/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OP;

import Util.DatabaseConnect;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import OP.User;

/**
 *
 * @author flag10
 */
public class DbOp {

//    private static final String NAME = "clinton";
//    private static final String EMAIL = "clinton@gmail.com";
//    private static final int AGE = 19;
//    private static final long ID = 123456;
//    public static void insertData() {
//        String sql = "INSERT INTO user(name,email,age,id)VALUES(?,?,?,?)";
//        try {
//            Connection conn = DatabaseConnect.getConnection();
//            PreparedStatement stmt = conn.prepareStatement(sql);
//            stmt.setString(1, NAME);
//            stmt.setString(2, EMAIL);
//            stmt.setInt(3, AGE);
//            stmt.setLong(4, ID);
//            int rowAffected = stmt.executeUpdate();
//            if (rowAffected > 0) {
//                System.out.println("added");
//            }
//            
//        } catch (SQLException e) {
//            System.err.println("SQL exception occurred: " + e.getMessage());
//        }
//    }
    public static void selectData() {
        List<User> users = new ArrayList();
        String sqlSelect = "SELECT *FROM user";
        try {
            Connection conn = DatabaseConnect.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sqlSelect);
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                long id = result.getLong("id");
                String name = result.getString("name");
                String email = result.getString("email");
                int age = result.getInt("age");
                User user = new User(id, name, email, age);
                users.add(user);
            }
            for (User user : users) {
                System.out.println(user);
            }
        } catch (SQLException e) {
            System.err.println("SQL exception occurred: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
//        insertData();
        selectData();
    }
}
