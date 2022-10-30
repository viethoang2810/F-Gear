/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var listOfRows = document.querySelectorAll(".table-row");
listOfRows.forEach((row,index) =>{
    var removeBtn = row.querySelector(".btn-remove");
    var modalForm = row.querySelector(".modal-wrapper");
    var modalWrapper = row.querySelector(".modal-wrapper");
    removeBtn.onclick = () => {
        modalForm.style.display = "block";
    };
    modalWrapper.addEventListener("click", () => {
        console.log(123);
        modalForm.style.display = "none";
    });
})
