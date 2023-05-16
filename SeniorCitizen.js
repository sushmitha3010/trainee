function seniorDeposit (){

var dataView;

var grid;

	var data = document.getElementById("senior").value

	/*<![CDATA[*/
	//var data = /*[[${registeredPaymentList}]]*/'Emp';//

	console.log(data);


	var data1 = JSON.parse(data);


/*<![CDATA[*/

/*]]>*/

console.log(data);

/* set unique it to array */

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

console.log(data);

/* unique id end */
function seniorCitizenDateFormatter(row, cell, value, columnDef, dataContext) {
		const date = new Date(value);
		var getDay3 = date.toLocaleString("default", { day: "2-digit" });
		var getMonth3 = date.toLocaleString("default", { month: "2-digit" });
		var getYear3 = date.toLocaleString("default", { year: "numeric" }); // Set the desired date format
		return getDay3 + "-" + getMonth3 + "-" + getYear3;// Format the date as a string
	}

var columnFilters = {};

var columns = [ {

id : "accountHolderName",

name : "User Name",

field : "accountHolderName",

 sortable : true,

width : 150

}, {

id : "mobNumber",

name : "Mobile Number",

field : "mobNumber",

 sortable : true,

width : 150

}, {

id : "accountNum",

name : "Account Number",

field : "accountNum",

 sortable : true,

width : 150

},{
	id : "money",

	name : "Amount",

	field : "money",
	 sortable : true,

	width : 90

	}, {

	id : "age",

	name : "Age",

	field : "age",
	 sortable : true,

	width : 60

	}, {

	id : "amountPaymentDate",

	name : "Deposit Date",

	field : "amountPaymentDate",
	formatter : seniorCitizenDateFormatter ,
	 sortable : true,
    width : 140
	}, {
		id : "returnDate",

		name : "Return Date",

		field : "returnDate",
		formatter : seniorCitizenDateFormatter ,
		 sortable : true,
		width : 140
	},{
		id : "interestAmount",

		name : "Simple Interest",

		field : "interestAmount",
		 sortable : true,

		width : 130
		}, {
		id : "maturity_amount",

		name : "Maturity Amount",

		field : "maturity_amount",
		 sortable : true,

		width : 130
		}, {
		id : "total_amount",

		name : "Total Amount",

		field : "total_amount",
		 sortable : true,
	    width : 100,
}, ];
var seniorCitizenOptions = {
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
    var sortcol6 = "title";
    var sortdir6 = 1;
    function comparer(a, b) {
        var x = a[sortcol6], y = b[sortcol6];
        return (x === y ? 0 : (x > y ? 1 : -1));
    }
$(function() {
        /* filter start */
        function filter(item) {
            for (var columnId in columnFilters) {
                if (columnId !== undefined && columnFilters[columnId] !== "") {
                    var column = grid.getColumns()[grid.getColumnIndex(columnId)];
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
        dataView = new Slick.Data.DataView();
        grid = new Slick.Grid("#myGrid3", dataView, columns, seniorCitizenOptions);
        grid.setSelectionModel(new Slick.RowSelectionModel());
        // header row start
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
                if (columnId !== null) {
                    columnFilters[columnId] = $.trim($(this).val());
                    dataView.refresh();
                }
            });
grid.onHeaderRowCellRendered.subscribe(function(e, args) {
            $(args.node).empty();
            $("<input type='text'>").data("columnId", args.column.id).val(
                columnFilters[args.column.id]).appendTo(args.node);
        });
        // header row end
        // move the filter panel defined in a hidden div into grid top panel
        $("#inlineFilterPanel")
            .appendTo(grid.getTopPanel())
            .show();
        grid.onCellChange.subscribe(function(e, args) {
            dataView.updateItem(args.item.id, args.item);
        });
        grid.onKeyDown.subscribe(function(e) {
            // select all rows on ctrl-a
            if (e.which !== 65 || !e.ctrlKey) {
                return false;
            }
            var rows = [];
            for (var i = 0; i < dataView.getLength(); i++) {
                rows.push(i);
            }
            grid.setSelectedRows(rows);
            e.preventDefault();
        });
        grid.onSort.subscribe(function(e, args) {
            sortdir6 = args.sortAsc;
            sortcol6 = args.sortCol.field;
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
                dataView.fastSort((sortcol6 === "percentComplete") ? percentCompleteValueFn : sortcol6, sortdir6);
            } else {
                // using native sort with comparer
                // preferred method but can be very slow in IE with huge datasets
                dataView.sort(comparer, sortdir6);
            }
        });
// wire up model events to drive the grid
        dataView.onRowCountChanged.subscribe(function(e, args) {
            grid.updateRowCount();
            grid.render();
        });
        dataView.onRowsChanged.subscribe(function(e, args) {
            grid.invalidateRows(args.rows);
            grid.render();
        });
        dataView.onPagingInfoChanged.subscribe(function(e, pagingInfo) {
            var isLastPage = pagingInfo.pageNum === pagingInfo.totalPages - 1;
            var enableAddRow = isLastPage || pagingInfo.pageSize === 0;
            var options = grid.getOptions();
            if (options.enableAddRow !== enableAddRow) {
                grid.setOptions({ enableAddRow: enableAddRow });
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
            for (var i = 0; i < 10 && i < dataView.getLength(); i++) {
                rows.push(i);
            }
            grid.setSelectedRows(rows);
        });
        // initialize the model after all the events have been hooked up
        grid.init();
        dataView.beginUpdate();
        dataView.setItems(data1);
        /*
        dataView.setFilterArgs({
            percentCompleteThreshold: percentCompleteThreshold,
            searchString: searchString
        });
        */
        dataView.setFilter(filter);
        dataView.endUpdate();
        // if you don't want the items that are not visible (due to being filtered out
        // or being on a different page) to stay selected, pass 'false' to the second arg
        dataView.syncGridSelection(grid, true);
        //$("#gridContainer").resizable();
    })
}

