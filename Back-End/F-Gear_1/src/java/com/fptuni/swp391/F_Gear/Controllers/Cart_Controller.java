/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptuni.swp391.F_Gear.Controllers;

import com.fptuni.swp391.F_Gear.DAO.Order_Management;
import com.fptuni.swp391.F_Gear.DAO.Product_Management;
import com.fptuni.swp391.F_Gear.DTO.Cart;
import com.fptuni.swp391.F_Gear.DTO.Item;
import com.fptuni.swp391.F_Gear.DTO.Product;
import com.fptuni.swp391.F_Gear.DTO.Users;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author nguye
 */
public class Cart_Controller extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Product_Management pm = new Product_Management();
        HttpSession session = request.getSession();
        String orderAction = request.getParameter("orderOp");
        System.out.println(orderAction);
        if (orderAction != null) {
            switch (orderAction) {
                case "addToCart": {
                    int proID = Integer.parseInt(request.getParameter("proID"));
                    int quantity = Integer.parseInt(request.getParameter("quantity"));
                    ArrayList<Product> listProduct = pm.getAllOfProduct();
                    Product product = pm.getProductById(listProduct, proID);
                    System.out.println(product.getProName());
                    int quantityTmp = 0;
                    boolean confirm = false;
                    if (session.getAttribute("cart") == null) {
                        List<Item> cart = new ArrayList<Item>();
                        cart.add(new Item(product, quantity));
                        session.setAttribute("cart", cart);
                    } else {
                        List<Item> cart = (List<Item>) session.getAttribute("cart");
                        for (int l = 0; l < cart.size(); l++) {
                            if (proID == (cart.get(l).getProduct().getProID())) {
                                quantityTmp = cart.get(l).getQuantity() + quantity;
                                cart.remove(l);
                                cart.add(new Item(product, quantityTmp));
                                confirm = true;
                            }
                        }
                        if (confirm == false) {
                            cart.add(new Item(product, quantity));
                        }
                    }
                    request.getRequestDispatcher("/views/Homepage.jsp").forward(request, response);
                }
                break;
                case "buyNow": {
                    int proID = Integer.parseInt(request.getParameter("proID"));
                    int quantity = Integer.parseInt(request.getParameter("quantity"));
                    ArrayList<Product> listProduct = pm.getAllOfProduct();
                    Product product = pm.getProductById(listProduct, proID);
                    System.out.println(product.getListImage().get(0).getUrl());
                    int quantityTmp = 0;
                    boolean confirm = false;
                    if (session.getAttribute("cart") == null) {
                        List<Item> cart = new ArrayList<Item>();
                        cart.add(new Item(product, quantity));
                        session.setAttribute("cart", cart);
                    } else {
                        List<Item> cart = (List<Item>) session.getAttribute("cart");
                        for (int l = 0; l < cart.size(); l++) {
                            if (proID == (cart.get(l).getProduct().getProID())) {
                                quantityTmp = cart.get(l).getQuantity() + quantity;
                                cart.remove(l);
                                cart.add(new Item(product, quantityTmp));
                                confirm = true;
                            }
                        }
                        if (confirm == false) {
                            cart.add(new Item(product, quantity));
                        }
                    }
                }
                break;
                case "remove": {
                    Cart cart = null;
                    Object o = session.getAttribute("cart");
                    if (o != null) {
                        cart = (Cart) o;
                    } else {
                        cart = new Cart();
                    }
                    int proID = Integer.parseInt(request.getParameter("proID"));
                    cart.removeItem(proID);
                    session.setAttribute("cart", cart);
                    request.getRequestDispatcher("/views/Cart.jsp").forward(request, response);
                }
                break;
                case "clearAll": {
                    session.removeAttribute("cart");
                    request.getRequestDispatcher("/views/Cart.jsp").forward(request, response);
                }
                break;
            }
        }
        request.getRequestDispatcher("/views/Cart.jsp").forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
