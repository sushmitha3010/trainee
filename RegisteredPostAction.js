function registeredPostAction() {

	var registeredPostDataView;
	var registeredPostGrid;

	var registeredPostData = document.getElementById("regAction").value

	/*<![CDATA[*/
	//var data = /*[[${registeredPaymentList}]]*/'Emp';//

	console.log(registeredPostData);


	var data1 = JSON.parse(registeredPostData);
	var trackingNoList = [];
	for (var i = 0; i < data1.length; i++) {
		trackingNoList.push(data1[i]['trackNo']);
		console.log(data1[i]['trackNo']);

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

	var columnFilters = {};

	function checkboxFormatter(row, cell, value, columnDef, dataContext) {
		let a = dataContext.trackNo;
		return '<input type="checkbox" value="' + a + '" name="checkName" id="checkBox"' + (value ? 'checked="checked"' : '') + '/>';
	}
	function registeredPostDateFormatter(row, cell, value, columnDef, dataContext) {
		const date = new Date(value);
		var getDay1 = date.toLocaleString("default", { day: "2-digit" });
		var getMonth1 = date.toLocaleString("default", { month: "2-digit" });
		var getYear1 = date.toLocaleString("default", { year: "numeric" }); // Set the desired date format
		return getDay1 + "-" + getMonth1 + "-" + getYear1;// Format the date as a string
	}

	//var check= document.getElementById("checkBox");
	var checkBox = document.querySelectorAll('input[type="checkbox"]:checked');
	console.log(checkBox);
	var columns3 = [{

		name: "Select",
		id: "Select",

		field: "Select",

		formatter: checkboxFormatter,
		width : 35
	},{
			name : "Sender Name",
			id : "sender_name",

			field : "sender_name",
			sortable : true,
			width : 125
		}, {
			name : "Sender Mobile No",
			id : "sender_mobile_no",

			field : "sender_mobile_no",
			sortable : true,
			width : 130
		}, {
			name : "Sender Address",
			id : "sender_address",

			field : "sender_address",
			sortable : true,
			width : 150
		}, {
			name : "Parcel Weight",
			id : "parcel_weight",

			field : "parcel_weight",
			sortable : true,
			width : 60
		}, {
			name : "Receiver Name",
			id : "receiver_name",

			field : "receiver_name",
			sortable : true,
			width : 125
		}, {
			name : "Receiver Mobile No",
			id : "receiver_mobile_no",

			field : "receiver_mobile_no",
			sortable : true,
			width : 130
		}, {
			name : "Receiver Address",
			id : "receiver_address",

			field : "receiver_address",
			sortable : true,
			width : 150
		}, {
			id : "parcelDate",

			name : "Parcel Booking date",

			field : "parcelDate",
			sortable : true,
			width : 120,
			formatter : registeredPostDateFormatter
		}, {
			id : "trackNo",

			name : "Tracking No",

			field : "trackNo",
			sortable : true,
			width : 100
		}, {
			id : "parcelStatus",

			name : "Parcel Status",

			field : "parcelStatus",
			sortable : true,
			width : 130
			}, {
			id : "chargeBalance",

			name : "Parcel Charge",

			field : "chargeBalance",
			sortable : true,
			width : 130
		} ];
var registeredPostOptions = {
        editable: true,
        enableAddRow:false,
        enableCellNavigation: true,
        asyncEditorLoading: true,
        forceFitColumns: false,
        showHeaderRow: true,
        headerRowHeight: 30,
        explicitInitialization: true,
        topPanelHeight: 25,
        rowHeight : 40,
        suppressCssChangesOnHiddenInit: true
    };
    var sortcol3 = "title";
    var sortdir4 = 1;
    function comparer(a, b) {
        var x = a[sortcol3], y = b[sortcol3];
        return (x === y ? 0 : (x > y ? 1 : -1));
     }
    $(function() {
        /* filter start */
        function filter(item) {
            for (var columnId in columnFilters) {
                if (columnId !== undefined && columnFilters[columnId] !== "") {
                    var column = registeredPostGrid.getColumns()[registeredPostGrid.getColumnIndex(columnId)];
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
        registeredPostDataView = new Slick.Data.DataView();
        registeredPostGrid = new Slick.Grid("#myGrid2", registeredPostDataView, columns3, registeredPostOptions);
        registeredPostGrid.setSelectionModel(new Slick.RowSelectionModel());
        // header row start
        registeredPostDataView.onRowCountChanged.subscribe(function(e, args) {
            registeredPostGrid.updateRowCount();
            registeredPostGrid.render();
        });
        registeredPostDataView.onRowsChanged.subscribe(function(e, args) {
            registeredPostGrid.invalidateRows(args.rows);
            registeredPostGrid.render();
        });
        $(registeredPostGrid.getHeaderRow()).delegate(":input", "change keyup",
            function(e) {
                var columnId = $(this).data("columnId");
                if (columnId !== null) {
                    columnFilters[columnId] = $.trim($(this).val());
                    registeredPostDataView.refresh();
                }
            });
registeredPostGrid.onHeaderRowCellRendered.subscribe(function(e, args) {
            $(args.node).empty();
            $("<input type='text'>").data("columnId", args.column.id).val(
                columnFilters[args.column.id]).appendTo(args.node);
        });
        // header row end
        // move the filter panel defined in a hidden div into grid top panel
        $("#inlineFilterPanel")
            .appendTo(registeredPostGrid.getTopPanel())
            .show();
        registeredPostGrid.onCellChange.subscribe(function(e, args) {
            registeredPostDataView.updateItem(args.item.id, args.item);
        });
        registeredPostGrid.onKeyDown.subscribe(function(e) {
            // select all rows on ctrl-a
            if (e.which !== 65 || !e.ctrlKey) {
                return false;
            }
            var rows = [];
            for (var i = 0; i < registeredPostDataView.getLength(); i++) {
                rows.push(i);
            }
            registeredPostGrid.setSelectedRows(rows);
            e.preventDefault();
        });
        registeredPostGrid.onSort.subscribe(function(e, args) {
            sortdir4 = args.sortAsc;
            sortcol3 = args.sortCol.field;
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
                registeredPostDataView.fastSort((sortcol3 === "percentComplete") ? percentCompleteValueFn : sortcol3, sortdir4);
            } else {
                // using native sort with comparer
                // preferred method but can be very slow in IE with huge datasets
                registeredPostDataView.sort(comparer, sortdir4);
            }
        });
// wire up model events to drive the grid
        registeredPostDataView.onRowCountChanged.subscribe(function(e, args) {
            registeredPostGrid.updateRowCount();
            registeredPostGrid.render();
        });
        registeredPostDataView.onRowsChanged.subscribe(function(e, args) {
            registeredPostGrid.invalidateRows(args.rows);
            registeredPostGrid.render();
        });
        registeredPostDataView.onPagingInfoChanged.subscribe(function(e, pagingInfo) {
            var isLastPage = pagingInfo.pageNum === pagingInfo.totalPages - 1;
            var enableAddRow = isLastPage || pagingInfo.pageSize === 0;
            var options = registeredPostGrid.getOptions();
            if (options.enableAddRow !== enableAddRow) {
                registeredPostGrid.setOptions({ enableAddRow: enableAddRow });
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
            for (var i = 0; i < 10 && i < registeredPostDataView.getLength(); i++) {
                rows.push(i);
            }
            registeredPostGrid.setSelectedRows(rows);
        });
        // initialize the model after all the events have been hooked up
        registeredPostGrid.init();
        registeredPostDataView.beginUpdate();
        registeredPostDataView.setItems(data1);
        /*
        dataView.setFilterArgs({
            percentCompleteThreshold: percentCompleteThreshold,
            searchString: searchString
        });
        */
        registeredPostDataView.setFilter(filter);
        registeredPostDataView.endUpdate();
        // if you don't want the items that are not visible (due to being filtered out
        // or being on a different page) to stay selected, pass 'false' to the second arg
        registeredPostDataView.syncGridSelection(registeredPostGrid, true);
        //$("#gridContainer").resizable();
    })
}
