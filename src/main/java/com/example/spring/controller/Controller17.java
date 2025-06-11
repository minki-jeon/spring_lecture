package com.example.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.*;

@Controller
@RequestMapping("main17")
public class Controller17 {
    @GetMapping("sub1")
    public String sub1(Model model) throws Exception {
        String sql = """
                INSERT INTO table12
                (col1, col2, col3, col4, col5, col6, col7)
                VALUES (?, ?, ?, ?, ?, ?, ?)
                """;

        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, "한글");
        statement.setString(2, "234234");
        statement.setString(3, "9198723");
        statement.setString(4, "987714.12");
        statement.setString(5, "1998-10-10");
        statement.setString(6, "16:21:34");
        statement.setString(7, "2009-01-31 06:21:34");

        statement.executeUpdate();

        return null;
    }
    @GetMapping("sub2")
    public String sub2(Model model) throws Exception {
        String sql = """
                INSERT INTO table12
                (col1, col2, col3, col4, col5, col6, col7)
                VALUES (?, ?, ?, ?, ?, ?, ?)
                """;

        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, "한글");
        statement.setInt(2, 3432342);
        statement.setLong(3, 8728374);
        statement.setDouble(4, 62347.34);
        statement.setDate(5, Date.valueOf("1998-10-10"));
        statement.setTime(6, Time.valueOf("16:21:34"));
        statement.setTimestamp(7, Timestamp.valueOf("2009-01-31 06:21:34"));

        statement.executeUpdate();

        return null;
    }

    @GetMapping("sub3")
    public String sub3(Model model) throws Exception {
        String sql = """
                select * FROM table12
                LIMIT 1
                """;

        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            System.out.println(resultSet.getString("col1"));
            System.out.println(resultSet.getString("col2"));
            System.out.println(resultSet.getString("col3"));
            System.out.println(resultSet.getString("col4"));
            System.out.println(resultSet.getString("col5"));
            System.out.println(resultSet.getString("col6"));
            System.out.println(resultSet.getString("col7"));
            System.out.println();
        }

        return null;
    }

    @GetMapping("sub4")
    public String sub4(Model model) throws Exception {
        String sql = """
                select * FROM table12
                LIMIT 1
                """;

        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            System.out.println(resultSet.getString("col1"));    // VARCHAR
            System.out.println(resultSet.getInt("col2"));    // INT
            System.out.println(resultSet.getLong("col3"));    // BIGINT
            System.out.println(resultSet.getDouble("col4"));    // DECIMAL
            System.out.println(resultSet.getDate("col5"));    // DATE
            System.out.println(resultSet.getTime("col6"));    // TIME
            System.out.println(resultSet.getTimestamp("col7"));    // DATETIME
            System.out.println();
        }

        return null;
    }

}
