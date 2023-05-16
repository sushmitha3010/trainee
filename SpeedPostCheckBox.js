
document.getElementById('deliver').onclick = function() {
	var markedCheckbox = document.getElementsByName('checkName');
	var inputField = document.getElementById('trackingNoList');
	var value = [];
	for (var checkbox of markedCheckbox) {
		if (checkbox.checked) {
			console.log(value);
			value.push(checkbox.value);
			document.body.append(checkbox.value + ',');
		}
	}
	inputField.value = value;
}
document.getElementById('process').onclick = function() {
	var markedCheckbox = document.getElementsByName('checkName');
	var inputField = document.getElementById('trackingNoList');
	var value = [];
	for (var checkbox of markedCheckbox) {
		if (checkbox.checked) {
			console.log(value);
			value.push(checkbox.value);
			document.body.append(checkbox.value + ',');
		}
	}
	inputField.value = value;
}
