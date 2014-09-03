<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>Avalon FTP</title>
<link href="resources/css/css_reset.css" rel="stylesheet"
	type="text/css">
<link href="resources/css/theme.css" rel="stylesheet" type="text/css">
<link href="resources/css/main_style.css" rel="stylesheet"
	type="text/css">
<link rel="shortcut icon" href="resources/images/favicon.ico"
	type="image/x-icon" />
<script language="javascript" src="resources/js/jquery-1.6.2.min.js"></script>
<script language="javascript" src="resources/js/main.js"></script>
<script language="javascript" src="resources/js/common.js"></script>

<script type="text/javascript">
	function executeReq(thisObj,selId) {
		document.gatElementById('instacneids').value ='123';
		var elementWraper = $(thisObj).closest('.section_box');
		$(elementWraper).find('.basic_grid tr').removeClass('highlight');
		$(thisObj).parents('tr').addClass('highlight');
		$(elementWraper).find('.section_full_inside').hide();
		var ans = window.confirm("Sure...");
		if (ans) {
			document.getElementById('selid').value = selId;
			alert('value is '+document.getElementById('selid').value);
			alert('value is '+document.getElementById('path1').value);
			document.pendingApproval.action = 'Execute.html';
			document.pendingApproval.submit();
		} else {
			 alert('You Press NO');
			$(thisObj).parents('tr').removeClass('highlight');
		}
	}
</script>
<script>
$(document).ready(function(){
$('#selectall').click(
	    function()
	    {
	        $("INPUT[type='checkbox']").attr('checked', $('#selectall').is(':checked'));    
	    }
	)
});

</script>

 <script type="text/javascript">
 var selValues="";
    $("#execute").live("click", function () {
    	
        $("input:checkbox[name=chk]:checked").each(function () {
            //alert("Id: " + $(this).attr("id") + " Value: " + $(this).val());
            selValues += $(this).attr("id")+",";    
            $("#selValues").val(selValues);
        });
        $( "#pendingApproval" ).submit();
       // alert("selValues"+selValues);
    });
</script>
</head>
<body>
	<!-- <h:header /> -->
	<%@ include file="/WEB-INF/templates/header.jsp"%>
	<div id="page_container">
		<div id="breadcrumb_area">
			<div id="breadcrumb">
				<ul>
					<li><a href="getHome.html">Home</a>&nbsp;&nbsp;</li>

				</ul>
			</div>

		</div>
		<div class="clearfix"></div>
		<h1>Manage Approvals</h1>
		<div id="content_main">
			<form:form method="POST" commandName="approvedRequests"  enctype="multipart/form-data" action="ExecuteRequests.htm"
				name="pendingApproval" id="pendingApproval">

				<div class="section_box">
					<div class="section_box_header">
						<h2>Approved Requests
						</h2>
					</div>
					<div>
						<label class="required_sign"> <c:if
								test="${message != null}">${message}</c:if>
						</label>
					</diva>
					<div class="column_single">
						<table class="basic_grid" border="0" cellspacing="0"
							cellpadding="0">
							<tr>
								<th>APPROVAL ID</th>
								<th>OBJECT TYPE</th>
								<th>FILE NAME</th>
								<th>SHORT NAME</th>
								<th>LOB CODE</th>
								<th>PATH</th>
								<th align="right" valign="top" class="right">Select All<input type="checkbox" id="selectall" name="selectall"></th>
							</tr>

							<c:choose>
								<c:when test="${not empty pendingList}">
									<c:forEach items="${pendingList}" var="approval"
										varStatus="status">
										<tr
											<c:choose>
							            		<c:when test="${status.count % 2 == 1}">class="odd"</c:when>
							            		<c:when test="${status.count % 2 == 0}">class="even"</c:when>
						            		</c:choose>>

											<td>${approval.approvalid}</td>
											<td>${approval.objecttype}</td>
											<td>${approval.filename}</td>
											<td>${approval.appshortname}</td>
											<td>${approval.lobcode}</td>
											<td>${approval.path}</td>
											<td nowrap class="right">
											 <input type="checkbox" id="${approval.id}-${approval.approvalid}-${approval.objecttype}-${approval.path}-${approval.filename}-${approval.appshortname}" name="chk">
											</td>
										</tr>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<tr>
										<td width="830"><h5>No Approvals Found</h5></td>
										<td nowrap class="right"></td>
										<td></td>
									</tr>
								</c:otherwise>
							</c:choose>

						</table>
					</div>
				</div>
				<div class="clearfix"></div>
				
				<input type="button"  	id='execute' 	value="Execute"	class="button"   onClick="ExecuteRequests();">
				<input type="hidden" 	id="selValues"	name="selValues" /> 
				<input type="hidden"  	id="objtype"	name="objtype" />
				<input type="hidden"  	id="selid"		name="selid" />
				<input type="hidden"  	id="path1"		name="path1" />
				<input type="hidden"  	id="instanceids"	name="instanceids" />
				
				
			</form:form>
		</div>

		

		<div class="button_row">
			<div class="buttion_bar_type2"></div>
			<div class="clearfix"></div>
		</div>
		<%-- </form:form> --%>
	</div>
	</div>
	<!-- <h:footer /> -->
	<%@ include file="/WEB-INF/templates/footer.jsp"%>
</body>
</html>
