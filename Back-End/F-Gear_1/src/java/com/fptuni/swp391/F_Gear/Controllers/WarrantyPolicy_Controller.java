/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptuni.swp391.F_Gear.Controllers;

import com.fptuni.swp391.F_Gear.DAO.CateBrand_Management;
import com.fptuni.swp391.F_Gear.DTO.CateBrand;
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
public class WarrantyPolicy_Controller extends HttpServlet {

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
        CateBrand_Management cm = new CateBrand_Management();
        if (adminAction != null) {
            switch (adminAction) {
                case "create": {
                    if (cm.searchCateBrand(Integer.parseInt(request.getParameter("category")), Integer.parseInt(request.getParameter("brand")))) {
                        int cateName = Integer.parseInt(request.getParameter("category"));
                        int brandName = Integer.parseInt(request.getParameter("brand"));
                        String typeWarranty = request.getParameter("typeWarranty");
                        String intendTime = request.getParameter("intendTime");
                        String note = request.getParameter("note");
                        CateBrand policy = new CateBrand();
                        policy.setCateID(cateName);
                        policy.setBrandID(brandName);
                        policy.setTypePolicy(typeWarranty);
                        policy.setIntendTime(intendTime);
                        policy.setNote(note);
                        cm.create(policy);
                    } else {
                        request.setAttribute("result", "Duplicate CateID and BrandID");
                    }
                }
                break;
                case "updated": {
                    int cateID = Integer.parseInt(request.getParameter("cateID"));
                    int brandID = Integer.parseInt(request.getParameter("brandID"));
                    String typePolicy = request.getParameter("typePolicy");
                    String intendTime = request.getParameter("intendTime");
                    String note = request.getParameter("note");
                    System.out.println(typePolicy);
                    CateBrand cateBrand = new CateBrand();
                    cateBrand.setCateID(cateID);
                    cateBrand.setBrandID(brandID);
                    cateBrand.setTypePolicy(typePolicy);
                    cateBrand.setIntendTime(intendTime);
                    cateBrand.setNote(note);
                    cm.updateCateBrand(cateBrand);
                }
                break;
                case "search": {
                    String name = request.getParameter("name").toLowerCase();
                    if (name != null) {
                        List<CateBrand> list = cm.search(name);
                        request.setAttribute("listOfPolicy", list);
                        request.getRequestDispatcher("/views/WarrantyPolicy_Management.jsp").forward(request, response);
                    }
                }
                break;
            }
        }
        List<CateBrand> listOfPolicy = new ArrayList<>();
        listOfPolicy = cm.getAllCateBrand();
        request.setAttribute("listOfPolicy", listOfPolicy);
        request.getRequestDispatcher("/views/WarrantyPolicy_Management.jsp").forward(request, response);
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
