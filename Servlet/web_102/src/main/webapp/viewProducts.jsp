<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="example.model.Product" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <title>Products List</title>
</head>
<body>
    <h1>Products List</h1>
    <table border="1">
        <tr>
            <th>Name</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Action</th>
        </tr>
                <%
                    List<Product> products = (List<Product>) request.getAttribute("products");
                    if (products != null) {
                        for (int i = 0; i < products.size(); i++) {
                            Product product = products.get(i);
                %>
                <tr>
                    <td><%= product.getName() %></td>
                    <td><%= product.getPrice() %></td>
                    <td><%= product.getQuantity() %></td>
                    <td>
                        <a href="products?action=delete&index=<%= i %>">Delete</a>
                    </td>
                </tr>
                <%
                        }
                    }
                %>
    </table>
    <br>
    <a href="addProduct">Add New Product</a>
</body>
</html>