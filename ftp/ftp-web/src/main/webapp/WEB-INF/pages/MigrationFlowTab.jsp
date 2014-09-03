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

	function onMigrationFlow() {
		document.Form.action = "migrationtab.html";
		document.Form.submit();
	}

	function onPersonalization() {
		document.Form.action = "personalizationtab.html";
		document.Form.submit();
	}
	function onSaveMigration() {
		alert("clicked on New button..savemigration.html")
		document.Form.action = "savemigration.html";
		document.Form.submit();
	}
	
	
	function onSearchMigrationFlow(){
		alert("clicked on Search button..searchmigrationflowbyname.html")
		document.Form.action = "searchmigrationflowbyname.html";
		document.Form.submit();
	}
</script>
</head>

<body>
	<%-- <h:header /> --%>
	 <%@ include file="/WEB-INF/templates/header.jsp" %> 
	<div id="page_container">

		<form:form method="post" modelAttribute="migrationFlowBean" name="Form">
	<label class="required_sign"></label> 
		<label class="required_sign">
			<c:if test="${migrationStatus != null}">
	      				${migrationStatus}
	     	</c:if>
	     </label>	
	
	<label class="required_sign"></label> 
		<label class="required_sign">
			<c:if test="${migrationFlowStatus != null}">
	      				${migrationFlowStatus}
	     	</c:if>
	     </label>	
	
	
			<div class="row">

				<div class="float_left" style="margin: 15px 0 5px 0;"></div>
				<div class="clearfix"></div>

				<div class="box_border">

					<table>

						<tr>
							<td>
								<div class="box_border"
									style="margin: 23px 10px 0 0; background-image: none;">
									<!-- <div class="row">
										<input type="button" id="address" value='Users'
											onclick='onUsers()' class="button" />
									</div> -->
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


								</div>
							</td>
							<td>
								<!-- added by murali --> <!-- start -->

								<div class="row"></div>
								<div class="row"></div>
								<div class="row">


									<div class="row">
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;


										<input type="button" value='Migration Flow' class="button" />



									</div>
								</div> <br> <br>



								<div class="row"></div> <!-- end -->
								<div class="row">



									<div class="frmlabel">
										<label id="jmigrationflowname" for="j_migrationflowname">MigrationFlow Name</label>
									</div>
									<%-- <div class="frmvaluee">
										<form:input path="migrationflowname" id="migrationflowname" />

									</div> --%>
									<div class="frmvaluee">
										<form:select path="migrationflowname" cssClass="a_field1">
										<form:option value="0" label="<--Select Migration Flow Name-->" />
											<%-- <form:options items="${migrationFlowNames}"
												itemValue="migId" itemLabel="migrationflowname" /> --%>
												<form:options items="${migrationFlowNames}"
												itemValue="migrationflowname" itemLabel="migrationflowname" />
												
										</form:select>

									</div>

									<div class="frmlabel">
										<label id="jsequence" for="j_sequence">Sequence</label>
									</div>
									<div class="frmvaluee">
										<form:input path="sequence" id="sequence" />

									</div>


								</div>



								<div class="row">


									<div class="frmlabel">
										<label id="jinstanceid" for="j_instanceid">Instance ID</label>
									</div>
									<div class="frmvaluee">
										<form:input path="instanceid" id="instanceid" />

									</div>

									<div class="frmlabel">
										<label id="jqppreq" for="j_appreq">Approval Reqd</label>
									</div>
									<div class="frmvaluee">
										<form:input path="appreq" id="appreq" />

									</div>


								</div>


								<div class="row"></div>
								<div class="row"></div>
								<div class="row">


									<div class="row">
										<div class="frmlabel">
											<label id="jmigrationflow" for="j_migrationflow">Migration
												Flow</label>
										</div>
										<div class="frmvaluee">
											<form:input path="migrationflow" id="migrationflow" />
										</div>


										<div class="row">
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										</div>
										<div class="row">
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;


											<input type="button" value='Search'
												onclick='onSearchMigrationFlow()' class="button" /> 
											<input
												type="button" value='Save' onclick='onSaveMigration()'
												class="button" /> 
											<input type="button" value='Details'
												onclick='onDetails()' class="button" />
										</div>




									</div>
								</div> <!-- Commented by murali --> <!--  <br><br>
                   <br><br>
                   <br><br>
                 --> <!-- Commented by murali --> <!--  <div class="row"> 
                 
                 
                     <div class="row">                 
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                 <input  type="button" value='Search' onclick='onPersonalization()' class="button"/>              
                   <input  type="button" value='New'  onclick='onConfiguration()' class="button"/>  
                  <input  type="button" value='Details' onclick='onDetails()' class="button"/>              
                               
                              
                   </div>                   
                                 
                   <br><br>
                   <br><br>         	  
                 
               
                 
                  
                </div>     --> <!--   </div> -->
							</td>
						</tr>

					</table>
				</div>

				<br> <br> <br> <br>
			</div>
		</form:form>


	</div>

	<br>
	<br>

<%-- 	<h:footer /> --%>
 <%@ include file="/WEB-INF/templates/footer.jsp" %> 
</body>
</html>


