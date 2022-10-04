var itemList = document.querySelectorAll(".navigation-item");

// Handle display modal confirmation
var listOfRows = document.querySelectorAll(".table-row");
listOfRows.forEach((row) => {
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
var exitIcon = document.querySelector(".exit-icon");
var editBtn = document.querySelector(".btn-edit");
var editModalWrapper = document.querySelector(".edit-modal-content");

editBtn.addEventListener("click", () => {
  editModalWrapper.style.display = "flex";
});
exitIcon.addEventListener("click", () => {
  editModalWrapper.style.display = "none";
});
// Handle value of input of update features
listOfRows.forEach((row) => {
  //Get the values is displayed on DOM
  var nameDisplay = row.querySelector(".table-product_name").innerHTML;
  var originalDisplay = row.querySelector(".table-product_original").innerHTML;
  var discountDisplay = row.querySelector(".table-product_discount").innerHTML;

  //Assign above values to value of inputs in form fields
  var nameInput = row.querySelector(".productName");
  var priceInput = row.querySelector(".productOriginal");
  var discountInput = row.querySelector(".productDiscount");


  nameInput.value = nameDisplay;
  priceInput.value = originalDisplay;
  discountInput.value = discountDisplay;

});
