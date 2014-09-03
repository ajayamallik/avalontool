	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<html>
	<head>
	
	<title>Approve Form</title>
	<link href="resources/css/css_reset.css" rel="stylesheet" type="text/css">
	<link href="resources/css/main_style.css" rel="stylesheet" type="text/css">
	<link href="resources/css/theme.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="resources/js/main.js"></script>
	<script type="text/javascript" src="resources/js/shortcuts.js"></script>
	<script type="text/javascript" src="resources/js/jquery-1.6.2.min.js"></script>
	<script src="resources/js/jquery.ui.datepicker.min.js"></script>
	<link href="resources/css/jquery.ui.datepicker.css" rel="stylesheet"
		type="text/css">
	<script src="resources/js/jquery.ui.widget.min.js"></script>
	
	<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
	<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
	<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
	 <!--  <link rel="stylesheet" href="/resources/demos/style.css" />  -->
	
	
	<style>
	.error {
		color: #ff0000;
	}
	 
	.errorblock {s
		color: #000;
		background-color: #ffEEEE;
		border: 3px solid #ff0000;
		padding: 8px;
		margin: 16px;
	}
	</style>
	<script>
	/* murali writting this */
	  /* $(document).ready(function(){
	    $('#requestType').change(function() {
	    alert($("#requestType option:selected").text());
	  });  
	}); */
	
	  
		    	
	
	/* $(document).ready(function(){
		  $('#requestType').change(function(){
		    alert("The text has been changed.");
		  });
		}); */
	 
	 function getInstanceValues(myOb){
		//alert("this is getInstanceValues()....");	
		var e = document.getElementById("requestType");
		var requestType = e.options[e.selectedIndex].value;
		//alert("The requestType is:"+requestType);
			$.ajax({
					url:'getInstanceNames',  //ApprovalController
					success:function(result){
										//alert("The InstanceName"+result.instanceDetails);
										splitAjaxData(result.instanceDetails,requestType);										
										}
					
			});  //ajax end
	}  // function end
	
	
function splitAjaxData(envList,requestType){

	document.getElementById("instanceNames").innerHTML = "";
		for(var i=0;i<envList.length;i++)
			{
			add(requestType,envList[i],i);							
			}			
	}	

//To add Radio Buttons dynamically
function add(type,name,i) {
	
    //Create an input type dynamically.
    var element = document.createElement("input");
			if(type == "upload") {
				obj = "checkbox";
				document.getElementById('reqtype').value ="U";
			}
			else if(type =="download"){
				obj = "radio";
				document.getElementById('reqtype').value ="D";
			}
			else if(type == "0"){
			document.getElementById("instanceNames").innerHTML = "";
			return 0;
			}
				
			//Assign different attributes to the element.
			element.setAttribute('type', obj);
			element.setAttribute('value', name);
			element.setAttribute('name',"instance"); 
			element.setAttribute('id', name);
	
			/*creating label for Text to Radio button*/
			var lblYes = document.createElement("label");
			/*create text node for label Text which display for Radio button*/
			var textYes = document.createTextNode(name);
			/*add text to new create lable*/
			lblYes.appendChild(textYes);
	 
			var foo = document.getElementById("instanceNames"); //span id to place radio buttons
 
				if(i%2 == 0 && i!= 0){
					var br = document.createElement("br");
					foo.appendChild(br);
				}
				
			//Append the element in page (in span).
			foo.appendChild(element);
			foo.appendChild(lblYes);	

}			
		
	
	
	$(function() {
	
		var date = new Date();
		var currentMonth = date.getMonth();
		var currentDate = date.getDate();
		var currentYear = date.getFullYear();
	
	$('#createdOnDatePicker')
	.datepicker(
			{
				defaultDate : "+1w",
				yearRange : "-75:+0",
				changeYear : true,
				changeMonth : true,
				numberOfMonths : 1,
				showOn : "button",
				dateFormat : 'yy-mm-dd',
				buttonImage : "resources/images/calendar.jpg",
				buttonImageOnly : true,
				maxDate : new Date(currentYear, currentMonth,
						currentDate),
				onSelect : function(selectedDate) {
							instance = $(this).data("datepicker"),
							date = $.datepicker
									.parseDate(
											instance.settings.dateFormat
													|| $.datepicker._defaults.dateFormat,
											selectedDate,
											instance.settings);
					
				}
			});
			
	
	});
	
	$(function(){
	    $('#approval').click(function() {	   
	    	
	    	//var valRadio = $('input[type="radio"]:checked').val();
	    	//var valChk = $('input[type="checkbox"]:checked').val();
	    	selValue = $("input[name='instance']:checked").map(
	    		    function () {return this.value;}).get().join(",");
	    			document.getElementById("selectedinstances").value = selValue ;
	    			alert(document.getElementById("selectedinstances").value);
	    			document.Form.action = "submitforApproval.html";	
	    			document.Form.submit();   	
	   
	    	});
	    
	    
	    
	    
	    $(window).load(function(){
	    	$(document).ready(function () {
	    	 var counter = 1;
	    	$("#addButton1").click(function () {
	    	            if (counter > 10) {
	    	                alert("Only 10 lines are allowed");
	    	                return false;
	    	            }
	    	            $('<div/>',{'id':'TextBoxDiv' + counter}).html(
	    	              $('<label/>').html(  )
	    	            )
	    	              .append( $( '<div class="frmvaluee"><input type="text"></div>').attr({'id':'objecttype' + counter,'name':'aprovalRequest['+counter+'].objecttype'}) )
	    	              .append( $('<div class="frmvaluee"><input type="text"></div>').attr({'id':'filename' + counter,'name':'aprovalRequest['+counter+'].filename'}) )
	    	              .append( $('<div class="frmvaluee"><input type="text"></div>').attr({'id':'appshortname' + counter,'name':'aprovalRequest['+counter+'].appshortname'}) )
	    	              .append( $('<div class="frmvaluee"><input type="text"></div>').attr({'id':'path' + counter,'name':'aprovalRequest['+counter+'].path'}) )
	    	            .appendTo( '#TextBoxesGroup' );      
	    	            counter++;
	    	            alert("-=-=-="+counter);
	    	        });
	    	 
	    	        $("#removeButton").click(function () {
	    	            if (counter == 1) {
	    	                alert("No more textbox to remove");
	    	                return false;
	    	            }
	    	            counter--;
	    	            $("#TextBoxDiv" + counter).remove();
	    	        });
	    	});
	    	});
	
	
	});
	
	
	</script>
	
	<script tpe="text/javascript">
	<!-- script to add dynamic text boxes -->
	function addRowToTable()
	{
	  var table = document.getElementById('mytable');  
	  var rowCount = table.rows.length;
	  var row = table.insertRow(rowCount);
	  
	 
	 var cell1 = row.insertCell(0);
	 var element1 = document.createElement("input");
	 element1.type = "text";
	 var length=(table.rows.length)-1;	
	 element1.name = "aprovalRequest["+length+"].objecttype";
	 element1.setAttribute("id", "objecttype" +length); 
	 element1.setAttribute("class","frmvaluee");
	 cell1.appendChild(element1);
	 
	 var cell2 = row.insertCell(1);
	 var element2 = document.createElement("input");
	 element2.type = "text";
	 var length=(table.rows.length)-1;	
	 element2.name = "aprovalRequest["+length+"].filename";
	 element2.setAttribute("id", "filename" +length); 
	 element2.setAttribute("class","frmvaluee");
	 cell2.appendChild(element2);
	
	 var cell3 = row.insertCell(2);
	 var element3 = document.createElement("input");
	 element3.type = "text";
	 var length=(table.rows.length)-1;	
	 element3.name = "aprovalRequest["+length+"].appshortname";
	 element3.setAttribute("id", "appshortname" +length); 
	 element3.setAttribute("class","frmvaluee");
	 cell3.appendChild(element3);
	 
	 var cell4 = row.insertCell(3);
	 var element4 = document.createElement("input");
	 element4.type = "text";
	 var length=(table.rows.length)-1;	
	 element4.name = "aprovalRequest["+length+"].path";
	 element4.setAttribute("id", "path" +length); 
	 element4.setAttribute("class","frmvaluee");
	 cell4.appendChild(element4);
	 
	 var cell5 = row.insertCell(4);
	 var element5 = document.createElement("input");
	 element5.type = "hidden";
	 var length=(table.rows.length)-1;	
	 element5.name = "aprovalRequest["+length+"].lobcode";
	 element5.setAttribute("id", "lobcode" +length); 
	 element5.setAttribute("class","frmvaluee");
	 cell5.appendChild(element5);
	 
	 var cell6 = row.insertCell(5);
	 var element6 = document.createElement("input");
	 element6.type = "hidden";
	 var length=(table.rows.length)-1;	
	 element6.name = "aprovalRequest["+length+"].language";
	 element6.setAttribute("id", "language" +length); 
	 element6.setAttribute("class","frmvaluee");
	 cell6.appendChild(element6);
	 
	 var cell7 = row.insertCell(6);
	 var element7 = document.createElement("input");
	 element7.type = "hidden";
	 var length=(table.rows.length)-1;	
	 element7.name = "aprovalRequest["+length+"].territory";
	 element7.setAttribute("id", "territory" +length); 
	 element7.setAttribute("class","frmvaluee");
	 cell7.appendChild(element7);
	 
	 var cell8 = row.insertCell(7);
	 var element8 = document.createElement("input");
	 element8.type = "hidden";
	 var length=(table.rows.length)-1;	
	 element8.name = "aprovalRequest["+length+"].execasapps";
	 element8.setAttribute("id", "execasapps" +length); 
	 element8.setAttribute("class","frmvaluee");
	 cell8.appendChild(element8);
	 
	 var cell9 = row.insertCell(8);
	 var element9 = document.createElement("input");
	 element9.type = "hidden";
	 var length=(table.rows.length)-1;	
	 element9.name = "aprovalRequest["+length+"].targetpath";
	 element9.setAttribute("id", "targetpath" +length); 
	 element9.setAttribute("class","frmvaluee");
	 cell9.appendChild(element9);
	 
	 var cell10 = row.insertCell(9);
	 var element10 = document.createElement("input");
	 element10.type = "hidden";
	 var length=(table.rows.length)-1;	
	 element10.name = "aprovalRequest["+length+"].businessevent";
	 element10.setAttribute("id", "businessevent" +length); 
	 element10.setAttribute("class","frmvaluee");
	 cell10.appendChild(element10);
	 
	 var cell11 = row.insertCell(10);
	 var element11 = document.createElement("input");
	 element11.type = "hidden";
	 var length=(table.rows.length)-1;	
	 element11.name = "aprovalRequest["+length+"].cntrlfilename";
	 element11.setAttribute("id", "cntrlfilename" +length); 
	 element11.setAttribute("class","frmvaluee");
	 cell11.appendChild(element11);
	 
	 
	 var cell12 = row.insertCell(11);
	 var element12 = document.createElement("img");
	 element12.src = "resources/images/ico_delete.gif"	;
	 
	 
	 element12.onclick = function() {
		 								deleteRow(this) // this is how to make it work
									}
	 
	 var length=(table.rows.length)-1;	
	 element12.name = "aprovalRequest["+length+"].cntrlfilename";
	 
	 cell12.appendChild(element12);
	 
	 
	 return length;
	}
	
	function deleteRow(t)
	{
	    var row = t.parentNode.parentNode;
	    document.getElementById("mytable").deleteRow(row.rowIndex);
	    console.log(row);
	}
	
	
	</script>
	
	<!--  test for JQURY UI  -->
	<script type="text/javascript">
	
	var flag = 0;
	function showDialog()
	{
	    $("#dialog-modal").attr("title", "Enter Details").dialog(
	    {
	        width: 950,
	        height: 300,
	        
	        open: function(event, ui)
	        {
	            var textarea = $('<textarea style="height: 276px;">');
	            
	            $(textarea).redactor({
	                focus: true,
	                autoresize: false,
	                initCallback: function()
	                {
	                    this.set('<p>Lorem...</p>');
	                }
	            });
	        }
	     });
	}
	
	
	
	function insertinRow(){	
		if(flag == 0){
			//alert("-=-=-=if part"+flag);
			selectopt = document.getElementById('objecttype');
			document.getElementById('objecttype0').value = selectopt.options[selectopt.selectedIndex].text;	
			document.getElementById('filename0').value = document.getElementById('filename').value;	
			document.getElementById('appshortname0').value = document.getElementById('shortname').value;
			document.getElementById('path0').value = document.getElementById('path').value;	
			
			document.getElementById('lobcode0').value = document.getElementById('lobcode').value;
			document.getElementById('language0').value = document.getElementById('language').value;
			document.getElementById('territory0').value = document.getElementById('territory').value;
			document.getElementById('execasapps0').value = document.getElementById('execasapps').value;
			document.getElementById('targetpath0').value = document.getElementById('targetpath').value;
			document.getElementById('businessevent0').value = document.getElementById('busievent').value;
			document.getElementById('cntrlfilename0').value = document.getElementById('cntrlfilename').value;
			//alert('insert succesfull ');
			flag++;
			//alert("flag incremented "+ flag)
			
		}else{
			
			//alert("-=-=-=-= else part"+flag);
			var k = addRowToTable();
			selectopt = document.getElementById('objecttype');
			document.getElementById('objecttype'+k).value = selectopt.options[selectopt.selectedIndex].text;	
			document.getElementById('filename'+k).value = document.getElementById('filename').value;	
			document.getElementById('appshortname'+k).value = document.getElementById('shortname').value;
			document.getElementById('path'+k).value = document.getElementById('path').value;	
			
			document.getElementById('lobcode'+k).value = document.getElementById('lobcode').value;
			document.getElementById('language'+k).value = document.getElementById('language').value;
			document.getElementById('territory'+k).value = document.getElementById('territory').value;
			document.getElementById('execasapps'+k).value = document.getElementById('execasapps').value;
			document.getElementById('targetpath'+k).value = document.getElementById('targetpath').value;
			document.getElementById('businessevent'+k).value = document.getElementById('busievent').value;
			document.getElementById('cntrlfilename'+k).value = document.getElementById('cntrlfilename').value;
			//alert('insert succesfull ');
		}	
		
		$('#dialog-modal').dialog('close');
	}
	
	</script>
	
	
	<script>
	
	$(function(){		
	
	    $('#businessevents').click(function() {
	 
	    	 $('#filename').show(); 
	    	 $('#shortname').show();
	    	 $('#path').show();
	    	 $('#lobcode').hide();
	    	 $('#language').hide();
	    	 $('#territory').hide(); 
	    	 $('#execasapps').hide();    	 
	    	 $('#targetpath').hide();    	 
	    	 $('#busievent').show();    	 
	    	 $('#cntrlfilename').hide();
	
	    	 
	    	 
	    	 $('#jfilename').show();
	    	 $('#jshortname').show();
	    	 $('#jpath').show();
	    	 $('#jlobcode').hide();
	    	 $('#jlanguage').hide();    	 
	    	 $('#jterritory').hide(); 
	    	 $('#jexecasapps').hide();    	 
	    	 $('#jtargetpath').hide();    	 
	         $('#jbusievent').show();    	 
	    	 $('#jcntrlfilename').hide();
	    	
	    	});
	    
	    
	    $('#oracleforms').click(function() {
	    	
	   	 $('#filename').show(); 
	   	 $('#shortname').show();
	   	 $('#path').show();
	   	 $('#lobcode').hide();
	   	 $('#language').hide();
	   	 $('#territory').hide(); 
	   	 $('#execasapps').hide();    	 
	   	 $('#targetpath').hide();    	 
	   	 $('#busievent').hide();    	 
	   	 $('#cntrlfilename').hide();
	
	   	 
	   	 $('#jfilename').show();
	   	 $('#jshortname').show();
	   	 $('#jpath').show();
	   	 $('#jlobcode').hide();
	   	 $('#jlanguage').hide();    	 
	   	 $('#jterritory').hide(); 
	   	 $('#jexecasapps').hide();    	 
	   	 $('#jtargetpath').hide();    	 
	      $('#jbusievent').hide();    	 
	   	 $('#jcntrlfilename').hide();    	   	 
	   		
	  	});
	    
	    
	    
	    $('#oraclereports').click(function() {
	    	
	    	 $('#filename').show(); 
	    	 $('#shortname').show();
	    	 $('#path').show();
	    	 $('#lobcode').hide();
	    	 $('#language').hide();
	    	 $('#territory').hide(); 
	    	 $('#execasapps').hide();    	 
	    	 $('#targetpath').hide();    	 
	    	 $('#busievent').hide();    	 
	    	 $('#cntrlfilename').hide();
	
	    	 
	    	 $('#jfilename').show();
	    	 $('#jshortname').show();
	    	 $('#jpath').show();
	    	 $('#jlobcode').hide();
	    	 $('#jlanguage').hide();    	 
	    	 $('#jterritory').hide(); 
	    	 $('#jexecasapps').hide();    	 
	    	 $('#jtargetpath').hide();    	 
	         $('#jbusievent').hide();    	 
	    	 $('#jcntrlfilename').hide();
	    		   	
	      	
	      	});
	    
	    
	    $('#oafxml').click(function() {
	    	
	   	 $('#filename').show(); 
	   	 $('#shortname').show();
	   	 $('#path').show();
	   	 $('#lobcode').hide();
	   	 $('#language').hide();
	   	 $('#territory').hide(); 
	   	 $('#execasapps').hide();    	 
	   	 $('#targetpath').hide();    	 
	   	 $('#busievent').hide();    	 
	   	 $('#cntrlfilename').hide();
	
	   	 
	   	 $('#jfilename').show();
	   	 $('#jshortname').show();
	   	 $('#jpath').show();
	   	 $('#jlobcode').hide();
	   	 $('#jlanguage').hide();    	 
	   	 $('#jterritory').hide(); 
	   	 $('#jexecasapps').hide();    	 
	   	 $('#jtargetpath').hide();    	 
	      $('#jbusievent').hide();    	 
	   	 $('#jcntrlfilename').hide();
	   	   	  	
	  	
	  	});
	    
	    
	    $('#rtffiles').click(function() {
	    	
	   	 $('#filename').show(); 
	   	 $('#shortname').show();
	   	 $('#path').show();
	   	 $('#lobcode').show();
	   	 $('#language').show();
	   	 $('#territory').show(); 
	   	 $('#execasapps').hide();    	 
	   	 $('#targetpath').hide();    	 
	   	 $('#busievent').hide();    	 
	   	 $('#cntrlfilename').hide();
	
	   	 
	   	 $('#jfilename').show();
	   	 $('#jshortname').show();
	   	 $('#jpath').show();
	   	 $('#jlobcode').show();
	   	 $('#jlanguage').show();    	 
	   	 $('#jterritory').show(); 
	   	 $('#jexecasapps').hide();    	 
	   	 $('#jtargetpath').hide();    	 
	        $('#jbusievent').hide();    	 
	   	 $('#jcntrlfilename').hide();
	   	
	 	});
	    
	    
	    
	    $('#sqlplsql').click(function() {
	    	
	   	 $('#filename').show(); 
	   	 $('#shortname').show();
	   	 $('#path').show();
	   	 $('#lobcode').hide();
	   	 $('#language').hide();
	   	 $('#territory').hide(); 
	   	 $('#execasapps').show();    	 
	   	 $('#targetpath').hide();    	 
	   	 $('#busievent').hide();    	 
	   	 $('#cntrlfilename').hide();
	
	   	 
	   	 $('#jfilename').show();
	   	 $('#jshortname').show();
	   	 $('#jpath').show();
	   	 $('#jlobcode').hide();
	   	 $('#jlanguage').hide();    	 
	   	 $('#jterritory').hide(); 
	   	 $('#jexecasapps').show();    	 
	   	 $('#jtargetpath').hide();    	 
	        $('#jbusievent').hide();    	 
	   	 $('#jcntrlfilename').hide();
	   		   	  	
	 	
	 	});
	    
	    
	    $('#migration').click(function() {
	    	
	    	
	   	 $('#filename').show(); 
	   	 $('#shortname').show();
	   	 $('#path').show();
	   	 $('#lobcode').hide();
	   	 $('#language').hide();
	   	 $('#territory').hide(); 
	   	 $('#execasapps').hide();    	 
	   	 $('#targetpath').show();    	 
	   	 $('#busievent').hide();    	 
	   	 $('#cntrlfilename').hide();
	
	   	 
	   	 $('#jfilename').show();
	   	 $('#jshortname').show();
	   	 $('#jpath').show();
	   	 $('#jlobcode').hide();
	   	 $('#jlanguage').hide();    	 
	   	 $('#jterritory').hide(); 
	   	 $('#jexecasapps').hide();    	 
	   	 $('#jtargetpath').show();    	 
	        $('#jbusievent').hide();    	 
	   	 $('#jcntrlfilename').hide();
	   	
	 	});
	    
	    
	    
	    $('#workflow').click(function() {
	    	
	   	 $('#filename').show(); 
	   	 $('#shortname').show();
	   	 $('#path').show();
	   	 $('#lobcode').hide();
	   	 $('#language').hide();
	   	 $('#territory').hide(); 
	   	 $('#execasapps').hide();    	 
	   	 $('#targetpath').hide();    	 
	   	 $('#busievent').hide();    	 
	   	 $('#cntrlfilename').hide();
	
	   	 
	   	 $('#jfilename').show();
	   	 $('#jshortname').show();
	   	 $('#jpath').show();
	   	 $('#jlobcode').hide();
	   	 $('#jlanguage').hide();    	 
	   	 $('#jterritory').hide(); 
	   	 $('#jexecasapps').hide();    	 
	   	 $('#jtargetpath').hide();    	 
	        $('#jbusievent').hide();    	 
	   	 $('#jcntrlfilename').hide();
	   	   	  	
	 	
	 	});
	    
	    
	    $('#aolobject').click(function() {
	    	
	    	
	    	
	   	 $('#filename').show(); 
	   	 $('#shortname').show();
	   	 $('#path').show();
	   	 $('#lobcode').hide();
	   	 $('#language').hide();
	   	 $('#territory').hide(); 
	   	 $('#execasapps').hide();    	 
	   	 $('#targetpath').hide();    	 
	   	 $('#busievent').hide();    	 
	   	 $('#cntrlfilename').show();
	
	   	 
	   	 $('#jfilename').show();
	   	 $('#jshortname').show();
	   	 $('#jpath').show();
	   	 $('#jlobcode').hide();
	   	 $('#jlanguage').hide();    	 
	   	 $('#jterritory').hide(); 
	   	 $('#jexecasapps').hide();    	 
	   	 $('#jtargetpath').hide();    	 
	        $('#jbusievent').hide();    	 
	   	 $('#jcntrlfilename').show();
	   	
	 	});
	    
	    
	    $('#custompll').click(function() {
	    	
	   	 $('#filename').show(); 
	   	 $('#path').show();
	   	 $('#fromlocation').show();
	   	 $('#lobcode').hide();
	   	 $('#language').hide();
	   	 $('#territory').hide(); 
	   	 $('#execasapps').hide();    	 
	   	 $('#targetpath').hide();    	 
	   	 $('#busievent').hide();    	 
	   	 $('#cntrlfilename').hide();
	
	   	 
	   	 $('#jfilename').show();
	   	 $('#jshortname').show();
	   	 $('#jpath').show();
	   	 $('#jlobcode').hide();
	   	 $('#jlanguage').hide();    	 
	   	 $('#jterritory').hide(); 
	   	 $('#jexecasapps').hide();    	 
	   	 $('#jtargetpath').hide();    	 
	     $('#jbusievent').hide();    	 
	   	 $('#jcntrlfilename').hide();
	   		   	  	
	 	
	 	});
	    
	    
	    
	    
	});
	</script>
	</head>
	
	<body>
	
	<!-- <h:header/> -->
	 <%@ include file="/WEB-INF/templates/header.jsp" %> 
	<div id="page_container">
	
	<form:form method="post" modelAttribute="approvalBean" name="Form" action="submitforApproval">	
	<label class="required_sign"></label> 
		<label class="required_sign">
			<c:if test="${status != null}">
	      				${status}
	     	</c:if>
	     </label>	
	
	<div id="dialog-modal" title="Basic modal dialog" style="display: none;">
	 <div>
	            
	            <div class="row">
	            	<div class="frmlabel"> 
	           			<label for="terms">Object Type</label> 
	           		</div>
	           		<div class="frmvalue">
	           		<select name="objecttype" id="objecttype" cssClass="a_field2">
	  					<option value="0" id="selectobject">Select Object</option>              
	                     <option value="1" id="businessevents">Business Events</option>
	                     <option value="2" id="oracleforms">Oracle Forms</option>
	                     <option value="3" id="oraclereports">Oracle Reports</option>
	                      <option value="4" id="oafxml">OAF XML Import</option>
	                      <option value="5" id="rtffiles">RTF Files</option>
	                      <option value="6" id="sqlplsql">SQL/PL-SQL Scripts</option>
	                      <option value="7" id="migration">File Migration</option>
	                      <option value="8" id="workflow">Oracle Work flow</option>
	                      <option value="9" id="aolobject">AOL Object</option>
	                      <option value="10" id="custompll">Custom PLL</option>
					</select>
					</div>
				</div>
					
	
	           
	          <div class="row">    
	          		<div class="frmlabel">         
	           			<label for="terms" id="jfilename">File Name</label> 
	           		</div>			
	           		<div class="frmvalue">
	           			<input type="textbox" id="filename" 	value="">
	           		</div>
	           		<div class="frmlabel">
	           			<label for="terms" id="jpath">Path</label>
	           		</div> 
	           		<div class="frmvalue">
	           			<input type="file" id="path" value="">
	           		</div>
	          </div>
	          
	          	<div class="row">
	          		<div class="frmlabel">
	            		<label for="terms" id="jshortname">Short Name</label>
	            	</div>	
	            	<div class="frmvalue">
	            			<input type="textbox" id="shortname" 	value="">  
	            	</div>      
	            	<div class="frmlabel">    
	            		<label for="terms" id="jlobcode">LOB Code</label>	
	            	</div>			
	            	<div class="frmvalue">
	            		<input type="textbox" id="lobcode" 		value="">
	            	</div>
	           </div>  
	           <div class="row">    
	           		<div class="frmlabel">       
	            		<label for="terms" id="jlanguage">Language</label>	
	            	</div>
	            	<div class="frmvalue">
	            	    <input type="textbox" id="language" 	value="">
	            	</div>
	            	<div class="frmlabel">
	            		<label for="terms" id="jterritory">Territory</label>
	            	</div>	
	            	<div class="frmvalue">
	            		<input type="textbox" id="territory" 	value="">
	            	</div>
	            </div>
	            <div class="row">
	            	<div class="frmlabel">
	            		<label for="terms" id="jexecasapps">Execute As Apps</label>
	            	</div>
	            	<div class="frmvalue">
	            		<input type="textbox" id="execasapps" 	value="">
	            	</div>
	            	<div class="frmlabel">
	            		<label for="terms" id="jtargetpath">Target Path</label>
	            	</div>	
	            	<div class="frmvalue">
	            		<input type="textbox" id="targetpath" 	value="">
	            	</div>
	            </div>
	            <div class="row">
	            	<div class="frmlabel">
	            		<label for="terms" id="jbusievent">Business Event Name</label>
	            	</div>
	            	<div class="frmvalue">
	            		<input type="textbox" id="busievent" 	value="">
	            	</div>
	            	<div class="frmlabel">
	            		<label for="terms" id="jcntrlfilename">Control File Name</label>
	            	</div>
	            	<div class="frmvalue">
	            		<input type="textbox" id="cntrlfilename" value="">
	            	</div>
	            </div> 
	            
	            <input type="button" id="reqformdata" name="reqformdata"  value=" OK "   class="button" onClick="insertinRow()">                  
	         </div>
	
	</div>
		     
		     <!-- commented by murali to remove unnecessary buttons in this page -->
		     
	              <%-- <div class="row">                         
	                                 
	                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" id="address" value='New' class="button"/>
	                
	               
	                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="button" value='Search' class="button"/> 
	                 
	                
	                 
	                  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input  type="button" value='Admin' class="button"/>  
	                
	                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label class="required_sign"> 
						<c:if test="${status != null}">
		            		${message}
		           		</c:if>
					</label>
	                
	                </div> --%>
	                      
	           
	        
	        
	        <br><br>  
	        
	
		<%-- <div class="row">
	                <div class="frmlabel">
	                <!-- <div class="frmlabellb"> -->
	                   <label for="j_requestno">Request No</label>
	                </div>
	                <div class="frmvalue">
	                  <form:input path="requestno" id="requestno" />  
	                  <form:errors path="requestno" class="required_sign"/>
	                </div>
	                
	                 <div class="frmlabel">
	                   <label for="j_createdby">Created By</label>
	                </div>
	                <div class="frmvalue">
	                 <form:input path="createdby" id="createdby" /> 
	                  <form:errors path="createdby" class="required_sign"/>
	                 
	                </div>        
	                </div> --%>
	                
	 
	    <div class="row">
	                <%-- <div class="frmlabel">
	                   <label for="j_migrationflow">Migration Flow</label>
	                </div>
	                <!-- Migraionflow drop down -->
	                <div class="frmvalue">
						<form:select path="migrationflow" cssClass="a_field2">
							<form:option value="0" label="Select Migration Flow" />
							<form:options items="${migrationFlows}" itemValue="migrationFlow" itemLabel="migrationFlow" />
							 <form:errors path="migrationflow" class="required_sign"/>
						</form:select>
	
					</div>
	                 --%>
	                <!--  writing for Request type -->
	                 <div class="frmlabel">
	                   <label for="j_requesttype">Request Type</label>
	                </div>
	                <!-- Migraionflow drop down -->
	                <div class="frmvalue">
						<form:select path="requestno" id="requestType" cssClass="a_field2" onChange="getInstanceValues(this);">
							<form:option value="0" label="Select Request Type" />
							<form:option value="upload" label="UPLOAD" />
							<form:option value="download" label="DOWNLOAD" />
							 <form:errors path="migrationflow" class="required_sign"/>
						</form:select>
	
					</div>
	                
	                 <div class="frmlabel">
	                   <label for="j_createdon">Created On</label>
	                </div>
	                <div class="frmvalue">
	                  <form:input id="createdOnDatePicker" path="createdon"
										cssClass="date_field" title="Correct date format is yyyy-mm-dd" />
					  <form:errors path="createdon" class="required_sign"/>
										   
	                </div>
	        </div>
			<div class="row">
				<div id="instanceNames"> 			</div>
			</div>
	        <!-- adding for showing requestType values -->
	        <div class="row">
	        	<div id="getInstanceValues"></div>
	        </div>
	                
	                <div class="row">
	                <%-- <div class="frmlabel">
	                   <label for="j_owner">Owner</label>
	                </div>
	                 <div class="frmvalue">
	                 <form:input path="ownerr" />
	                  <form:errors path="ownerr" class="required_sign"/>
	                 
	                </div> --%>
	                <div class="frmlabel">
	                   <label for="j_group">Group</label>
	                </div>
	                <%-- <div class="frmvalue">
	                 <form:input path="groupp" />
	                </div> --%>
	                <!-- status values drop down -->
	                 <div class="frmvalue">
						<form:select path="groupp" cssClass="a_field2">
							<form:option value="0" label="Select Group Name" />
							<form:options items="${groupNames}" itemValue="groupName" itemLabel="groupName" />
						 <form:errors path="groupp" class="required_sign"/>
						</form:select>
	
					</div>
	               
	                 <div class="frmlabel">
	                   <label for="j_status">Status</label>
	                </div>
	                  <%-- <div class="frmvalue">
	                 	<form:input path="statuss" />
	                </div> --%>
					<!-- Status values drop down -->    
					<div class="frmvalue">
						<form:select path="statuss" cssClass="a_field2">
							<form:option value="0" label="Select Status" />
							<form:options items="${statusNames}" itemValue="statusValues" itemLabel="statusValues" />
						 <form:errors path="statuss" class="required_sign"/>
						</form:select>
	
					</div>
					                   
	                </div>
	                
	                <div class="row">
	                <%-- <div class="frmlabel">
	                   <label for="j_group">Group</label>
	                </div>
	                <div class="frmvalue">
	                 <form:input path="groupp" />
	                </div>
	                <!-- status values drop down -->
	                 <div class="frmvalue">
						<form:select path="groupp" cssClass="a_field2">
							<form:option value="0" label="Select Group Name" />
							<form:options items="${groupNames}" itemValue="groupName" itemLabel="groupName" />
						 <form:errors path="groupp" class="required_sign"/>
						</form:select>
	
					</div> --%>
					<div class="frmlabel">
	                   <label for="j_owner">Owner</label>
	                </div>
	                 <div class="frmvalue">
	                 <form:input path="ownerr" />
	                  <form:errors path="ownerr" class="required_sign"/>
	                 
	                </div>
	                
	                 <div class="frmlabel">
	                   <label for="j_migrationtype">Migration Type</label>
	                </div>
	               <div class="frmvalue">
	                <%--  <form:input path="migrationtype" />
	                 <form:errors path="migrationtype" class="required_sign"/>  --%>
	                 <form:select path="migrationtype" cssClass="a_field2">
							<form:option value="0" label="Select Migration Type"/>
							<form:options items="${migrationTypes}" itemValue="migrationTypeName" itemLabel="migrationTypeName" />
						 <form:errors path="migrationtype" class="required_sign"/>
						</form:select>
	                 
	                </div>
	                 </div>
	                 <div class="row">
	               <%--  <div class="frmlabel">
	                <!-- <div class="frmlabellb"> -->
	                   <label for="j_requestno">Request No</label>
	                </div>
	                <div class="frmvalue">
	                  <form:input path="requestno" id="requestno" />  
	                  <form:errors path="requestno" class="required_sign"/>
	                </div> --%>
	                
	                 <div class="frmlabel">
	                   <label for="j_createdby">Created By</label>
	                </div>
	                <div class="frmvalue">
	                 <form:input path="createdby" id="createdby" /> 
	                  <form:errors path="createdby" class="required_sign"/>
	                 
	                </div>        
	                </div>
	       
	                
	                    
	            
	                <br><br>
	                 <br><br>          
	                  <br><br> 
	                  
	                        
	                 <div class="row">
	                                   
	                 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" id='addButton' value='AddLines' class="button" onClick='showDialog()'/>                  
	                 <!--  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value='Edit' class="button"/>                  
	                  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input  type="button" id='removeButton' value='Delete' class="button"/>                  
	                      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input  type="button" id="timeentry" value='Cancel' class="button"/>  -->  
	                </div>
	                    
	                    
	                    <br><br>
	               <br><br>
	            
	             
	            
	            
	            <div class="row">                                   
	                 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='button' id='address' value='Lines' class='button' onClick=''/>                  
	                  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value='Deploy' class='button'/>
	              </div>
	
	             
	              <div class="row">
	              <!--  for dynamic text boxes start -->
	              <table class="basic_grid" border="0" cellspacing="0" cellpadding="0" >
					<tr>		
				    <th>Object Type</th>
					<th>File Name</th>
					<th>Short Name</th>
					<th>Path </th>
					</tr>
						<table class="basic_grid" border="0" cellspacing="0" cellpadding="0" id="mytable">
				 		<TR>	            
	
						             <TD> <INPUT class="frmvaluee"  type='text'  name = "aprovalRequest[0].objecttype" 		id="objecttype0"/></TD>
						             <TD> <INPUT class="frmvaluee"  type='text'  name = "aprovalRequest[0].filename" 		id="filename0" /> </TD>
						             <TD> <INPUT class="frmvaluee"  type='text'  name = "aprovalRequest[0].appshortname"    id="appshortname0" /></TD>				           
						             <TD> <INPUT class="frmvaluee"  type='text'  name ="aprovalRequest[0].path" 	 		id="path0" /> </TD>	
						             
						             <TD> <INPUT class="frmvaluee"  type='hidden'  name ="aprovalRequest[0].lobcode" 	 	id="lobcode0" /> </TD>	
						             <TD> <INPUT class="frmvaluee"  type='hidden'  name ="aprovalRequest[0].language" 	 	id="language0" /> </TD>	
						             <TD> <INPUT class="frmvaluee"  type='hidden'  name ="aprovalRequest[0].territory" 	 	id="territory0" /> </TD>	
						             <TD> <INPUT class="frmvaluee"  type='hidden'  name ="aprovalRequest[0].execasapps" 	id="execasapps0" /> </TD>	
						             <TD> <INPUT class="frmvaluee"  type='hidden'  name ="aprovalRequest[0].targetpath" 	id="targetpath0" /> </TD>	
						             <TD> <INPUT class="frmvaluee"  type='hidden'  name ="aprovalRequest[0].businessevent" 	id="businessevent0" /> </TD>	
						             <TD> <INPUT class="frmvaluee"  type='hidden'  name ="aprovalRequest[0].cntrlfilename" 	id="cntrlfilename0" /> </TD>				             	             
						            
				 		</TR>
					</table>		
			   </table>
	              <!--  for dynamic text boxes end -->
	                </div>
	              
	             
	                <br><br>               
	                 <div class="row">
	                                   
	                 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" id='approval' value='Submit for Approval' class="button" />
	                  
	                  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value='Save' class="button"/>
	               
	           </div>
	           <br>
	           <br>  
	           <input type="hidden" id="selectedinstances" name="selectedinstances" path="instanceids"/>
	           <input type="hidden" id="reqtype" name="reqtype">
	     </form:form>                   
	   
	   </div>            
	                
	  <br><br>             
	
	<%-- <h:footer /> --%>
	 <%@ include file="/WEB-INF/templates/footer.jsp" %>
	</body>
	</html>
	             
	
