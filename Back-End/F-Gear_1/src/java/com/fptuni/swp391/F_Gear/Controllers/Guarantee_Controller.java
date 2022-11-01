/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptuni.swp391.F_Gear.Controllers;

import com.fptuni.swp391.F_Gear.DAO.Guarantee_Management;
import com.fptuni.swp391.F_Gear.DTO.Guarantee;
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
public class Guarantee_Controller extends HttpServlet {

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
        List<Guarantee> listOfGuarantee = new ArrayList<>();
        Guarantee_Management bm = new Guarantee_Management();
        if (adminAction != null) {
            switch (adminAction) {
                case "updated": {
                    int guaID = Integer.parseInt(request.getParameter("gua_ID"));
                    String guaName = request.getParameter("detailGua");
                    Guarantee guarantee = new Guarantee();
                    guarantee.setGuaranteeID(guaID);
                    guarantee.setDetailGua(guaName);
                    bm.updateGuarantee(guarantee);
                }
                break;
                case "create": {
                    String detailGua = request.getParameter("detailGua");
                    Guarantee guarantee = new Guarantee();
                    guarantee.setDetailGua(detailGua);
                    bm.create(guarantee);
                }
                break;
                case "search": {
                    String name = request.getParameter("name").toLowerCase();
                    if (name != null) {
                        List<Guarantee> list = bm.searchGuarantee(name);
                        request.setAttribute("listOfGuarantee", list);
                        request.getRequestDispatcher("/views/Guarantee_Management.jsp").forward(request, response);
                    }
                }
                break;
            }
        }
        listOfGuarantee = bm.selectAll();
        request.setAttribute("listOfGuarantee", listOfGuarantee);
        request.getRequestDispatcher("/views/Guarantee_Management.jsp").forward(request, response);
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
