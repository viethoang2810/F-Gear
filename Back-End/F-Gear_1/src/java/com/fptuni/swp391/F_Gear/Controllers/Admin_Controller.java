/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptuni.swp391.F_Gear.Controllers;

import com.fptuni.swp391.F_Gear.DAO.Admin_Management;
import com.fptuni.swp391.F_Gear.DAO.Product_Management;
import com.fptuni.swp391.F_Gear.DTO.Product;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nguye
 */
public class Admin_Controller extends HttpServlet {

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
        Admin_Management am = new Admin_Management();
        ArrayList<Product> listOfProduct = new ArrayList<>();
        String adminAction = request.getParameter("adminOp");
        if (adminAction != null) {
            switch (adminAction) {
                case "updated": {
                    int proId = Integer.parseInt(request.getParameter("product_id"));
                    String name = request.getParameter("proName");
                    int proPrice = Integer.parseInt(request.getParameter("originPrice"));
                    int discount = Integer.parseInt(request.getParameter("discount"));
                    int finalPrice = proPrice - (proPrice / 100 * discount);
                    Product product = new Product();
                    product.setProID(proId);
                    product.setProName(name);
                    product.setProOriginalPrice(Integer.toString(proPrice));
                    product.setDiscount(discount);
                    product.setProCurrentPrice(Integer.toString(finalPrice));
                    am.updateProduct(product);
                }
                break;
                case "remove": {
                    int id = Integer.parseInt(request.getParameter("product_id"));
                    am = new Admin_Management();
                    am.remove(id);
                }
                break;
                case "cancel":
                    break;
                case "search": {
                    String name = request.getParameter("name").toLowerCase();
                    am = new Admin_Management();
                    if (name != null) {
                        List<Product> list = am.searchProduct(name);
                        request.setAttribute("listOfProduct", list);
                        request.getRequestDispatcher("/views/Admin_Product_Management.jsp").forward(request, response);
                    }
                }
                break;
            }
        }
        listOfProduct = pm.getAllOfProduct();
        request.setAttribute("listOfProduct", listOfProduct);
        request.getRequestDispatcher("/views/Admin_Product_Management.jsp").forward(request, response);
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
