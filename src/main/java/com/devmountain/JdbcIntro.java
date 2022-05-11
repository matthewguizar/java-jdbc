package com.devmountain;

import org.postgresql.ds.PGSimpleDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcIntro {

    public static void main(String[] args) {

        try {

            PGSimpleDataSource ds = new PGSimpleDataSource();
            ds.setDatabaseName("culinarydb");
            Connection connection = ds.getConnection("postgres", "123");

            if (connection.isValid(500)) {
                System.out.println("Got a connection using DataSource!");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT name FROM foods");

                System.out.println("Here are all the rows in the 'foods' table:");
                while(resultSet.next()) {
                    System.out.println(resultSet.getString(1));
                }
            }

        } catch (Exception e) {
            System.out.println("Exception using DriverManager: " + e.getMessage());
        }
    }


}
