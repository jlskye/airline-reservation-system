document.write("<script src='<%=basePath %>js/WebCalendar.js' type='text/javascript' ></script>");
var TableEditable = function () {

    return {

        //main function to initiate the module
        init: function () {
            function restoreRow(oTable, nRow) {
                var aData = oTable.fnGetData(nRow);
                var jqTds = $('>td', nRow);

                for (var i = 0, iLen = jqTds.length; i < iLen; i++) {
                    oTable.fnUpdate(aData[i], nRow, i, false);
                }

                oTable.fnDraw();
            }

            function editRow(oTable, nRow) {
                var aData = oTable.fnGetData(nRow);
                var jqTds = $('>td', nRow);
                jqTds[0].innerHTML = '<input type="text" id="sname" class="m-wrap small" value="' + aData[0] + '" >';
                jqTds[1].innerHTML = '<input type="text" id="sequence" class="m-wrap small" value="' + aData[1] + '">';
                jqTds[2].innerHTML = '<input type="text" id="arrivetime"  onclick="SelectDate(this,\'yyyy-MM-dd hh:mm\')" class="m-wrap small" value="' + aData[2] + '">';
                jqTds[3].innerHTML = '<input type="text" id="departtime" onclick="SelectDate(this,\'yyyy-MM-dd hh:mm\')" class="m-wrap small" value="' + aData[3] + '">';
                jqTds[4].innerHTML = '<input type="text" id="price"   class="m-wrap small" value="' + aData[4] + '">';
                jqTds[5].innerHTML = '<a class="edit" href="">保存</a>';
                jqTds[6].innerHTML = '<a class="cancel">取消</a>';   
                jqTds[7].innerHTML = '<input type="hidden" id="sid"   class="m-wrap small" value="' + aData[7] + '">';
                jqTds[8].innerHTML = '<input type="hidden" id="sid"   class="m-wrap small" value="' + aData[8] + '">';
                jqTds[9].innerHTML = '<input type="hidden" id="sid"   class="m-wrap small" value="' + aData[9] + '">';
            }
            
            function save1Row(oTable, nRow) {
                var jqInputs = $('input', nRow);
                oTable.fnUpdate(jqInputs[0].value, nRow, 0, false);
                oTable.fnUpdate(jqInputs[1].value, nRow, 1, false);
                oTable.fnUpdate(jqInputs[2].value, nRow, 2, false);
                oTable.fnUpdate(jqInputs[3].value, nRow, 3, false);
                oTable.fnUpdate(jqInputs[4].value, nRow, 4, false);
                oTable.fnUpdate('<a class="edit" href="">编辑</a>', nRow, 5, false);
                oTable.fnUpdate('<a class="delete" href="">删除</a>', nRow, 6, false);
                oTable.fnDraw();     
                var key = jqIputs[5].value;
                var name = $("#trainname").val();
                var date = $("#traindate").val();
                if(key != ""){
	                	$.ajax({
	                		url:"/LunaNova/route/update" ,
	                		type:"post",
	                		data:{
	                			train_name:jqInputs[6].value,
	                			route_date:jqInputs[7].value,
	                			station_name:jqInputs[0].value,
	                			sequence:jqInputs[1].value,
	                			route_arrive_time:jqInputs[2].value,
	                			route_start_time:jqInputs[3].value,
	                			route_price:jqInputs[4].value,
	                			route_id:jqInputs[5].value,
	                			m:"modify"
	                		},
	                		success:function(){                		
	                			alert("修改成功");
	                		}
	                	});
                }else{
                	$.ajax({
	                	url:"/LunaNova/route/add" ,
	                	type:"post",
	                	data:{
	                		train_name:name,
                			route_date:date,
                			station_name:jqInputs[0].value,
                			sequence:jqInputs[1].value,
                			route_arrive_time:jqInputs[2].value,
                			route_start_time:jqInputs[3].value,
                			route_price:jqInputs[4].value,
	                		m:"add"
	                	},
	                		success:function(){                		
	                			alert("添加成功");
	                		}
	                	});
                }
            }
            

            function cancelEditRow(oTable, nRow) {
                var jqInputs = $('input', nRow);
                oTable.fnUpdate(jqInputs[0].value, nRow, 0, false);
                oTable.fnUpdate(jqInputs[1].value, nRow, 1, false);
                oTable.fnUpdate(jqInputs[2].value, nRow, 2, false);
                oTable.fnUpdate(jqInputs[3].value, nRow, 3, false);
                oTable.fnUpdate(jqInputs[3].value, nRow, 4, false);
                oTable.fnUpdate('<a class="edit" href="">编辑</a>', nRow, 5, false);
                oTable.fnDraw();
            }

            var oTable = $('#sample_editable_1').dataTable({
                "aLengthMenu": [
                    [5, 15, 20, -1],
                    [5, 15, 20, "All"] // change per page values here
                ],
                // set the initial value
                "iDisplayLength": 5,
                "sDom": "<'row-fluid'<'span6'l><'span6'f>r>t<'row-fluid'<'span6'i><'span6'p>>",
                "sPaginationType": "bootstrap",
                "oLanguage": {
                    "sLengthMenu": "_MENU_ 条每页",
                    "oPaginate": {
                        "sPrevious": "上一页",
                        "sNext": "下一页"
                    }
                },
                "aoColumnDefs": [{
                        'bSortable': false,
                        'aTargets': [0]
                    }
                ]
            });

            jQuery('#sample_editable_1_wrapper .dataTables_filter input').addClass("m-wrap medium"); // modify table search input
            jQuery('#sample_editable_1_wrapper .dataTables_length select').addClass("m-wrap small"); // modify table per page dropdown
            jQuery('#sample_editable_1_wrapper .dataTables_length select').select2({
                showSearchInput : false //hide search box with special css class
            }); // initialzie select2 dropdown

            var nEditing = null;

            $('#sample_editable_1_new').click(function (e) {
                e.preventDefault();
                var aiNew = oTable.fnAddData(['', '', '', '', '',
                        '<a class="edit" href="">编辑</a>', '<a class="cancel" data-mode="new" href="">取消</a>','','',''
                ]);
                var nRow = oTable.fnGetNodes(aiNew[0]);
                editRow(oTable, nRow);
                nEditing = nRow;
            });

            $('#sample_editable_1 a.delete').live('click', function (e) {
                e.preventDefault();
                
                if (confirm("确定要删除该车站吗") == false) {
                    return;
                }
                var nRow = $(this).parents('tr')[0];
                oTable.fnDeleteRow(nRow);
                alert("Deleted! Do not forget to do some ajax to sync with backend :)");
            });

            $('#sample_editable_1 a.cancel').live('click', function (e) {
                e.preventDefault();
                if ($(this).attr("data-mode") == "new") {
                    var nRow = $(this).parents('tr')[0];
                    oTable.fnDeleteRow(nRow);
                } else {
                    restoreRow(oTable, nEditing);
                    nEditing = null;
                }
            });

            $('#sample_editable_1 a.edit').live('click', function (e) {
                e.preventDefault();

                /* Get the row as a parent of the link that was clicked on */
                var nRow = $(this).parents('tr')[0];

                if (nEditing !== null && nEditing != nRow) {
                    /* Currently editing - but not this row - restore the old before continuing to edit mode */
                    restoreRow(oTable, nEditing);
                    editRow(oTable, nRow);
                    nEditing = nRow;
                } else if (nEditing == nRow && this.innerHTML == "保存") {
                    /* Editing this row and want to save it */                    
                	save1Row(oTable, nEditing);
                    nEditing = null;
                } else {
                    /* No edit in progress - let's start one */
                    editRow(oTable, nRow);
                    nEditing = nRow;
                }
            });
        }
    
    };

}();