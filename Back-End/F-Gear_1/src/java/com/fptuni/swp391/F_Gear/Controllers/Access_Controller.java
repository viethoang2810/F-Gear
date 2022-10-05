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
import java.util.ArrayList;
import java.util.StringTokenizer;
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
@WebServlet(name = "Access_Controller", urlPatterns = {"/Access/*"})
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
        String op = request.getParameter("op");
//        String access = request.getParameter("access");
//        if(access != null){
//            switch(access){
//                case "register":
//                    request.getRequestDispatcher("/view/register.jsp").forward(request, response);
//                    break;
//            }
//        }
        Access_Management a = new Access_Management();
        if (op != null) {
            HttpSession session = request.getSession(true);

            try {
                switch (op.toLowerCase()) {
                    case "login": {
                        String userName = request.getParameter("userName");
                        String password = a.getMD5(request.getParameter("password"));
                        Users user = Access_Management.check(userName, password);
                        if (user != null) {
                            session.setAttribute("user", user);

                            response.sendRedirect("./Home/HomePage");
                            return;
                        } else {
                            url = "/views/login.jsp";
                            request.setAttribute("message", "Incorrect Username or Password");
                        }
                    }
                    break;
                    case "logout": {
                        session.invalidate();
                        response.sendRedirect("./");
                    }
                    break;

                    case "register": {

                        String userName = request.getParameter("userName");
                        String password = request.getParameter("password");
                        String cofirm = request.getParameter("cofirm");
                        String phone = request.getParameter("phone");
                        String regex = "(84|0[3|5|7|8|9])+([0-9]{8})\\b";
                        if (password.equals(cofirm) && phone.matches(regex)) {
                            if (a.checkUserName(userName)) {
                                Users user = new Users();
                                user.setUserName(userName);
                                user.setPassword(a.getMD5(password));
                                user.setPhoneNumber(phone);
                                request.setAttribute("user", user);

                                if (a.signUp(user)) {
                                    url = "/views/login.jsp";
                                } else {
                                    url = "/views/register.jsp";
                                    request.setAttribute("message", "Unable to register.");
                                }

                            } else {
                                url = "/views/register.jsp";
                                request.setAttribute("message", "Username is already taken.");
                            }

                        } else {
                            if (!password.equals(cofirm)) {
                                url = "/views/register.jsp";
                                request.setAttribute("userName", userName);
                                request.setAttribute("password", password);
                                request.setAttribute("phone", phone);
                                request.setAttribute("message", "Passwords do not match!");
                            }
                            if (!phone.matches(regex)) {
                                url = "/views/register.jsp";
                                request.setAttribute("userName", userName);
                                request.setAttribute("password", password);
                                request.setAttribute("cofirm", cofirm);
                                request.setAttribute("message", "Phone number is not correct!");
                            }
                        }

                    }
                    break;

                    case "signup": {
                        url = "/views/register.jsp";
                    }
                    break;

                    case "loginwithgoogle": {
                        String code = request.getParameter("code");
                        String accessToken = Access_Management.getToken(code);
                        System.out.println(code);
                        System.out.println(Access_Management.getUserInfo(accessToken));

                        StringTokenizer st = new StringTokenizer(Access_Management.getUserInfo(accessToken), "{ ,\"\n}");
                        ArrayList<String> list = new ArrayList<>();
                        while (st.hasMoreTokens()) {
                            list.add(st.nextToken());
                        }
//                        System.out.println("id: " + list.get(2));
//                        System.out.println("email: " + list.get(5));
//                        System.out.println("avatar: " + list.get(11));
                        Users user = new Users();
                        user.setUserName(list.get(5));
                        user.setAvatar(list.get(11));
                        user.setFullName(list.get(5));
                        System.out.println(user.getUserName());
                        System.out.println("user: " + user.toString());

                        if (a.checkUserName(user.getUserName())) {
                            if (a.signUpWithGoogle(user)) {
                                System.out.println("login dc, va dk dc do chua co tk");
                            }
                        } else {
                            System.out.println("login dc, nhung k dk dc vi da co tk");
                        }

                        session.setAttribute("user", user);
//                        response.sendRedirect("./Home/HomePage");
                        url = "/views/Homepage.jsp";
                    }

                }
            } catch (Exception e) {
                log("Error at MainController: " + e.toString());
            }
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
