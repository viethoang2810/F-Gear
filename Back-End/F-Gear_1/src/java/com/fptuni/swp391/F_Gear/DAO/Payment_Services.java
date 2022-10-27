/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptuni.swp391.F_Gear.DAO;

import com.fptuni.swp391.F_Gear.DTO.Orders;
import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Details;
import com.paypal.api.payments.Item;
import com.paypal.api.payments.ItemList;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.PayerInfo;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.PaymentExecution;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dell
 */
public class Payment_Services {

    private static final String CLIENT_ID
            = "Ab-yszk8f0CVgwyz4WJep6LRHyOA9tUH_085cdf8-eSCL12ZuTsWe9NC53QeGw9IZRNjs-1jY7Y5tPbC";
    private static final String CLIENT_SECRET
            = "EBKA4PmZ3oA-L1_ztwwkmvBogRTLrFYcRQbB4t4S6sS5hhe9krc_eE73JfSVgQ_waRUz1uJApITXLOxP";
    private static final String MODE = "sandbox";

    public String authorizePayment(Orders order) throws PayPalRESTException {
        Payer payer = getPayerInformation();
        RedirectUrls redirectUrls = getRedirectURLs();
        List<Transaction> listTransaction = getTransactionInformation(order);
        Payment requestPayment = new Payment();
        requestPayment.setTransactions(listTransaction)
                .setRedirectUrls(redirectUrls)
                .setPayer(payer)
                .setIntent("authorize");
        APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);
        Payment approvedPayment = requestPayment.create(apiContext);
        System.out.println("day la dong minh in ra: " + approvedPayment);
        return getApprovalLink(approvedPayment);
    }

    private String getApprovalLink(Payment approvedPayment) {
        List<Links> links = approvedPayment.getLinks();
        String approvalLink = null;
        for (Links link : links) {
            if (link.getRel().equalsIgnoreCase("approval_url")) {
                approvalLink = link.getHref();
            }
        }
        return approvalLink;
    }

    private List<Transaction> getTransactionInformation(Orders o) {
        Details details = new Details();
        details.setSubtotal(o.getSubtotal());
        details.setTax(o.getTax());
        details.setShipping(o.getShipping());

        Amount amount = new Amount();
        amount.setCurrency("USD");
        amount.setTotal(o.getTotal());
        amount.setDetails(details);

        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setDescription(o.getProductName());

        ItemList itemList = new ItemList();
        List<Item> items = new ArrayList<Item>();
        Item item = new Item();
        item.setCurrency("USD")
                .setName(o.getProductName())
                .setPrice(o.getSubtotal())
                .setTax(o.getTax())
                .setQuantity("1");

        items.add(item);
        transaction.setItemList(itemList);
        List<Transaction> listTransaction = new ArrayList<Transaction>();
        listTransaction.add(transaction);
        return listTransaction;
    }

    private RedirectUrls getRedirectURLs() {
        RedirectUrls redirectUrls = new RedirectUrls();
        redirectUrls.setCancelUrl("http://localhost:8080/F-Gear_1/views/cancel.jsp");
        redirectUrls.setReturnUrl("http://localhost:8080/F-Gear_1/review_payment");
        return redirectUrls;
    }

    private Payer getPayerInformation() {
        Payer payer = new Payer();
        payer.setPaymentMethod("paypal");
        PayerInfo payerInfo = new PayerInfo();
        payerInfo.setFirstName("hoang")
                .setLastName("dung")
                .setEmail("9.3hoangquocdung147@gmail.com");
        payer.setPayerInfo(payerInfo);
        return payer;
    }

    public Payment getPaymentDetails(String paymentId) throws PayPalRESTException {
        APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);
        return Payment.get(apiContext, paymentId);
    }

    public Payment executePayment(String paymentId, String payerId) throws PayPalRESTException {
        PaymentExecution paymentExecution = new PaymentExecution();
        paymentExecution.setPayerId(payerId);

        Payment payment = new Payment().setId(paymentId);
        APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);
        return payment.execute(apiContext, paymentExecution);
    }
}
