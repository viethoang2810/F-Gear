

// Handle change images of product 

var listOfImage = document.querySelectorAll('.image-invole-item');
var displayImage = document.querySelector('.product-image');
console.log(listOfImage);
listOfImage.forEach((image, index) => {
    image.addEventListener('click', () => {
      let linkClicked = image.querySelector('.involve-item').src;
      handleRemoveClass(listOfImage,getIndexOfElement(listOfImage,'active-picture'),'active-picture');
      displayImage.src = linkClicked.split('http://127.0.0.1:5500/Front-End/')[1];
      image.classList.add('active-picture');
    })
})
// The method will be returned index of element which has a className contains active class
 const getIndexOfElement = (listOfImage,className) => {
  for(var i = 0 ; i < listOfImage.length ; i++) {
    if(listOfImage[i].className.includes(className)){
      return i;
    }
  }
}
//The method will be remove the className based on index provided
 const handleRemoveClass = (listOfImage,index,className) =>{
    for(var i = 0 ; i < listOfImage.length ; i++) {
        if(i == index){
          listOfImage[i].classList.remove(className);
        }
    }
}
