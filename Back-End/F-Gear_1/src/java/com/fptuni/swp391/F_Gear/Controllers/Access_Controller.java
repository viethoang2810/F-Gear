/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptuni.swp391.F_Gear.Controllers;

import com.fptuni.swp391.F_Gear.DAO.Access_Management;
import com.fptuni.swp391.F_Gear.DAO.User_Management;
import com.fptuni.swp391.F_Gear.DTO.Chart;
import com.fptuni.swp391.F_Gear.DTO.Email;
import com.fptuni.swp391.F_Gear.DTO.Users;
import com.fptuni.swp391.F_Gear.Utils.EmailUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
                        String rememberPassword = request.getParameter("remember_password");

                        Users user = Access_Management.check(userName, password);
                        if (user != null) {
                            if (rememberPassword != null) {
                                Cookie cookieUsername = new Cookie("username", userName);
                                Cookie cookiePassword = new Cookie("password", request.getParameter("password"));
                                cookieUsername.setMaxAge(60 * 60 * 24 * 15);
                                cookiePassword.setMaxAge(60 * 60 * 24 * 15);
                                response.addCookie(cookieUsername);
                                response.addCookie(cookiePassword);
                            }
                            if (user.getRoleName().equals("user")) {
                                session.setAttribute("user", user);
                                response.sendRedirect("./Home/Homepage");
                            } else if (user.getRoleName().equals("admin")) {
                                response.sendRedirect("./Access/Dashboard?op=chartadminpage");

                            }

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
                        return;

                    }

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

//                        for (String string : list) {
//                            System.out.println(string);
//                        }
//                        System.out.println("id: " + list.get(3));
//                        System.out.println("email: " + list.get(7));
//                        System.out.println("fullname: " + list.get(14));
//                        System.out.println("avatar: " + list.get(26));
                        Users user = new Users();
                        user.setUserName(list.get(7));
                        user.setAvatar(list.get(26));
                        user.setFullName(list.get(14));
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

                        List<Chart> listGamingQuanity = am.selectLaptopGamingQuantityEachMonth();
                        List<Chart> listOfficeQuanity = am.selectOfficeLaptopQuantityEachMonth();
                        List<Chart> listMouseQuanity = am.selectMousesQuantityEachMonth();
                        List<Chart> listHeadphoneQuanity = am.selectHeadPhonesQuantityEachMonth();
                        List<Chart> listTmp = new ArrayList<>();
                        List<Chart> listTmp2 = new ArrayList<>();
                        List<Chart> listTmp3 = new ArrayList<>();
                        List<Chart> listTmp4 = new ArrayList<>();
                        long total = 0;
                        long quantity = 0;
                        for (int i = 0; i < listTotal.size(); i++) {
                            total = total + listTotal.get(i).getTotal();
                        }
                        for (int i = 0; i < listQuantity.size(); i++) {
                            quantity = quantity + listQuantity.get(i).getQuantity();
                        }

                        //cho laptop gaming
                        for (int i = 1; i <= 12; i++) {
                            listTmp.add(new Chart(i, 0));
                        }
                        for (int i = 0; i < listTmp.size(); i++) {
                            for (int j = 0; j < listGamingQuanity.size(); j++) {
                                if (listTmp.get(i).getMonth() == listGamingQuanity.get(j).getMonth()) {
                                    listTmp.get(i).setQuantity(listGamingQuanity.get(j).getQuantity());
                                }
                            }
                        }

                        //cho laptop van phong
                        for (int i = 1; i <= 12; i++) {
                            listTmp2.add(new Chart(i, 0));
                        }
                        for (int i = 0; i < listTmp2.size(); i++) {
                            for (int j = 0; j < listOfficeQuanity.size(); j++) {
                                if (listTmp2.get(i).getMonth() == listOfficeQuanity.get(j).getMonth()) {
                                    listTmp2.get(i).setQuantity(listOfficeQuanity.get(j).getQuantity());
                                }
                            }
                        }

                        //cho chuot
                        for (int i = 1; i <= 12; i++) {
                            listTmp3.add(new Chart(i, 0));
                        }
                        for (int i = 0; i < listTmp3.size(); i++) {
                            for (int j = 0; j < listMouseQuanity.size(); j++) {
                                if (listTmp3.get(i).getMonth() == listMouseQuanity.get(j).getMonth()) {
                                    listTmp3.get(i).setQuantity(listMouseQuanity.get(j).getQuantity());
                                }
                            }
                        }
                        //cho laptop tai nghe
                        for (int i = 1; i <= 12; i++) {
                            listTmp4.add(new Chart(i, 0));
                        }
                        for (int i = 0; i < listTmp4.size(); i++) {
                            for (int j = 0; j < listHeadphoneQuanity.size(); j++) {
                                if (listTmp4.get(i).getMonth() == listHeadphoneQuanity.get(j).getMonth()) {
                                    listTmp4.get(i).setQuantity(listHeadphoneQuanity.get(j).getQuantity());
                                }
                            }
                        }

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
                        request.setAttribute("listGamingQuanity", listTmp);
                        request.setAttribute("listOfficeQuanity", listTmp2);
                        request.setAttribute("listMouseQuanity", listTmp3);
                        request.setAttribute("listHeadphoneQuanity", listTmp4);

                        url = "/views/Adminpage.jsp";
                        break;
                    }
                    case "forgotpassword": {
                        String userName = request.getParameter("userName");
                        String emailAddress = request.getParameter("gmail");

                        Users user = a.findByUsernameAndGmail(userName, emailAddress);

                        if (user == null) {
                            request.setAttribute("message", "Username or gmail are incorrect");
                        } else {
                            String newPass = EmailUtils.randomAlphaNumeric(8);
                            if (User_Management.updateUserPassword(a.getMD5(newPass), userName)) {

                                Email email = new Email();
                                email.setFrom("dien gmail fpt vo day");
                                email.setFromPassword("dien pass vo day");
                                email.setTo(emailAddress);
                                email.setSubject("Forgot Password Function");
                                StringBuilder sb = new StringBuilder();
                                sb.append("Dear").append(userName).append("<br/>");
                                sb.append("You are used the forgot password function. <br> ");
                                sb.append("Your password is: <br>").append(newPass).append("<br/>");
                                sb.append("Regard<br/>");
                                sb.append("Administrator");

                                email.setContent(sb.toString());

                                EmailUtils.sendEmail(email);

                                request.setAttribute("message", "Email sent to the email Address."
                                        + " Please check and get your password");
                                url = "/views/ForgotPassword_Page.jsp";
                            } else {
                                System.out.println("k update dc");
                            }
                        }
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
