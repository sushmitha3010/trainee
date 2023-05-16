function recurringListAction() {

	var dataView;
	var grid;
	var columnFilters = {};




	var data = document.getElementById("recuringAction").value

	/*<![CDATA[*/
	//var data = /*[[${registeredPaymentList}]]*/'Emp';//

	console.log(data);


	var data1 = JSON.parse(data);
	var trackingNoList = [];
	for (var i = 0; i < data1.length; i++) {
		trackingNoList.push(data1[i]['track_no']);
		console.log(data1[i]['track_no']);

	}
	console.log(trackingNoList);

	var nextId = 1;
	data1.forEach(function(item) {
		// Generate a unique id using the nextId value
		var itemId = "item_" + nextId;

		// Set the id property of the item object
		item.id = itemId;

		// Increment the nextId value
		nextId++;
	});
	// Use the updated items array list with unique ids
	/* unique id end */
	var options = {
		enableCellNavigation: true,
		showHeaderRow: true,
		headerRowHeight: 30,
		explicitInitialization: true
	};

	//var check= document.getElementById("checkBox");
	var check = document.querySelectorAll('input[type="checkbox"]:checked');
	console.log(check);
 var columns = [ {

id : "userName",

name : "user Name",

field : "userName",

width : 150

}, {

id : "depositAmount",

name : "Deposit Amount",

field : "depositAmount",

width : 150

}, {

id : "paidDate",

name : "Deposit Date",

field : "paidDate",

width : 150



}, ]




	/* filter start */
	$(function() {
		function filter(item) {
			for (var columnId in columnFilters) {
				if (columnId !== undefined
					&& columnFilters[columnId] !== "") {
					var c = grid.getColumns()[grid.getColumnIndex(columnId)];
					if (item[c.field] !== columnFilters[columnId]) {
						return false;
					}
				}
			}
			return true;
		}
		/* filter end */

		dataView = new Slick.Data.DataView();
		grid = new Slick.Grid("#myGrid", dataView, columns, options);

		/* filter start */
		dataView.onRowCountChanged.subscribe(function(e, args) {
			grid.updateRowCount();
			grid.render();
		});

		dataView.onRowsChanged.subscribe(function(e, args) {
			grid.invalidateRows(args.rows);
			grid.render();
		});

		$(grid.getHeaderRow()).delegate(":input", "change keyup",
			function(e) {
				var columnId = $(this).data("columnId");
				if (columnId != null) {
					columnFilters[columnId] = $.trim($(this).val());
					dataView.refresh();
				}
			});

		grid.onHeaderRowCellRendered.subscribe(function(e, args) {
			$(args.node).empty();
			$("<input type='text'>").data("columnId", args.column.id).val(
				columnFilters[args.column.id]).appendTo(args.node);
		});



		grid.init();

		dataView.beginUpdate();
		dataView.setItems(data1);
		dataView.setFilter(filter);
		dataView.endUpdate();
	})
}
