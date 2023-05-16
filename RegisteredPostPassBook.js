function registeredPostPassBook() {

	var registeredPostPassBookDataView;

	var registeredPostPassBookGrid;

	var registeredPostPassBookData = document.getElementById("registeredPostPassBook").value;

	var data1 = JSON.parse(registeredPostPassBookData);
	console.log(registeredPostPassBookData);

	/* set unique it to array */

	var registeredPostPassBookId = 1;

	data1.forEach(function(item) {

		// Generate a unique id using the nextId value

		var itemId = "item_" + registeredPostPassBookId;

		// Set the id property of the item object

		item.id = itemId;

		// Increment the nextId value

		registeredPostPassBookId++;

	});

	// Use the updated items array list with unique ids

	console.log(registeredPostPassBookData);

	/* unique id end */
	function registeredPostPassBookDateFormatter(row, cell, value, columnDef, dataContext) {
		const date = new Date(value);
		var getDay = date.toLocaleString("default", { day: "2-digit" });
		var getMonth = date.toLocaleString("default", { month: "2-digit" });
		var getYear = date.toLocaleString("default", { year: "numeric" }); // Set the desired date format
		return getDay + "-" + getMonth + "-" + getYear;// Format the date as a string
	}

	var columnFilters = {};

	var columns = [{
		id: "sender_name",

		name: "Sender Name",

		field: "sender_name",

		width: 125

	}, {

		id: "sender_mobile_no",

		name: "Sender Mobile No",

		field: "sender_mobile_no",

		width: 130

	}, {

		id: "sender_address",

		name: "Sender Address",

		field: "sender_address",

		width: 140

	}, {
		id: "parcel_weight",

		name: "Parcel Weight",

		field: "parcel_weight",

		width: 60

	}, {

		id: "receiver_name",

		name: "Receiver Name",

		field: "receiver_name",

		width: 135

	}, {

		id: "receiver_mobile_no",

		name: "Receiver Mobile No",

		field: "receiver_mobile_no",

		width: 140

	}, {
		id: "receiver_address",

		name: "Receiver Address",

		field: "receiver_address",

		width: 140

	}, {

		id: "booking_date",

		name: "Booking Date",

		field: "booking_date",
		formatter: registeredPostPassBookDateFormatter,

		width: 130,
	}, {

		id: "tracking_no",

		name: "Tracking No",

		field: "tracking_no",

		width: 100
	}, {
		id: "parcelCharge",
		name: "Parcel Charge",
		field: "parcelCharge",
		width: 100
	}];

	var registeredPostPassBookOptions = {
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
	var sortcol = "title";
	var sortdir = 1;
	function comparer(a, b) {
		var x = a[sortcol], y = b[sortcol];
		return (x === y ? 0 : (x > y ? 1 : -1));
	}
	$(function() {
		/* filter start */
		function filter(item) {
			for (var columnId in columnFilters) {
				if (columnId !== undefined && columnFilters[columnId] !== "") {
					var column = registeredPostPassBookGrid.getColumns()[registeredPostPassBookGrid.getColumnIndex(columnId)];
					if (item[column.field] !== undefined) {
						var filterResult = typeof item[column.field].indexOf === 'function'
							? (item[column.field].indexOf(columnFilters[columnId]) === -1)
							: (item[column.field] !== columnFilters[columnId]);
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
		registeredPostPassBookDataView = new Slick.Data.DataView();
		registeredPostPassBookGrid = new Slick.Grid("#myGrid1", registeredPostPassBookDataView, columns, registeredPostPassBookOptions);
		registeredPostPassBookGrid.setSelectionModel(new Slick.RowSelectionModel());
		// header row start
		registeredPostPassBookDataView.onRowCountChanged.subscribe(function(e, args) {
			registeredPostPassBookGrid.updateRowCount();
			registeredPostPassBookGrid.render();
		});
		registeredPostPassBookDataView.onRowsChanged.subscribe(function(e, args) {
			registeredPostPassBookGrid.invalidateRows(args.rows);
			registeredPostPassBookGrid.render();
		});
		$(registeredPostPassBookGrid.getHeaderRow()).delegate(":input", "change keyup",
			function(e) {
				var columnId = $(this).data("columnId");
				if (columnId !== null) {
					columnFilters[columnId] = $.trim($(this).val());
					registeredPostPassBookDataView.refresh();
				}
			});
		registeredPostPassBookGrid.onHeaderRowCellRendered.subscribe(function(e, args) {
			$(args.node).empty();
			$("<input type='text'>").data("columnId", args.column.id).val(
				columnFilters[args.column.id]).appendTo(args.node);
		});
		// header row end
		// move the filter panel defined in a hidden div into grid top panel
		$("#inlineFilterPanel")
			.appendTo(registeredPostPassBookGrid.getTopPanel())
			.show();
		registeredPostPassBookGrid.onCellChange.subscribe(function(e, args) {
			registeredPostPassBookDataView.updateItem(args.item.id, args.item);
		});
		registeredPostPassBookGrid.onKeyDown.subscribe(function(e) {
			// select all rows on ctrl-a
			if (e.which !== 65 || !e.ctrlKey) {
				return false;
			}
			var rows = [];
			for (var i = 0; i < registeredPostPassBookDataView.getLength(); i++) {
				rows.push(i);
			}
			registeredPostPassBookGrid.setSelectedRows(rows);
			e.preventDefault();
		});
		registeredPostPassBookGrid.onSort.subscribe(function(e, args) {
			sortdir = args.sortAsc;
			sortcol = args.sortCol.field;
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
				registeredPostPassBookDataView.fastSort((sortcol === "percentComplete") ? percentCompleteValueFn : sortcol, sortdir);
			} else {
				// using native sort with comparer
				// preferred method but can be very slow in IE with huge datasets
				registeredPostPassBookDataView.sort(comparer, sortdir);
			}
		});
		// wire up model events to drive the grid
		registeredPostPassBookDataView.onRowCountChanged.subscribe(function(e, args) {
			registeredPostPassBookGrid.updateRowCount();
			registeredPostPassBookGrid.render();
		});
		registeredPostPassBookDataView.onRowsChanged.subscribe(function(e, args) {
			registeredPostPassBookGrid.invalidateRows(args.rows);
			registeredPostPassBookGrid.render();
		});
		registeredPostPassBookDataView.onPagingInfoChanged.subscribe(function(e, pagingInfo) {
			var isLastPage = pagingInfo.pageNum === pagingInfo.totalPages - 1;
			var enableAddRow = isLastPage || pagingInfo.pageSize === 0;
			var options = registeredPostPassBookGrid.getOptions();
			if (options.enableAddRow !== enableAddRow) {
				registeredPostPassBookGrid.setOptions({ enableAddRow: enableAddRow });
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
			for (var i = 0; i < 10 && i < registeredPostPassBookDataView.getLength(); i++) {
				rows.push(i);
			}
			registeredPostPassBookGrid.setSelectedRows(rows);
		});
		// initialize the model after all the events have been hooked up
		registeredPostPassBookGrid.init();
		registeredPostPassBookDataView.beginUpdate();
		registeredPostPassBookDataView.setItems(data1);
		/*
		dataView.setFilterArgs({
			percentCompleteThreshold: percentCompleteThreshold,
			searchString: searchString
		});
		*/
		registeredPostPassBookDataView.setFilter(filter);
		registeredPostPassBookDataView.endUpdate();
		// if you don't want the items that are not visible (due to being filtered out
		// or being on a different page) to stay selected, pass 'false' to the second arg
		registeredPostPassBookDataView.syncGridSelection(registeredPostPassBookGrid, true);
		//$("#gridContainer").resizable();
	})
}

