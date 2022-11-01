/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var itemList = document.querySelectorAll(".navigation-item");

// Handle display modal confirmation
var listOfRows = document.querySelectorAll(".table-row");
listOfRows.forEach((row) => {

});

// Handle display add modal
var addBtn = document.querySelector(".modal-btn");
var closeIcon = document.querySelector(".close-icon");
var addModalContent = document.querySelector(".add-modal-content");

addBtn.addEventListener("click", () => {
    addModalContent.style.display = "flex";
});
closeIcon.addEventListener("click", () => {
    addModalContent.style.display = "none";
});
// Handle display edit modal





// Handle value of input of update features
listOfRows.forEach((row) => {
    //Get the values is displayed on DOM
    var nameDisplay = row.querySelector(".table-product_name");

var editModalWrapper = row.querySelector(".edit-modal-content");
    
    //Assign above values to value of inputs in form fields

//  Edit button
    var editBtn = row.querySelector(".btn-edit");//////////
    editBtn.addEventListener("click", () => {
        
        editModalWrapper.style.display = "flex";
        
    });

    var exitIcon = document.querySelector(".exit-icon");
    exitIcon.addEventListener("click", () => {
        editModalWrapper.style.display = "none";
    });
//    Remove
  //  var removeBtn = row.querySelector(".btn-remove");
    var modalForm = row.querySelector(".modal-wrapper");
    var modalWrapper = row.querySelector(".modal-wrapper");
    //removeBtn.onclick = () => {
    //    modalForm.style.display = "block";
   // };
    modalWrapper.addEventListener("click", () => {
        console.log(123);
        modalForm.style.display = "none";
    });

    var nameInput = row.querySelector(".productName");
        
        nameInput.value = nameDisplay.innerHTML;
       
});


