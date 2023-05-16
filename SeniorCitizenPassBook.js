function seniorCitizenDepositPassBook() {

	var dataViews;

	var passBookGrid;

	var seniorCitizenData = document.getElementById("seniorCitizenPassBook").value;

	var data1 = JSON.parse(seniorCitizenData);
	console.log(seniorCitizenData);

	/* set unique it to array */

	var seniorCitizenId = 1;

	data1.forEach(function(item) {

		// Generate a unique id using the nextId value

		var itemId = "item_" + seniorCitizenId;

		// Set the id property of the item object

		item.id = itemId;

		// Increment the nextId value

		seniorCitizenId++;

	});

	// Use the updated items array list with unique ids

	console.log(seniorCitizenData);

	/* unique id end */
	function seniorCitizenDateFormatter(row, cell, value, columnDef, dataContext) {
		const date = new Date(value);
		var getDay = date.toLocaleString("default", { day: "2-digit" });
		var getMonth = date.toLocaleString("default", { month: "2-digit" });
		var getYear = date.toLocaleString("default", { year: "numeric" }); // Set the desired date format
		return getDay + "-" + getMonth + "-" + getYear;// Format the date as a string
	}



	var seniorCitizenPassBookColumnFilters = {};

	var columns2 = [{
        field: "accountHolderName",

		id: "accountHolderName",

		name: "User Name",

		width: 150

	}, {
		field: "mobNumber",

		id: "mobNumber",

		name: "Mobile Number",

		width: 140

	}, {
        field: "accountNum",

		id: "accountNum",

		name: "Account Number",

		width: 150

	}, {
		field: "money",
		id: "money",

		name: "Amount",

		width: 90

	}, {
        field: "age",

		id: "age",

		name: "Age",

		width: 60

	}, {
		field: "amountPaymentDate",

		id: "amountPaymentDate",

		name: "Deposit Date",

		formatter: seniorCitizenDateFormatter,

		width: 140
	}, {
        field: "amountReDate",

		id: "amountreDate",

		name: "Return Date",
		formatter: seniorCitizenDateFormatter,
		width: 130
	}, {
		id: "interestAmount",

		name: "Simple Interest",

		field: "interestAmount",

		width: 130

	}, {

		id: "maturity_amount",

		name: "Maturity Amount",

		field: "maturity_amount",

		width: 120

	}, {

		id: "total_amount",

		name: "Total Amount",

		field: "total_amount",

		width: 120,
	},];




	var seniorCitizenPassBookOptions = {
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
	var sortcol9 = "title";
	var sortdir9 = 1;
	function comparer(a, b) {
		var x = a[sortcol9], y = b[sortcol9];
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
			for (var columnId in seniorCitizenPassBookColumnFilters) {
				if (columnId !== undefined && seniorCitizenPassBookColumnFilters[columnId] !== "") {
					var column = passBookGrid.getColumns()[passBookGrid.getColumnIndex(columnId)];
					if (item[column.field] !== undefined) {
						var filterResult = typeof item[column.field].indexOf === 'function'
							? (item[column.field].indexOf(seniorCitizenPassBookColumnFilters[columnId]) === -1)
							: (item[column.field] !== seniorCitizenPassBookColumnFilters[columnId]);
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
		dataViews = new Slick.Data.DataView();
		passBookGrid = new Slick.Grid("#myGrid2", dataViews, columns2, seniorCitizenPassBookOptions);
		passBookGrid.setSelectionModel(new Slick.RowSelectionModel());
		// header row start
		dataViews.onRowCountChanged.subscribe(function(e, args) {
			passBookGrid.updateRowCount();
			passBookGrid.render();
		});
		dataViews.onRowsChanged.subscribe(function(e, args) {
			passBookGrid.invalidateRows(args.rows);
			passBookGrid.render();
		});
		$(passBookGrid.getHeaderRow()).delegate(":input", "change keyup",
			function(e) {
				var columnId = $(this).data("columnId");
				if (columnId !== null) {
					seniorCitizenPassBookColumnFilters[columnId] = $.trim($(this).val());
					dataViews.refresh();
				}
			});
		passBookGrid.onHeaderRowCellRendered.subscribe(function(e, args) {
			$(args.node).empty();
			$("<input type='text'>").data("columnId", args.column.id).val(
				seniorCitizenPassBookColumnFilters[args.column.id]).appendTo(args.node);
		});
		// header row end
		// move the filter panel defined in a hidden div into grid top panel
		$("#inlineFilterPanel")
			.appendTo(passBookGrid.getTopPanel())
			.show();
		passBookGrid.onCellChange.subscribe(function(e, args) {
			dataViews.updateItem(args.item.id, args.item);
		});
		passBookGrid.onKeyDown.subscribe(function(e) {
			// select all rows on ctrl-a
			if (e.which !== 65 || !e.ctrlKey) {
				return false;
			}
			var rows = [];
			for (var i = 0; i < dataViews.getLength(); i++) {
				rows.push(i);
			}
			passBookGrid.setSelectedRows(rows);
			e.preventDefault();
		});
		passBookGrid.onSort.subscribe(function(e, args) {
			sortdir9 = args.sortAsc;
			sortcol9 = args.sortCol.field;
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
				dataViews.fastSort((sortcol9 === "percentComplete") ? percentCompleteValueFn : sortcol9, sortdir9);
			} else {
				// using native sort with comparer
				// preferred method but can be very slow in IE with huge datasets
				dataViews.sort(comparer, sortdir9);
			}
		});
		// wire up model events to drive the grid
		dataViews.onRowCountChanged.subscribe(function(e, args) {
			passBookGrid.updateRowCount();
			passBookGrid.render();
		});
		dataViews.onRowsChanged.subscribe(function(e, args) {
			passBookGrid.invalidateRows(args.rows);
			passBookGrid.render();
		});
		dataViews.onPagingInfoChanged.subscribe(function(e, pagingInfo) {
			var isLastPage = pagingInfo.pageNum === pagingInfo.totalPages - 1;
			var enableAddRow = isLastPage || pagingInfo.pageSize === 0;
			var options = passBookGrid.getOptions();
			if (options.enableAddRow !== enableAddRow) {
				passBookGrid.setOptions({ enableAddRow: enableAddRow });
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
			for (var i = 0; i < 10 && i < dataViews.getLength(); i++) {
				rows.push(i);
			}
			passBookGrid.setSelectedRows(rows);
		});
		// initialize the model after all the events have been hooked up
		passBookGrid.init();
		dataViews.beginUpdate();
		dataViews.setItems(data1);
		/*
		dataView.setFilterArgs({
			percentCompleteThreshold: percentCompleteThreshold,
			searchString: searchString
		});
		*/
		dataViews.setFilter(filter);
		dataViews.endUpdate();
		// if you don't want the items that are not visible (due to being filtered out
		// or being on a different page) to stay selected, pass 'false' to the second arg
		dataViews.syncGridSelection(passBookGrid, true);
		//$("#gridContainer").resizable();
	})
}

