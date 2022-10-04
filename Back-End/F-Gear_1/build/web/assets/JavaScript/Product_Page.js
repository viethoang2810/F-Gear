// Handle submit filter form
var filterList = document.querySelector(".filter-list");

filterList.addEventListener("change", () => {
  console.log(filterList.value);
  let formFilter = document.querySelector(".filter-form");
  formFilter.submit();
});
// Handle Paging product
var recordPerPage = 8;
var listItem = document.querySelectorAll(".product-item");
var flagArray = [];
listItem.forEach((item) => {
  flagArray.push(item);
});

var pageWrapper = document.querySelector(".index-list"); //Get the parent node of list index

assignNumberPage(numPages());
//Assign number page to HTML element

function assignNumberPage(totalPage) {
  for (var i = 1; i < totalPage + 1; i++) {
    // let page = `<li class="index-item"></li>` ;
    // page.innerHTML = i ;
    var page = document.createElement("li");
    page.classList.add("index-item");
    page.innerHTML = i;

    pageWrapper.append(page);
  }
}
var listOfPage = document.querySelectorAll(".index-item");
var productWrapper = document.querySelector(".product-list");


var currentPage = 1;


listOfPage.forEach((page) => {
 
  page.addEventListener("click", () => {
    currentPage = page.innerHTML;

    changePage(page.innerHTML);
  });
});

const changePage = (page) => {
  removeAllChildNodes(productWrapper);

  for (var i = (page - 1) * recordPerPage; i < page * recordPerPage; i++) {
    if (flagArray[i] == undefined) {
      flagArray[i] = " ";
    }
    productWrapper.append(flagArray[i]);
  }
};


// Calculate amount of page
function numPages() {
  return Math.ceil(flagArray.length / recordPerPage);
}

changePage(1);

//Remove all child or parent node
function removeAllChildNodes(parent) {
  while (parent.firstChild) {
    parent.removeChild(parent.firstChild);
  }
}
//Handle change page by clicking button
function prevPage(page) {
  console.log(page);
  if (currentPage == 1) {
    return;
  }
  page--;
  changePage(page);
  currentPage = page ;

}
var prevBtn = document.querySelector('.change-prev');

prevBtn.addEventListener('click',()=>{
  if(currentPage <= 1){
    return ;
  }
  currentPage--;
  changePage(currentPage);
})
var nextBtn = document.querySelector('.change-next');
nextBtn.addEventListener('click',() => {
  console.log("Next: "+ currentPage);

  if(currentPage == numPages()){
    return ;
  }
  currentPage++;
  changePage(currentPage);

})

