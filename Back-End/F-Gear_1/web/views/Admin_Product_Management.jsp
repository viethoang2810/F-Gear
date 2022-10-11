<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>F-GEAR</title>
        <link rel="icon" href="../assets/Images/pinterest_board_photo.png">
        <link rel="stylesheet" href="../assets/CSS/Product_Management.css">
        <link rel="stylesheet" href="../assets/CSS/GlobalStyles.css"> <!-- This file contains all of common styles of pages-->
        <link rel="stylesheet" href="../assets/CSS/Responive.css">
        <!-- Font Awesome link-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
              integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
              crossorigin="anonymous" referrerpolicy="no-referrer" />
        <!-- Bootstrap link-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
    </head>

    <body>
        <div class="container-fluid">
            <div class="row header">
                <header class="header-wrapper">
                    <img src="../assets/Images/Logo_After_Login.png" alt="" class="header-logo">
                </header>
            </div>
            <!-- Make a white space which is buffered for height because header has position is fixed -->
            <div class="row ">
                <div class="white-space">

                </div>
            </div>
            <div class="row sidebar-row" >
                <div class="sidebar-wrapper">
                    <div class="siderbar sidebar-nav col-lg-3 col-xl-2 col-md-12 col-sm-12 col-12">
                        <div class="navigation-wrapper">
                            <ul class="navigation-list">
                                <li class="navigation-item ">
                                    <a href="../Admin/Dashboard" class="navigation-item_link">Dashbroad</a>
                                </li>
                                <li class="navigation-item active">
                                    <a href="../Admin/Management" class="navigation-item_link ">Product Management</a>
                                </li>
                            </ul>
                        </div>
                        <button class="modal-btn">Add new</button>
                        <div class="add-modal-wrapper">
                            <div class="add-modal-content">
                                <div class="add-modal-form-wrapper">
                                    <div class="add-modal-title">
                                        <span class="modal-title" style="margin-bottom:30px;">Add new product</span>
                                        <span> <i class="fa-solid fa-xmark close-icon" style="font-size:2rem;margin-left: 70px; margin-bottom:30px;cursor: pointer;"></i></span>
                                    </div>
                                    <form action="./Admin" class="add-form" method="POST">
                                        <div class="add-input-wrapper">
                                            <label for="proName" class="input-label">Name product</label>
                                            <input type="text" name="proName" id="proName" class="input-text">
                                        </div>
                                        <div class="add-input-wrapper">
                                            <label for="proCategories" class="input-label">Category</label>
                                            <select name="category" id="proCategories" class="brands-list input-text">
                                                <option value="laptop" class="brand-item">Laptop</option>
                                                <option value="mouse" class="brand-item">Mouse</option>
                                                <option value="headphone" class="brand-item">Headphone</option>
                                                <option value="Others" class="brand-item">Others</option>    
                                            </select>
                                        </div>
                                        <div class="add-input-wrapper">
                                            <label for="proBrand" class="input-label">Brand</label>
                                            <select name="brand" id="proBrand" class="brands-list input-text">
                                                <option value="1" class="brand-item">ASUS</option>
                                                <option value="2" class="brand-item">ACER</option>
                                                <option value="3" class="brand-item">MSI</option>
                                                <option value="4" class="brand-item">DELL</option>
                                                <option value="5" class="brand-item">ASUS</option>
                                            </select>
                                        </div>
                                        <div class="add-input-wrapper">
                                            <label for="originPrice" class="input-label">Original price</label>
                                            <input type="text" name="originPrice" id="originPrice" class="input-text">
                                        </div>
                                        <div class="add-input-wrapper">
                                            <label for="proImage_1" class="input-label">Image 1</label>
                                            <input type="hidden" name="image_1" class="image-pro_1">
                                            <div class="change-image" id="proImage_1">
                                                <label for="file-upload" class="custom-file-upload">
                                                    <i class="fa fa-cloud-upload"></i> Choose from your device
                                                </label>
                                                <input id="file-upload" type="file" name="file-upload" />
                                            </div>
                                        </div>
                                        <div class="add-input-wrapper">
                                            <label for="proImage_2" class="input-label">Image 2</label>
                                            <input type="hidden" name="image_2" class="image-pro_2">
                                            <div class="change-image" id="proImage_2">
                                                <label for="file-upload" class="custom-file-upload">
                                                    <i class="fa fa-cloud-upload"></i> Choose from your device
                                                </label>
                                                <input id="file-upload" type="file" name="file-upload" />
                                            </div>
                                        </div>
                                        <div class="add-input-wrapper">
                                            <label for="proImage_3" class="input-label">Image 3</label>
                                            <input type="hidden" name="image_3" class="image-pro_3">
                                            <div class="change-image" id="proImage_3">
                                                <label for="file-upload" class="custom-file-upload">
                                                    <i class="fa fa-cloud-upload"></i> Choose from your device
                                                </label>
                                                <input id="file-upload" type="file" name="file-upload" />
                                            </div>
                                        </div>
                                        <!-- Specification for latop -->
                                        <div class="add-input-wrapper">
                                            <label for="CPU-spec" class="input-label">CPU</label>
                                            <input type="text" name="cpu" id="CPU-spec" class="input-text">
                                        </div>
                                        <div class="add-input-wrapper">
                                            <label for="ram-spec" class="input-label">RAM</label>
                                            <input type="text" name="RAM-spec" id="ram-spec" class="input-text">
                                        </div>
                                        <div class="add-input-wrapper">
                                            <label for="disk" class="input-label">Hard disk</label>
                                            <input type="text" name="disk" id="disk" class="input-text">
                                        </div>
                                        <div class="add-input-wrapper">
                                            <label for="graphic_card" class="input-label">Graphic Card </label>
                                            <input type="text" name="graphic_card" id="graphic_card" class="input-text">
                                        </div>
                                        <!-- Specification for mouse -->
                                        <div class="add-input-wrapper">
                                            <label for="Connect-spec" class="input-label">Connect</label>
                                            <input type="text" name="connect" id="Connect-spec" class="input-text">
                                        </div>
                                        <div class="add-input-wrapper">
                                            <label for="Sensor-spec" class="input-label">Sensor</label>
                                            <input type="text" name="sensorr-spec" id="Sensor-spec" class="input-text">
                                        </div>
                                        <!-- Another types of product -->
                                        <div class="submit-wrapper"> <button type="submit" class="submit-btn" name="adminOp" value="add_product">Add to
                                                store</button></div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="product-mgt_list col-lg-8 col-xl-9 col-md-12 col-sm-12 col-12 text-center" style="overflow-y:scroll ; margin: 0 auto;">
                        <table class="table">
                            <thead class="table-head">
                                <tr>
                                    <th scope="col">Product ID</th>
                                    <th scope="col">Product Name</th>
                                    <th scope="col">Original Price</th>
                                    <th scope="col">Discount</th>
                                    <th scope="col">Final Price</th>
                                    <th scope="col"></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="product" items="${listOfProduct}">
                                    <tr style="vertical-align: middle;" class="table-row">
                                        <td scope="row">${product.proID}</td>
                                        <td class="table-product_name">${product.proName}</td>
                                        <td class="table-product_original">${product.proOriginalPrice}</td>
                                        <td class="table-product_discount">${product.discount}</td>
                                        <td >${product.proCurrentPrice}</td>
                                        <td class="table-btns">
                                            <button class="btn-action btn-edit">
                                                <i class="fa-solid fa-pen-to-square"></i>
                                            </button>

                                            <button class="btn-action btn-remove">
                                                <i class="fa-solid fa-trash"></i>
                                            </button>
                                            <div class="edit-modal-wrapper" style="padding-bottom:20px;">
                                                <div class="edit-modal-content">
                                                    <div class="edit-modal-form-wrapper">
                                                        <div class="edit-modal-title">
                                                            <span class="modal-title" style="margin-bottom:30px;">Update product </span>
                                                            <span> <i class="fa-solid fa-xmark exit-icon" style="font-size:2rem;margin-left: 70px; margin-bottom:30px;cursor: pointer;"></i></span>
                                                        </div>
                                                        <form action="./Admin" class="edit-modal-form"  method="POST">
                                                            <input type="hidden" name="product_id" class="product-id" value="${product.proID}">
                                                            <div class="edit-input-wrapper">
                                                                <label for="proName" class="input-label">Name product</label>
                                                                <input type="text" name="proName" id="proName" class="input-text productName" >
                                                            </div>
                                                            <div class="edit-input-wrapper">
                                                                <label for="originPrice" class="input-label">Original price</label>
                                                                <input type="text" name="originPrice" id="originPrice" class="input-text productOriginal" >
                                                            </div>
                                                            <div class="edit-input-wrapper">
                                                                <label for="discountPrice" class="input-label">Discount</label>
                                                                <input type="text" name="discount" id="discountPrice" class="input-text productDiscount" >
                                                            </div>
                                                            <!-- Put id of product here-->
                                                            <button type="submit" class="edit-modal-btn-action" name="adminOp"
                                                                    value="updated">Update product</button>
                                                        </form>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="modal-wrapper">
                                                <div class="modal-content">
                                                    <div class="modal-form-wrapper">
                                                        <span class="confirm-annotation" style="margin-bottom:30px;">You really
                                                            want remove product ${product.proID}</span>
                                                        <form action="../Admin/Management" class="modal-form" method="POST">
                                                            <input type="hidden" name="product_id" class="product-id" value="${product.proID}">
                                                            <!-- Put id of product here-->
                                                            <button type="submit" class="modal-btn-action" name="adminOp"
                                                                    value="remove">Confirm</button>
                                                            <button type="submit" class="modal-btn-action" name="adminOp"
                                                                    value="cancel">Cancel</button>
                                                        </form>
                                                    </div>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                </c:forEach>

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <%@include file="./Footer.jsp" %>

        </div>
    </body>
    <script type="module" src="../assets/JavaScript/Product_Management.js"></script>

</html>