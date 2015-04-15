<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="true" %>
<html>
<head>
	<title>Shirt Color Mgmt</title>
	
	<!-- jquery and its UI -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js"></script>
	<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/themes/flick/jquery-ui.css" />
	
	<!-- jeasyui for using data grid  -->
	<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">
	<script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
	
	<link rel="stylesheet" href='<spring:url value="/resources/main.css" />' />
	<script>
		// Shorthand for $( document ).ready()
		$(function() {
		});
	</script>
</head>
<body>
	<h1 class="centerTitle">
		Shirt Color Management Dash board
	</h1>
	<div align="center">
		<p>
			<table id="ShirtColorListDataGrid" class="easyui-datagrid" style="width:600px;height:250px"
				url='<spring:url value="/api/getShirtColorList.htm"/>' method="get"
				title="ShirtColors list" iconCls="icon-save" singleSelect="true"
				fitColumns="true"
				data-options="pagination:true,rownumbers:true"
				toolbar="#toolbar">
				<thead>
					<tr>
						<th field="name" width="50">name</th>
						<th field="company" width="50">company</th>
					</tr>
				</thead>
			</table>
			
			<div id="toolbar">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="#">New</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="#">Edit</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="#">Remove</a>
    </div>
      
		</p>
	</div>	
</body>
</html>