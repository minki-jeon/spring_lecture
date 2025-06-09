package com.example.spring.controller;

import com.example.spring.dto.CustomerDto;
import com.example.spring.dto.EmployeeDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("main14")
public class Controller14 {
    @GetMapping("sub1")
    public String sub1(String keyword, Model model) throws Exception {
        // 직원 설명 (Notes)에 특정 keyword가 있는 직원들 조회
        String sql = """
                SELECT *
                FROM Employees
                WHERE Notes LIKE ?
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, "%" + keyword + "%");

        List<EmployeeDto> list = new ArrayList<>();
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            EmployeeDto employeeDto = new EmployeeDto();
            employeeDto.setId(rs.getInt("employeeId"));
            employeeDto.setLastName(rs.getString("lastName"));
            employeeDto.setFirstName(rs.getString("firstName"));
            employeeDto.setBirthDate(rs.getDate("BirthDate").toLocalDate());
            employeeDto.setPhoto(rs.getString("photo"));
            employeeDto.setNotes(rs.getString("notes"));
            list.add(employeeDto);
        }
        model.addAttribute("employeeList", list);

        return "main14/sub1";
    }

    @RequestMapping("sub2")
    public String sub2(String keyword, Model model) throws Exception {
        String sql = """
                SELECT * FROM Customers
                WHERE CustomerName LIKE ?
                OR ContactName LIKE ?
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, "%" + keyword + "%");
        statement.setString(2, "%" + keyword + "%");
        ResultSet rs = statement.executeQuery();

        List<CustomerDto> list = new ArrayList<>();
        while (rs.next()) {
            CustomerDto customerDto = new CustomerDto();
            customerDto.setId(rs.getInt("customerId"));
            customerDto.setName(rs.getString("customerName"));
            customerDto.setContactName(rs.getString("contactName"));
            customerDto.setAddress(rs.getString("address"));
            customerDto.setCity(rs.getString("city"));
            customerDto.setPostalCode(rs.getString("postalCode"));
            customerDto.setCountry(rs.getString("country"));
            list.add(customerDto);
        }
        model.addAttribute("customerList", list);

        return "main14/sub2";
    }
}
