const count = document.querySelector(".counting");

document.getElementById("registeredPost").onclick = function() {
	openregisteredPostApproval()
};

document.getElementById("speedPost").onclick = function() {
	openSpeedPostApproval()
};

document.getElementById("recurringDeposit").onclick = function() {
	openrecurringDepositApproval()
};

document.getElementById("timeDeposit").onclick = function() {
	openTimeDepositApproval()
};

document.getElementById("seniorCitizen").onclick = function() {
	openseniorDepositApproval()
};

function openregisteredPostApproval() {
	const count = document.querySelector(".counting");
	const grid1 = document.getElementById("myGrid2");
	const deliveredButton = document.getElementById("register");
	const grid2 = document.getElementById("myGrid1");
	const deliveredButton2 = document.getElementById("speed");
	const grid3 = document.getElementById("myGrid3");
	const grid4 = document.getElementById("myGrid4");
	const grid5 = document.getElementById("myGrid5");
	grid1.style.display = "block";
	grid2.style.display = "none";
	grid3.style.display = "none";
	grid4.style.display = "none";
	grid5.style.display = "none";
	deliveredButton.style.display = "block";
	deliveredButton2.style.display = "none";
	count.style.display = "none";
}

function openSpeedPostApproval() {
	const count = document.querySelector(".counting");
	const grid1 = document.getElementById("myGrid4");
	const deliveredButton = document.getElementById("register");
	const grid2 = document.getElementById("myGrid1");
	const deliveredButton2 = document.getElementById("speed");
	const grid3 = document.getElementById("myGrid2");
	const grid4 = document.getElementById("myGrid3");
	const grid5 = document.getElementById("myGrid5");
	grid1.style.display = "block";
	grid2.style.display = "none";
	grid3.style.display = "none";
	grid4.style.display = "none";
	grid5.style.display = "none";
	deliveredButton.style.display = "none";
	deliveredButton2.style.display = "block";
	count.style.display = "none";
}

function openrecurringDepositApproval() {
	const count = document.querySelector(".counting");
	const deliveredButton = document.getElementById("register");
	const deliveredButton2 = document.getElementById("speed");
	const grid1 = document.getElementById("myGrid1");
	const grid2 = document.getElementById("myGrid2");
	const grid3 = document.getElementById("myGrid3");
	const grid4 = document.getElementById("myGrid4");
	const grid5 = document.getElementById("myGrid5");
	grid1.style.display = "block";
	grid2.style.display = "none";
	grid3.style.display = "none";
	grid4.style.display = "none";
	grid5.style.display = "none";
	count.style.display = "none";
	deliveredButton.style.display = "none";
	deliveredButton2.style.display = "none";
}

function openTimeDepositApproval() {
	const count = document.querySelector(".counting");
	const grid1 = document.getElementById("myGrid1");
	const grid2 = document.getElementById("myGrid2");
	const grid3 = document.getElementById("myGrid3");
	const grid4 = document.getElementById("myGrid4");
	const grid5 = document.getElementById("myGrid5");
	const deliveredButton = document.getElementById("register");
	const deliveredButton2 = document.getElementById("speed");
	grid1.style.display = "none";
	grid2.style.display = "none";
	grid3.style.display = "none";
	grid4.style.display = "none";
	grid5.style.display = "block";
	count.style.display = "none";
	deliveredButton.style.display = "none";
	deliveredButton2.style.display = "none";
}

function openseniorDepositApproval() {
	const count = document.querySelector(".counting");
	const grid1 = document.getElementById("myGrid1");
	const grid2 = document.getElementById("myGrid2");
	const grid3 = document.getElementById("myGrid3");
	const grid4 = document.getElementById("myGrid4");
	const grid5 = document.getElementById("myGrid5");
	const deliveredButton = document.getElementById("register");
	const deliveredButton2 = document.getElementById("speed");
	grid1.style.display = "none";
	grid2.style.display = "none";
	grid3.style.display = "block";
	grid4.style.display = "none";
	grid5.style.display = "none";
	count.style.display = "none";
	deliveredButton.style.display = "none";
	deliveredButton2.style.display = "none";
}
