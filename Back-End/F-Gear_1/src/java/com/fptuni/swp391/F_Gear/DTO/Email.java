/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fptuni.swp391.F_Gear.DTO;

/**
 *
 * @author ADMIN
 */
public class Email {

    private String from;
    private String to;
    private String fromPassword;
    private String content;
    private String subject;

    public Email() {
    }

    public Email(String from, String to, String fromPassword, String content, String subject) {
        this.from = from;
        this.to = to;
        this.fromPassword = fromPassword;
        this.content = content;
        this.subject = subject;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFromPassword() {
        return fromPassword;
    }

    public void setFromPassword(String fromPassword) {
        this.fromPassword = fromPassword;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

}
