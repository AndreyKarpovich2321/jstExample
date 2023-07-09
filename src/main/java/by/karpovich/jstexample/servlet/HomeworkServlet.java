package by.karpovich.jstexample.servlet;

import by.karpovich.jstexample.model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@WebServlet(value = "/homework_25")
public class HomeworkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> productsList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/main", "root", "msqlsrvrpss")){
            PreparedStatement ps = connection.prepareStatement("SELECT NAME, PRICE, CATEGORY FROM PRODUCTS");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                productsList.add(new Product(rs.getString("NAME"), rs.getInt("PRICE"), rs.getString("CATEGORY")));
            }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        req.setAttribute("products", productsList);


    }
}
