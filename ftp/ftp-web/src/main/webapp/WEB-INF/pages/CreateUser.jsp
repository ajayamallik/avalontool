<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>Create User</title>
<link href="resources/css/css_reset.css" rel="stylesheet"
	type="text/css">
<link href="resources/css/theme.css" rel="stylesheet" type="text/css">
<link href="resources/css/main_style.css" rel="stylesheet"
	type="text/css">
<script type="text/javascript" src="resources/js/main.js"></script>
<script type="text/javascript">
	function reSet(thisValue) {			
		
		document.systemUserForm.userIdentificationNoTxt.disabled = false;
		document.forms["systemUserForm"]["userIdentificationNoTxt"].value = "";
		document.forms["systemUserForm"]["firstname"].value = "";
		document.forms["systemUserForm"]["lastname"].value = "";
		document.forms["systemUserForm"]["email"].value = "";
		document.forms["systemUserForm"]["username"].value = "";
		document.forms["systemUserForm"]["userpass"].value = "";
		document.forms["systemUserForm"]["confirmPassword"].value = "";
		document.forms["systemUserForm"]["empid"].value = "";

	}

	function reSet2(thisValue) {	
		
	
		
		document.forms["systemUserForm"]["username"].value = "";
		document.forms["systemUserForm"]["userpass"].value = "";
		document.forms["systemUserForm"]["confirmPassword"].value = "";
		document.forms["systemUserForm"]["firstname"].value = "${userdetails.firstname}";
		document.forms["systemUserForm"]["lastname"].value = "${userdetails.lastname}";
		document.forms["systemUserForm"]["email"].value = "${userdetails.email}";
		document.forms["systemUserForm"]["empid"].value = "${userdetails.empid}";
	}

	function cancel(thisValue) {
		document.systemUserForm.action = "manageSystemUsers.html";
		document.systemUserForm.method = "GET";
		document.systemUserForm.submit();
	}

	function submitUser() {
		
		
		document.systemUserForm.action = "createSystemUser.html";
		document.systemUserForm.submit();
	}

	
	function changeUserIdentificationNo(selectedValue) {
		

		if (selectedValue == 2 || selectedValue == 3 || selectedValue == 4 || selectedValue == 5 ) {
			document.systemUserForm.userIdentificationNoTxt.disabled = false;
			document.getElementById("userIdentificationNo").style.display='block';

			var labelEle = document.getElementById("userIdentificationNoText");
			if(selectedValue == 2){
				labelEle.innerHTML = "ADMIN" ;
			}else if(selectedValue == 3){
				labelEle.innerHTML = "EMPLOYEE ";
			}else if(selectedValue == 4){
				labelEle.innerHTML = "ROLE";
			}else if(selectedValue == 5){
				labelEle.innerHTML = "HR";
			}

		} else {
			document.systemUserForm.userIdentificationNoTxt.disabled = true;
			document.getElementById("userIdentificationNo").style.display='none';
		}
	}
	

		
	// score the password
	function scorePassword(pass) {
	    var score = 0;
	    if (!pass)
	        return score;

	    // award every unique letter until 5 repetitions
	    var letters = new Object();
	    for (var i=0; i<pass.length; i++) {
	        letters[pass[i]] = (letters[pass[i]] || 0) + 1;
	        score += 4.0 / letters[pass[i]];
	    }

	    // bonus points for mixing it up
	    var variations = {
	        digits: /\d/.test(pass),
	        lower: /[a-z]/.test(pass),
	        upper: /[A-Z]/.test(pass),
	        nonWords: /\W/.test(pass),
	    }

	    variationCount = 0;
	    for (var check in variations) {
	        variationCount += (variations[check] == true) ? 1 : 0;
	    }
	    score += (variationCount -1) * 15;

	    return parseInt(score);
	}
	
	//Good passwords start to score around 60 or so, here's function to translate that in words:
	function checkPassStrength(pass) {
		
		if(pass.length>=8){
			var score = scorePassword(pass);
		    if (score >= 80)
		        return "strong|Strong";
		    if ((score < 80) &&( score >= 60))
		        return "good|Good";
		    if ((score < 60 )&&( score >= 30))
		        return "average|Average";
		    if (score < 30)
		        return "weak|Weak";
		}
	    return "tooshort|Too Short";
	}
	
	//rate and populate the password strenghBar
	function populateStrengthBar(pass){
		
			var bar = document.getElementById("strengthBar");
			var label = document.getElementById("strengthBarLabel");
			var div = document.getElementById("strengthBarLabeldiv");
			
		if(pass.length>0){
			var rate = checkPassStrength(pass);
			div.style.display = 'block';
			bar.className=rate.split('|')[0];
			label.innerText=rate.split('|')[1]; 
			label.textContent =rate.split('|')[1]; 
		}else{
			div.style.display = 'none';
		}
	}

</script>


<!-- css & js for tool tip -->
<link rel="stylesheet" href="resources/css/jquery.tooltip.css" type="text/css" />
<script type="text/javascript" src="resources/js/jquery-1.6.2.min.js"></script>
<script type="text/javascript" src="resources/js/jquery.tooltip.js"></script>
<script type="text/javascript">
  $j = jQuery.noConflict();
  $j(document).ready(function(){
    $j("input.item").tooltip();

  });
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
<div class="clearfix"></div>
<h1>System User Details</h1>

<br><br>


<div id="content_main">
<div class="box_border">
<form:form method="POST" commandName="userdetails" name="systemUserForm" action="createSystemUser.htm">

<form:input type="hidden" path="role_id" value="${userdetails.role_id}" />
		
		<form:input type="hidden" path="userid" value="${userdetails.userid}" />
		
		
		
		<label class="required_sign"> 
		<c:if test="${message != null}"> ${message} </c:if> </br>
		<c:if test="${userdetails != null}">
		<spring:bind path="userdetails.*">
			<c:if test="${not empty status.errorMessages}">
				<c:forEach var="error" items="${status.errorMessages}">
					<c:out value="${error}" escapeXml="false" />
					<br />
				</c:forEach>
			</c:if>
		</spring:bind>
		</c:if>
	</label> 
	
		
	
	
	<div class="row">
	<div class="frmlabellb">User Role:</div>
	<div class="frmvalue"><form:select path="type" 
		name="type" 
	            onchange="changeUserIdentificationNo(this.value);">
		<c:choose>	
		<c:when test="${userdetails.type != null}">
		
		         <form:option value="${userdetails.type}" selected="selected">
                        	${userdetails.type}
                        	
                        		</form:option>
                    </c:when>
                	
		<c:otherwise><form:options items="${userLevelList}" 
			 />
			 
			 </c:otherwise>
			 
			 </c:choose>
			
	</form:select></div>
	
	
	<div class="frmlabellb"><label>First Name:</label></div>
	<div class="frmvalue"><form:input path="firstname"
		name="firstname"  value="${userdetails.firstname }"/>
		
	</div>
	
	
	</div>
	<div class="row">
	<div class="frmlabellb"><label>User Name:</label></div>
	<div class="frmvalue"><form:input path="username" maxlength="45" value="${userdetails.username }"/>
	
	</div>
	
	
	<div class="frmlabellb"><label>Last Name:</label></div>
	<div class="frmvalue"><form:input path="lastname" maxlength="45"
		name="lastname"  value="${userdetails.lastname }"/>
		
		
	</div>
	
	
	
	
	
	</div>
	
	<div class="row">
	<div class="frmlabellb"><label>Password:</label></div>
		
		<div class="frmvalue">
			
			
			<div >
			<form:password path="userpass"
			maxlength="45" name="userpass" value="" onchange="populateStrengthBar(this.value)" onkeyup="populateStrengthBar(this.value)" class="item"/>
			
			
			
				<div class="tooltip_description" style="display: none">
					<div align="left" style="font-weight:bold;" >To secure your password:</div>
					<div id="toolpipText">
		                                    <ul  >
						<li> - Use both letters and numbers</li>
						<li> - Add special characters (such as $, &, ?)</li>
						<li> - Mix uppercase and lowercase letters</li>
					</ul>
		        	</div>
				</div>
       	 	</div>
		</div>
		
		
		
		
		<div class="frmlabellb"><label>Email Adress:</label></div>
	<div class="frmvalue"><form:input path="email" maxlength="45"
		name="email" value="${userdetails.email }" />
		
			
		
		</div>
	
			</div>
	
	
	<div class="row">
	<div class="frmlabellb"><label>Confirm Password:</label></div>
		
	<div class="frmvalue">
		<input type="password" name="confirmPassword" maxlength="45" value="" onpaste="return false">
	</div>
	
		<div class="frmlabellb"><label>Employee ID:</label></div>
		
	<div class="frmvalue">
		<form:input path="empid" maxlength="45"
		name="empid" value="${userdetails.empid }" />
		
		</div>
	</div>
	
	<br>
	
	
	
		<div class="row" id="strengthBarLabeldiv" style="display: none; ">
	         <div class="frmlabel"> </div>
	         <div class="frmvalue">
	          <div class="passwordrow">
	          <div class="strengthBar">
	          <div id="strengthBar" class="average"></div></div> 
	          <div class="clearfix"></div>
	          <div>
	          	<strong>Password strength:</strong>
	          	 <span id="strengthBarLabel"></span>
	          </div>
	         	</div>
	         </div>
     	</div>
	
	
		<br><br><br>
		
	<div class="button_row">
	<div class="buttion_bar_type2">
	
	
	<input type="button"
		class="button"
		onClick="${userDetail.userLoginId!=0?'reSet2(this)':'reSet(this)'}"
		value="Reset" id="reset"> <input
		type="button" value="Save"
		onclick="submitUser()"
		class="button"> <input type="button"
		value="Cancel" class="button"
		onClick="cancel(this)">
	
		
		
		</div>
	
</div>

	<br>
	<br>
	
	
	<div class="clearfix"></div>
	
	  
		
	</form:form>

</div>	
</div>
</div>


<%-- <h:footer /> --%>
 <%@ include file="/WEB-INF/templates/footer.jsp" %>
</body>
</html>