function validate(){
	
	if( document.getElementById('customer_name').value == ""){
		document.getElementById('nameMsg').innerHTML="Name cannot be empty";
		document.getElementById('nameMsg').style.color = "red";
		document.getElementById('nameMsg').style.fontsize = 10;
		return false;
	}else if( document.getElementById('customer_name').value.length>20){
		document.getElementById('nameMsg').innerHTML="Name is invalid";
		document.getElementById('nameMsg').style.color = "red";
		return false;
	}else{
		document.getElementById('nameMsg').innerHTML="";
	}

  if( document.getElementById('shipping_address').value == ""){
		document.getElementById('addressMsg').innerHTML="Address cannot be empty";
		document.getElementById('addressMsg').style.color = "red";
		return false;
	}else if( document.getElementById('shipping_address').value.length>50){
		document.getElementById('addressMsg').innerHTML="Address is invalid";
		document.getElementById('addressMsg').style.color = "red";
		return false;
	}else{
		document.getElementById('addressMsg').innerHTML="";
	}
	
	
	if( document.getElementById('customer_contact').value == ""){
		document.getElementById('contactMsg').innerHTML="Contact number cannot be empty"
		document.getElementById('contactMsg').style.color = "red";
		
		return false;
	}else if( document.getElementById('customer_contact').value.length!=10){
		document.getElementById('contactMsg').innerHTML="Contact number is invalid";
		document.getElementById('contactMsg').style.color = "red";
		return false;
	}else{
		document.getElementById('contactMsg').innerHTML="";
	}
 
  
        return( true );
   }
         