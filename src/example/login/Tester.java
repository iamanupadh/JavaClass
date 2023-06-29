package org.example.login;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        System.out.println("Enter the userName: ");
        Scanner scanner = new Scanner(System.in);
        String userName = scanner.next();

        System.out.println("Enter the password: ");
        String password = scanner.next();

        JdbcConnector jdbcConnector = new JdbcConnector();

        try {
            var connection = jdbcConnector.myDatabaseConnection();

            if (connection == null) {
                throw new Exception();
            }

            String query = "Select * from logindb.credential where username=? and password=?";

            var preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                while (resultSet.next()) {
                    Integer loginId = resultSet.getInt("loginid");
                    System.out.println("LoginId " + loginId);
                }

            } else {
                throw new SQLException();
            }


        } catch (SQLException e) {
            System.out.println("Wrong UserName and Password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
