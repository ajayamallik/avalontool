<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

	
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
<link rel="shortcut icon" href="resources/images/favicon.ico" type="image/x-icon" />
<script language="javascript" src="resources/js/jquery-1.6.2.min.js"></script>
<script language="javascript" src="resources/js/main.js"></script>
<script language="javascript" src="resources/js/common.js"></script>

<script type="text/javascript">

function deleteUserRole(thisObj) {
	var elementWraper = $(thisObj).closest('.section_box');
	$(elementWraper).find('.basic_grid tr').removeClass('highlight');
	$(thisObj).parents('tr').addClass('highlight');
	$(elementWraper).find('.section_full_inside').hide();
	var ans = window.confirm("Sure...");
	if(ans){
		document.userRoleForm.action='deleteUserRole.html';
		document.userRoleForm.submit();
	}
	else {
		$(thisObj).parents('tr').removeClass('highlight');
	}
	}
</script>
</head>
<body>

	<!--  header -->
	 <%@ include file="/WEB-INF/templates/header.jsp" %>
	<div id="page_container">
		<div id="breadcrumb_area">
			<div id="breadcrumb">
				<ul>
					<li><a href="admin.html">Home</a>&nbsp;&nbsp;</li>
					
				</ul>
			</div>
			
		</div>
		<div class="clearfix"></div>
		<h1>Manage Roles </h1>
		<div id="content_main">
			<form:form method="POST" commandName="userRole" action=""
				name="userRoleForm">

				<div class="section_box">
					<div class="section_box_header">
						<h2>Manage User Role</h2>
					</div>
					<div>
						<label class="required_sign">
							<c:if test="${message != null}">${message}</c:if>
						</label>
						<form:errors path="role" cssClass="required_sign"/><br>
						<form:errors path="description" cssClass="required_sign"/>
					</div>
					<div class="column_single">
						<table class="basic_grid" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<th>Role</th>
								<th>Description</th>
								<th align="right" valign="top" class="right"></th>
							</tr>
							
							<c:choose>
								<c:when test="${not empty userRoleList}">
									<c:forEach items="${userRoleList}" var="role" varStatus="status">
										<tr
											<c:choose>
							            		<c:when test="${status.count % 2 == 1}">class="odd"</c:when>
							            		<c:when test="${status.count % 2 == 0}">class="even"</c:when>
						            		</c:choose>>
						            		
											<td>${role.role}</td>
											<td>${role.description}</td>
											<td nowrap class="right">
											
												
												<img src="resources/images/ico_edit.gif"
												
												 
													title="Edit"  
											
												
												onClick="document.userRoleForm.role_id.value='${role.role_id}';
							              			document.userRoleForm.action='loadUserRoleDetails.html';
						              			document.userRoleForm.submit();"
												width="18" height="20" class="icon"> 
												
																							
												<img src="resources/images/ico_delete.gif"
												
												onClick="document.userRoleForm.selectedRole.value='${role.role_id}';deleteUserRole(this);"
												title="Delete" width="18" height="20" class="icon">
												
												
												
											</td>
												
												
										</tr>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<tr>
										<td width="830"><h5>No Role Found</h5>
										</td>
										<td nowrap class="right"></td>
										<td></td>
									</tr>
								</c:otherwise>
							</c:choose> 
							
							</table>
					</div>
					</div>
					<div class="clearfix"></div>
				</div>
				<input type="hidden" name="selectedRole">
				<form:hidden path="role_id"/>
				   <div class="button_row">
				  	<div class="buttion_bar_type2" >
				  		 
							<input type="button" value="Add New Role" onClick="window.location='newUserRoleDetails.html'" class="button">
						
			        </div>
			        <div class="clearfix"></div>
	  			   </div>
			</form:form>
		</div>
	</div>
	<h:footer />
</body>
<%-- <h:footer /> --%>
 <%@ include file="/WEB-INF/templates/footer.jsp" %>
</html>
