<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>Avalon HRMS</title>
<link href="resources/css/css_reset.css" rel="stylesheet"
	type="text/css">
<link href="resources/css/theme.css" rel="stylesheet" type="text/css">
<link href="resources/css/main_style.css" rel="stylesheet"
	type="text/css">
<script language="javascript" src="resources/js/jquery-1.6.2.min.js"></script>
<script language="javascript" src="resources/js/main.js"></script>

<script type="text/javascript">
//update UserLogin
function updateStatusUserStatus(thisObj, value, userid) {
	$(thisObj).parents('tr').addClass('highlight');
	if(value == "disable"){
		var ans = window.confirm("Disable Confirm");
	}else if(value == "enable"){
		var ans = window.confirm("Enable Confirm");
	}

	if(ans){
		if(value == "disable") {
			document.getElementById('selectedUserStatus').value = "0";
		}
		else
		{
			document.getElementById('selectedUserStatus').value = "1";
		}
		document.getElementById('selectedUserLoginId').value = userid;
		document.systemUserSearch.action = "updateUserStatus.html";
		document.systemUserSearch.submit();
	}
	else{
		$(thisObj).parents('tr').removeClass('highlight');
	}
	
}

//resetPassword.
function resetPassword(thisObj, userid) {
		document.getElementById('selectedUserLoginId').value = userid;
		document.systemUserSearch.action = "editSystemUser.html";
        document.systemUserSearch.submit();
}


//resetPassword.
function disableUser(thisObj, userid) {
		document.getElementById('selectedUserLoginId').value = userid;
		document.systemUserSearch.action = "disableSystemUser.html";
        document.systemUserSearch.submit();
}




//Unlock user
function unlockUser(thisObj, userLoginId, loginAttempts) {
	if(loginAttempts<2){
		return false;
	}
	$(thisObj).parents('tr').addClass('highlight');
	var ans = window.confirm("Confirm");

	if(ans){
		document.getElementById('selectedUserLoginId').value = userLoginId;
		document.systemUserSearch.action = "unlockUser.htm";
        document.systemUserSearch.submit();
	}else{
		$(thisObj).parents('tr').removeClass('highlight');
	}
	
}

//Delete user
function deleteUserLogin(thisObj, userLoginId,status) {
	
	if(status==1)
		{
		
		alert("You Cannot Delete Active User");
		
		}
	
	
	else{

	$(thisObj).parents('tr').addClass('highlight');
	var ans = window.confirm("Delete Confirm");

	if(ans){
		document.getElementById('selectedUserLoginId').value = userLoginId;
		document.systemUserSearch.action = "deleteUserLogin.html";
        document.systemUserSearch.submit();
	}else{
		$(thisObj).parents('tr').removeClass('highlight');
	}
	
	}
}

//Used of pagination in onclick event of previous and next buttons
function previousOrNext(value){
	pageSize = 10;

	if(value == "next"){
		startFrom = parseInt(${startFrom}) + pageSize;
		document.getElementById('startFrom').value = startFrom + "";

	}else if(value == "previous"){
		startFrom = parseInt(${startFrom}) - pageSize;
		document.getElementById('startFrom').value = startFrom + "";
	}

	document.getElementById('actionType').value = value;	
	document.systemUserSearch.submit();
}


function resetForm(){
	
	document.systemUserSearch.action='manageSystemUser.html';
	document.systemUserSearch.submit();


}


</script>
</head>
<body>


	<!--  header -->
	 <%@ include file="/WEB-INF/templates/header.jsp" %>
	 
<div id="page_container">
<div id="breadcrumb">
<ul>
	<li><a href="admin.html">Home</a>&nbsp;&nbsp;</li>
	
</ul>
</div>

<div class="clearfix"></div>
<h1>Manage System Users</h1>
<label class="required_sign"> <c:if test="${message != null}"> 
			${message}
		</c:if> </label>
<div id="content_main"><form:form method="POST"
	commandName="userdetails" name="systemUserSearch" action="searchSystemUsers.html">

	<div class="clearfix"></div>
	<div class="section_full_search">
	<div class="box_border">
	<div class="column">
	<div class="row">
	<div class="float_left">
	<div class="lbl_lock"><label>User Name:</label></div>
	<div class=""> <form:input path="username" /> </div>
	</div>
	<div class="float_left">
	<div class="lbl_lock">
	
	<div class="row">
	<div class="frmlabellb">User Role:</div>
	<div class="frmvalue"><form:select path="type" disabled="${userdetails.userid!=0?true:false}"
		name="type" 
		onchange="changeUserIdentificationNo(this.value);">
		<form:options items="${userLevelList}" 
			 />
	</form:select></div>
	</div>
	<div class="float_right">

	<div class="buttion_bar_type1">
	
	    <input type="reset" value="Reset" class="button" onclick="resetForm()">
		<input type="submit" value="Search" class="button">
	<br>
	<br>
	
	</div>
	</div>
	</div>
	</div>
	<div class="clearfix"></div>
	</div>
	</div>
	<c:if
		test="${fn:length(userLoginList) > 0 || (userLoginList) == 'Empty' }">
		<div class="section_box" id="search_results" style="display: block">

		<div class="section_box_header">
		<h2>Search Results</h2>
		</div>

		<div class="column_single">
		<table class="basic_grid" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<th>User Name</th>
				<th>User Role</th>

			</tr>

			<c:choose>
				<c:when test="${(userLoginList) == 'Empty' }">
					<tr class="odd">
						<td>No Records Found</td>
						<td></td>
					</tr>
				</c:when>

				<c:otherwise>
					<c:forEach items="${userLoginList}" var="userLogin"
						varStatus="status">
						
						
						<tr class="<c:if test="${status.count % 2 == 0}">even</c:if>
						
						<c:if test="${status.count % 2 == 1}">odd</c:if>">
							<td>${userLogin.username}</td>
							<td>${userLogin.type}</td>
							
							
							<td class="right">
								
									<img src="resources/images/ico_edit.gif"										
									width="18" height="20" border="0" class="icon"
									onclick="resetPassword(this,${userLogin.userid})"
									title='Edit'>
															
								<img src="${userLogin.status==1?'resources/images/ico_enableuser.gif':'resources/images/ico_disableuser.gif'}"
																		
									width="18" height="20" border="0" class="icon"
									onclick="updateStatusUserStatus(this,'${userLogin.status==1?'disable':'enable'}', ${userLogin.userid})"
								
									title='Disable'>												
							
								<img src="resources/images/ico_delete.gif"
								onClick="deleteUserLogin(this,${userLogin.userid},${userLogin.status })"
								title="Delete" width="18" height="20" class="icon">
							
								 
							</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>

		</table>
		</div>

		<div class="clearfix"></div>
		</div>

	</c:if>
	<div class="button_row">
	<div class="buttion_bar_type2">
	
	<input type="button" value="Add New User"
		onClick="window.location='createuser.html'" class="button">
		
	</div>	
	<div class="clearfix">		
	</div>
	</div>
	<input type="hidden" name="selectedUserLoginId"
		id="selectedUserLoginId" />
	<input type="hidden" name="startFrom" id="startFrom" value="0" />
	<input type="hidden" name="selectedUserStatus" id="selectedUserStatus"
		value="0" />
	<input type="hidden" name="actionType" id="actionType" value="search" />
</form:form></div>
</div>
<%-- <h:footer /> --%>
 <%@ include file="/WEB-INF/templates/footer.jsp" %>
</body>
</html>