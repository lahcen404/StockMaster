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
import Model.Stock;

@WebServlet("/stocks/*")
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
        String action = request.getPathInfo();

        try {
            switch (action) {
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
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    private void listStock(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        List<Stock> stockList = stockDAO.getAllStocks();
        request.setAttribute("listStock", stockList);
        request.getRequestDispatcher("/stock-list.jsp").forward(request, response);
    }

    private void insertStock(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String nom = request.getParameter("nom");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        float prixUnite = Float.parseFloat(request.getParameter("prixUnite"));
        String category = request.getParameter("category");
        String description = request.getParameter("description");

        Stock newStock = new Stock(nom, quantity, prixUnite, category, description);
        stockDAO.insertStock(newStock);
        response.sendRedirect(request.getContextPath() + "/stocks");
    }

    private void deleteStock(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        stockDAO.deleteStock(id);
        response.sendRedirect(request.getContextPath() + "/stocks");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Stock existingStock = stockDAO.getStockById(id);
        request.setAttribute("stock", existingStock);
        request.getRequestDispatcher("/stock-form.jsp").forward(request, response);
    }

    private void updateStock(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nom = request.getParameter("nom");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        float prixUnite = Float.parseFloat(request.getParameter("prixUnite"));
        String category = request.getParameter("category");
        String description = request.getParameter("description");

        Stock stock = new Stock(id, nom, quantity, prixUnite, category, description);
        stockDAO.updateStock(stock);
        response.sendRedirect(request.getContextPath() + "/stocks");
    }
}
