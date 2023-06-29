package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JdbcConnector {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/learningdb1";
        String user = "root";
        String password = "Damak1097";

        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        var nameList = new ArrayList<String>();
        List<Integer> idList = new ArrayList<>();
        var nameIdMap = new HashMap<Integer,String>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,user,password);
            System.out.println("Sucess");

            String updateQuery = "Update learningdb1.student set name=? where id=?";
            String query = "SELECT * FROM learningdb1.student where id=?";

            var updatedStatement = connection.prepareStatement(updateQuery);
            updatedStatement.setString(1,"Anup");
            updatedStatement.setInt(2,1);

            updatedStatement.executeUpdate();

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,1);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id"));
                System.out.println(resultSet.getString("name"));
            }

            System.out.println("sucess");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }

                if (preparedStatement != null) {
                    preparedStatement.close();
                }

                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }
    }




}
