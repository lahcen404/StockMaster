<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Stock List</title>
</head>
<body>
    <h1>Stock List</h1>
    <a href="stocks/new">Add New Stock</a>
    <table border="1">
        <tr>
            <th>Nom</th>
            <th>Description</th>
            <th>Quantity</th>
            <th>Prix Unitaire</th>
            <th>Category</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="stock" items="${listStock}">
            <tr>
                <td>${stock.nom}</td>
                <td>${stock.description}</td>
                <td>${stock.quantity}</td>
                <td>${stock.prixUnite}</td>
                <td>${stock.category}</td>
                <td>
                    <a href="stocks/edit?id=${stock.id}">Edit</a> |
                    <a href="stocks/delete?id=${stock.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
