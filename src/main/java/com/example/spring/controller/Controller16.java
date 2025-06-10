package com.example.spring.controller;

import com.example.spring.dto.CustomerDto;
import com.example.spring.dto.SuppliersDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("main16")
public class Controller16 {

    @GetMapping("sub1")
    public String form1(Model model) throws SQLException {
        String sql = """
                SELECT *
                FROM Customers
                ORDER BY CustomerID DESC
                """;

        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        List<CustomerDto> customerList = new ArrayList<>();
        while (resultSet.next()) {
            CustomerDto customerDto = new CustomerDto();
            customerDto.setId(resultSet.getInt("customerId"));
            customerDto.setName(resultSet.getString("customerName"));
            customerDto.setContactName(resultSet.getString("contactName"));
            customerDto.setAddress(resultSet.getString("address"));
            customerDto.setCity(resultSet.getString("city"));
            customerDto.setPostalCode(resultSet.getString("postalCode"));
            customerDto.setCountry(resultSet.getString("country"));
            customerList.add(customerDto);
        }
        model.addAttribute("customerList", customerList);


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

        //* 중복삽입 방지 - redirect를 통해 Get방식 요청 페이지로 이동
        // -> PRG패턴(Post-Redirect-Get Pattern) 방식
//        return "main16/sub1";
        return "redirect:/main16/sub1";
    }

    @GetMapping("sub2")
    public String form2(Model model) throws SQLException {
        String sql = """
                SELECT * 
                FROM Suppliers
                ORDER BY SupplierID DESC
                """;

        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        List<SuppliersDTO> supplierList = new ArrayList<>();
        while (resultSet.next()) {
            SuppliersDTO supplierDto = new SuppliersDTO();
            supplierDto.setId(resultSet.getInt("supplierId"));
            supplierDto.setName(resultSet.getString("supplierName"));
            supplierDto.setContactName(resultSet.getString("contactName"));
            supplierDto.setAddress(resultSet.getString("address"));
            supplierDto.setCity(resultSet.getString("city"));
            supplierDto.setPostalCode(resultSet.getString("postalCode"));
            supplierDto.setCountry(resultSet.getString("country"));
            supplierDto.setPhone(resultSet.getString("phone"));
            supplierList.add(supplierDto);
        }
        model.addAttribute("supplierList", supplierList);

        return "main16/sub2";
    }

    @PostMapping("sub2")
    public String process2(SuppliersDTO supplier) throws SQLException {
        String sql = """
                INSERT INTO Suppliers
                (SupplierName, ContactName, Address, City, PostalCode, Country, Phone)
                VALUES
                (?, ?, ?, ?, ?, ?, ?)
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, supplier.getName());
        statement.setString(2, supplier.getContactName());
        statement.setString(3, supplier.getAddress());
        statement.setString(4, supplier.getCity());
        statement.setString(5, supplier.getPostalCode());
        statement.setString(6, supplier.getCountry());
        statement.setString(7, supplier.getPhone());
        statement.executeUpdate();

        return "redirect:/main16/sub2";
    }

    @GetMapping("sub3")
    public String form3(Integer id, Model model) throws SQLException {

        if (id != null) {
            String sql = """
                    SELECT *
                    FROM Customers
                    WHERE CustomerID = ?
                    """;
            String url = "jdbc:mysql://localhost:3306/w3schools";
            String username = "root";
            String password = "1234";
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // 조회 결과가 있을 때만
                CustomerDto customerDto = new CustomerDto();
                customerDto.setId(resultSet.getInt("customerId"));
                customerDto.setName(resultSet.getString("customerName"));
                customerDto.setContactName(resultSet.getString("contactName"));
                customerDto.setAddress(resultSet.getString("address"));
                customerDto.setCity(resultSet.getString("city"));
                customerDto.setPostalCode(resultSet.getString("postalCode"));
                customerDto.setCountry(resultSet.getString("country"));
                model.addAttribute("customer", customerDto);
            }
        }

        return "main16/sub3";
    }

    @PostMapping("sub3")
    public String process3(Integer id, RedirectAttributes rttr) throws SQLException {
        String sql = """
                DELETE FROM Customers
                WHERE CustomerID = ?
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.executeUpdate();

        // 삭제 이후에 입력한 값 다시 조회
        rttr.addAttribute("id", id);    // query string에 붙인다.

        // get방식 페이지로 요청
        return "redirect:/main16/sub3";
    }

    @GetMapping("sub4")
    public String form4(Integer id, Model model) throws SQLException {
        //* 데이터 조회
        if (id != null) {
            String sql = """
                    SELECT * FROM Suppliers
                    WHERE SupplierID = ?
                    """;
            String url = "jdbc:mysql://localhost:3306/w3schools";
            String username = "root";
            String password = "1234";
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                SuppliersDTO supplierDto = new SuppliersDTO();
                supplierDto.setId(resultSet.getInt("supplierId"));
                supplierDto.setName(resultSet.getString("supplierName"));
                supplierDto.setContactName(resultSet.getString("contactName"));
                supplierDto.setAddress(resultSet.getString("address"));
                supplierDto.setCity(resultSet.getString("city"));
                supplierDto.setPostalCode(resultSet.getString("postalCode"));
                supplierDto.setCountry(resultSet.getString("country"));
                supplierDto.setPhone(resultSet.getString("phone"));
                model.addAttribute("supplier", supplierDto);
            }

        }

        return "main16/sub4";
    }

    @PostMapping("sub4")
    public String process4(Integer id, RedirectAttributes rttr) throws SQLException {
        //* 데이터 삭제
        String sql = """
                DELETE FROM Suppliers 
                WHERE SupplierID = ?
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.executeUpdate();

        rttr.addAttribute("id", id);

        return "redirect:/main16/sub4";
    }

    @GetMapping("sub5")
    public String select1(Integer id, Model model) throws SQLException {
        if (id != null) {
            String sql = """
                    SELECT * FROM Customers
                    WHERE CustomerID = ?
                    """;
            String url = "jdbc:mysql://localhost:3306/w3schools";
            String username = "root";
            String password = "1234";
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                CustomerDto customerDto = new CustomerDto();
                customerDto.setId(resultSet.getInt("customerId"));
                customerDto.setName(resultSet.getString("customerName"));
                customerDto.setContactName(resultSet.getString("contactName"));
                customerDto.setAddress(resultSet.getString("address"));
                customerDto.setCity(resultSet.getString("city"));
                customerDto.setPostalCode(resultSet.getString("postalCode"));
                customerDto.setCountry(resultSet.getString("country"));
                model.addAttribute("customer", customerDto);
            }
        }

        return "main16/sub5";
    }



    @PostMapping("sub5")
    public String update1(CustomerDto customerDto, RedirectAttributes rttr) throws SQLException {
//        System.out.println("customerDto = " + customerDto);

        String sql = """
                UPDATE Customers
                SET CustomerName = ?,
                    ContactName = ?,
                    Address = ?,
                    City = ?,
                    PostalCode = ?,
                    Country = ?
                WHERE CustomerID = ?
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, customerDto.getName());
        statement.setString(2, customerDto.getContactName());
        statement.setString(3, customerDto.getAddress());
        statement.setString(4, customerDto.getCity());
        statement.setString(5, customerDto.getPostalCode());
        statement.setString(6, customerDto.getCountry());
        statement.setInt(7, customerDto.getId());

        rttr.addAttribute("id", customerDto.getId());

        return "redirect:/main16/sub5";
    }

}
