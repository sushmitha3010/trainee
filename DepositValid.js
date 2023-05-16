function validateForm() {
	let userName = document.querySelector("#UserName").value;
	let mobileNumber = document.querySelector("#MobileNumber").value;
	let accountNumber = document.querySelector("#AccountNumber").value;
	let principleAmount = document.querySelector("#PrincipleAmount").value;
	try {
		if (userName === null || userName.trim() === "") {
			throw new Error("User Name Cannot be Empty");
		}
		else if (userName.length < 4) {
			throw new Error("User Name Length Should Not be Less Than 4 Characters");
		}
		else if (mobileNumber.length < 10 || mobileNumber.length > 10) {
			throw new Error("Mobile No Must Contain 10 Numbers Only");
		}
		else if (accountNumber.length < 12 || accountNumber.length > 12) {
			throw new Error("Account No Must Contain 12 Numbers Only");
		}
		else if (principleAmount < 0) {
			throw new Error("The Principle Amount Could Not Less Than Zero")
		}
		else {
			alert("Welcome:" + userName);
		}
		let form = document.querySelector("#RecurringDepositform");
		form.submit();
	}
	catch (err) {
		alert("Error:" + err.message);
	}
}
function dateCalulation() {
	var year1 = new Date("December 31, 1947 20:22:10 GMT+11:00");
	var year2 = new Date("December 31, 1947 20:22:10 GMT-11:00");
	document.writeln("Year value1 : " + year1.getUTCFullYear() + "<br>");
	document.writeln("Year value2 : " + year2.getUTCFullYear());
}
