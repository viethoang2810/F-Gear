/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptuni.swp391.F_Gear.Controllers;

import com.fptuni.swp391.F_Gear.DAO.User_Management;
import com.fptuni.swp391.F_Gear.DTO.Users;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author Admin
 */
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10, // 10 MB
        maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class User_Controller extends HttpServlet {

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
        doPost(request, response);

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

        String path = request.getPathInfo();
        if (path.equals("/UserProfile")) {
            User_Management um = new User_Management();
            boolean flagCheckUpdate = false;
            String usernameKey = request.getParameter("username");
            HttpSession userSession = request.getSession();

            Users us = (Users) userSession.getAttribute("user");
            String submitForm = request.getParameter("action");
            if (submitForm != null) {
                String fullName = request.getParameter("fullname");
                String phoneNumber = request.getParameter("phonenumber");
                String gender = request.getParameter("gender");
                um.updateUserInfor(fullName, phoneNumber, gender, us.getUserName());
                us.setFullName(fullName);
                us.setPhoneNumber(phoneNumber);
                us.setGender(gender);

            }
            try {

                Part filepart = request.getPart("file-upload");
                String realPath = request.getServletContext().getRealPath("/avatar");
                String fileName = Paths.get(filepart.getSubmittedFileName()).getFileName().toString();
                flagCheckUpdate = um.updateUserAvatar(fileName, us.getUserName());

                if (!Files.exists(Paths.get(realPath))) {
                    Files.createDirectory(Paths.get(realPath));
                }
                filepart.write(realPath + "/" + fileName);
                File sourceImage = new File(realPath + "/" + fileName);

                us.setAvatar(fileName);

            } catch (Exception e) {
                //Handle exception in here
            }
            request.setAttribute("gender", us.getGender());
            request.getRequestDispatcher("/views/User_Profile.jsp").forward(request, response);
        } else if (path.equals("/Buying_History")) {
            request.getRequestDispatcher("/views/Buying_History.jsp").forward(request, response);

        }
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
