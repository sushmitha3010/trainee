function recurringDepositPassBook(){

var recurringPassBookDataView;

var recurringPassBookGrid;

	var recurringPassBookData = document.getElementById("recurringPassBook").value;

	var data1 = JSON.parse(recurringPassBookData);
console.log(recurringPassBookData);

/* set unique it to array */

var recurringPassBookId = 1;

data1.forEach(function(item) {

// Generate a unique id using the nextId value

var itemId = "item_" + recurringPassBookId;

// Set the id property of the item object

item.id = itemId;

// Increment the nextId value

recurringPassBookId++;

});

// Use the updated items array list with unique ids

console.log(recurringPassBookData);

/* unique id end */
function recurringDepositPassBookDateFormatter(row, cell, value, columnDef, dataContext) {
		const date = new Date(value);
		var getDay = date.toLocaleString("default", { day: "2-digit" });
		var getMonth = date.toLocaleString("default", { month: "2-digit" });
		var getYear = date.toLocaleString("default", { year: "numeric" }); // Set the desired date format
		return getDay + "-" + getMonth + "-" + getYear;// Format the date as a string
	}



var columnFilters = {};

var columns = [ {

id : "customerName",

name : "user Name",

field : "customerName",

width : 150

}, {

id : "contactNo",

name : "Mobile Number",

field : "contactNo",

width : 150

}, {

id : "accountNumber",

name : "Account Number",

field : "accountNumber",

width : 150

}, {

	id : "principleAmount",

	name : "Principle Amount",

	field : "principleAmount",

	width : 120
}, {
	id : "noOfMonths",

	name : "Number Of Months",

	field : "noOfMonths",

	width : 120
}, {
	id : "depositDate",

	name : "Deposit Date ",

	field : "depositDate",
	formatter : recurringDepositPassBookDateFormatter,

	width : 150
}, {
	id : "amountReturnDate",

	name : "Return Date ",

	field : "amountReturnDate",
    formatter : recurringDepositPassBookDateFormatter,
	width : 140
},{
	id : "Interest",

	name : "Interest",

	field : "Interest",

	width : 100
}, {
	id : "maturityAmount",

	name : "Maturity Amount",

	field : "maturityAmount",

	width : 150
}, {
	id : "totalAmount",

	name : "Total Amount",

	field : "totalAmount",

	width : 150
}, ];


var recurringDepositPassBookOptions = {
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
    var sortcol4 = "title";
    var sortdir4 = 1;
    function comparer(a, b) {
        var x = a[sortcol4], y = b[sortcol4];
        return (x === y ? 0 : (x > y ? 1 : -1));
    }
$(function() {
        /* filter start */
        function filter(item) {
            for (var columnId in columnFilters) {
                if (columnId !== undefined && columnFilters[columnId] !== "") {
                    var column = recurringPassBookGrid.getColumns()[recurringPassBookGrid.getColumnIndex(columnId)];
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
        recurringPassBookDataView = new Slick.Data.DataView();
        recurringPassBookGrid = new Slick.Grid("#myGrid", recurringPassBookDataView, columns, recurringDepositPassBookOptions);
        recurringPassBookGrid.setSelectionModel(new Slick.RowSelectionModel());
        // header row start
        recurringPassBookDataView.onRowCountChanged.subscribe(function(e, args) {
            recurringPassBookGrid.updateRowCount();
            recurringPassBookGrid.render();
        });
        recurringPassBookDataView.onRowsChanged.subscribe(function(e, args) {
            recurringPassBookGrid.invalidateRows(args.rows);
            recurringPassBookGrid.render();
        });
        $(recurringPassBookGrid.getHeaderRow()).delegate(":input", "change keyup",
            function(e) {
                var columnId = $(this).data("columnId");
                if (columnId !== null) {
                    columnFilters[columnId] = $.trim($(this).val());
                    recurringPassBookDataView.refresh();
                }
            });
recurringPassBookGrid.onHeaderRowCellRendered.subscribe(function(e, args) {
            $(args.node).empty();
            $("<input type='text'>").data("columnId", args.column.id).val(
                columnFilters[args.column.id]).appendTo(args.node);
        });
        // header row end
        // move the filter panel defined in a hidden div into grid top panel
        $("#inlineFilterPanel")
            .appendTo(recurringPassBookGrid.getTopPanel())
            .show();
        recurringPassBookGrid.onCellChange.subscribe(function(e, args) {
            recurringPassBookDataView.updateItem(args.item.id, args.item);
        });
        recurringPassBookGrid.onKeyDown.subscribe(function(e) {
            // select all rows on ctrl-a
            if (e.which !== 65 || !e.ctrlKey) {
                return false;
            }
            var rows = [];
            for (var i = 0; i < recurringPassBookDataView.getLength(); i++) {
                rows.push(i);
            }
            recurringPassBookGrid.setSelectedRows(rows);
            e.preventDefault();
        });
        recurringPassBookGrid.onSort.subscribe(function(e, args) {
            sortdir4 = args.sortAsc;
            sortcol4 = args.sortCol.field;
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
                recurringPassBookDataView.fastSort((sortcol4 === "percentComplete") ? percentCompleteValueFn : sortcol4, sortdir4);
            } else {
                // using native sort with comparer
                // preferred method but can be very slow in IE with huge datasets
                recurringPassBookDataView.sort(comparer, sortdir4);
            }
        });
// wire up model events to drive the grid
        recurringPassBookDataView.onRowCountChanged.subscribe(function(e, args) {
            recurringPassBookGrid.updateRowCount();
            recurringPassBookGrid.render();
        });
        recurringPassBookDataView.onRowsChanged.subscribe(function(e, args) {
            recurringPassBookGrid.invalidateRows(args.rows);
            recurringPassBookGrid.render();
        });
        recurringPassBookDataView.onPagingInfoChanged.subscribe(function(e, pagingInfo) {
            var isLastPage = pagingInfo.pageNum === pagingInfo.totalPages - 1;
            var enableAddRow = isLastPage || pagingInfo.pageSize === 0;
            var options = recurringPassBookGrid.getOptions();
            if (options.enableAddRow !== enableAddRow) {
                recurringPassBookGrid.setOptions({ enableAddRow: enableAddRow });
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
            for (var i = 0; i < 10 && i < recurringPassBookDataView.getLength(); i++) {
                rows.push(i);
            }
            recurringPassBookGrid.setSelectedRows(rows);
        });
        // initialize the model after all the events have been hooked up
        recurringPassBookGrid.init();
        recurringPassBookDataView.beginUpdate();
        recurringPassBookDataView.setItems(data1);
        /*
        dataView.setFilterArgs({
            percentCompleteThreshold: percentCompleteThreshold,
            searchString: searchString
        });
        */
        recurringPassBookDataView.setFilter(filter);
        recurringPassBookDataView.endUpdate();
        // if you don't want the items that are not visible (due to being filtered out
        // or being on a different page) to stay selected, pass 'false' to the second arg
        recurringPassBookDataView.syncGridSelection(recurringPassBookGrid, true);
        //$("#gridContainer").resizable();
    })
}

