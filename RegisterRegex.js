var nameError = document.getElementById("name-validation");
var passwordError = document.getElementById("password-validation");
var mobileNoError = document.getElementById("mobileNo-validation");
var aadharNoError = document.getElementById("aadharNo-validation");
var addressError = document.getElementById("address-validation");
var mailIdError = document.getElementById("mailId-validation");
var text;
function nameValid() {
	var userName = document.getElementById("userName").value;
	var nameValid = '^[A-Za-z]*$';
	if (userName === 0 || userName.trim() === "") {
		text = 'Name Cannot Be Empty';
		nameError.innerHTML = text;
		return false;
	}
	if (userName.length < 4) {
		text = 'Name Must Contain Greater Than 4 Characters';
		nameError.innerHTML = text;
		return false;
	}
	if (!userName.match(nameValid)) {
		text = 'Invalid Name Name Only Contain Characters<br> and Not Contains Digits';
		nameError.innerHTML = text;
		return false;
	}
	nameError.innerHTML = '<i class="fa-regular"></i>';
	return true;
}
function passwordValidation() {
	var password = document.getElementById('password').value;
	let passwordValidation = /^.[A-Za-z0-9]{1,}[@#$!%^&?><]{1,}.*$/;
	if (password === null || password.trim() === "") {
		text = "Password Cannot Be Empty";
		passwordError.innerHTML = text;
		return false;
	}
	if (!password.match(passwordValidation)) {
		text = "Password Should be more than 6 characters and <br>Must Contain Atleast one Special Character";
		passwordError.innerHTML = text;
		return false;
	}
	passwordError.innerHTML = '<i class="fa-regular"></i>';
	return true;
}
function mobileNoValidation1() {
	var mobileNo = document.getElementById("mobileNo").value;
	let mobileNoValidation1 = "[6-9][0-9]{9}";
	if (mobileNo === 0) {
		text = 'Mobile Number Cannot Be Empty';
		mobileNoError.innerHTML = text;
		return false;
	}
	if (mobileNo.length < 10 || mobileNo.length > 10) {
		text = 'Mobile Number Must Conatin 10 Digits';
		mobileNoError.innerHTML = text;
		return false;
	}
	if (!mobileNo.match(mobileNoValidation1)) {
		text = 'Invalid Mobile Number Mobile Number Starts<br> With 6,7,8 or 9 Only ';
		mobileNoError.innerHTML = text;
		return false;
	}
	mobileNoError.innerHTML = '<i class="fa-regular"></i>';
	return true;
}
function aadharNoValidation() {
	var aadharNo = document.getElementById("AadharNumber").value;
	let aadharNoValidation = "\\d{12}";
	if (aadharNo === 0) {
		text = 'Aadhar Number Cannot Be Empty';
		aadharNoError.innerHTML = text;
		return false;
	}
	if (aadharNo.length < 12 || aadharNo.length > 12) {
		text = 'Aadhar Number Must Conatin 12 Digits';
		aadharNoError.innerHTML = text;
		return false;
	}
	if (!aadharNo.match(aadharNoValidation)) {
		text = 'Invalid Aadhar Number';
		aadharNoError.innerHTML = text;
		return false;
	}
	aadharNoError.innerHTML = '<i class="fa-regular"></i>';
	return true;
}
function mailIdValidation() {
	var mailId = document.getElementById("mailId").value;
	let mailIdValidation = "^[a-zA-Z0-9+.-]+@[a-zA-Z+.-]+$";
	if (mailId === 0) {
		text = ' Mail Id Cannot Be Empty';
		mailIdError.innerHTML = text;
		return false;

	}
	if (mailId.length < 5 || mailId.length > 50) {
		text = ' Invalid Mail Id!  ';
		mailIdError.innerHTML = text;
		return false;
	}
	if (!mailId.match(mailIdValidation)) {
		text = 'Invalid Mail Id ! Mail Id should contain only <br>alphabets after @ symbol';
		mailIdError.innerHTML = text;
		return false;
	}
	mailIdError.innerHTML = '<i class="fa-regular"></i>';
	return true;
}
function addressValidation1() {
	var address = document.getElementById("address").value;
	let addressValidation1 = "^(.+){10,50}[a-z,.-A-Z0-9\s]";
	if (address === null || address.trim() === "") {
		text = 'Address Cannot Be Empty and Must Include  ,.-numbers,a-zA-Z ';
		addressError.innerHTML = text;
		return false;
	}
	if (address.length < 10 || address.length > 50) {
		text = ' Address Must Conatin minimum 10 and maximum 50<br> Characters and must include ,.-numbers,a-zA-Z ';
		addressError.innerHTML = text;
		return false;
	}
	if (!address.match(addressValidation1)) {
		text = 'Invalid Address';
		addressError.innerHTML = text;
		return false;
	}
	addressError.innerHTML = '<i class="fa-regular"></i>';
	return true;
}




