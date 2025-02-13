package Controler;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StockDAO;
import model.Stock;

/**
 * Servlet implementation class ServletStock
 */
@WebServlet("/")
public class ServletStock extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private StockDAO stockDAO;

    public ServletStock() {
        this.stockDAO = new StockDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertStock(request, response);
                    break;
                case "/delete":
                    deleteStock(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateStock(request, response);
                    break;
                default:
                    listStock(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listStock(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Stock> listStock = stockDAO.selectAllStock();
        request.setAttribute("listStock", listStock);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Stock-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("Stock-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Stock existingStock = stockDAO.selectStock(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Stock-form.jsp");
        request.setAttribute("stock", existingStock);
        dispatcher.forward(request, response);
    }

    private void insertStock(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String nom = request.getParameter("nom");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        float prixUnite = Float.parseFloat(request.getParameter("PrixUnite"));
        String category = request.getParameter("Category");
        String description = request.getParameter("Description");

        Stock newStock = new Stock(nom, quantity, prixUnite, category, description);
        stockDAO.insertStock(newStock);
        response.sendRedirect("list");
    }

    private void updateStock(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nom = request.getParameter("nom");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        float prixUnite = Float.parseFloat(request.getParameter("PrixUnite"));
        String category = request.getParameter("Category");
        String description = request.getParameter("Description");

        Stock stock = new Stock(id, nom, quantity, prixUnite, category, description);
        stockDAO.updateStock(stock);
        response.sendRedirect("list");
    }

    private void deleteStock(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        stockDAO.deleteStock(id);
        response.sendRedirect("list");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
