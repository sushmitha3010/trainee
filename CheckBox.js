
document.getElementById('delivered').onclick = function() {
	var markedCheckbox = document.getElementsByName('checkName');
	var inputField = document.getElementById('leaveIdList');
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
document.getElementById('processing').onclick = function() {
	var markedCheckbox = document.getElementsByName('speed');
	var inputField = document.getElementById('leaveIdList');
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
