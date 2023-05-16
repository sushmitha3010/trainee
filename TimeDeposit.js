function timeDeposit (){

var timeDepositDataView;

var timeDepositGrid;
	var timeDepositData = document.getElementById("time").value
	console.log(timeDepositData);


	var data1 = JSON.parse(timeDepositData);


/*<![CDATA[*/

/*]]>*/

console.log(timeDepositData);

/* set unique it to array */

var timeDepositId = 1;

data1.forEach(function(item) {

// Generate a unique id using the nextId value

var itemId = "item_" + timeDepositId;

// Set the id property of the item object

item.id = itemId;

// Increment the nextId value

timeDepositId++;

});

// Use the updated items array list with unique ids

console.log(timeDepositData);

/* unique id end */
function timeDepositDateFormatter(row, cell, value, columnDef, dataContext) {
		const date = new Date(value);
		var getDay2 = date.toLocaleString("default", { day: "2-digit" });
		var getMonth2 = date.toLocaleString("default", { month: "2-digit" });
		var getYear2 = date.toLocaleString("default", { year: "numeric" }); // Set the desired date format
		return getDay2 + "-" + getMonth2 + "-" + getYear2;// Format the date as a string
	}

var columnFilters = {};

var columns = [ {

id : "depositUserName",

name : "User Name",

field : "depositUserName",

sortable : true,

width : 150

}, {

id : "phoneNo",

name : "Mobile Number",

field : "phoneNo",

sortable : true,

width : 130

}, {

id : "acctNumber",

name : "Account Number",

field : "acctNumber",

sortable : true,

width : 150

},{

id : "initialAmount",

name : "Amount",

field : "initialAmount",

sortable : true,

width : 90

}, {
	id : "periods",

	name : "Periods",

	field : "periods",

    sortable : true,
	width : 80
},{
	id : "paymentDate",

	name : "Deposit Date",

	field : "paymentDate",
	sortable : true,

	width : 130,
	formatter : timeDepositDateFormatter
},{
	id : "return_date",

	name : "Return Date",

	field : "return_date",
	sortable : true,

	width : 120,
	formatter : timeDepositDateFormatter
	},{

	id : "simple_interest",

	name : "Simple Interest",

	field : "simple_interest",
	sortable : true,

	width : 130

	}, {
		id : "amountMaturity",

		name : "Maturity Amount",

		field : "amountMaturity",
		sortable : true,

		width : 140
	},{
		id : "totalPayment",

		name : "Total Amount",

		field : "totalPayment",
		sortable : true,

		width : 130,
		}, ]
var timeDepositOptions = {
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
    var sortcol5 = "title";
    function comparer(a, b) {
        var x = a[sortcol5], y = b[sortcol5];
        return (x === y ? 0 : (x > y ? 1 : -1));
    }
$(function() {
        /* filter start */
        function filter(item) {
            for (var columnId in columnFilters) {
                if (columnId !== undefined && columnFilters[columnId] !== "") {
                    var column = timeDepositGrid.getColumns()[timeDepositGrid.getColumnIndex(columnId)];
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
        timeDepositDataView = new Slick.Data.DataView();
        timeDepositGrid = new Slick.Grid("#myGrid5", timeDepositDataView, columns, timeDepositOptions);
        timeDepositGrid.setSelectionModel(new Slick.RowSelectionModel());
        // header row start
        timeDepositDataView.onRowCountChanged.subscribe(function(e, args) {
            timeDepositGrid.updateRowCount();
            timeDepositGrid.render();
        });
        timeDepositDataView.onRowsChanged.subscribe(function(e, args) {
            timeDepositGrid.invalidateRows(args.rows);
            timeDepositGrid.render();
        });
        $(timeDepositGrid.getHeaderRow()).delegate(":input", "change keyup",
            function(e) {
                var columnId = $(this).data("columnId");
                if (columnId != null) {
                    columnFilters[columnId] = $.trim($(this).val());
                    timeDepositDataView.refresh();
                }
            });
timeDepositGrid.onHeaderRowCellRendered.subscribe(function(e, args) {
            $(args.node).empty();
            $("<input type='text'>").data("columnId", args.column.id).val(
                columnFilters[args.column.id]).appendTo(args.node);
        });
        // header row end
        // move the filter panel defined in a hidden div into grid top panel
        $("#inlineFilterPanel")
            .appendTo(timeDepositGrid.getTopPanel())
            .show();
        timeDepositGrid.onCellChange.subscribe(function(e, args) {
            timeDepositDataView.updateItem(args.item.id, args.item);
        });
        timeDepositGrid.onKeyDown.subscribe(function(e) {
            // select all rows on ctrl-a
            if (e.which !== 65 || !e.ctrlKey) {
                return false;
            }
            var rows = [];
            for (var i = 0; i < timeDepositDataView.getLength(); i++) {
                rows.push(i);
            }
            timeDepositGrid.setSelectedRows(rows);
            e.preventDefault();
        });
        timeDepositGrid.onSort.subscribe(function(e, args) {
           var sortdir = args.sortAsc;
            sortcol5 = args.sortCol.field;
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
                timeDepositDataView.fastSort((sortcol5 === "percentComplete") ? percentCompleteValueFn : sortcol5, sortdir);
            } else {
                // using native sort with comparer
                // preferred method but can be very slow in IE with huge datasets
                timeDepositDataView.sort(comparer, sortdir);
            }
        });
// wire up model events to drive the grid
        timeDepositDataView.onRowCountChanged.subscribe(function(e, args) {
            timeDepositGrid.updateRowCount();
            timeDepositGrid.render();
        });
        timeDepositDataView.onRowsChanged.subscribe(function(e, args) {
            timeDepositGrid.invalidateRows(args.rows);
            timeDepositGrid.render();
        });
        timeDepositDataView.onPagingInfoChanged.subscribe(function(e, pagingInfo) {
            var isLastPage = pagingInfo.pageNum === pagingInfo.totalPages - 1;
            var enableAddRow = isLastPage || pagingInfo.pageSize === 0;
            var options = timeDepositGrid.getOptions();
            if (options.enableAddRow !== enableAddRow) {
                timeDepositGrid.setOptions({ enableAddRow: enableAddRow });
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
            for (var i = 0; i < 10 && i < timeDepositDataView.getLength(); i++) {
                rows.push(i);
            }
            timeDepositGrid.setSelectedRows(rows);
        });
        // initialize the model after all the events have been hooked up
        timeDepositGrid.init();
        timeDepositDataView.beginUpdate();
        timeDepositDataView.setItems(data1);
        /*
        dataView.setFilterArgs({
            percentCompleteThreshold: percentCompleteThreshold,
            searchString: searchString
        });
        */
        timeDepositDataView.setFilter(filter);
        timeDepositDataView.endUpdate();
        // if you don't want the items that are not visible (due to being filtered out
        // or being on a different page) to stay selected, pass 'false' to the second arg
        timeDepositDataView.syncGridSelection(timeDepositGrid, true);
        //$("#gridContainer").resizable();
    })
}


