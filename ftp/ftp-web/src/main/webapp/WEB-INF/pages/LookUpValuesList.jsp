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
<link rel="shortcut icon" href="resources/images/favicon.ico" type="image/x-icon" />
<script language="javascript" src="resources/js/jquery-1.6.2.min.js"></script>
<script language="javascript" src="resources/js/main.js"></script>
<script language="javascript" src="resources/js/common.js"></script>

<script type="text/javascript">

function editGroupValue(url){
	alert("cliked on edit href...")
	document.getElementById("lookUpValuesForm").action=url;
	  document.getElementById("lookUpValuesForm").submit();
}
</script>
</head>
<body>

	<!--  header -->
	 <%@ include file="/WEB-INF/templates/header.jsp" %>
	<div id="page_container">
		<div id="breadcrumb_area">
			<!-- <div id="breadcrumb">
				<ul>
					<li><a href="getHome.html">Home</a>&nbsp;&nbsp;</li>
					
				</ul>
			</div> -->
			
		</div>
		<div class="clearfix"></div>
		<h1>LookUp Values List </h1>
		<div id="content_main">
			<form:form method="post" modelAttribute="lookUpValuesBean"  name="lookUpValuesForm" id="lookUpValuesForm">

				<div class="section_box">
					<div class="section_box_header">
						<h2>LookUp Values List</h2>
					</div>
					<div>
						<%-- <label class="required_sign">
							<c:if test="${groupMetaBeanID != null}">${groupMetaBeanID}</c:if>
						</label> --%>
						
						
	    			   
						<%-- <form:errors path="role" cssClass="required_sign"/><br>
						<form:errors path="description" cssClass="required_sign"/> --%>
					</div>
					<div class="column_single">
						<table class="basic_grid" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<th>LookUp Values ID</th>
								<th>LookUp Values Names </th>
								<th align="right" valign="top" class="right"></th>
							</tr>
							
							<c:choose>
								<c:when test="${not empty lookUpValuesBeans}">
									<c:forEach items="${lookUpValuesBeans}" var="lookUp" varStatus="status">
										<tr
											<c:choose>
							            		<c:when test="${status.count % 2 == 1}">class="odd"</c:when>
							            		<c:when test="${status.count % 2 == 0}">class="even"</c:when>
						            		</c:choose>>
						            		
											<td>${lookUp.lookUpValuesId}</td>
											<td>${lookUp.lookUpValuesName}</td>
											<td nowrap class="right">
												
												<a href="${lookUp.lookUpValuesName}">
													<img src="resources/images/ico_edit.gif" title="AddNew" width="18" height="20" class="icon" onclick='editSearchValue(${lookUp.lookUpValuesName}.html)'>
												</a>
												
												
											</td>
												
												
										</tr>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<tr>
										<td width="830"><h5>No Records Found</h5>
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
					</form:form>
				</div>
				<%-- <div>
				<input type="hidden" name="selectedRole">
				<form:hidden path="role_id"/>
				   <div class="button_row">
				  	<div class="buttion_bar_type2" >
				  		 
							<input type="button" value="Add New Role" onClick="window.location='newUserRoleDetails.html'" class="button">
						
			        </div>
			        <div class="clearfix"></div>
	  			   </div>
			</form:form>
		</div> --%>
	</div>
	<!-- <h:footer /> -->
</body>
<%-- <h:footer /> --%>
 <%@ include file="/WEB-INF/templates/footer.jsp" %>
</html>
