function ordervalidate()
{
	let contact = document.getElementById("contactNumber").value;
    let address = document.getElementById("shippingAddress").value;
    
    if (isBlank(contact)) {
        document.getElementById("contactMsg").innerHTML = "Enter contact number";
        document.getElementById("contactMsg").style.color = "red";
        return false;
    }
    
    if (isBlank(address)) {
        document.getElementById("addMsg").innerHTML = "Enter shipping address";
        document.getElementById("addMsg").style.color = "red";
        return false;
    }
    
    if (!isValidPhoneNumber(contact)) {
        document.getElementById("contactMsg").innerHTML = "Enter valid phone no of 10 digit";
        document.getElementById("contactMsg").style.color = "red";
        return false;
    }
    
   return ( true );
}

function isBlank(val) {
    return (val.trim() == "") ? true : false;
}
function isValidPhoneNumber(contact) {
    let phoneRE = /^[6-9]{2}[0-9]{8}$/;
    if (contact.match(phoneRE)) {
        return true;
    } else
        return false;
}
