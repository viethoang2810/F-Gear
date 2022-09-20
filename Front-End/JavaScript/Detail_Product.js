//Handle menu-dropdown on header
var checkClick = false; //set state for clicking which is use to handle display menu

const handleDropdownMenu = (checkClick) => {
  let menuBtn = document.querySelector(".btn-menu");
  let menuDropDown = document.querySelector(".navigator-wrapper");
  menuBtn.addEventListener("click", () => {
    checkClick = !checkClick;


    if (checkClick) {
      menuDropDown.style.display = "block";
    } else {
      menuDropDown.style.display = "none";
    }
  });
};

handleDropdownMenu(checkClick);
// Handle menu of categories on sidebar 

const handleDropdownSidebar = (checkClick) =>{
    let menuBtn = document.querySelector(".navigator-btn_menu");
    let menuDropDown = document.querySelector('.btn-navigator-list');

    menuBtn.addEventListener('click', () =>{
      checkClick = !checkClick;


    if (checkClick) {
      menuDropDown.style.display = "block";
    } else {
      menuDropDown.style.display = "none";
    }
    })
}
handleDropdownSidebar(checkClick);

// Handle change images of product 

var listOfImage = document.querySelectorAll('.image-invole-item');
var displayImage = document.querySelector('.product-image');
console.log(listOfImage);
listOfImage.forEach((image, index) => {
    image.addEventListener('click', () => {
      let linkClicked = image.querySelector('.involve-item').src;
      handleRemoveClass(getIndexOfElement());
      displayImage.src = linkClicked.split('http://127.0.0.1:5500/Front-End/')[1];
      image.classList.add('active-picture');
    })
})
// The method will be returned index of element which has a className contains active class
const getIndexOfElement = () => {
  for(var i = 0 ; i < listOfImage.length ; i++) {
    if(listOfImage[i].className.includes('active-picture')){
      return i;
    }
  }
}
//The method will be remove the className based on index provided
const handleRemoveClass = (index) =>{
    for(var i = 0 ; i < listOfImage.length ; i++) {
        if(i == index){
          listOfImage[i].classList.remove('active-picture');
        }
    }
}