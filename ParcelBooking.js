function validateForm() {
	let senderName = document.querySelector("#SenderName").value;
	let senderMobileNo = document.querySelector("#SenderMobileNumber").value;
	let senderAddress = document.querySelector("#SenderAddress").value;
	let receiverName = document.querySelector("#ReceiverName").value;
	let receiverMobileNo = document.querySelector("#ReceiverMobileNumber").value;
	let receiverAddress = document.querySelector("#ReceiverAddress").value;
	let parcelCharge = parcelWeight * 15;
	try {
		if (senderName === null || senderName.trim() === "") {
			throw new Error("Sender Name Cannot be Empty");
		}
		else if (senderName.length < 4) {
			throw new Error("Sender Name Length Should Not be Less Than 4 Characters");
		}
		else if (senderMobileNo.length < 10 || senderMobileNo.length > 10) {
			throw new Error(" Sender Mobile No Must Contain 10 Numbers Only");
		}
		else if (senderAddress.length < 10) {
			throw new Error(" Sender Address Should Not be Less Than 10 Characters");
		}
		else if (parcelWeight === 0) {
			throw new Error("parcel weight should not be zero  ")
		}
		else if (receiverName.length < 4) {
			throw new Error("Receiver Name Length Should Not be Less Than 4 Characters");
		}
		else if (receiverMobileNo.length < 10 || senderMobileNo.length > 10) {
			throw new Error(" Reeceiver Mobile No Must Contain 10 Numbers Only");
		}
		else if (receiverAddress.length < 10) {
			throw new Error(" Receiver Address Should Not be Less Than 10 Characters");
		}
		else {
			alert("Welcome:" + senderName);
			alert("Total Parcel Charge Is:" + parcelCharge);
		}
		let form = document.querySelector("#parcelForm");
		form.submit();
	}
	catch (err) {
		alert("Error:" + err.message);
	}
}
