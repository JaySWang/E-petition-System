	<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="/struts-dojo-tags" prefix="sx"%>

<!doctype html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Add argument scheme</title>


<body>

		  <script>   
		  var m="${requestScope.message}"; 
	if( m!=""){	  
  var   bln   = m;
  alert(bln);   
  
  requestScope.message="";
	}
  </script> 


<script>
function addRow(){
var num = document.getElementById("num").value;
for(var i = 0; i < num; i++){
var row = document.getElementById("table").insertRow();
var cal = row.insertCell();

var input1 = document.createElement("input");
    input1.setAttribute("type", "text");
    input1.setAttribute("name", "type"+i);
    input1.setAttribute("placeholder", "type"+i);

var input2 = document.createElement("input");
    input2.setAttribute("type", "text");
    input2.setAttribute("name", "template"+i);
    input2.setAttribute("placeholder", "template text");
cal.appendChild(input1);
cal.appendChild(input2);

}

var row = document.getElementById("table").insertRow();
var cal = row.insertCell();
var input3 = document.createElement("input");
    input3.setAttribute("type", "text");
    input3.setAttribute("name", "variables");
    input3.setAttribute("placeholder", "variables in the templates(use '/' to separate)");
    cal.appendChild(input3);
    
    
}
</script>





  <br>
	<table  width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="table">
	  <tr>
		<td width="80%" height="1" bgcolor="#ffffff"></td>
	  </tr>
	  <tr>
		 <td height="25" colspan="2" align="center" bgcolor="#799ae1"><span class="title">ADD ARGUMENT SCHEME</span></td>
	  </tr>
	</table>
	
	
	<br/>
<a href="http://philosophicaldisquisitions.blogspot.co.uk/2010/03/argumentation-schemes-part-1.html">
	Types of Argument Schemes
	</a>
	
	<br/>
	<br/>
	<a href="/E-Petition/JSP/admin/argumentSchemes.jsp" target="_self">argument Scheme list</a>
	
	
	<s:form action="addArgumentScheme">
	  <table  width="350" border="0" align="center" cellpadding="0" cellspacing="0" class="table">
	 
	  <tr  height="40">
	    <td>name</td>
	    <td><input name="name" type="text" /></td>
	  </tr>
	
	  <tr  height="40">
	    <td>description</td>
	    <td><input name="description" type="text" /></td>
	  </tr>

  <tr  height="40">
	    <td>types of assumption </td>
	    <td>
	    <table id="table" >
	   <tr>
	   <td><input type="text"  placeholder="please enter a number" id="num" name="num">

<input type="button" value="confirm " onclick="addRow();">
</td>
</tr>
	   </table> 
	 </td>

	  </tr>
	 

	  

	

	  
	  <tr align="center"  height="40">
	    <td colspan="2">
		  <input name="" type="submit"  value="add"/>
		  <input name="" type="reset" value="reset" />
		</td>
	  </tr>
     </table>
	</s:form>
	<br>
</body>
</html>