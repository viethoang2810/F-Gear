/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptuni.swp391.F_Gear.Controllers;

import com.fptuni.swp391.F_Gear.DAO.Cart_Management;
import com.fptuni.swp391.F_Gear.DAO.Payment_Services;
import com.fptuni.swp391.F_Gear.DTO.Item;
import com.fptuni.swp391.F_Gear.DTO.Orders;
import com.fptuni.swp391.F_Gear.DTO.Users;
import com.paypal.api.payments.PayerInfo;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.Transaction;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author dell
 */
@WebServlet(name = "excute_payment", urlPatterns = {"/excute_payment"})
public class excute_payment extends HttpServlet {

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
        String paymentId = request.getParameter("paymentId");
        String payerId = request.getParameter("PayerID");
//        String payerId = "3JQECFKTPAK8A";
        System.out.println("paymentID: " + paymentId);
        System.out.println("payerId: " + payerId);
        try {
            Payment_Services paymentServices = new Payment_Services();
            Payment payment = paymentServices.executePayment(paymentId, payerId);

            PayerInfo payerInfo = payment.getPayer().getPayerInfo();
            Transaction transaction = payment.getTransactions().get(0);
            request.setAttribute("payer", payerInfo);
            request.setAttribute("transaction", transaction);

//            add to db
            HttpSession session = request.getSession();
            Cart_Management cm = new Cart_Management();
            Users u = (Users) session.getAttribute("user");
            List<Item> cart = (List<Item>) session.getAttribute("cart");

            cm.createOrder(u);
            List<Orders> listOrders = cm.listOrder();
            Orders o = listOrders.get(listOrders.size() - 1);

            for (int i = 0; i < cart.size(); i++) {
                cm.createOrderDetail(o, cart.get(i).getProduct(), cart.get(i).getQuantity(), cart.get(i).getPrice());
            }
            session.removeAttribute("cart");
            session.removeAttribute("total");
            request.getRequestDispatcher("./views/receipt.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Could not execute payment");
            request.getRequestDispatcher("./views/paymentError.jsp").forward(request, response);
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
