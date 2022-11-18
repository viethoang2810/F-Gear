/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptuni.swp391.F_Gear.Controllers;

import com.fptuni.swp391.F_Gear.DAO.AccountManagement;
import com.fptuni.swp391.F_Gear.DAO.Admin_Management;
import com.fptuni.swp391.F_Gear.DAO.Product_Management;
import com.fptuni.swp391.F_Gear.DTO.Account;
import com.fptuni.swp391.F_Gear.DTO.Images;
import com.fptuni.swp391.F_Gear.DTO.ProSpec;
import com.fptuni.swp391.F_Gear.DTO.Product;
import java.io.IOException;
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
public class Admin_Controller extends HttpServlet {

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
        Product_Management pm = new Product_Management();
        Admin_Management am = new Admin_Management();
        String path = request.getPathInfo();
        switch (path) {
            case "/Dashboard":
                request.getRequestDispatcher("/views/Adminpage.jsp").forward(request, response);
                break;
            case "/Management":
                ArrayList<Product> listOfProduct = new ArrayList<>();
                String adminAction = request.getParameter("adminOp");
                if (adminAction != null) {
                    switch (adminAction) {
                        case "updated": {
                            int proId = Integer.parseInt(request.getParameter("product_id"));
                            String name = request.getParameter("proName");
                            String price = request.getParameter("originPrice").replaceAll(",", "").trim();
                            //int proPrice = Integer.parseInt(request.getParameter("originPrice"));
                            int proPrice = Integer.parseInt(price);
                            int discount = Integer.parseInt(request.getParameter("discount"));
                            int finalPrice = proPrice - (proPrice / 100 * discount);
                            Product product = new Product();
                            product.setProID(proId);
                            product.setProName(name);
                            product.setProOriginalPrice(Integer.toString(proPrice));
                            product.setDiscount(discount);
                            product.setProCurrentPrice(Integer.toString(finalPrice));
                            am.updateProduct(product);
                        }
                        break;
                        case "remove": {
                            int id = Integer.parseInt(request.getParameter("product_id"));
                            am = new Admin_Management();
                            am.remove(id);
                        }
                        break;
                        case "cancel":
                            break;
                        case "search": {
                            String name = request.getParameter("name").toLowerCase();
                            am = new Admin_Management();
                            if (name != null) {
                                List<Product> list = am.searchProduct(name);
                                request.setAttribute("listOfProduct", list);
                                request.getRequestDispatcher("/views/Admin_Product_Management.jsp").forward(request, response);
                            }
                        }
                        break;
                        case "add_product":
                            if (am.searchProductI(request.getParameter("proName"))) {
                                try {
                                    ArrayList<Images> listImage = new ArrayList<>();
                                    ArrayList<ProSpec> listSpec = new ArrayList<>();

                                    String nameProduct = request.getParameter("proName");
                                    String price = request.getParameter("originPrice");
                                    String brandID = request.getParameter("brand");
                                    String categoryID = request.getParameter("category");
                                    String guaID = request.getParameter("guarantee");
                                    //insert product
                                    Product p = new Product();
                                    p.setProName(nameProduct);
                                    p.setProOriginalPrice(price);
                                    p.setBrandID(Integer.parseInt(brandID));
                                    p.setCateID(Integer.parseInt(categoryID));
                                    p.setGuaID(Integer.parseInt(guaID));
                                    request.setAttribute("product", p);

                                    //insert image
                                    if (!request.getParameter("file-upload1").isEmpty()) {
                                        listImage.add(new Images(request.getParameter("file-upload1")));
                                    }
                                    if (!request.getParameter("file-upload2").isEmpty()) {
                                        listImage.add(new Images(request.getParameter("file-upload2")));
                                    }
                                    if (!request.getParameter("file-upload3").isEmpty()) {
                                        listImage.add(new Images(request.getParameter("file-upload3")));
                                    }

                                    //insert spec
                                    if (!request.getParameter("cpu").isEmpty()) {
                                        listSpec.add(new ProSpec(1, request.getParameter("cpu")));
                                    }
                                    request.setAttribute("cpu", request.getParameter("cpu"));

                                    if (!request.getParameter("ram").isEmpty()) {
                                        listSpec.add(new ProSpec(2, request.getParameter("ram")));
                                    }
                                    request.setAttribute("ram", request.getParameter("ram"));

                                    if (!request.getParameter("disk").isEmpty()) {
                                        listSpec.add(new ProSpec(3, request.getParameter("disk")));
                                    }
                                    request.setAttribute("disk", request.getParameter("disk"));

                                    if (!request.getParameter("card").isEmpty()) {
                                        listSpec.add(new ProSpec(4, request.getParameter("card")));
                                    }
                                    request.setAttribute("card", request.getParameter("card"));

                                    if (!request.getParameter("monitor").isEmpty()) {
                                        listSpec.add(new ProSpec(5, request.getParameter("monitor")));
                                    }
                                    request.setAttribute("monitor", request.getParameter("monitor"));

                                    if (!request.getParameter("webcam").isEmpty()) {
                                        listSpec.add(new ProSpec(6, request.getParameter("webcam")));
                                    }
                                    request.setAttribute("webcam", request.getParameter("webcam"));

                                    if (!request.getParameter("battery").isEmpty()) {
                                        listSpec.add(new ProSpec(7, request.getParameter("battery")));
                                    }
                                    request.setAttribute("battery", request.getParameter("battery"));

                                    if (!request.getParameter("weight").isEmpty()) {
                                        listSpec.add(new ProSpec(17, request.getParameter("weight")));
                                    }
                                    request.setAttribute("weight", request.getParameter("weight"));

                                    //insert mouse
                                    if (!request.getParameter("dpi").isEmpty()) {
                                        listSpec.add(new ProSpec(8, request.getParameter("dpi")));
                                    }
                                    request.setAttribute("dpi", request.getParameter("dpi"));

                                    if (!request.getParameter("number").isEmpty()) {
                                        listSpec.add(new ProSpec(9, request.getParameter("number")));
                                    }
                                    request.setAttribute("number", request.getParameter("number"));

                                    if (!request.getParameter("longevity").isEmpty()) {
                                        listSpec.add(new ProSpec(10, request.getParameter("longevity")));
                                    }
                                    request.setAttribute("longevity", request.getParameter("longevity"));

                                    if (!request.getParameter("shell").isEmpty()) {
                                        listSpec.add(new ProSpec(12, request.getParameter("shell")));
                                    }
                                    request.setAttribute("shell", request.getParameter("shell"));

                                    if (!request.getParameter("frequency").isEmpty()) {
                                        listSpec.add(new ProSpec(14, request.getParameter("frequency")));
                                    }
                                    request.setAttribute("frequency", request.getParameter("frequency"));

                                    //insert headphone
                                    if (!request.getParameter("soundproofing").isEmpty()) {
                                        listSpec.add(new ProSpec(15, request.getParameter("soundproofing")));
                                    }
                                    request.setAttribute("soundproofing", request.getParameter("soundproofing"));

                                    if (!request.getParameter("style").isEmpty()) {
                                        listSpec.add(new ProSpec(16, request.getParameter("style")));
                                    }
                                    request.setAttribute("style", request.getParameter("style"));

                                    //insert chung của 4 cate
                                    if (!request.getParameter("compatible").isEmpty()) {
                                        listSpec.add(new ProSpec(13, request.getParameter("compatible")));
                                    }
                                    request.setAttribute("compatible", request.getParameter("compatible"));

                                    if (!request.getParameter("connect").isEmpty()) {
                                        listSpec.add(new ProSpec(11, request.getParameter("connect")));
                                    }
                                    request.setAttribute("connect", request.getParameter("connect"));

                                    if (!request.getParameter("color").isEmpty()) {
                                        listSpec.add(new ProSpec(18, request.getParameter("color")));
                                    }
                                    request.setAttribute("color", request.getParameter("color"));

                                    if (!am.createProduct(p, listImage, listSpec)) {
                                        request.setAttribute("result", "Insert failed.");
                                    } else {
                                        request.setAttribute("product", p = null);
                                        request.setAttribute("cpu", "");
                                        request.setAttribute("ram", "");
                                        request.setAttribute("disk", "");
                                        request.setAttribute("card", "");
                                        request.setAttribute("monitor", "");
                                        request.setAttribute("webcam", "");
                                        request.setAttribute("battery", "");
                                        request.setAttribute("weight", "");
                                        request.setAttribute("dpi", "");
                                        request.setAttribute("number", "");
                                        request.setAttribute("longevity", "");
                                        request.setAttribute("shell", "");
                                        request.setAttribute("frequency", "");
                                        request.setAttribute("soundproofing", "");
                                        request.setAttribute("style", "");
                                        request.setAttribute("compatible", "");
                                        request.setAttribute("connect", "");
                                        request.setAttribute("color", "");
                                        request.setAttribute("result", "Insert success.");
                                        listOfProduct = pm.getAllOfProductAfterSort("ProID_DESC");
                                    }

                                } catch (Exception e) {
                                    //request.setAttribute("result", "Exception: " + e.getMessage());
                                    request.setAttribute("result", "Insert failed.");
                                    e.printStackTrace();
                                }
                                break;
                            } else {
                                request.setAttribute("result", "Duplicate product name.");
                            }
                    }
                }
                listOfProduct = pm.getAllOfProductAfterSort("ProID_DESC");
                request.setAttribute("listOfProduct", listOfProduct);
                request.getRequestDispatcher("/views/Admin_Product_Management.jsp").forward(request, response);
                break;
            case "/AccountManagement":
                ArrayList<Account> listOfAccounts = new ArrayList<>();
                AccountManagement accmgt = new AccountManagement();
                String keySort = request.getParameter("sort_total-order");
                listOfAccounts = accmgt.getAccountsInformations();

                if (keySort == null) {
                    listOfAccounts = accmgt.getAccountsInformations();
                } else {
                    listOfAccounts = accmgt.getAccountSorting(keySort);
                } 

                request.setAttribute("listOfAccount", listOfAccounts);
                request.getRequestDispatcher("/views/AccountManagement.jsp").forward(request, response);
                break;
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
