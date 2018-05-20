package controller;

import model.Product;
import service.ProductService;
import service.ProductServiceIplm;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "CartServlet", urlPatterns = "/cart")
public class CartServlet extends HttpServlet {
    ProductService productService = new ProductServiceIplm();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                addToCart(request, response);
                break;
            case "update":
                updateTOCart (request, response);
                break;
            default:
                response.sendRedirect("/");
                break;
        }
    }

    private void addToCart(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        HttpSession session = request.getSession();
        Map<Integer, Product> carts = new HashMap<>();

        Product product = this.productService.findById(id);
        carts.put(id, product);
        session.setAttribute("shoppingCart", carts);

        response.sendRedirect("cart.jsp");

    }

    private  void removeCart(HttpServletRequest request, HttpServletResponse response) throws IOException{}
    private void updateTOCart(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int amount = Integer.parseInt(request.getParameter("amount"));
        if(amount >= 0) {
            if(amount == 0) {
                removeCart(request, response);
            } else {
                HttpSession session = request.getSession();
                Map shoppingCart = (HashMap) session.getAttribute("shoppingCart");
                Product product = (Product) shoppingCart.get(id);
                boolean isExistProduct = product != null;

                if(isExistProduct) {
                    product.setAmount(amount);
                    shoppingCart.put(id, product);
                    session.setAttribute("shoppingCart", shoppingCart);
                }
                response.sendRedirect("cart.jsp");
            }
        }
    }
}
