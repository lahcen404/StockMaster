<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Stock Master</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>


<section class="container mx-auto  p-4 drop-shadow-xl">
  <div class="add-task-section  p-6 m-13 rounded-lg shadow-lg mb-4">
    <h2 class="text-3xl font-bold mb-4 text-center font-serif">ADD PRODUCT</h2>

    <form id="taskForm" method="post" action="insert" class="mb-6">
      <div class="grid grid-cols-1 md:grid-cols-2 gap-3">
        <div>
          <label for="nomProduit" class="block text-gray-700 font-medium mb-2">Nom de Produit</label>
          <input type="text" id="nomProduit" name="nom"
                 class="w-full border border-gray-300 rounded p-2 drop-shadow-md "
                 placeholder="Entrer le Nom de Produit" >
        </div>
        
         
        
          <div>
          <label for="quantity" class="block text-gray-700 font-medium mb-2">Quantity en stock</label>
          <input type="text" id="quantity" name="quantity"
                 class="w-full border border-gray-300 rounded p-2 drop-shadow-md "
                 placeholder="Entrer Quantity en stock" >
        </div>
          <div>
          <label for="prixUnitaire" class="block text-gray-700 font-medium mb-2">Prix unitaire</label>
          <input type="text" id="prixUnitaire" name="prixUnite"
                 class="w-full border border-gray-300 rounded p-2 drop-shadow-md "
                 placeholder="Entrer Prix unitaire" >
        </div>
        
        <div>
          <label for="category" class="block text-gray-700 font-medium mb-2">Category</label>
          <select id="category" name="category" class="w-full border border-gray-300 rounded p-2 drop-shadow-md">
            <option value="Electronique">Electronique</option>
            <option value="Alimentation">Alimentation</option>
            <option value="beauty">Beauty</option>
            <option value="fashion">Fashion</option>
            
          </select>
        </div>
      </div>
      <div class="mt-4">
        <label for="produitDescription" class="block text-gray-700 font-medium mb-2">Description</label>
        <textarea id="produitDescription" rows="3" name="description"
                  class="w-full border border-gray-300 rounded p-2 drop-shadow-md"
                  placeholder="Enter produit description"></textarea>
      </div>
      <button type="submit" class="text-white bg-gradient-to-r mt-4 from-blue-500 via-blue-600 to-blue-700 hover:bg-gradient-to-br focus:ring-4 focus:outline-none focus:ring-blue-300 dark:focus:ring-blue-800 shadow-lg shadow-blue-500/50 dark:shadow-lg dark:shadow-blue-800/80 font-medium rounded-lg text-sm px-5 py-2.5 text-center me-2 mb-2 ">ADD TASK</button>

    </form>
  </div>
</section>
	<section>
		<div>
			<table id="produitsTable"
				class="mt-8 w-full bg-white rounded-lg shadow-md">
				<thead>
					<tr class="bg-gray-200">
						<th class="px-4 py-2">Id</th>
						<th class="px-4 py-2">Nom</th>
						<th class="px-4 py-2">Description</th>
						<th class="px-4 py-2">Quantity en stock</th>
						<th class="px-4 py-2">Prix unitaire</th>
						<th class="px-4 py-2">Category</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="produit" items="${listStock}">
						<tr class="px-4 py-2 mx-4">
							<td class="px-4 py-2 "><c:out value="${produit.id}" /></td>
							<td class="px-4 py-2"><c:out value="${produit.nom}" /></td>
							<td class="px-4 py-2"><c:out value="${produit.description}" /></td>
							<td class="px-4 py-2"><c:out value="${produit.quantite}" /></td>
							<td class="px-4 py-2"><c:out value="${produit.prix}" /></td>
							<td class="px-4 py-2"><c:out value="${produit.categorie}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</section>
</body>
</html>