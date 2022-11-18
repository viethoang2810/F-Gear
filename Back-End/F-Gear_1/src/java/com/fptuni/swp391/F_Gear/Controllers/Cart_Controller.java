/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptuni.swp391.F_Gear.Controllers;

import com.fptuni.swp391.F_Gear.DAO.Cart_Management;
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
                    List<Item> cart = (List<Item>) session.getAttribute("cart");

                    Cart_Management cm = new Cart_Management();
                    int proID = Integer.parseInt(request.getParameter("proID"));
                    int quantity = Integer.parseInt(request.getParameter("quantity"));
                    ArrayList<Product> listProduct = pm.getAllOfProduct2();
                    Product product = pm.getProductById(listProduct, proID);
                    String proCurrentPrice = product.getProCurrentPrice().replaceAll(",", "").trim();
                    long price = Long.parseLong(proCurrentPrice);
                    int quantityTmp = 0;
                    boolean confirm = false;
                    if (cart == null) {
                        cart = new ArrayList<Item>();
                        cart.add(new Item(product, quantity, price));
                        session.setAttribute("cart", cart);
                        session.setAttribute("size", cart.size());
                        totalPrice(request, response);
                        totalQuantity(request, response);
                    } else {
                        cart = (List<Item>) session.getAttribute("cart");
                        for (int l = 0; l < cart.size(); l++) {
                            if (proID == (cart.get(l).getProduct().getProID())) {
                                quantityTmp = cart.get(l).getQuantity() + quantity;
                                cart.remove(l);
                                cart.add(new Item(product, quantityTmp, price));
                                confirm = true;
                                totalPrice(request, response);
                                totalQuantity(request, response);
                                session.setAttribute("cart", cart);
                                session.setAttribute("size", cart.size());
                            }
                        }
                        if (confirm == false) {
                            cart.add(new Item(product, quantity, price));
                            totalPrice(request, response);
                            totalQuantity(request, response);
                            session.setAttribute("cart", cart);
                            session.setAttribute("size", cart.size());
                        }
                    }
                    if (cm.findItemInCart(proID, cart)) {
                          session.setAttribute("checkAdded", cm.findItemInCart(proID, cart));
                    }

                    response.sendRedirect("./Detail/DetailPro?proID=" + proID);
                }
                break;
                case "buyNow": {
                    int proID = Integer.parseInt(request.getParameter("proID"));
                    int quantity = Integer.parseInt(request.getParameter("quantity"));
                    ArrayList<Product> listProduct = pm.getAllOfProduct2();
                    Product product = pm.getProductById(listProduct, proID);
                    String proCurrentPrice = product.getProCurrentPrice().replaceAll(",", "").trim();
                    long price = Long.parseLong(proCurrentPrice);
                    int quantityTmp = 0;
                    boolean confirm = false;
                    if (session.getAttribute("cart") == null) {
                        List<Item> cart = new ArrayList<Item>();
                        cart.add(new Item(product, quantity, price));
                        session.setAttribute("cart", cart);
                        session.setAttribute("size", cart.size());
                        totalPrice(request, response);
                        totalQuantity(request, response);
                    } else {
                        List<Item> cart = (List<Item>) session.getAttribute("cart");
                        for (int l = 0; l < cart.size(); l++) {
                            if (proID == (cart.get(l).getProduct().getProID())) {
                                quantityTmp = cart.get(l).getQuantity() + quantity;
                                cart.remove(l);
                                cart.add(new Item(product, quantityTmp, price));
                                confirm = true;
                                session.setAttribute("cart", cart);
                                session.setAttribute("size", cart.size());
                                totalPrice(request, response);
                                totalQuantity(request, response);
                            }
                        }
                        if (confirm == false) {
                            cart.add(new Item(product, quantity, price));
                            session.setAttribute("cart", cart);
                            totalPrice(request, response);
                            totalQuantity(request, response);
                            session.setAttribute("cart", cart);
                            session.setAttribute("size", cart.size());
                        }
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
                    session.setAttribute("size", cart.size());
                    totalPrice(request, response);
                    totalQuantity(request, response);
                    response.sendRedirect("./views/Cart.jsp");
                }
                break;
                case "clearAll": {
                    session.removeAttribute("size");
                    session.removeAttribute("cart");
                    session.removeAttribute("total");
                    session.removeAttribute("quantity");
                    response.sendRedirect("./views/Cart.jsp");
                }
                break;
                case "decreasing": {
                    int proID = Integer.parseInt(request.getParameter("proID"));
                    int quantity = Integer.parseInt(request.getParameter("quantity"));
                    ArrayList<Product> listProduct = pm.getAllOfProduct2();
                    Product product = pm.getProductById(listProduct, proID);
                    String proCurrentPrice = product.getProCurrentPrice().replaceAll(",", "").trim();
                    long price = Long.parseLong(proCurrentPrice);
                    int quantityTmp = 0;
                    List<Item> cart = (List<Item>) session.getAttribute("cart");
                    for (int l = 0; l < cart.size(); l++) {
                        if (proID == (cart.get(l).getProduct().getProID())) {
                            if (quantity > 1) {
                                quantityTmp = quantity - 1;
                                cart.remove(l);
                                cart.add(new Item(product, quantityTmp, price));
                                session.setAttribute("cart", cart);
                                totalPrice(request, response);
                                totalQuantity(request, response);
                            } else {
                                cart.remove(l);
                                session.setAttribute("cart", cart);
                                totalPrice(request, response);
                                totalQuantity(request, response);
                            }
                        }
                    }
                    response.sendRedirect("./views/Cart.jsp");
                }
                break;
                case "increasing": {
                    int proID = Integer.parseInt(request.getParameter("proID"));
                    int quantity = Integer.parseInt(request.getParameter("quantity"));
                    ArrayList<Product> listProduct = pm.getAllOfProduct2();
                    Product product = pm.getProductById(listProduct, proID);
                    String proCurrentPrice = product.getProCurrentPrice().replaceAll(",", "").trim();
                    long price = Long.parseLong(proCurrentPrice);
                    int quantityTmp = 0;
                    List<Item> cart = (List<Item>) session.getAttribute("cart");
                    for (int l = 0; l < cart.size(); l++) {
                        if (proID == (cart.get(l).getProduct().getProID())) {
                            quantityTmp = quantity + 1;
                            cart.remove(l);
                            cart.add(new Item(product, quantityTmp, price));
                            session.setAttribute("cart", cart);
                            totalPrice(request, response);
                            totalQuantity(request, response);
                        }
                    }
                    response.sendRedirect("./views/Cart.jsp");
                }
                break;
                case "inputQuantity": {
                    int proID = Integer.parseInt(request.getParameter("proID"));
                    int quantity = Integer.parseInt(request.getParameter("quantity"));
                    ArrayList<Product> listProduct = pm.getAllOfProduct2();
                    Product product = pm.getProductById(listProduct, proID);
                    String proCurrentPrice = product.getProCurrentPrice().replaceAll(",", "").trim();
                    long price = Long.parseLong(proCurrentPrice);
                    List<Item> cart = (List<Item>) session.getAttribute("cart");
                    for (int l = 0; l < cart.size(); l++) {
                        if (proID == (cart.get(l).getProduct().getProID())) {
                            cart.add(new Item(product, quantity, price));
                            cart.remove(l);
                            session.setAttribute("cart", cart);
                            session.setAttribute("size", cart.size());
                            totalPrice(request, response);
                            totalQuantity(request, response);
                        }
                    }
                }
                response.sendRedirect("./views/Cart.jsp");
                break;
            }
        }
    }

    protected void totalPrice(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        List<Item> cart = (List<Item>) session.getAttribute("cart");
        long subTotal;
        long total = 0;
        for (int i = 0; i < cart.size(); i++) {
            subTotal = cart.get(i).getPrice() * cart.get(i).getQuantity();
            total = total + subTotal;
        }
        session.setAttribute("total", total);
    }

    protected void totalQuantity(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        List<Item> cart = (List<Item>) session.getAttribute("cart");
        int subQuantity;
        int quantity = 0;
        for (int i = 0; i < cart.size(); i++) {
            subQuantity = cart.get(i).getQuantity();
            quantity = quantity + subQuantity;
        }
        session.setAttribute("quantity", quantity);
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
