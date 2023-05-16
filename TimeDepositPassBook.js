function timeDepositDepositPassBook(){

var timeDepositView;

var timeDepositGrid;

	var timeDepositData = document.getElementById("timeDepositPassBook").value;

	var data1 = JSON.parse(timeDepositData);
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
function timeDepositPassBookDateFormatter(row, cell, value, columnDef, dataContext) {
		const date = new Date(value);
		var getDay = date.toLocaleString("default", { day: "2-digit" });
		var getMonth = date.toLocaleString("default", { month: "2-digit" });
		var getYear = date.toLocaleString("default", { year: "numeric" }); // Set the desired date format
		return getDay + "-" + getMonth + "-" + getYear;// Format the date as a string
	}



var timeDepositPassBokColumn = {};

var columns1 = [ {
   width : 150,

   id : "depositUserName",

   name : "User Name",

   field : "depositUserName",

}, {
   width : 140,

   id : "mobNo",

   name : "Mobile Number",

   field : "mobNo",

}, {

   id : "acctNumber",

   name : "Account Number",

   field : "acctNumber",

   width : 150

},{
	width : 90,

   id : "initialAmount",

   name : "Amount",

   field : "initialAmount",
}, {
	width : 60,
	id : "periods",

	name : "Periods",

	field : "periods",
},{
	width : 140,
	id : "paymentDate",

	name : "Deposit Date",

	field : "paymentDate",
	formatter : timeDepositPassBookDateFormatter,
},{
	width : 130,
	id : "depsoitReturnDate",

	name : "Return Date",

	field : "depsoitReturnDate",

	formatter : timeDepositPassBookDateFormatter
	},{
	width : 130,
	id : "simple_interest",

	name : "Simple Interest",

	field : "simple_interest",

	}, {
		width : 120,
		id : "paymentMaturity",

		name : "Maturity Amount",

		field : "paymentMaturity",
	},{
		width : 120,
		id : "totalPayment",

		name : "Total Amount",

		field : "totalPayment",
}, ] ;



var timeDepositPassBookOptions = {
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
    var sortcol8 = "title";
    function comparer(a, b) {
        var x = a[sortcol8], y = b[sortcol8];
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
            for (var columnId in timeDepositPassBokColumn) {
                if (columnId !== undefined && timeDepositPassBokColumn[columnId] !== "") {
                    var column = timeDepositGrid.getColumns()[timeDepositGrid.getColumnIndex(columnId)];
                    if (item[column.field] !== undefined) {
                        var filterResult = typeof item[column.field].indexOf === 'function'
                            ? (item[column.field].indexOf(timeDepositPassBokColumn[columnId]) === -1)
                            : (item[column.field] !== timeDepositPassBokColumn[columnId]);
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
        timeDepositView = new Slick.Data.DataView();
        timeDepositGrid = new Slick.Grid("#myGrid1", timeDepositView, columns1, timeDepositPassBookOptions);
        timeDepositGrid.setSelectionModel(new Slick.RowSelectionModel());
        // header row start
        timeDepositView.onRowCountChanged.subscribe(function(e, args) {
            timeDepositGrid.updateRowCount();
            timeDepositGrid.render();
        });
        timeDepositView.onRowsChanged.subscribe(function(e, args) {
            timeDepositGrid.invalidateRows(args.rows);
            timeDepositGrid.render();
        });
        $(timeDepositGrid.getHeaderRow()).delegate(":input", "change keyup",
            function(e) {
                var columnId = $(this).data("columnId");
                if (columnId !== null) {
                    timeDepositPassBokColumn[columnId] = $.trim($(this).val());
                    timeDepositView.refresh();
                }
            });
timeDepositGrid.onHeaderRowCellRendered.subscribe(function(e, args) {
            $(args.node).empty();
            $("<input type='text'>").data("columnId", args.column.id).val(
                timeDepositPassBokColumn[args.column.id]).appendTo(args.node);
        });
        // header row end
        // move the filter panel defined in a hidden div into grid top panel
        $("#inlineFilterPanel")
            .appendTo(timeDepositGrid.getTopPanel())
            .show();
        timeDepositGrid.onCellChange.subscribe(function(e, args) {
            timeDepositView.updateItem(args.item.id, args.item);
        });
        timeDepositGrid.onKeyDown.subscribe(function(e) {
            // select all rows on ctrl-a
            if (e.which !== 65 || !e.ctrlKey) {
                return false;
            }
            var rows = [];
            for (var i = 0; i < timeDepositView.getLength(); i++) {
                rows.push(i);
            }
            timeDepositGrid.setSelectedRows(rows);
            e.preventDefault();
        });
        timeDepositGrid.onSort.subscribe(function(e, args) {
            sortdir = args.sortAsc ? 1 : -1;
            sortcol8 = args.sortCol.field;
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
                timeDepositView.fastSort((sortcol8 === "percentComplete") ? percentCompleteValueFn : sortcol8, args.sortAsc);
            } else {
                // using native sort with comparer
                // preferred method but can be very slow in IE with huge datasets
                timeDepositView.sort(comparer, args.sortAsc);
            }
        });
// wire up model events to drive the grid
        timeDepositView.onRowCountChanged.subscribe(function(e, args) {
            timeDepositGrid.updateRowCount();
            timeDepositGrid.render();
        });
        timeDepositView.onRowsChanged.subscribe(function(e, args) {
            timeDepositGrid.invalidateRows(args.rows);
            timeDepositGrid.render();
        });
        timeDepositView.onPagingInfoChanged.subscribe(function(e, pagingInfo) {
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
            for (var i = 0; i < 10 && i < timeDepositView.getLength(); i++) {
                rows.push(i);
            }
            timeDepositGrid.setSelectedRows(rows);
        });
        // initialize the model after all the events have been hooked up
        timeDepositGrid.init();
        timeDepositView.beginUpdate();
        timeDepositView.setItems(data1);
        /*
        dataView.setFilterArgs({
            percentCompleteThreshold: percentCompleteThreshold,
            searchString: searchString
        });
        */
        timeDepositView.setFilter(filter);
        timeDepositView.endUpdate();
        // if you don't want the items that are not visible (due to being filtered out
        // or being on a different page) to stay selected, pass 'false' to the second arg
        timeDepositView.syncGridSelection(timeDepositGrid, true);
        //$("#gridContainer").resizable();
    })
}

