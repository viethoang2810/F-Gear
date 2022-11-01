/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptuni.swp391.F_Gear.Controllers;

import com.fptuni.swp391.F_Gear.DAO.WarrantyPolicy_Management;
import com.fptuni.swp391.F_Gear.DTO.WarrantyPolicy;
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
        List<WarrantyPolicy> listOfPolicy = new ArrayList<>();
        WarrantyPolicy_Management bm = new WarrantyPolicy_Management();
        if (adminAction != null) {
            switch (adminAction) {
                case "search": {
                    String name = request.getParameter("name").toLowerCase();
                    if (name != null) {
                        List<WarrantyPolicy> list = bm.searchPolicy(name);
                        request.setAttribute("listOfPolicy", list);
                        request.getRequestDispatcher("/views/WarrantyPolicy_Management.jsp").forward(request, response);
                    }
                }
                break;
                case "create": {
                    String cateName = request.getParameter("cateName");
                    String brandName = request.getParameter("brandName");
                    String typeWarranty = request.getParameter("typeWarranty");
                    String intendTime = request.getParameter("intendTime");
                    String note = request.getParameter("note");
                    WarrantyPolicy policy = new WarrantyPolicy();
                    policy.setCateName(cateName);
                    policy.setBrandName(brandName);
                    policy.setTypeWarranty(typeWarranty);
                    policy.setIntendTime(intendTime);
                    policy.setNote(note);
                    bm.create(policy);
                }
                break;
                case "remove": {
                    int id = Integer.parseInt(request.getParameter("policy_id"));
                    bm.remove(id);
                }
                break;
                case "cancel":
                    break;
                case "updated": {
                    int policy_id = Integer.parseInt(request.getParameter("policy_id"));
                    String cateName = request.getParameter("cateName");
                    String brandName = request.getParameter("brandName");
                    String typeWarranty = request.getParameter("typeWarranty");
                    String intendTime = request.getParameter("intendTime");
                    String note = request.getParameter("note");
                    WarrantyPolicy policy = new WarrantyPolicy();
                    policy.setWaID(policy_id);
                    policy.setCateName(cateName);
                    policy.setBrandName(brandName);
                    policy.setTypeWarranty(typeWarranty);
                    policy.setIntendTime(intendTime);
                    policy.setNote(note);
                    bm.update(policy);
                }
                break;

            }
        }
        listOfPolicy = bm.selectAll();
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
