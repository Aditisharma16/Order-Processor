function validate(s) {
	console.log("validate");
	console.log(s);
	console.log(document.getElementById('contactNumber'+s).value)
	console.log(document.getElementById('shippingAddress'+s).value)
	if (document.getElementById('contactNumber'+s).value == "") {
		document.getElementById('contactMsg'+s).innerHTML = "Contact number cannot be empty";
		document.getElementById('contactMsg'+s).style.color = "red";
		document.getElementById('contactMsg'+s).style.fontsize = 10;
		return false;
	}else if (document.getElementById('contactNumber'+s).value.length != 10) {
		document.getElementById('contactMsg'+s).innerHTML = "Contact number is invalid";
		document.getElementById('contactMsg'+s).style.color = "red";
		document.getElementById('contactMsg'+s).style.fontsize = 10;
		return false;
	}else {
		document.getElementById('contactMsg'+s).innerHTML = "";
	}

	if (document.getElementById('shippingAddress'+s).value == "") {
		document.getElementById('addMsg'+s).innerHTML = "Address cannot be empty";
		document.getElementById('addMsg'+s).style.color = "red";
		document.getElementById('addMsg'+s).style.fontsize = 10;
		return false;
	}else if (document.getElementById('shippingAddress'+s).value.length > 50) {
		document.getElementById('addMsg'+s).innerHTML = "Address is invalid";
		document.getElementById('addMsg'+s).style.color = "red";
		document.getElementById('addMsg'+s).style.fontsize = 10;
		return false;
	}else{
		document.getElementById('addMsg'+s).innerHTML = "";
	}
	return (true);
}
