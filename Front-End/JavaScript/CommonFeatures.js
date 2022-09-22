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
//Handle redirect page by JS 
var paymentRedirectPage = document.querySelector('.payment');

paymentRedirectPage.onclick = (e) =>{
  window.location.replace("http://127.0.0.1:5500/Front-End/Payment_Guildine.html");
}