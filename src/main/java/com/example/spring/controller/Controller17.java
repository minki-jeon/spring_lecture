package com.example.spring.controller;

import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

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

    @Data
    static class Dto5 {
        private String col1;            // VARCHAR
        private Integer col2;           // INT
        private Long col3;              // BIGINT
        private Double col4;            // DEC/DECIMAL
        private LocalDate col5;         // DATE
        private LocalTime col6;              // TIME
        private LocalDateTime col7;     // DATETIME
    }

    @GetMapping("sub5")
    public String sub5(Model model) throws Exception {
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
            Dto5 dto5 = new Dto5();
            dto5.setCol1(resultSet.getString("col1"));    // VARCHAR
            dto5.setCol2(resultSet.getInt("col2"));    // INT
            dto5.setCol3(resultSet.getLong("col3"));    // BIGINT
            dto5.setCol4(resultSet.getDouble("col4"));    // DECIMAL
            dto5.setCol5(resultSet.getDate("col5").toLocalDate());    // DATE
            dto5.setCol6(resultSet.getTime("col6").toLocalTime());    // TIME
            dto5.setCol7(resultSet.getTimestamp("col7").toLocalDateTime());    // DATETIME
            model.addAttribute("dto5", dto5);
        }

        return "main17/sub5";
    }

    @GetMapping("sub6")
    public String sub6(Model model) throws Exception {
        return "main17/sub6";
    }

    @PostMapping("sub6")
    public String process6(Dto5 dto5) throws Exception {
//        System.out.println("dto5 = " + dto5);
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
        statement.setString(1, dto5.getCol1());
        statement.setInt(2, dto5.getCol2());
        statement.setLong(3, dto5.getCol3());
        statement.setDouble(4, dto5.getCol4());
        statement.setDate(5, Date.valueOf(dto5.getCol5()));
        statement.setTime(6, Time.valueOf(dto5.getCol6()));
        statement.setTimestamp(7, Timestamp.valueOf(dto5.getCol7()));

        statement.executeUpdate();

        return "redirect:/main17/sub6";
    }

    // CREATE TABLE table13(name(텍스트), birth_date(날짜), score(소숫점2), born_at(날짜시간))
    // DTO7, Form(Html), Request Handler Method (get, post)
    @Data
    static class Dto7 {
        private String name;
        private LocalDate birthDate;
        private Double score;
        private LocalDateTime bornAt;
    }

    @GetMapping("sub7")
    public String sub7(Model model) throws Exception {
        String sql = "SELECT * FROM table13";
        
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        var list = new ArrayList<Dto7>();
        while (resultSet.next()) {
            Dto7 dto7 = new Dto7();
            dto7.setName(resultSet.getString("name"));
            dto7.setBirthDate(resultSet.getDate("birth_date").toLocalDate());
            dto7.setScore(resultSet.getDouble("score"));
            dto7.setBornAt(resultSet.getTimestamp("born_at").toLocalDateTime());
//            model.addAttribute("dto7", dto7);
//            System.out.println("dto7 = " + dto7);
            list.add(dto7);
        }
        model.addAttribute("list", list);

        return "main17/sub7";
    }

    @PostMapping("sub7")
    public String process7(Dto7 dto7) throws Exception {
//        System.out.println("dto7 = " + dto7);

        String sql = """
                INSERT INTO table13
                (name, birth_date, score, born_at)
                VALUES (?, ?, ?, ?)
                """;
        
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, dto7.getName());
        statement.setDate(2, Date.valueOf(dto7.getBirthDate()));
        statement.setDouble(3, dto7.getScore());
        statement.setTimestamp(4, Timestamp.valueOf(dto7.getBornAt()));
        statement.executeUpdate();

        return "redirect:/main17/sub7";
    }
}
