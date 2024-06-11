<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Product</title>
</head>
<body>
    <h1>Add New Product</h1>
    <form action="products" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name"><br><br>
        <label for="price">Price:</label>
        <input type="text" id="price" name="price"><br><br>
        <label for="quantity">Quantity:</label>
        <input type="text" id="quantity" name="quantity"><br><br>
        <input type="submit" value="Add Product" >
    </form>
    <br>
    <a href="products">Back to Order List</a>
</body>
</html>