/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptuni.swp391.F_Gear.Controllers;

import com.fptuni.swp391.F_Gear.DAO.Category_Management;
import com.fptuni.swp391.F_Gear.DTO.Category;
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
public class Category_Controller extends HttpServlet {

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
        List<Category> listOfCategory = new ArrayList<>();
        Category_Management cm = new Category_Management();
        if (adminAction != null) {
            switch (adminAction) {
                case "updated": {
                    int cateID = Integer.parseInt(request.getParameter("cate_ID"));
                    String cateName = request.getParameter("cateName");
                    Category category = new Category();
                    category.setCateID(cateID);
                    category.setCateName(cateName);
                    cm.updateCategory(category);
                }
                break;
                case "create": {
                    String cateName = request.getParameter("cateName");
                    Category category = new Category();
                    category.setCateName(cateName);
                    cm.create(category);
                }
                break;
                case "search": {
                    String name = request.getParameter("name").toLowerCase();
                    if (name != null) {
                        List<Category> list = cm.searchCategory(name);
                        request.setAttribute("listOfCategory", list);
                        request.getRequestDispatcher("/views/Category_Management.jsp").forward(request, response);
                    }
                }
                break;
            }
        }
        listOfCategory = cm.selectAll();
        request.setAttribute("listOfCategory", listOfCategory);
        request.getRequestDispatcher("/views/Category_Management.jsp").forward(request, response);
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
