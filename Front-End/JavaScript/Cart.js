// Handle increase and descrease amount of product

const listOfRow = document.querySelectorAll(".table-row");

listOfRow.forEach((row, index) => {
  var price = row.querySelector(".cart-item_price").innerHTML;
  const descreaseBtn = row.querySelector(".btn-decreasing");
  const increasBtn = row.querySelector(".btn-increasing");
  amountOfItem = row.querySelector(".amount-content").innerHTML;
  
  if (!localStorage.getItem(`amountDefault-${index + 1}`)) {
    localStorage.setItem(`amountDefault-${index + 1}`, 1);
    
  }
  if (!localStorage.getItem(`priceDefault-${index + 1}`)) {
    localStorage.setItem(`priceDefault-${index + 1}`, price);
  }
  row.querySelector(".cart-item_price").innerHTML = localStorage.getItem(`priceDefault-${index + 1}`);

  row.querySelector(".amount-content").innerHTML = localStorage.getItem(
    `amountDefault-${index + 1}`
  );
  var amountOfItem = row.querySelector(".amount-content").innerHTML;
  row.querySelector(".amount-content").innerHTML = localStorage.getItem(
    `amountDefault-${index + 1}`
  );
  
  console.log(
    `Index row : ${index + 1} : Index itemStorage ${localStorage.getItem(
      `amountDefault-${index + 1}`
    )}`
  );
  descreaseBtn.addEventListener("click", () => {
    if (amountOfItem <= 1) return;
    row.querySelector(".amount-content").innerHTML = --amountOfItem;
    localStorage.setItem(`amountDefault-${index + 1}`, amountOfItem);
    let priceStorage =  calculatePrice(price, amountOfItem, row, ".cart-item_price");
    localStorage.setItem(`priceDefault-${index + 1}`, priceStorage);
    calculatePrice(price, amountOfItem, row, ".cart-item_price");
  });

  increasBtn.addEventListener("click", () => {
    if (amountOfItem >= 10) return; //Amount of item is limited at 10 item per cart , if they want to buy more than 10 , pls make a telephone for store owner
    amountOfItem++;

    row.querySelector(".amount-content").innerHTML = amountOfItem;
    localStorage.setItem(`amountDefault-${index + 1}`, amountOfItem);
    let priceStorage =  calculatePrice(price, amountOfItem, row, ".cart-item_price");
    localStorage.setItem(`priceDefault-${index + 1}`, priceStorage);

    console.log(priceStorage);
  });
});
// Handle price as user changes amount of item
function calculatePrice(price, amount, scope, className) {
  price = price.split(".");
  price = parseInt(price[0]);
  scope.querySelector(className).innerHTML = amount * price + ".000.000đ";
  return amount * price + ".000.000đ";
}
// Handle display choose payment method modal
const checkoutMethodBtn = document.querySelector('.checkout-btn');
const closeIcon = document.querySelector('.close-icon');

checkoutMethodBtn.onclick = () => {
   document.querySelector('.modal-wrapper').style.display = 'flex';
}
closeIcon.addEventListener('click', ()=>{
  document.querySelector('.modal-wrapper').style.display = 'none';

})