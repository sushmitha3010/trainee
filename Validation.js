function validateForm() {
	let userName = document.querySelector("#UserName").value;
	let password = document.querySelector("#Password").value;
	let mobileNumber = document.querySelector("#MobileNumber").value;
	let aadharNumber = document.querySelector("#AadharNumber").value;
	let address = document.querySelector("#Address").value;
	try {
		if (userName === null || userName.trim() === "") {
			throw new Error("User Name Cannot be Empty");
		}
		else if (userName.length < 4) {
			throw new Error("User Name Length Should Not be Less Than 4 Characters");
		}
		else if (password.length < 8) {
			throw new Error("Password Length Should Not be Less Than 8 Characters ");
		}
		else if (mobileNumber.length < 10 || mobileNumber.length > 10) {
			throw new Error("Mobile No Must Contain 10 Numbers Only");
		}
		else if (aadharNumber.length < 12 || aadharNumber.length > 12) {
			throw new Error("Aadhar No Must Contain 12 Numbers Only");
		}
		else if (address.length < 10) {
			throw new Error("Address Should Not be Less Than 10 Characters");
		}
		else {
			alert("Welcome:" + userName);
		}
		let form = document.querySelector("#registerForm");
		form.submit();
	}
	catch (err) {
		alert("Error:" + err.message);
	}
}



