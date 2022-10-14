/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptuni.swp391.F_Gear.Controllers;

import com.fptuni.swp391.F_Gear.DAO.Product_Management;
import com.fptuni.swp391.F_Gear.DTO.Item;
import com.fptuni.swp391.F_Gear.DTO.Product;
import java.io.IOException;
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
        if (orderAction != null) {
            switch (orderAction) {
                case "addToCart": {
                    int proID = Integer.parseInt(request.getParameter("proID"));
                    int quantity = Integer.parseInt(request.getParameter("quantity"));
                    ArrayList<Product> listProduct = pm.getAllOfProduct();
                    Product product = pm.getProductById(listProduct, proID);
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
                    response.sendRedirect("./Product/Store");
                }
                break;
                case "buyNow": {
                    int proID = Integer.parseInt(request.getParameter("proID"));
                    int quantity = Integer.parseInt(request.getParameter("quantity"));
                    ArrayList<Product> listProduct = pm.getAllOfProduct();
                    Product product = pm.getProductById(listProduct, proID);                 
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
                        session.setAttribute("cart", cart);
                    }
                    response.sendRedirect("./views/Cart.jsp");
                }
                break;
                case "remove": {
                    List<Item> cart = (List<Item>) session.getAttribute("cart");
                    int proID = Integer.parseInt(request.getParameter("proID"));
                    
                    for (int i = 0; i < cart.size(); i++) {
                        if (proID == (cart.get(i).getProduct().getProID())) {
                            cart.remove(i);
                        }
                    }
                    session.setAttribute("cart", cart);
                    response.sendRedirect("./views/Cart.jsp");
                }
                break;
                case "clearAll": {
                    session.removeAttribute("cart");
                    response.sendRedirect("./views/Cart.jsp");
                }
                break;
            }
        }
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
