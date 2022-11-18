<%-- 
    Document   : Contact
    Created on : Oct 10, 2022, 7:04:28 PM
    Author     : dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contact</title>
        <link rel="stylesheet" href="./assets/CSS/GlobalStyles.css">
        <link rel="stylesheet" href="./assets/CSS/Responive.css">
        <link rel="stylesheet" href="./assets/CSS/Homepage.css">
        <link rel="stylesheet" href="./assets/CSS/responsive.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css">
        <!--        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
                <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>-->
    </head>

    <style>
        .body-testimonials-item {
            margin: 0 auto;
            width: 1000px;
            height: 4px;
            background: linear-gradient(to right, red, orange, yellow, green, blue, indigo, violet, red);
            animation: go 3s linear infinite;
        }

        @keyframes go {
            0% {
                background-position: 0;
            }

            100% {
                background-position: 1000px 0;
            }
        }
    </style>

    <body>
        <%--<%@include file="./Header.jsp" %>--%>
        <a href="http://localhost:8080/F-Gear_1/Home/HomePage" style="font-size: 40px; padding: 20px 0 0 0px; text-decoration: none; "> ⬅ Back to home</a>
        <div class="body-testimonials-item"></div>
        <div style="width:1000px; margin: 0 auto;">
            <h1 style="text-align: center;" >Thank you for purchasing our product. Please leave your comments to help us improve.</h1>

        </div>
        <div class="body-testimonials-item"></div>
        <div class="container-fluid px-5 my-5">
            <div class="row justify-content-center">
                <div class="col-xl-10">
                    <div class="card border-0 rounded-3 shadow-lg overflow-hidden">
                        <div class="card-body p-0">
                            <div class="row g-0">
                                <div class="col-sm-6 d-none d-sm-block bg-image">
                                    <img style="width: 200%; max-height: 600px;" src="https://genk.mediacdn.vn/2015/img-20120704-140805-1435311038302.jpg"/>
                                </div>
                                <div class="col-sm-6 p-4" style="background-color: white;">
                                    <div class="text-center">
                                        <div class="h3 fw-light">Contact Form</div>
                                        <p class="mb-4 text-muted">24/7 Customer Care</p>
                                    </div>



                                    <form id="contactForm" action="../MailController" method="post">

                                        <!-- Name Input -->
                                        <div class="form-floating mb-3">
                                            <input class="form-control" id="name" name="name" type="text" placeholder="Name" data-sb-validations="required" />
                                            <label for="name">Name</label>
                                            <div class="invalid-feedback" data-sb-feedback="name:required">Name is required.</div>
                                        </div>

                                        <!-- Email Input -->
                                        <div class="form-floating mb-3">
                                            <input class="form-control" id="emailAddress" name="email" type="email" placeholder="Email Address" data-sb-validations="required,email" />
                                            <label for="emailAddress">Email Address</label>
                                            <div class="invalid-feedback" data-sb-feedback="emailAddress:required">Email Address is required.</div>
                                            <div class="invalid-feedback" data-sb-feedback="emailAddress:email">Email Address Email is not valid.</div>
                                        </div>

                                        <!--Subject Input-->
                                        <div class="form-floating mb-3">
                                            <input class="form-control" id="subject" name="subject" type="text" placeholder="Subject" data-sb-validations="required,subject" />
                                            <label for="subject">Subject</label>
                                            <div class="invalid-feedback" data-sb-feedback="emailAddress:required">Email Address is required.</div>
                                            <div class="invalid-feedback" data-sb-feedback="emailAddress:email">Email Address Email is not valid.</div>
                                        </div>

                                        <!-- Message Input -->
                                        <div class="form-floating mb-3">
                                            <textarea class="form-control" id="message" name="message" type="text" placeholder="Message" style="height: 10rem;" data-sb-validations="required"></textarea>
                                            <label for="message">Message</label>
                                            <div class="invalid-feedback" data-sb-feedback="message:required">Message is required.</div>
                                        </div>

                                        <!-- Submit success message -->
                                        <!--                                        <div class="d-none" id="submitSuccessMessage">
                                                                                    <div class="text-center mb-3">
                                                                                        <div class="fw-bolder">Form submission successful!</div>
                                                                                        <p>To activate this form, sign up at</p>
                                                                                        <a href="https://startbootstrap.com/solution/contact-forms">https://startbootstrap.com/solution/contact-forms</a>
                                                                                    </div>
                                                                                </div>-->

                                        <!-- Submit error message -->
                                        <div class="d-none" id="submitErrorMessage">
                                            <div class="text-center text-danger mb-3">Error sending message!</div>
                                        </div>

                                        <!-- Submit button -->
                                        <div class="d-grid">
                                            <button class="btn btn-primary btn-lg" id="submitButton" type="submit">Submit</button>
                                        </div>
                                    </form>
                                    <!-- End of contact form -->

                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
    <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>

</html>
