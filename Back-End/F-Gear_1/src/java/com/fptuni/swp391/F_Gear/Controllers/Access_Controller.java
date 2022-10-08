/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptuni.swp391.F_Gear.Controllers;

import com.fptuni.swp391.F_Gear.DAO.Access_Management;
import com.fptuni.swp391.F_Gear.DTO.Chart;
import com.fptuni.swp391.F_Gear.DTO.Users;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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

                            response.sendRedirect("./Home?action=homepage");
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
                        int phone = Integer.parseInt(request.getParameter("phone"));
                        if (password.equals(cofirm)) {
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
                            url = "/views/register.jsp";
                            request.setAttribute("userName", userName);
                            request.setAttribute("password", password);
                            request.setAttribute("phone", phone);
                            request.setAttribute("message", "Passwords do not match!");
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
                        break;
                    }
                    case "chartadminpage": {
                        Access_Management am = new Access_Management();
                        List<Chart> listTotal = am.selectAllTotalEachMonth();
                        List<Chart> listQuantity = am.selectAllQuantityEachMonth();
                        List<Chart> listSellingAllTime = am.selectTop12SellingProductAllTime();
                        List<Chart> listSellingMonth1 = am.selectTopSellingProductMonth1();
                        List<Chart> listSellingMonth2 = am.selectTopSellingProductMonth2();
                        List<Chart> listSellingMonth3 = am.selectTopSellingProductMonth3();
                        List<Chart> listSellingMonth4 = am.selectTopSellingProductMonth4();
                        List<Chart> listSellingMonth5 = am.selectTopSellingProductMonth5();
                        List<Chart> listSellingMonth6 = am.selectTopSellingProductMonth6();
                        List<Chart> listSellingMonth7 = am.selectTopSellingProductMonth7();
                        List<Chart> listSellingMonth8 = am.selectTopSellingProductMonth8();
                        List<Chart> listSellingMonth9 = am.selectTopSellingProductMonth9();
                        List<Chart> listSellingMonth10 = am.selectTopSellingProductMonth10();
                        List<Chart> listSellingMonth11 = am.selectTopSellingProductMonth11();
                        List<Chart> listSellingMonth12 = am.selectTopSellingProductMonth12();

                        long total = 0;
                        long quantity = 0;
                        String strTmp = "";
                        for (int i = 0; i < listTotal.size(); i++) {
                            total = total + listTotal.get(i).getTotal();
                        }
                        for (int i = 0; i < listQuantity.size(); i++) {
                            quantity = quantity + listQuantity.get(i).getQuantity();
                        }
//                        for (int i = 0; i < am.selectTop12SellingProductAllTime().size(); i++) {
//                            strTmp = am.selectTop12SellingProductAllTime().get(i).getProName().substring(0, 10);
//                            listSellingAllTime.get(i).setProName(strTmp);
//                        }
//                        System.out.println(listSellingAllTime);
                        request.setAttribute("total", total);
                        request.setAttribute("quantity", quantity);
                        request.setAttribute("listEachMonth", listTotal);
                        request.setAttribute("listQuantityEachMonth", listQuantity);
                        request.setAttribute("listSellingAllTime", listSellingAllTime);
                        request.setAttribute("listSellingMonth1", listSellingMonth1);
                        request.setAttribute("listSellingMonth2", listSellingMonth2);
                        request.setAttribute("listSellingMonth3", listSellingMonth3);
                        request.setAttribute("listSellingMonth4", listSellingMonth4);
                        request.setAttribute("listSellingMonth5", listSellingMonth5);
                        request.setAttribute("listSellingMonth6", listSellingMonth6);
                        request.setAttribute("listSellingMonth7", listSellingMonth7);
                        request.setAttribute("listSellingMonth8", listSellingMonth8);
                        request.setAttribute("listSellingMonth9", listSellingMonth9);
                        request.setAttribute("listSellingMonth10", listSellingMonth10);
                        request.setAttribute("listSellingMonth11", listSellingMonth11);
                        request.setAttribute("listSellingMonth12", listSellingMonth12);
                        url = "/views/Adminpage.jsp";
                        break;
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
