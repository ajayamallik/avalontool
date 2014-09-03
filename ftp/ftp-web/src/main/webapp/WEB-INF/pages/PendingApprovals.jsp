<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>Avalon HRMS</title>
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
	function approvalPending(thisObj,selId) {

		var elementWraper = $(thisObj).closest('.section_box');
		$(elementWraper).find('.basic_grid tr').removeClass('highlight');
		$(thisObj).parents('tr').addClass('highlight');
		$(elementWraper).find('.section_full_inside').hide();
		var ans = window.confirm("Sure...");
		if (ans) {
			document.getElementById('selid').value = selId;
			alert('value is '+document.getElementById('selid').value);
			document.pendingApproval.action = 'approved.html';
			document.pendingApproval.submit();
		} else {
			 alert('You Press NO');
			$(thisObj).parents('tr').removeClass('highlight');
		}
	}
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
		<h1>Manage Aprovals</h1>
		<div id="content_main">
			<form:form method="POST" commandName="pendingreq" action=""
				name="pendingApproval">

				<div class="section_box">
					<div class="section_box_header">
						<h2>Pending Requests
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
								<th align="right" valign="top" class="right"></th>
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
											<img src="resources/images/y.gif"
												onClick="approvalPending(this,${approval.id})"
												title="Approve" width="18" height="20" class="icon"></td>


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
				
				
				<input type="hidden" name="approvalId" id="approvalId"/> 
				<input type="hidden"  name="selid" id="selid"/>
				
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
