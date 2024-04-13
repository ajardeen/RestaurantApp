
// start cart tab open and close js

const cartopen=document.querySelector("#cart-icon");
const cart=document.querySelector('.cart');
const cartclose=document.querySelector('#cart-close');
cartopen.addEventListener('click',()=>{
    cart.classList.add('tabopen');
});
cartclose.addEventListener('click',()=>{
    cart.classList.remove('tabopen');
});

// end  



// default DOM
document.addEventListener('DOMContentLoaded',loadfood);
function loadfood(){
   loadContant();
}
//end


function loadContant(){
	
    //remove food items in cart
    let btnremove=document.querySelectorAll(".cart-remove");
    btnremove.forEach((btn)=>{
        btn.addEventListener('click',removeitem);
    });

    // cart input text field
     let qtyinputs=document.querySelectorAll(".cart-quantity");
     qtyinputs.forEach((input)=>{
         input.addEventListener('change',changeQty);
     });

     // add cart
     let cartbtn=document.querySelectorAll(".add-cart");
     cartbtn.forEach((btn)=>{
        btn.addEventListener('click',addcart);
     });

     updateTotal();
     
     //  start place order
     const porder=document.querySelector('#place-order');
     porder.addEventListener('click',order);
    
  }



// remove cart items
function removeitem(){
    if(confirm("Are you Sure delete?")){
        // filtering productArray[] to remove after clicked delete button from cart
        let id=this.parentElement.querySelector('.product-id').innerHTML;
        // console.log(title);
        productArray=productArray.filter(element=>element.id!=id);
       //----------------------
        this.parentElement.remove();
    }
    updateTotal();
}

//change qty
function changeQty(){
    if(isNaN(this.value) || this.value<1){
        this.value=1;
    }
  loadContant();
  updateTotal();
}


let productArray=[];


//add cart
function addcart(){
   let product=this.parentElement;
   let title=product.querySelector('.food-title').innerHTML;
   let price=product.querySelector('.food-price').innerHTML;
   let id=product.querySelector('.food-id').innerHTML;
//    console.log(title,price);

// productArray system

let checkProduct={id,title,price};

// checking new product exist or not

if(productArray.find((item)=>item.id==checkProduct.id))
{
    alert("Product Already 'ADDED!'");
    return;
}
else{
    productArray.push(checkProduct);
    
}


// append product
let newProduct=createCartProduct(id,title,price);
let cart_content=document.querySelector(".cart-content");

let newdiv=document.createElement('div');
newdiv.innerHTML=newProduct;
cart_content.append(newdiv);
loadContant();
                        }

// create cart product
function createCartProduct(id,title,price){
    return `<div class="cart-box">
    <hr>
    <div class="detail-box">
    <div class="product-id">${id}</div>
     <div class="product-title">${title}</div>
     <div class="price-box">
         <div class="cart-price">${price}</div>
         <span class="Amount">Amount</span>
         <div class="cart-amt">${price}</div>
     </div>
     <input type="number" value="1" class="cart-quantity">
    </div>
    
    <span class="material-symbols-outlined cart-remove" >
delete
</span>
    </div>`;

}

// update total

function updateTotal(){
    const cartItems=document.querySelectorAll('.cart-box');
    const totalValue=document.querySelector('.total-price');
    let total=0;

    cartItems.forEach(product=>{
        let productElement=product.querySelector('.cart-price');
        let price=parseFloat(productElement.innerHTML.replace("Rs.",""));
        let qty=product.querySelector('.cart-quantity').value;
        total+=(price*qty);
        product.querySelector('.cart-amt').innerText='Rs.'+(price*qty);

    });
    
    totalValue.innerHTML='Rs.'+total;
}


// place order
 function order(){
	let billamt=0;
	let billing=document.querySelector('.billing');
	billing.style.display='flex';
	let id=document.querySelectorAll('.product-id');
	let title=document.querySelectorAll('.product-title');
	let price=document.querySelectorAll('.cart-price');
	let amt=document.querySelectorAll('.cart-amt');
	let qty=document.querySelectorAll('.cart-quantity');
	let total=document.querySelector('.total-price');
	
	
	
	let billingtbody=document.querySelector('#billingtbody');
	
	for(let i=0;i<id.length;i++){
		let tr=document.createElement('tr');
		tr.className='trbill';
		
		let snotd=document.createElement('td');
		snotd.textContent=id[i].innerHTML;
		tr.append(snotd);
		
		let nametd=document.createElement('td');
		nametd.textContent=title[i].innerHTML;
		tr.append(nametd);
		
		let pricetd=document.createElement('td');
		pricetd.textContent=price[i].innerHTML;
		tr.append(pricetd);
		
		let qtytd=document.createElement('td');
		qtytd.textContent=qty[i].value;
		tr.append(qtytd);
		
		let amttd=document.createElement('td');
		amttd.textContent=amt[i].innerHTML;
		amttd.className='amttd';
		tr.append(amttd);
		
		billingtbody.append(tr);
		
	
	}
	let totalbill=document.querySelectorAll('.amttd');
	totalbill.forEach(amt=>{
		let newamt=amt.innerHTML.replace('Rs.',"");
		billamt+=parseFloat(newamt);
		
		});
	
	let totaltd=document.querySelector('.bill-total');
	totaltd.innerHTML=billamt;
	
	
	let cartbox=document.querySelectorAll('.cart-box');
	cartbox.forEach(e=>e.remove());
	 total.innerHTML='Rs.0';
	 
	 productArray=[];

}
     
 

//----------------------end------------------------


 let billcancel=document.querySelector('.billcancel');
        billcancel.addEventListener('click',()=>{
            let billing=document.querySelector('.billing');
            let trbill=document.querySelectorAll('.trbill');
          if(confirm('Cancel anyway?')){
         billing.style.display='none';
         trbill.forEach(tr=>tr.remove())
         }
        });

        let pay=document.querySelector('.pay');
        pay.addEventListener('click',()=>{
            let billing=document.querySelector('.billing');
            let trbill=document.querySelectorAll('.trbill');
           if(confirm("Payment Completed")){
           billing.style.display='none';
           trbill.forEach(tr=>tr.remove());
           }
        });