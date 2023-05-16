function speedPostPassBook() {

	var speedPostPassBookDataView;

	var speedPostPassBookGrid;

	var speedPostPassBookData = document.getElementById("speedPostPassBook").value;

	var data1 = JSON.parse(speedPostPassBookData);
	console.log(speedPostPassBookData);

	/* set unique it to array */

	var speedPostPassBookId = 1;

	data1.forEach(function(item) {

		// Generate a unique id using the nextId value

		var itemId = "item_" + speedPostPassBookId;

		// Set the id property of the item object

		item.id = itemId;

		// Increment the nextId value

		speedPostPassBookId++;

	});

	// Use the updated items array list with unique ids

	console.log(speedPostPassBookData);

	/* unique id end */
	function dateFormat(row, cell, value, columnDef, dataContext) {
		const date = new Date(value);
		var getDay = date.toLocaleString("default", { day: "2-digit" });
		var getMonth = date.toLocaleString("default", { month: "2-digit" });
		var getYear = date.toLocaleString("default", { year: "numeric" }); // Set the desired date format
		const formattedDate = getDay + "-" + getMonth + "-" + getYear;// Format the date as a string
		return formattedDate; // Return the formatted date string
	}



	var speedPostColumnFilters = {};

	var columns = [{
		id: "senderName",

		name: "Sender Name",

		field: "senderName",

		width: 125

	}, {

		id: "senderMobileNo",

		name: "Sender Mobile No",

		field: "senderMobileNo",

		width: 130

	}, {

		id: "senderUserAddress",

		name: "Sender Address",

		field: "senderUserAddress",

		width: 160

	}, {
		id: "kms",

		name: "Kilometers",

		field: "kms",

		width: 60

	}, {

		id: "receiveUserName",

		name: "Receiver Name",

		field: "receiveUserName",

		width: 125

	}, {

		id: "receiveUserMobileNo",

		name: "Receiver Mobile No",

		field: "receiveUserMobileNo",

		width: 130

	}, {
		id: "receiverUserAddress",

		name: "Receiver Address",

		field: "receiverUserAddress",

		width: 160

	}, {

		id: "bookDate",

		name: "Booking Date",

		field: "bookDate",
		formatter: dateFormat,

		width: 120,
	}, {

		id: "trackingCode",

		name: "Tracking No",

		field: "trackingCode",

		width: 100
	}, {
		id: "charge",

		name: "Parcel Charge",

		field: "charge",

		width: 100
	}];

	var speedPostPassBookOption = {
		editable: true,
		enableAddRow: false,
		enableCellNavigation: true,
		asyncEditorLoading: true,
		forceFitColumns: false,
		showHeaderRow: true,
		headerRowHeight: 30,
		rowHeight : 40,
		explicitInitialization: true,
		topPanelHeight: 25,
		suppressCssChangesOnHiddenInit: true
	};
	var sortcol1 = "title";
	var sortdir1 = 1;
	function comparer(a, b) {
		var x = a[sortcol1], y = b[sortcol1];
		return (x === y ? 0 : (x > y ? 1 : -1));
	}
	$(".grid-header .ui-icon")
		.addClass("ui-state-default ui-corner-all")
		.mouseover(function(e) {
			$(e.target).addClass("ui-state-hover")
		})
		.mouseout(function(e) {
			$(e.target).removeClass("ui-state-hover")
		});
	$(function() {
		/* filter start */
		function filter(item) {
			for (var columnId in speedPostColumnFilters) {
				if (columnId !== undefined && speedPostColumnFilters[columnId] !== "") {
					var column = speedPostPassBookGrid.getColumns()[speedPostPassBookGrid.getColumnIndex(columnId)];
					if (item[column.field] !== undefined) {
						var filterResult = typeof item[column.field].indexOf === 'function'
							? (item[column.field].indexOf(speedPostColumnFilters[columnId]) === -1)
							: (item[column.field] !== speedPostColumnFilters[columnId]);
						if (filterResult) {
							return false;
						}
					}
				}
			}
			return true;
		}

		/* filter end */
		//        dataView = new Slick.Data.DataView({ inlineFilters: true });
		speedPostPassBookDataView = new Slick.Data.DataView();
		speedPostPassBookGrid = new Slick.Grid("#myGrid2", speedPostPassBookDataView, columns, speedPostPassBookOption);
		speedPostPassBookGrid.setSelectionModel(new Slick.RowSelectionModel());
		// header row start
		speedPostPassBookDataView.onRowCountChanged.subscribe(function(e, args) {
			speedPostPassBookGrid.updateRowCount();
			speedPostPassBookGrid.render();
		});
		speedPostPassBookDataView.onRowsChanged.subscribe(function(e, args) {
			speedPostPassBookGrid.invalidateRows(args.rows);
			speedPostPassBookGrid.render();
		});
		$(speedPostPassBookGrid.getHeaderRow()).delegate(":input", "change keyup",
			function(e) {
				var columnId = $(this).data("columnId");
				if (columnId !== null) {
					speedPostColumnFilters[columnId] = $.trim($(this).val());
					speedPostPassBookDataView.refresh();
				}
			});
		speedPostPassBookGrid.onHeaderRowCellRendered.subscribe(function(e, args) {
			$(args.node).empty();
			$("<input type='text'>").data("columnId", args.column.id).val(
				speedPostColumnFilters[args.column.id]).appendTo(args.node);
		});
		// header row end
		// move the filter panel defined in a hidden div into grid top panel
		$("#inlineFilterPanel")
			.appendTo(speedPostPassBookGrid.getTopPanel())
			.show();
		speedPostPassBookGrid.onCellChange.subscribe(function(e, args) {
			speedPostPassBookDataView.updateItem(args.item.id, args.item);
		});
		speedPostPassBookGrid.onKeyDown.subscribe(function(e) {
			// select all rows on ctrl-a
			if (e.which !== 65 || !e.ctrlKey) {
				return false;
			}
			var rows = [];
			for (var i = 0; i < speedPostPassBookDataView.getLength(); i++) {
				rows.push(i);
			}
			speedPostPassBookGrid.setSelectedRows(rows);
			e.preventDefault();
		});
		speedPostPassBookGrid.onSort.subscribe(function(e, args) {
			sortdir1 = args.sortAsc;
			sortcol1 = args.sortCol.field;
			if ($.browser.msie && $.browser.version <= 8) {
				// using temporary Object.prototype.toString override
				// more limited and does lexicographic sort only by default, but can be much faster
				var percentCompleteValueFn = function() {
					var val = this["percentComplete"];
					if (val < 10) {
						return "00" + val;
					} else if (val < 100) {
						return "0" + val;
					} else {
						return val;
					}
				};
				// use numeric sort of % and lexicographic for everything else
				speedPostPassBookDataView.fastSort((sortcol1 === "percentComplete") ? percentCompleteValueFn : sortcol1, sortdir1);
			} else {
				// using native sort with comparer
				// preferred method but can be very slow in IE with huge datasets
				speedPostPassBookDataView.sort(comparer, sortdir1);
			}
		});
		// wire up model events to drive the grid
		speedPostPassBookDataView.onRowCountChanged.subscribe(function(e, args) {
			speedPostPassBookGrid.updateRowCount();
			speedPostPassBookGrid.render();
		});
		speedPostPassBookDataView.onRowsChanged.subscribe(function(e, args) {
			speedPostPassBookGrid.invalidateRows(args.rows);
			speedPostPassBookGrid.render();
		});
		speedPostPassBookDataView.onPagingInfoChanged.subscribe(function(e, pagingInfo) {
			var isLastPage = pagingInfo.pageNum === pagingInfo.totalPages - 1;
			var enableAddRow = isLastPage || pagingInfo.pageSize === 0;
			var options = speedPostPassBookGrid.getOptions();
			if (options.enableAddRow !== enableAddRow) {
				speedPostPassBookGrid.setOptions({ enableAddRow: enableAddRow });
			}
		});
		/*
				// wire up the slider to apply the filter to the model
				$("#pcSlider,#pcSlider2").slider({
					"range": "min",
					"slide": function(event, ui) {
						Slick.GlobalEditorLock.cancelCurrentEdit();
						if (percentCompleteThreshold != ui.value) {
							window.clearTimeout(h_runfilters);
							h_runfilters = window.setTimeout(updateFilter, 10);
							percentCompleteThreshold = ui.value;
						}
					}
				});
				// wire up the search textbox to apply the filter to the model
				$("#txtSearch,#txtSearch2").keyup(function(e) {
					Slick.GlobalEditorLock.cancelCurrentEdit();
					// clear on Esc
					if (e.which == 27) {
						this.value = "";
					}
					searchString = this.value;
					updateFilter();
				});
		*/
		$("#btnSelectRows").click(function() {
			if (!Slick.GlobalEditorLock.commitCurrentEdit()) {
				return;
			}
			var rows = [];
			for (var i = 0; i < 10 && i < speedPostPassBookDataView.getLength(); i++) {
				rows.push(i);
			}
			speedPostPassBookGrid.setSelectedRows(rows);
		});
		// initialize the model after all the events have been hooked up
		speedPostPassBookGrid.init();
		speedPostPassBookDataView.beginUpdate();
		speedPostPassBookDataView.setItems(data1);
		/*
		dataView.setFilterArgs({
			percentCompleteThreshold: percentCompleteThreshold,
			searchString: searchString
		});
		*/
		speedPostPassBookDataView.setFilter(filter);
		speedPostPassBookDataView.endUpdate();
		// if you don't want the items that are not visible (due to being filtered out
		// or being on a different page) to stay selected, pass 'false' to the second arg
		speedPostPassBookDataView.syncGridSelection(speedPostPassBookGrid, true);
		//$("#gridContainer").resizable();
	})
}


