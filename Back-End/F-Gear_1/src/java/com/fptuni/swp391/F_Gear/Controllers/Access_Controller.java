/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptuni.swp391.F_Gear.Controllers;

import com.fptuni.swp391.F_Gear.DAO.Access_Management;
import com.fptuni.swp391.F_Gear.DTO.Users;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "Access_Controller", urlPatterns = {"/accesscontroller"})
public class Access_Controller extends HttpServlet {

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
        String url = "";
        HttpSession session = request.getSession();
        String op = request.getParameter("op").toLowerCase();
        try {
            switch (op) {
                case "login": {
                    String userName = request.getParameter("userName");
                    int password = Integer.parseInt(request.getParameter("password"));
                    Users user = Access_Management.check(userName, password);
                    if (user != null) {
                        url = "/views/Homepage.jsp";
                        session.setAttribute("user", user);
                    } else {
                        url = "/views/login.jsp";
                        request.setAttribute("message", "Incorrect Username or Password");
                    }
                }
                break;
                case "logout": {
                    session.invalidate();
                    url = "/views/Homepage.jsp";
                }
                break;

                case "register": {
                    String userName = request.getParameter("userName");
                    int password = Integer.parseInt(request.getParameter("password"));
                    int cofirm = Integer.parseInt(request.getParameter("cofirm"));
                    int phone = Integer.parseInt(request.getParameter("phone"));
                    if (password != cofirm) {
                        url = "/views/register.jsp";
                        request.setAttribute("message", "Passwords do not match!");
                    } else {
                        Users user = Access_Management.check(userName);
                        if (user == null) {
                            user = new Users();
                            user.setUserName(userName);
                            user.setPassword(password);
                            user.setPhoneNumber(phone);
                            request.setAttribute("user", user);

                            if (Access_Management.signUp(user)) {
                                url = "/views/login.jsp";
                            } else {
                                url = "/views/register.jsp";
                                request.setAttribute("message", "Username is already taken.");
                            }
                        } else {
                            url = "/views/register.jsp";
                            request.setAttribute("message", "Username is already taken.");
                        }
                    }
                }
                break;

            }
        } catch (Exception e) {
            log("Error at MainController: " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
