<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

    <form id="taskForm" class="mb-6">
      <div class="grid grid-cols-1 md:grid-cols-2 gap-3">
        <div>
          <label for="nomProduit" class="block text-gray-700 font-medium mb-2">Nom de Produit</label>
          <input type="text" id="taskTitle"
                 class="w-full border border-gray-300 rounded p-2 drop-shadow-md "
                 placeholder="Entrer le Nom de Produit" >
        </div>
        
         
        
          <div>
          <label for="quantity" class="block text-gray-700 font-medium mb-2">Quantity en stock</label>
          <input type="text" id="taskTitle"
                 class="w-full border border-gray-300 rounded p-2 drop-shadow-md "
                 placeholder="Entrer Quantity en stock" >
        </div>
          <div>
          <label for="prixUnitaire" class="block text-gray-700 font-medium mb-2">Prix unitaire</label>
          <input type="text" id="taskTitle"
                 class="w-full border border-gray-300 rounded p-2 drop-shadow-md "
                 placeholder="Entrer Prix unitaire" >
        </div>
        
        <div>
          <label for="taskPriority" class="block text-gray-700 font-medium mb-2">Category</label>
          <select id="taskPriority" class="w-full border border-gray-300 rounded p-2 drop-shadow-md">
            <option value="Electronique">Electronique</option>
            <option value="Alimentation">Alimentation</option>
            <option value="beauty">Beauty</option>
            <option value="fashion">Fashion</option>
            
          </select>
        </div>
      </div>
      <div class="mt-4">
        <label for="taskDescription" class="block text-gray-700 font-medium mb-2">Description</label>
        <textarea id="taskDescription" rows="3"
                  class="w-full border border-gray-300 rounded p-2 drop-shadow-md"
                  placeholder="Enter task description"></textarea>
      </div>
      <button type="submit" class="text-white bg-gradient-to-r mt-4 from-blue-500 via-blue-600 to-blue-700 hover:bg-gradient-to-br focus:ring-4 focus:outline-none focus:ring-blue-300 dark:focus:ring-blue-800 shadow-lg shadow-blue-500/50 dark:shadow-lg dark:shadow-blue-800/80 font-medium rounded-lg text-sm px-5 py-2.5 text-center me-2 mb-2 ">ADD TASK</button>

    </form>
  </div>
</section>
</body>
</html>