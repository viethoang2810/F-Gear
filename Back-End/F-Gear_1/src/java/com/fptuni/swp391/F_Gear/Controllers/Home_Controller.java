/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptuni.swp391.F_Gear.Controllers;

import com.fptuni.swp391.F_Gear.DAO.Product_Management;
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
 * @author dell
 */
public class Home_Controller extends HttpServlet {

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
        Product_Management pm = new Product_Management();
        String action = request.getParameter("action");
        String brand = request.getParameter("brand");
        String price = request.getParameter("price");
        String series = request.getParameter("series");
        String type = request.getParameter("type");
        String cate = request.getParameter("cate");
        String option = request.getParameter("option");
        System.out.println(action);
        if (option != null) {
            String keySearch = request.getParameter("keySearch");
            response.sendRedirect("../Product/Store?keySearch=" + keySearch);
            return;
        }
        if (action != null) {
            switch (action) {
                case "Brand": {
                    List<Product> list = pm.filterByBrands(brand, cate);
                    request.setAttribute("listHomepage", list);
                    request.getRequestDispatcher("/views/Homepage.jsp").forward(request, response);
                }
                break;
                case "Price": {
                    List<Product> list = pm.filterByPrice(price, cate);
                    request.setAttribute("listHomepage", list);
                    request.getRequestDispatcher("/views/Homepage.jsp").forward(request, response);
                }
                break;
                case "Series": {
                    List<Product> list = pm.filterMachineSeries(series, cate);
                    request.setAttribute("listHomepage", list);
                    request.getRequestDispatcher("/views/Homepage.jsp").forward(request, response);
                }
                break;
                case "Type": {
                    List<Product> list = pm.filterType(type, cate);
                    request.setAttribute("listHomepage", list);
                    request.getRequestDispatcher("/views/Homepage.jsp").forward(request, response);
                }
                case "TypeCore": {
                    List<Product> list = pm.filterTypeCore(type, cate);
                    request.setAttribute("listHomepage", list);
                    request.getRequestDispatcher("/views/Homepage.jsp").forward(request, response);
                }
                break;
                default:
                    break;
            }
        }
        List<Product> listTop8Pro = pm.selectTop8InHomepage();
        request.setAttribute("listHomepage", listTop8Pro);
        request.getRequestDispatcher("/views/Homepage.jsp").forward(request, response);
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
