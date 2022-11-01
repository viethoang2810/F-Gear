/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptuni.swp391.F_Gear.Controllers;

import com.fptuni.swp391.F_Gear.DAO.Brand_Management;
import com.fptuni.swp391.F_Gear.DTO.Brand;
import java.io.IOException;
import java.io.PrintWriter;
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
public class Brand_Controller extends HttpServlet {

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
        String adminAction = request.getParameter("adminOp");
        List<Brand> listOfBrand = new ArrayList<>();
        Brand_Management bm = new Brand_Management();
        if (adminAction != null) {
            switch (adminAction) {
                case "updated": {
                    int branID = Integer.parseInt(request.getParameter("brand_ID"));
                    String brandName = request.getParameter("brandName");
                    Brand brand = new Brand();
                    brand.setBrandID(branID);
                    brand.setBrandName(brandName);
                    bm.updateBrand(brand);
                }
                break;
                case "create": {
                    String brandName = request.getParameter("brandName");
                    Brand brand = new Brand();
                    brand.setBrandName(brandName);
                    bm.create(brand);
                }
                break;
                case "search": {
                    String name = request.getParameter("name").toLowerCase();
                    System.out.println(name);
                    if (name != null) {
                        List<Brand> list = bm.searchBrand(name);
                        request.setAttribute("listOfBrand", list);
                        request.getRequestDispatcher("/views/Brand_Management.jsp").forward(request, response);
                    }
                }
                break;
            }
        }
        listOfBrand = bm.selectAll();
        request.setAttribute("listOfBrand", listOfBrand);
        request.getRequestDispatcher("/views/Brand_Management.jsp").forward(request, response);
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
