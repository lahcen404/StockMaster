package Controler;

import dao.StockDAO;
import Model.Stock;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;

@WebServlet("/")
public class ServletStock extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private StockDAO stockDAO;


    public void init() {
    	stockDAO = new StockDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String action = request.getServletPath();

        try {
            switch (action) {
               
                case "/insert":
                	insertStock(request, response);
                    break;
                case "/list":
                    listStock(request, response);
                    break;
                default:
                    listStock(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void insertStock(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String nom = request.getParameter("nom");
        String description = request.getParameter("description");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        double prixUnitaire = Double.parseDouble(request.getParameter("prixUnite"));
        String category = request.getParameter("category");

        Stock newStock = new Stock(nom, description, quantity, prixUnitaire, category);
        stockDAO.insertStock(newStock);
        response.sendRedirect(request.getContextPath() + "/list");
    }

    private void listStock(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Stock> listStock = stockDAO.selectAllStock();
        
        // tester list 
        listStock.forEach(product -> System.out.println(product.getNom()));
        
        request.setAttribute("listStock", listStock);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Stock-list.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteStock(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        stockDAO.deleteStock(id);
        response.sendRedirect("stocks");
    }
}
