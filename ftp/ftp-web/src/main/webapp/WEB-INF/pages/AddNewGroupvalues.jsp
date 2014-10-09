<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>

<title>Approve</title>
<link href="resources/css/css_reset.css" rel="stylesheet"
	type="text/css">
<link href="resources/css/main_style.css" rel="stylesheet"
	type="text/css">
<link href="resources/css/theme.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="resources/js/main.js"></script>
<script type="text/javascript" src="resources/js/shortcuts.js"></script>
<script type="text/javascript" src="resources/js/jquery-1.6.2.min.js"></script>
<script src="resources/js/jquery.ui.datepicker.min.js"></script>
<link href="resources/css/jquery.ui.datepicker.css" rel="stylesheet"
	type="text/css">
<script src="resources/js/jquery.ui.widget.min.js"></script>

<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<!--  <link rel="stylesheet" href="/resources/demos/style.css" />  -->


<style>
.error {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
<script>
	 function onUsers() {
		document.Form.action = "usertab.html";
		document.Form.submit();
	}
	function onDeployment() {
		document.Form.action = "deploymenttab.html";
		document.Form.submit();
	}

	function onConfiguration() {
		document.Form.action = "configtab.html";
		document.Form.submit();
	}

	function onMigrationFlow() {alert("MigrationFlow button clicked....calling ..migrationtab.html");
		
		document.Form.action = "migrationtab.html";
		document.Form.submit();
	}

	function onPersonalization() {
		document.Form.action = "personalizationtab.html";
		document.Form.submit();
	}
	function onSaveDeployment() {
		alert("New button clicked....calling ..savedeployment.html");
		document.Form.action = "savedeployment.html";
		document.Form.submit();
	}
	
	function onSearchDeployment() {
		alert("Searched button clicked....calling ..searchdeployment.html");
		document.Form.action = "searchdeployment.html";
		document.Form.submit();
	} 
	/* Groupvalues related functions */
	function onSaveGroupValue() {
		alert("Save button clicked....calling ..addNewGroupValues.html");
		document.Form.action = "addNewGroupValues.html";
		document.Form.submit();
	}
	function onSearchGroupValue(){
		alert("Search button clicked....calling ..SearchGroupValues.html");
		document.Form.action = "SearchGroupValues.html";
		document.Form.submit();
	}
	function onUpdateGroupValue(){
		alert("Search button clicked....calling ..updateGroupValues.html");
		document.Form.action = "updateGroupValues.html";  
		/* document.Form.action = "updateNewMigrationFlow?migrationFlowId=${migflow.migrationFlowId}"; */
		document.Form.submit();
	}
	
</script>
</head>

<body>
	<%@ include file="/WEB-INF/templates/header.jsp"%>
	<div id="page_container">

		<form:form modelAttribute="groupMetaBean" method="post"  name="Form">
		
		
		<label class="required_sign"></label> 
		<label class="required_sign">
			<c:if test="${groupId != null}">
	      				${groupId}
	     	</c:if>
	     </label>	 					
		<label class="required_sign"></label> 
		<label class="required_sign">
			<c:if test="${groupMetaBeanID != null}">
	      				${groupMetaBeanID}
	     	</c:if>
	     </label>
	     <label class="required_sign"></label> 
		<label class="required_sign">
			<c:if test="${updatedgroupId != null}">
	      				${updatedgroupId}
	     	</c:if>
	     </label>	
	     
		
			<div class="row">

				<div class="float_left" style="margin: 15px 0 5px 0;"></div>
				<div class="clearfix"></div>

				<div class="box_border">

					<table>

						<tr>
							<td>
								<!-- <div class="box_border"
									style="margin: 23px 10px 0 0; background-image: none;">
									<div class="row">
										<input type="button" id="address" value='Users'
											onclick='onUsers()' class="button" />
									</div>
									<div class="row">
										<input type="button" value='Deployment Env'
											onclick='onDeployment()' class="button" />
									</div>
									<div class="row">
										<input type="button" value='Migrationflow'
											onclick='onMigrationFlow()' class="button" />
									</div>
									<div class="row">
										<input type="button" value='Personalization'
											onclick='onPersonalization()' class="button" />
									</div>
									<div class="row">
										<input type="button" value='Configuration'
											onclick='onConfiguration()' class="button" />
									</div>


								</div> -->
								<div class="box_border" style="margin:23px 10px 0 0; background-image:none; "> 	     
                 <div class="row">                           
                  <input type="button" id="address" value='           Users          ' onclick='onUsers()' class="button"/>               
                 </div>                   
                  <div class="row">               
                  <input type="button" value='  Deployment Env  ' onclick='onDeployment()'  class="button"/>                  
                  </div>                  
                 <div class="row">                 
                 <input  type="button" value='    Migrationflow    ' onclick='onMigrationFlow()' class="button"/>              
                  </div>                    
                 <div class="row">                 
                  <input  type="button" value='   Personalization  ' onclick='onPersonalization()' class="button"/>              
                   </div>                   
                  <div class="row">                 
                  <input  type="button" value='    Configuration    '  onclick='onConfiguration()' class="button"/>              
                  </div> 
                                   
                    
        </div>
							</td>
							<td>

								<div class="row"></div>
								<div class="row"></div>
								<div class="row">


									<div class="row">
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

<!-- 
										<input type="button" value='Environment Details'
											onclick='onPersonalization()' class="button" />
 -->


									</div>
								</div> <br>
							<br>



								<div class="row">


									
									
									<!--this div added newly 8/7/2014 -->
									<div class="frmvaluee">
									<form:hidden path="groupMetaId"/>
									</div>
									
									<div class="frmlabel">
										<label id="jgroup" for="j_group">Enter GroupValues</label>
									</div>
									<div class="frmvaluee">
										<form:input path="groupName" id="groupName" name="groupName"/>
										<form:errors path="groupName" class="required_sign" />
									</div>
								</div>
									<div class="row"></div>

									<br>
									<br>

									<div class="row">
										<!--&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;-->&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="button" value='Save' onclick='onSaveGroupValue()' class="button" /> 
							<input type="button" value='search' onclick='onSearchGroupValue()' class="button" />
							<input type="button" value='Update' onclick='onUpdateGroupValue()' class="button" />		
									</div>



							</td>
						</tr>

					</table>
				</div>

				<br>
				<br> <br> <br>
		

	</div>

	<br>
	<br>
</form:form>

	<%@ include file="/WEB-INF/templates/footer.jsp"%>
</div>
</body>
</html>


