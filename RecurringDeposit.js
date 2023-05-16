function recurringDeposit(){

var recurringDepositDataView;

var recurringDepositGrid;

	var recurringDepositData = document.getElementById("recur").value;

	var data1 = JSON.parse(recurringDepositData);
console.log(recurringDepositData);

/* set unique it to array */

var recurringDepositId = 1;

data1.forEach(function(item) {

// Generate a unique id using the nextId value

var itemId = "item_" + recurringDepositId;

// Set the id property of the item object

item.id = itemId;

// Increment the nextId value

recurringDepositId++;

});

// Use the updated items array list with unique ids

console.log(recurringDepositData);

/* unique id end */
function recurringDepositDateFormatter(row, cell, value, columnDef, dataContext) {
		const date = new Date(value);
		var getDay4 = date.toLocaleString("default", { day: "2-digit" });
		var getMonth4 = date.toLocaleString("default", { month: "2-digit" });
		var getYear4 = date.toLocaleString("default", { year: "numeric" }); // Set the desired date format
		return getDay4 + "-" + getMonth4 + "-" + getYear4;// Format the date as a string
	}



var columnFilters = {};

var columns = [ {

id : "customerName",

name : "User Name",

field : "customerName",

sortable : true,

width : 150
}, {
id : "contactNo",

name : "Mobile Number",

field : "contactNo",

sortable : true,

width : 150
}, {
id : "accountNumber",

name : "Account Number",

field : "accountNumber",

sortable : true,

width : 160
}, {
	id : "principleAmount",

	name : "Principle Amount",

	field : "principleAmount",
	sortable : true,

	width : 100
}, {
	id : "noOfMonths",

	name : "Number Of Months",

	field : "noOfMonths",
	sortable : true,

	width : 90
}, {
	id : "depositDate",

	name : "Deposit Date ",

	field : "depositDate",
    formatter : recurringDepositDateFormatter,
    sortable : true,
    	width : 140
}, {
	id : "depositReturnDate",

	name : "Return Date ",

	field : "depositReturnDate",
    formatter : recurringDepositDateFormatter,
    sortable : true,
	width : 140
}, {
	id : "InterestAmount",

	name : "Interest",

	field : "InterestAmount",
	sortable : true,

	width : 80
}, {
	id : "maturityAmount",

	name : "Maturity Amount",

	field : "maturityAmount",
	sortable : true,

	width : 120
}, {
	id : "amountTotal",

	name : "Total Amount",

	field : "amountTotal",
	sortable : true,

	width : 120
}, ]
var recurringDepositOptions = {
        editable: true,
        enableAddRow:false,
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
    var sortcol7 = "title";
    var sortdir7 = 1;
    function comparer(a, b) {
        var x = a[sortcol7], y = b[sortcol7];
        return (x === y ? 0 : (x > y ? 1 : -1));
    }
$(function() {
        /* filter start */
        function filter(item) {
            for (var columnId in columnFilters) {
                if (columnId !== undefined && columnFilters[columnId] !== "") {
                    var column = recurringDepositGrid.getColumns()[recurringDepositGrid.getColumnIndex(columnId)];
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
        recurringDepositDataView = new Slick.Data.DataView();
        recurringDepositGrid = new Slick.Grid("#myGrid1", recurringDepositDataView, columns, recurringDepositOptions);
        recurringDepositGrid.setSelectionModel(new Slick.RowSelectionModel());
        // header row start
        recurringDepositDataView.onRowCountChanged.subscribe(function(e, args) {
            recurringDepositGrid.updateRowCount();
            recurringDepositGrid.render();
        });
        recurringDepositDataView.onRowsChanged.subscribe(function(e, args) {
            recurringDepositGrid.invalidateRows(args.rows);
            recurringDepositGrid.render();
        });
        $(recurringDepositGrid.getHeaderRow()).delegate(":input", "change keyup",
            function(e) {
                var columnId = $(this).data("columnId");
                if (columnId !== null) {
                    columnFilters[columnId] = $.trim($(this).val());
                    recurringDepositDataView.refresh();
                }
            });
recurringDepositGrid.onHeaderRowCellRendered.subscribe(function(e, args) {
            $(args.node).empty();
            $("<input type='text'>").data("columnId", args.column.id).val(
                columnFilters[args.column.id]).appendTo(args.node);
        });
        // header row end
        // move the filter panel defined in a hidden div into grid top panel
        $("#inlineFilterPanel")
            .appendTo(recurringDepositGrid.getTopPanel())
            .show();
        recurringDepositGrid.onCellChange.subscribe(function(e, args) {
            recurringDepositDataView.updateItem(args.item.id, args.item);
        });
        recurringDepositGrid.onKeyDown.subscribe(function(e) {
            // select all rows on ctrl-a
            if (e.which !== 65 || !e.ctrlKey) {
                return false;
            }
            var rows = [];
            for (var i = 0; i < recurringDepositDataView.getLength(); i++) {
                rows.push(i);
            }
            recurringDepositGrid.setSelectedRows(rows);
            e.preventDefault();
        });
        recurringDepositGrid.onSort.subscribe(function(e, args) {
            sortdir7 = args.sortAsc;
            sortcol7 = args.sortCol.field;
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
                recurringDepositDataView.fastSort((sortcol7 === "percentComplete") ? percentCompleteValueFn : sortcol7, sortdir7);
            } else {
                // using native sort with comparer
                // preferred method but can be very slow in IE with huge datasets
                recurringDepositDataView.sort(comparer, sortdir7);
            }
        });
// wire up model events to drive the grid
        recurringDepositDataView.onRowCountChanged.subscribe(function(e, args) {
            recurringDepositGrid.updateRowCount();
            recurringDepositGrid.render();
        });
        recurringDepositDataView.onRowsChanged.subscribe(function(e, args) {
            recurringDepositGrid.invalidateRows(args.rows);
            recurringDepositGrid.render();
        });
        recurringDepositDataView.onPagingInfoChanged.subscribe(function(e, pagingInfo) {
            var isLastPage = pagingInfo.pageNum === pagingInfo.totalPages - 1;
            var enableAddRow = isLastPage || pagingInfo.pageSize === 0;
            var options = recurringDepositGrid.getOptions();
            if (options.enableAddRow !== enableAddRow) {
                recurringDepositGrid.setOptions({ enableAddRow: enableAddRow });
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
            for (var i = 0; i < 10 && i < recurringDepositDataView.getLength(); i++) {
                rows.push(i);
            }
            recurringDepositGrid.setSelectedRows(rows);
        });
        // initialize the model after all the events have been hooked up
        recurringDepositGrid.init();
        recurringDepositDataView.beginUpdate();
        recurringDepositDataView.setItems(data1);
        /*
        dataView.setFilterArgs({
            percentCompleteThreshold: percentCompleteThreshold,
            searchString: searchString
        });
        */
        recurringDepositDataView.setFilter(filter);
        recurringDepositDataView.endUpdate();
        // if you don't want the items that are not visible (due to being filtered out
        // or being on a different page) to stay selected, pass 'false' to the second arg
        recurringDepositDataView.syncGridSelection(recurringDepositGrid, true);
        //$("#gridContainer").resizable();
    })
}

