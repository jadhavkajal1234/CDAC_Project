package com.app.dao;



import javax.servlet.*;
import javax.servlet.http.*;

import com.app.pojos.Product;

import java.io.*;

public class AddToCart extends HttpServlet
{
    public void service(HttpServletRequest request,
        HttpServletResponse response)
        throws IOException, ServletException
    {

// First get the item values from the request.
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        double price = Double.parseDouble(
            request.getParameter("price"));
        String type = request.getParameter("type");

// Now create an item to add to the cart.
        Product product = new Product(name, description, price, type);

        HttpSession session = request.getSession();

// Get the cart.
        CartDaoImpl cart = (CartDaoImpl) session.
            getAttribute("OrderCart");

// Now display the cart and allow the user to check out or order more items.
        response.sendRedirect(response.encodeRedirectURL(
            "/cart/cartToOrder"));
    }
}


