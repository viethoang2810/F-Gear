/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptuni.swp391.F_Gear.Controllers;

import com.fptuni.swp391.F_Gear.DAO.Admin_Management;
import com.fptuni.swp391.F_Gear.DTO.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nguye
 */
@WebServlet(name = "Admin_Controller", urlPatterns = {"/admin"})
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
        String op = request.getParameter("op").toLowerCase();
        System.out.println(op);
        if (op != null) {
            try {
                switch (op) {
                    //op show list product - vanndh
                    case "list": {
                        Admin_Management am = new Admin_Management();
                        List<Product> list = am.listProduct();
                        request.setAttribute("list", list);
                        request.getRequestDispatcher("/views/admin_Page.jsp").forward(request, response);
                    }
                    break;
                    //op search product - vanndh
                    case "search": {
                        String name = request.getParameter("name").toLowerCase();
                        Admin_Management am = new Admin_Management();
                        if (name != null) {
                            List<Product> list = am.searchProduct(name);
                            request.setAttribute("list", list);
                            request.getRequestDispatcher("/views/admin_Page.jsp").forward(request, response);
                        } else {
                            response.sendRedirect("/admin?op=list");
                        }
                    }
                    break;
                    //show form edit - vanndh
                    case "edit": {
                        int proID = Integer.parseInt(request.getParameter("proID").toLowerCase().trim());
                        Admin_Management am = new Admin_Management();
                        Product p = am.findProductByID(proID);
                        request.setAttribute("product", p);
                        request.getRequestDispatcher("/views/editProduct_Page.jsp").forward(request, response);
                    }
                    break;
                    // update product - vanndh
                    case "update": {
                        try {
                            int proID = Integer.parseInt(request.getParameter("proID"));
                            String proName = request.getParameter("proName");
                            int proOriginal = Integer.parseInt(request.getParameter("proOriginalPrice"));
                            int discount = Integer.parseInt(request.getParameter("Discount"));                            
                            int proCurrentPrice = proOriginal - (proOriginal*discount/100);                           
                            int status = Integer.parseInt(request.getParameter("status"));
                            Product product = new Product();
                            product.setProID(proID);
                            product.setProName(proName);
                            product.setProOriginalPrice(Integer.toString(proOriginal));
                            product.setDiscount(discount);
                            product.setProCurrentPrice(Integer.toString(proCurrentPrice));
                            product.setStatus(status);
                            Admin_Management am = new Admin_Management();
                            if (am.updateProduct(product)) {
                                response.sendRedirect("./admin?op=list");
                                return;
                            }
                        } catch (NumberFormatException ex) {
                            System.out.println(ex);
                        }
                        request.setAttribute("result", "Can't update this Product.");
                        request.getRequestDispatcher("/admin?op=edit").forward(request, response);
                    }
                    break;
                }
            } catch (Exception e) {
                log("Error at MainController: " + e.toString());
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
