//Handle menu-dropdown on header
var checkClick = false; //set state for clicking which is use to handle display menu

const handleDropdownMenu = (checkClick) => {
  let menuBtn = document.querySelector(".btn-menu");
  let menuDropDown = document.querySelector(".navigator-wrapper");
  menuBtn.addEventListener("click", () => {
    checkClick = !checkClick;
    console.log(checkClick);

    if (checkClick) {
      menuDropDown.style.display = "block";
    } else {
      menuDropDown.style.display = "none";
    }
  });
};

handleDropdownMenu(checkClick);
