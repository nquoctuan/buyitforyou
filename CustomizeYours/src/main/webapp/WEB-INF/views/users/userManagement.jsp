<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="true" %>
<html>
<head>
	<title>Security Section</title>
	
	<!-- jquery and its UI -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js"></script>
	<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/themes/flick/jquery-ui.css" />	
	
	<!-- jeasyui for using data grid  -->
	<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">
	<script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
	
	<link rel="stylesheet" href='<spring:url value="/resources/main.css" />' />
	<script type="text/javascript">
		$(function() {
			var url = '';
			$("#editLinkBtn").click(function(event) {
				var row = $('#UserListDataGrid').datagrid('getSelected');
		        if (row){
		            $('#dlg').dialog('open').dialog('setTitle','Edit User');
		            $('#fm').form('load',row);
		            url = '<spring:url value="/api/personByUsername.htm" />'+row.username;
		        }
			});
		});
		
		function saveUser() {
			 $('#fm').form('submit',{
                url: <spring:url value="/admin/updateUser.htm"/>,
                onSubmit: function(){
                    return $(this).form('validate');
                },
                success: function(result){
                    var result = eval('('+result+')');
                    if (result){
                    	$('#dlg').dialog('close');        // close the dialog
                        $('#dg').datagrid('reload');    // reload the user data
                    } else {
                    	$.messager.show({
                            title: 'Error',
                            msg: 'fail to update user'
                        });
                    }
                }
            });
		}
	</script>
</head>
<body>
	<h1 class="centerTitle">
		User management Dash board
	</h1>
	<div align="center">
		<p>
			<table id="UserListDataGrid" class="easyui-datagrid" style="width:600px;height:250px"
				url='<spring:url value="/getPersonList.htm"/>' method="get"
				title="Users list" iconCls="icon-save" singleSelect="true"
				fitColumns="true" toolbar="#toolbar"
				data-options="pagination:true,rownumbers:true">
				<thead>
					<tr>
						<th field="username" width="50">Username</th>
						<th field="fullName" width="50">Full Name</th>
						<th field="email" width="50">Email</th>
						<th field="role" width="50">Role</th>
					</tr>
				</thead>
			</table>
			<div id="toolbar">
		        <a id="editLinkBtn" class="easyui-linkbutton" iconCls="icon-edit" plain="true">Edit</a>
		        <a id="removeLinkBtn" class="easyui-linkbutton" iconCls="icon-remove" plain="true">Remove</a>
		    </div>
		    
		    <div id="dlg" class="easyui-dialog" style="width:400px;height:135px;padding:10px 20px"
		            closed="true" buttons="#dlg-buttons">
		        <div class="ftitle">User Information</div>
		        <form id="fm" method="post" novalidate>
		        	<div class="fitem">
		                <label>Email:</label>
		                <input name="username" class="easyui-textbox" readonly="readonly">
		            </div>
		            <div class="fitem">
		                <label>Email:</label>
		                <input name="email" class="easyui-textbox" validType="email">
		            </div>
		            <div class="fitem">
		                <label>Role:</label>
		                <select class="easyui-combobox" name="role">
							<option value="0">Guest</option>
							<option value="1" selected="selected">Simple User</option>
							<option value="10">Administrator</option>
						</select>
		            </div>
		        </form>
		    </div>
		    <div id="dlg-buttons">
		        <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" style="width:90px">Save</a>
		        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">Cancel</a>
		    </div>
		</p>
	</div>	
	
</body>
</html>