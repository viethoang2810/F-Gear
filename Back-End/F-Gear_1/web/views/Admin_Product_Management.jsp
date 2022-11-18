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

    <style>
        .subtable {
            display: none;
        }

        .subtable-active {
            display: block;
        }
        .priceInput {
            border: 1px solid #000;
        }
        .hideSmall {
            visibility: hidden;
        }

        .priceInputError {
            border: 1px solid red;
        }

        .priceError {
            visibility: visible;
            color: red;
        }
    </style>

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
                <form action="../Admin/Management" style="width: 70%; margin-left: 20%;">
                    <input type="text" placeholder="Search . . ."
                           style="width: 60%; height: 40px; padding: 5px 0 5px 10px;" name="name" />
                    <button style="padding: 8px 15px; border: none; background-color: gray; color: white; border-radius: 10px;" name="adminOp" value="search">Search</button>
                </form>
            </div>
            <div class="row sidebar-row" >
                <div class="sidebar-wrapper">
                    <div class="siderbar sidebar-nav col-lg-3 col-xl-2 col-md-12 col-sm-12 col-12">
                        <div class="navigation-wrapper">
                            <ul class="navigation-list">
                                <li class="navigation-item ">
                                    <a href="../Access/Dashboard?op=chartadminpage" class="navigation-item_link">Dashbroad</a>
                                </li>
                                <li class="navigation-item active">
                                    <a href="../Admin/Management" class="navigation-item_link ">Product Management</a>
                                </li>
                                <li class="navigation-item ">
                                    <a href="../Admin/AccountManagement" class="navigation-item_link ">Account Management</a>
                                </li>
                                <li class="navigation-item ">
                                    <a href="../Brand/*" class="navigation-item_link">Brand Management</a>
                                </li>
                                <li class="navigation-item ">
                                    <a href="../Guarantee/*" class="navigation-item_link">Category Management</a>
                                </li>
                                <li class="navigation-item ">
                                    <a href="../Guarantee/*" class="navigation-item_link">Guarantee Management</a>
                                </li>   
                                <li class="navigation-item">
                                    <a href="../WarrantyPolicy/*" class="navigation-item_link ">Warranty Policy</a>
                                </li>
                            </ul>
                        </div>
                        <button class="modal-btn" style="margin-top: 15px">Add new</button>
                        <p style="color: red">${result}<p>
                        <div class="add-modal-wrapper">
                            <div class="add-modal-content">
                                <div class="add-modal-form-wrapper" style="height: 500px;">
                                    <div class="add-modal-title">
                                        <span class="modal-title" style="margin-bottom:30px;">Add new product</span>
                                        <span> <i class="fa-solid fa-xmark close-icon" style="font-size:2rem;margin-left: 70px; margin-bottom:30px;cursor: pointer;"></i></span>
                                    </div>
                                    <form action="../Admin/Management" class="add-form">
                                        <div class="add-input-wrapper">
                                            <label for="proName" class="input-label">Name product</label>
                                            <input required type="text" name="proName" id="proName"  class="input-text" value="${product.proName}">
                                        </div>
                                        <div class="add-input-wrapper">
                                            <label for="proCategories" class="input-label">Category</label>
                                            <select name="category" id="proCategories" class="brands-list input-text">
                                                <option value="1" ${"1" == product.cateID?"selected":""} class="brand-item">Laptop Gaming</option>
                                                <option value="2" ${"2" == product.cateID?"selected":""} class="brand-item">Laptop Office</option>
                                                <option value="3" ${"3" == product.cateID?"selected":""} class="brand-item">Mouse</option>
                                                <option value="4" ${"4" == product.cateID?"selected":""} class="brand-item">Headphone</option>
                                                <option value="5" ${"5" == product.cateID?"selected":""} class="brand-item">Others</option>    
                                            </select>
                                        </div>
                                        <div class="add-input-wrapper">
                                            <label for="proBrand" class="input-label">Brand</label>
                                            <select name="brand" id="proBrand" class="brands-list input-text subtable subtable-active">
                                                <option value="1" ${"1" == product.brandID?"selected":""} class="brand-item">ACER</option>
                                                <option value="2" ${"2" == product.brandID?"selected":""} class="brand-item">ASUS</option>
                                                <option value="3" ${"3" == product.brandID?"selected":""} class="brand-item">MSI</option>
                                                <option value="4" ${"4" == product.brandID?"selected":""} class="brand-item">LENOVO</option>
                                                <option value="4" ${"5" == product.brandID?"selected":""} class="brand-item">DELL</option>
                                                <option value="6" ${"6" == product.brandID?"selected":""} class="brand-item">HP</option>
                                            </select>
                                            <select name="brand" id="proBrand" class="brands-list input-text subtable">
                                                <option value="1" ${"1" == product.brandID?"selected":""} class="brand-item">ACER</option>
                                                <option value="2" ${"2" == product.brandID?"selected":""} class="brand-item">ASUS</option>
                                                <option value="3" ${"3" == product.brandID?"selected":""} class="brand-item">MSI</option>
                                                <option value="4" ${"4" == product.brandID?"selected":""} class="brand-item">LENOVO</option>
                                                <option value="4" ${"5" == product.brandID?"selected":""} class="brand-item">DELL</option>
                                                <option value="6" ${"6" == product.brandID?"selected":""} class="brand-item">HP</option>
                                            </select>
                                            <select name="brand" id="proBrand" class="brands-list input-text subtable">
                                                <option value="2" ${"2" == product.brandID?"selected":""} class="brand-item">ASUS</option>
                                                <option value="7" ${"7" == product.brandID?"selected":""} class="brand-item">Logitech</option>
                                                <option value="8" ${"8" == product.brandID?"selected":""} class="brand-item">Razer</option>
                                                <option value="10" ${"10" == product.brandID?"selected":""} class="brand-item">Orther</option>
                                            </select>
                                            <select name="brand" id="proBrand" class="brands-list input-text subtable">
                                                <option value="8" ${"8" == product.brandID?"selected":""} class="brand-item">Razer</option>
                                                <option value="9" ${"9" == product.brandID?"selected":""} class="brand-item">Sony</option>
                                                <option>Corsari</option>
                                                <option value="10" ${"10" == product.brandID?"selected":""} class="brand-item">Orther</option>
                                            </select>
                                        </div>
                                        <div class="add-input-wrapper">
                                            <label for="proCategories" class="input-label">Guarantee</label>
                                            <select name="guarantee" id="proGuarantee" class="brands-list input-text">
                                                <option value="1" ${"1" == product.guaID?"selected":""} class="brand-item">6 months</option>
                                                <option value="2" ${"2" == product.guaID?"selected":""} class="brand-item">12 months</option>
                                                <option value="3" ${"3" == product.guaID?"selected":""} class="brand-item">18 months</option>
                                                <option value="4" ${"4" == product.guaID?"selected":""} class="brand-item">24 months</option>
                                                <option value="5" ${"5" == product.guaID?"selected":""} class="brand-item">30 months</option>    
                                                <option value="6" ${"6" == product.guaID?"selected":""} class="brand-item">36 months</option>    
                                            </select>
                                        </div>
                                        <div class="add-input-wrapper">
                                            <label for="originPrice" class="input-label">Original price</label>
                                            <div style="display: flex; flex-direction: column; width: 100%">
                                                <input class="priceInput"  required type="number" name="originPrice" id="originPrice" class="input-text" value="${product.proOriginalPrice}">
                                                <small id="error" class="hideSmall">Invalid price</small>
                                            </div>
                                        </div>
                                        <div class="add-input-wrapper">
                                            <label for="proImage_1" class="input-label">Image 1</label>
                                            <input type="text" name="image_1" id ="img1" class="image-pro_1">
                                            <div class="change-image" id="proImage_1">
                                                <label for="file-upload" class="custom-file-upload">
                                                    <i class="fa fa-cloud-upload"></i> Choose from your device
                                                </label>
                                                <input id="file-upload" type="file" name="file-upload1" />
                                            </div>
                                        </div>
                                        <div class="add-input-wrapper">
                                            <label for="proImage_2" class="input-label">Image 2</label>
                                            <input type="text" name="image_2" id="img2" class="image-pro_2">
                                            <div class="change-image" id="proImage_2">
                                                <label for="file-upload2" class="custom-file-upload">
                                                    <i class="fa fa-cloud-upload"></i> Choose from your device
                                                </label>
                                                <input id="file-upload2" type="file" name="file-upload2" />
                                            </div>
                                        </div>
                                        <div class="add-input-wrapper">
                                            <label for="proImage_3" class="input-label">Image 3</label>
                                            <input type="text" name="image_3" id="img3" class="image-pro_3">
                                            <div class="change-image" id="proImage_3">
                                                <label for="file-upload3" class="custom-file-upload">
                                                    <i class="fa fa-cloud-upload"></i> Choose from your device
                                                </label>
                                                <input id="file-upload3" type="file" name="file-upload3" />
                                            </div>
                                        </div>
                                        <!-- Specification for laptop -->
                                        <div class="add-input-wrapper">
                                            <label for="CPU-spec" class="input-label">CPU</label>
                                            <input type="text" name="cpu" id="CPU-spec" class="input-text" value="${cpu}">
                                        </div>
                                        <div class="add-input-wrapper">
                                            <label for="ram-spec" class="input-label">RAM</label>
                                            <input type="text" name="ram" id="ram-spec" class="input-text" value="${ram}">
                                        </div>
                                        <div class="add-input-wrapper">
                                            <label for="disk" class="input-label">Hard disk</label>
                                            <input type="text" name="disk" id="disk" class="input-text" value="${disk}">
                                        </div>
                                        <div class="add-input-wrapper">
                                            <label for="graphic_card" class="input-label">Graphic Card</label>
                                            <input type="text" name="card" id="graphic_card" class="input-text" value="${card}">
                                        </div>
                                        <div class="add-input-wrapper">
                                            <label for="monitor" class="input-label">Monitor</label>
                                            <input type="text" name="monitor" id="graphic_card" class="input-text" value="${monitor}">
                                        </div>
                                        <div class="add-input-wrapper">
                                            <label for="webcam" class="input-label">Webcam</label>
                                            <input type="text" name="webcam" id="graphic_card" class="input-text" value="${webcam}">
                                        </div>
                                        <div class="add-input-wrapper">
                                            <label for="battery" class="input-label">Battery</label>
                                            <input type="text" name="battery" id="graphic_card" class="input-text" value="${battery}">
                                        </div>
                                        <div class="add-input-wrapper">
                                            <label for="weight" class="input-label">Weight</label>
                                            <input type="text" name="weight" id="graphic_card" class="input-text" value="${weight}">
                                        </div>

                                        <!-- Specification for mouse -->
                                        <div class="add-input-wrapper">
                                            <label for="Connect-spec" class="input-label">DPI</label>
                                            <input type="text" name="dpi" id="Connect-spec" class="input-text" value="${dpi}">
                                        </div>
                                        <div class="add-input-wrapper">
                                            <label for="Connect-spec" class="input-label">Number Of Buttons</label>
                                            <input type="text" name="number" id="Connect-spec" class="input-text" value="${number}">
                                        </div>
                                        <div class="add-input-wrapper">
                                            <label for="Connect-spec" class="input-label">Longevity</label>
                                            <input type="text" name="longevity" id="Connect-spec" class="input-text" value="${longevity}">
                                        </div>
                                        <div class="add-input-wrapper">
                                            <label for="Connect-spec" class="input-label">Shell Material</label>
                                            <input type="text" name="shell" id="Connect-spec" class="input-text" value="${shell}">
                                        </div>

                                        <!-- Specification for head phone -->                                        

                                        <div class="add-input-wrapper">
                                            <label for="Connect-spec" class="input-label">Frequency</label>
                                            <input type="text" name="frequency" id="Connect-spec" class="input-text" value="${frequency}">
                                        </div>
                                        <div class="add-input-wrapper">
                                            <label for="Connect-spec" class="input-label">Soundproofing Ability</label>
                                            <input type="text" name="soundproofing" id="Connect-spec" class="input-text" value="${soundproofing}">
                                        </div>
                                        <div class="add-input-wrapper">
                                            <label for="Connect-spec" class="input-label">Headphone Style</label>
                                            <input type="text" name="style" id="Connect-spec" class="input-text" value="${style}">
                                        </div>

                                        <!-- 3 thuoc tinh nay tai thoi diem hien tai dang dung chung cho 4 cate -->
                                        <div class="add-input-wrapper">
                                            <label for="Connect-spec" class="input-label">Compatible</label>
                                            <input type="text" name="compatible" id="Connect-spec" class="input-text" value="${compatible}">
                                        </div>
                                        <div class="add-input-wrapper">
                                            <label for="Connect-spec" class="input-label">Connect</label>
                                            <input type="text" name="connect" id="Connect-spec" class="input-text" value="${connect}">
                                        </div>
                                        <div class="add-input-wrapper">
                                            <label for="Connect-spec" class="input-label">Color</label>
                                            <input type="text" name="color" id="Connect-spec" class="input-text" value="${color}">
                                        </div> 
                                        <div class="submit-wrapper"> <button id="addBtn" class="addBtn" type="submit" class="submit-btn" name="adminOp" value="add_product">Add to
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
                                                        <form action="../Admin/Management" class="edit-modal-form"  method="POST">
                                                            <input type="hidden" name="product_id" class="product-id" value="${product.proID}">
                                                            <div class="edit-input-wrapper">
                                                                <label for="proName" class="input-label">Name product</label>
                                                                <input type="text" name="proName" id="proName" class="input-text productName" required="" >
                                                            </div>
                                                            <div class="edit-input-wrapper">
                                                                <label for="originPrice" class="input-label">Original price</label>
                                                                <input type="text" name="originPrice" id="originPrice" class="input-text productOriginal" required="" >
                                                            </div>
                                                            <div class="edit-input-wrapper">
                                                                <label for="discountPrice" class="input-label">Discount</label>
                                                                <input type="number" max="100" min="0" name="discount" id="discountPrice" class="input-text productDiscount" required="" >
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
    <script>
        const priceInput = document.querySelector('.priceInput')
        const addBtn = document.querySelector('.addBtn')
        const error = document.querySelector('#error')
        priceInput.oninput = function () {
            validatePrice(priceInput)
        }

        function validatePrice(textBoxId) {
            let textVal = textBoxId.value
            let regex = /^[0-9]*$/
            let passed = textVal.match(regex)
            addBtn.disabled = false
            error.classList.remove('priceError')
            priceInput.classList.remove('priceInputError')
            if (passed == null || priceInput.value < 100 || priceInput.value > 1000000000) {
                addBtn.disabled = true
                error.classList.add('priceError')
                priceInput.classList.add('priceInputError')
            }
        }
        //show image name
        const file1 = document.querySelector('#file-upload')
        const file2 = document.querySelector('#file-upload2')
        const file3 = document.querySelector('#file-upload3')
        file1.onchange = function () {
            document.querySelector('#img1').value = file1.value.replace(/^.*[\\\/]/, '')
        }
        file2.onchange = function () {
            document.querySelector('#img2').value = file2.value.replace(/^.*[\\\/]/, '')
        }
        file3.onchange = function () {
            document.querySelector('#img3').value = file3.value.replace(/^.*[\\\/]/, '')
        }

        const selectTable = document.getElementById("proCategories");
        const subtable = document.querySelectorAll('.subtable')
          console.log(selectTable)
        selectTable.onchange = function () {
        let text = selectTable.options[selectTable.selectedIndex].text;
      console.log(text)
        switch (text) {
            case 'Laptop Gaming':
                console.log('gaming');
                subtable[0].classList.add('subtable-active')
                subtable[1].classList.remove('subtable-active')
                subtable[2].classList.remove('subtable-active')
                subtable[3].classList.remove('subtable-active')
                break;
            case 'Laptop Office':
                console.log('van phong');
                subtable[0].classList.remove('subtable-active')
                subtable[1].classList.add('subtable-active')
                subtable[2].classList.remove('subtable-active')
                subtable[3].classList.remove('subtable-active')
                break;
            case 'Mouse':
                console.log('Chuot');
                subtable[0].classList.remove('subtable-active')
                subtable[1].classList.remove('subtable-active')
                subtable[2].classList.add('subtable-active')
                subtable[3].classList.remove('subtable-active')
                break;
            case 'Headphone':
                console.log('Tai nghe');
                subtable[0].classList.remove('subtable-active')
                subtable[1].classList.remove('subtable-active')
                subtable[2].classList.remove('subtable-active')
                subtable[3].classList.add('subtable-active')
                break;
        }
    }
    </script>
</html>