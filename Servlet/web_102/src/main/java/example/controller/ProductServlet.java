package example.controller;

import example.model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.Console;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {
    private static final List<Product> products = new ArrayList<>();
    Console console = System.console();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Handle product deletion if the action is delete
       String action = request.getParameter("action");
       if(action!=null) {
           if (action.equals("delete")) {
               int index = Integer.parseInt(request.getParameter("index"));
               products.remove(index);
           }
       }

        // Set products as request attribute and forward to JSP
        request.setAttribute("products", products);
        request.getRequestDispatcher("/viewProducts.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        products.add(new Product(name, price, quantity));

        response.sendRedirect("products");
    }
}