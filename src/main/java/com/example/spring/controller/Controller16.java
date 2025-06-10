package com.example.spring.controller;

import com.example.spring.dto.CustomerDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Controller
@RequestMapping("main16")
public class Controller16 {

    @GetMapping("sub1")
    public String form1(){

        return "main16/sub1";
    }
    @PostMapping("sub1")
    public String process(CustomerDto customer) throws SQLException {
//        System.out.println(customer);
        String sql = """
                INSERT INTO Customers
                (CustomerName, ContactName, Address, City, PostalCode, Country)
                VALUES
                (?, ?, ?, ?, ?, ?)
                """;

        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, customer.getName());
        statement.setString(2, customer.getContactName());
        statement.setString(3, customer.getAddress());
        statement.setString(4, customer.getCity());
        statement.setString(5, customer.getPostalCode());
        statement.setString(6, customer.getCountry());

//        statement.execute();  // select
        statement.executeUpdate();  // insert, update, delete

        return "main16/sub1";
    }
}
