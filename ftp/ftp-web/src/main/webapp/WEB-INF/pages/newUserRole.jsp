<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>Avalon HRMS</title>
	
<link href="resources/css/css_reset.css" rel="stylesheet" type="text/css">
<link href="resources/css/theme.css" rel="stylesheet" type="text/css">
<link href="resources/css/ui.dynatree.css" rel="stylesheet" type="text/css">
<link href="resources/css/main_style.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="resources/js/main.js"></script>
<script type="text/javascript" src="resources/js/shortcuts.js"></script>
<script type="text/javascript" src="resources/js/jquery-1.6.2.min.js"></script>



<script language="javascript" type="text/javascript" >



var roleIdList=new Array();

i=0;
$(function() {
	$('#cbox').click(function(e){
   $('input[type="checkbox"]:checked').each(function(){       
	   roleIdList[i++] = (this.value);	   
	   
   }) ;  
   
   document.userRoleForm.roleList.value=roleIdList;
	document.userRoleForm.action='saveOrUpdateUserRole.html';
	document.userRoleForm.submit();
  
});



});


function submitData(){

		
	}

function resetForm(){
	
		document.userRoleForm.action='newUserRoleDetails.html';
		document.userRoleForm.submit();
	
	
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
  <h1>User Role Details</h1>
  <div id="content_main">
			<form:form method="GET" modelAttribute="userRole" action=""
				name="userRoleForm">
				
					<div class="section_box">
			        <div class="section_box_header">
			          <h2>User Role</h2>
			        </div>
			        <label class="success_sign">
			         <c:if test="${success_message != null}"> <c:out value="${success_message}" escapeXml="false" />
			        </c:if>
			        </label>
			        <label class="required_sign">
			        <c:if test="${message != null}"> <c:out value="${message}" escapeXml="false" />
			        </c:if> </br>
			        <c:if test="${userRole!=null}">
			       </c:if>			
					</label>
						
			        <div class="column">
                              <div class="row">
                                  <div class="float_left">
                                      <div class="frmlabellb">
                                         <label>Role Name</label>
                                    </div>
                                    <div class="frmvalue">
                                          <form:input path="role" maxlength="20" value="${role}"/>
                                    </div>
                               
                                    <div class="frmlabel">
                                          <label>Description</label>
                                    </div>
                                    <div class="frmvalue">
                                        <textarea name="description" cols="15" rows="2" maxlength="100"> ${desc} </textarea>
                                      </div>
                                </div>
                              </div>
                        </div>
					 
					        <div class="clearfix"></div>
					 
					        <div class="column_single">
					          <div class="row">
					            <div class="frmlabel">
					              <label> Assign Role Privileges</label>
					            </div> <br>
					            <div class="float_left">	
						            <!--show tabs -->
					                <ul>
					                					                
					                					                
					                <c:if test="${!empty privilege}"> 		             
					                
						            <c:forEach items="${privilege}" var="privilege">
						            
						               <c:if test="${!empty privilegeIdList}"> 	
						               
						              <c:set var="temporary" value ="true"/> 	             
					                
					                 <c:forEach items="${privilegeIdList}" var="privilegeid">
					                                         
					                 	 	      <c:choose>
					                 	      				                 	      
							            		<c:when test="${privilege.privilegeId  == privilegeid.privilegeId}">						            		 
							            		 						            		  
							            		<input type="checkbox"  name="${privilege.privilegeId}"  value="${privilege.privilegeId}"  checked/>
							            		    		
							            		<c:set var="temporary" value="false"/>
							            		</c:when>
							            		
							            		<c:otherwise>
							            		
							            		 <c:set var="found" value="false"/>
							            		  <c:if test="${temporary eq 'true'}"> 
							            		  
							            		             <c:forEach items="${privilegeIdList}" var="privilegeid">							            		   							            		 
                                                               <c:if  test="${privilege.privilegeId  == privilegeid.privilegeId}">
                                                                <c:set var="found" value="true"/>
                                                                 </c:if>
                                                               </c:forEach>
							            		   
							            		   
							            		 <c:if test="${found eq 'false'}">
							            		   
							            		<input type="checkbox"  name="${privilege.privilegeId}"  value="${privilege.privilegeId}" />
							            		
							            		<c:set var="temporary" value="false"/>
							            		
							            		</c:if>
							            							            		
							            		
							            		
							            		 </c:if>
							            		
							            		</c:otherwise>
							            		
							            		
							            		</c:choose>	
							            		
							            		            			            		
							            	       
						            </c:forEach>           
						           						            	
						               <c:out value="${privilege.privilegeId}"/> 					                  
						                          <c:out value="${privilege.name}"/><br>
						                          
						                         
						                          
						                    </c:if>        
						                           <c:if test="${empty privilegeIdList}">
						                           						                           
						                           <input type="checkbox"  name="${privilege.privilegeId}" value="${privilege.privilegeId}"  />
						                           
						                            <c:out value="${privilege.privilegeId}"/> 
						              
						                  
						                          <c:out value="${privilege.name}"/><br>
						          
						                           
						                           </c:if>
						                         		
							          
						               
						              </c:forEach>
			   
					            </c:if>
					            
					            </ul>
					            </div>
					           
			        <br>
			        <div class="clearfix"></div>
			      </div>
			 
			      <div class="clearfix"></div>
			      
				      <div class="button_row">
				        <div class="buttion_bar_type2">
				          <sec:authorize access="hasRole('MANAGEROLE')">
				      		
					  	      <input value="Reset" class="button" onclick="resetForm()" type="reset">
					          <input value="Save"  id='cbox' class="button"  type="button">
					  	      <input value="Cancel" class="button" onclick="window.location='manageUserRoles.htm'" type="button">
			      			
				        </sec:authorize>
				        </div>
				        <div class="clearfix">
				        
				        
				        </div>
				        
				        <input type="hidden" name="roleList">
				      </div>
			      <div class="clearfix"></div>
			      					</form:form>
		</div>
	</div>
	
	
</body>

<%-- <h:footer /> --%>
 <%@ include file="/WEB-INF/templates/footer.jsp" %>
</html>
						              
						             
					       