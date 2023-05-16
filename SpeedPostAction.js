function speedPostAction() {

	var speedPostDataView;
	var speedPostGrid;

	var speedPostData = document.getElementById("speedAction").value

	/*<![CDATA[*/
	//var data = /*[[${registeredPaymentList}]]*/'Emp';//

	console.log(speedPostData);


	var data1 = JSON.parse(speedPostData);
	var trackingNoList = [];
	for (var i = 0; i < data1.length; i++) {
		trackingNoList.push(data1[i]['trackNo']);
		console.log(data1[i]['trackNo']);

	}
	console.log(trackingNoList);

	var speedPostId = 1;
	data1.forEach(function(item) {
		// Generate a unique id using the nextId value
		var itemId = "item_" + speedPostId;

		// Set the id property of the item object
		item.id = itemId;

		// Increment the nextId value
		speedPostId++;
	});
	// Use the updated items array list with unique ids
	/* unique id end */
	var columnFilters = {};

	function checkboxFormatter(row, cell, value, columnDef, dataContext) {
		let a = dataContext.trackNo;
		return '<input type="checkbox" value="' + a + '" name="checkName" id="checkBox"' + (value ? 'checked="checked"' : '') + '/>';
	}
	function speedPostActionDateFormatFunction(row, cell, value, columnDef, dataContext) {
		const date = new Date(value);
		var getDay = date.toLocaleString("default", { day: "2-digit" });
		var getMonth = date.toLocaleString("default", { month: "2-digit" });
		var getYear = date.toLocaleString("default", { year: "numeric" }); // Set the desired date format
		return getDay + "-" + getMonth + "-" + getYear;// Format the date as a string
	}

	//var check= document.getElementById("checkBox");
	var check = document.querySelectorAll('input[type="checkbox"]:checked');
	console.log(check);

	var columns4 = [{
		id: "Select",

		name: "Select",

        formatter: checkboxFormatter,
		field: "Select",

		width: 35
	}, {
		id: "senderName",

       field: "senderName",
		name: "Sender Name",

		sortable: true,
		width: 125
	}, {
		id: "senderMobileNo",

		name: "Sender Mobile No",

        sortable: true,

		field: "senderMobileNo",
		width: 130
	}, {
		id: "senderUserAddress",

         width: 150,

		name: "Sender Address",

		field: "senderUserAddress",
		sortable: true
		}, {
		sortable: true,
		id: "kms",

		name: "Kilometers",

		field: "kms",
		width: 60
	}, {
		id: "receiveUserName",

		name: "Receiver Name",
		sortable: true,

		field: "receiveUserName",
		width: 125
	}, {
		id: "receiveUserMobileNo",

		name: "Receiver Mobile No",

		field: "receiveUserMobileNo",
		width: 130,
		sortable: true,
	}, {
		width: 170,
		id: "receiverUserAddress",

		name: "Receiver Address",

		field: "receiverUserAddress",
		sortable: true,
	}, {
		id: "parcelDate",

		name: "Parcel Booking date",

		field: "parcelDate",
		sortable: true,
		width: 120,

		formatter: speedPostActionDateFormatFunction
	}, {
		id: "trackNo",

		name: "Tracking No",

		field: "trackNo",
		sortable: true,
		width: 100
	}, {
		id: "parcel_status",
		name: "Parcel Status",
		field: "parcel_status",
		sortable: true,
		width: 110
	}, {
		id: "parcelCharge",
		name: "Parcel Charge",
		field: "parcelCharge",
		sortable: true,
		width: 110
	}];
	var speedPostOptions = {
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
	var sortcol2 = "title";
	var sortdir2 = 1;
	function comparer(a, b) {
		var x = a[sortcol2], y = b[sortcol2];
		return (x === y ? 0 : (x > y ? 1 : -1));
	}
	$(function() {
		/* filter start */
		function filter(item) {
			for (var columnId in columnFilters) {
				if (columnId !== undefined && columnFilters[columnId] !== "") {
					var column = speedPostGrid.getColumns()[speedPostGrid.getColumnIndex(columnId)];
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
		speedPostDataView = new Slick.Data.DataView();
		speedPostGrid = new Slick.Grid("#myGrid4", speedPostDataView, columns4, speedPostOptions);
		speedPostGrid.setSelectionModel(new Slick.RowSelectionModel());
		// header row start
		speedPostDataView.onRowCountChanged.subscribe(function(e, args) {
			speedPostGrid.updateRowCount();
			speedPostGrid.render();
		});
		speedPostDataView.onRowsChanged.subscribe(function(e, args) {
			speedPostGrid.invalidateRows(args.rows);
			speedPostGrid.render();
		});
		$(speedPostGrid.getHeaderRow()).delegate(":input", "change keyup",
			function(e) {
				var columnId = $(this).data("columnId");
				if (columnId !== null) {
					columnFilters[columnId] = $.trim($(this).val());
					speedPostDataView.refresh();
				}
			});
		speedPostGrid.onHeaderRowCellRendered.subscribe(function(e, args) {
			$(args.node).empty();
			$("<input type='text'>").data("columnId", args.column.id).val(
				columnFilters[args.column.id]).appendTo(args.node);
		});
		// header row end
		// move the filter panel defined in a hidden div into grid top panel
		$("#inlineFilterPanel")
			.appendTo(speedPostGrid.getTopPanel())
			.show();
		speedPostGrid.onCellChange.subscribe(function(e, args) {
			speedPostDataView.updateItem(args.item.id, args.item);
		});
		speedPostGrid.onKeyDown.subscribe(function(e) {
			// select all rows on ctrl-a
			if (e.which !== 65 || !e.ctrlKey) {
				return false;
			}
			var rows = [];
			for (var i = 0; i < speedPostDataView.getLength(); i++) {
				rows.push(i);
			}
			speedPostGrid.setSelectedRows(rows);
			e.preventDefault();
		});
		speedPostGrid.onSort.subscribe(function(e, args) {
			sortdir2 = args.sortAsc;
			sortcol2 = args.sortCol.field;
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
				speedPostDataView.fastSort((sortcol2 === "percentComplete") ? percentCompleteValueFn : sortcol2, sortdir2);
			} else {
				// using native sort with comparer
				// preferred method but can be very slow in IE with huge datasets
				speedPostDataView.sort(comparer, sortdir2);
			}
		});
		// wire up model events to drive the grid
		speedPostDataView.onRowCountChanged.subscribe(function(e, args) {
			speedPostGrid.updateRowCount();
			speedPostGrid.render();
		});
		speedPostDataView.onRowsChanged.subscribe(function(e, args) {
			speedPostGrid.invalidateRows(args.rows);
			speedPostGrid.render();
		});
		speedPostDataView.onPagingInfoChanged.subscribe(function(e, pagingInfo) {
			var isLastPage = pagingInfo.pageNum === pagingInfo.totalPages - 1;
			var enableAddRow = isLastPage || pagingInfo.pageSize === 0;
			var options = speedPostGrid.getOptions();
			if (options.enableAddRow !== enableAddRow) {
				speedPostGrid.setOptions({ enableAddRow: enableAddRow });
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
			for (var i = 0; i < 10 && i < speedPostDataView.getLength(); i++) {
				rows.push(i);
			}
			speedPostGrid.setSelectedRows(rows);
		});
		// initialize the model after all the events have been hooked up
		speedPostGrid.init();
		speedPostDataView.beginUpdate();
		speedPostDataView.setItems(data1);
		/*
		dataView.setFilterArgs({
			percentCompleteThreshold: percentCompleteThreshold,
			searchString: searchString
		});
		*/
		speedPostDataView.setFilter(filter);
		speedPostDataView.endUpdate();
		// if you don't want the items that are not visible (due to being filtered out
		// or being on a different page) to stay selected, pass 'false' to the second arg
		speedPostDataView.syncGridSelection(speedPostGrid, true);
		//$("#gridContainer").resizable();
	})
}
