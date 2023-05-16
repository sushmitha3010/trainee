var nameError = document.getElementById("name-error");
var mobileNoError = document.getElementById("mobileNo-error");
var accountNoError = document.getElementById("accountNo-error");
var principleAmountError = document.getElementById("principleAmount-validation");
var amountError = document.getElementById("amount-validation");
var monthError = document.getElementById("month-validation");
var ageError = document.getElementById("age-validation");
var text;
function regexValid() {
	var name = document.getElementById("UserName").value;
	var nameValidation = '[A-Za-z]*$';
	if (name === 0 || name.trim() === "") {
		text = 'Name Cannot Be Empty';
		nameError.innerHTML = text;
		return false;
	}
	if (name.length < 4) {
		text = 'Name Must Contain Greater Than 4 Characters';
		nameError.innerHTML = text;
		return false;
	}
	if (!name.match(nameValidation)) {
		text = 'Invalid Name! Name Only Allowed For Characters Not Contain Digits';
		nameError.innerHTML = text;
		return false;
	}
	nameError.innerHTML = 'Valid';
	return true;
}
function mobileNoValidation() {
	var mobileNo = document.getElementById("MobileNumber").value;
	let mobileNovalid = "[6-9][0-9]{9}";
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
	if (!mobileNo.match(mobileNovalid)) {
		text = 'Invalid Mobile Number Mobile Number Must Starts With 6,7,8 and 9';
		mobileNoError.innerHTML = text;
		return false;
	}
	mobileNoError.innerHTML = '<i class="fa-regular"></i>';
	return true;
}
function accountNoValidation() {
	var accountNo = document.getElementById("AccountNumber").value;
	let accountNovalid = "\\d{12}";
	if (accountNo === 0) {
		text = 'Account Number Cannot Be Empty';
		accountNoError.innerHTML = text;
		return false;
	}
	if (accountNo.length < 12 || accountNo.length > 12) {
		text = 'Account Number Must Conatin 12 Digits';
		accountNoError.innerHTML = text;
		return false;
	}
	if (!accountNo.match(accountNovalid)) {
		text = 'Invalid Account Number';
		accountNoError.innerHTML = text;
		return false;
	}
	accountNoError.innerHTML = '<i class="fa-regular"></i>';
	return true;
}
function amountValidation() {
	var principleAmount = document.getElementById("PrincipleAmount").value;
	if (principleAmount === 0) {
		text = 'amount  Cannot Enter Zero Value';
		principleAmountError.innerHTML = text;
		return false;
	}
	principleAmountError.innerHTML = '<i class="fa-regular"></i>';
	return true;
}
function amountValidation1() {
	var amount = document.getElementById("PrincipleAmount").value;
	if (amount <= 0) {
		text = 'amount  Cannot Enter Zero Value and Cannot Enter Negative Values';
		amountError.innerHTML = text;
		return false;
	}
	amountError.innerHTML = '<i class="fa-regular"></i>';
	return true;
}

function monthValidation() {
	var month = document.getElementById("NumberOfMonths").value;
	if (month <= 0) {
		text = 'Months  Cannot Enter Zero Value and Cannot Enter Negative Values';
		monthError.innerHTML = text;
		return false;
	}
	monthError.innerHTML = '<i class="fa-regular"></i>';
	return true;
}

function ageValidation() {
	var age = document.getElementById("Age").value;
	let ageValid = /^(1[89]|[6-9]\d)$/;
	if (age === 0 || age.trim() === "") {
		text = 'Age  Cannot Enter Zero Value and Cannot Enter Negative Values';
		ageError.innerHTML = text;
		return false;
	}
	if (!age.match(ageValid)) {
		text = "Age does Not Contain less than 60 age and Greater than 99 age";
		ageError.innerHTML = text;
		return false;
	}
	ageError.innerHTML = '<i class="fa-regular"></i>';
	return true;
}




















