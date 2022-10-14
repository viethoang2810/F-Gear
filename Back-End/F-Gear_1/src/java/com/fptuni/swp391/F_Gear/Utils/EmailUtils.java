/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fptuni.swp391.F_Gear.Utils;

import com.fptuni.swp391.F_Gear.DTO.Email;
import java.util.Properties;
import java.util.Random;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author ADMIN
 */
public class EmailUtils {

    private static final String alpha = "abcdefghijklmnopqrstuvwxyz"; // a-z     
    private static final String alphaUpperCase = alpha.toUpperCase(); // A-Z    
    private static final String digits = "0123456789"; // 0-9    
    private static final String ALPHA_NUMERIC = alpha + alphaUpperCase + digits;

    public static void sendEmail(final Email email) throws Exception {
        Properties prop = new Properties();

        prop.setProperty("mail.smtp.host", "smtp.gmail.com");
        prop.setProperty("mail.smtp.port", "587");
        prop.setProperty("mail.smtp.auth", "true");
        prop.setProperty("mail.smtp.starttls.enable", "true");

        prop.put("mail.smtp.socketFactory.port", "587");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email.getFrom(), email.getFromPassword());
            }
        });

        try {
            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(email.getFrom()));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email.getTo()));
            message.setSubject(email.getSubject());
            message.setContent(email.getContent(), "text/html; charset=utf-8");

            Transport.send(message);

        } catch (Exception e) {
            e.printStackTrace();

            throw e;
        }
    }

    public String getRandomNumber() {
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        return String.format("%06d", number);
    }

    private static Random generator = new Random();

    public static int randomNumber(int min, int max) {
        return generator.nextInt((max - min) + 1) + min;
    }
    
    public static String randomAlphaNumeric(int numberOfCharactor) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberOfCharactor; i++) {
            int number = randomNumber(0, ALPHA_NUMERIC.length() - 1);
            char ch = ALPHA_NUMERIC.charAt(number);
            sb.append(ch);
        }
        return sb.toString();
    }

}
