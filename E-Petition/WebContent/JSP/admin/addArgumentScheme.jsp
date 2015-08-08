	<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="/struts-dojo-tags" prefix="sx"%>

<!doctype html>

<html>
<head>

<meta  charset="utf-8">
 <!-- FONT
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
  <link href="//fonts.googleapis.com/css?family=Raleway:400,300,600" rel="stylesheet" type="text/css">

  <!-- CSS
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
  <link rel="stylesheet" href="../../css/normalize.css">
  <link rel="stylesheet" href="../../css/skeleton.css">
<title>login</title> 

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

var input2 = document.createElement("textarea");
    input2.setAttribute("name", "template"+i);
    input2.setAttribute("placeholder", "template text");
cal.appendChild(input1);
cal.appendChild(input2);

}

var row = document.getElementById("table").insertRow();
var cal = row.insertCell();
var input3 = document.createElement("textarea");
    input3.setAttribute("name", "variables");
    input3.setAttribute("placeholder", "variables in the templates(use '/' to separate)");
    cal.appendChild(input3);
    
    
}
</script>


<div class="container">

 <header class="sixteen columns offset-by-three">   
      <h1>
ADD ARGUMENT SCHEME
    </h1>
     </header>
	
	
<div class="row">
<div class="three columns offset-by-three">
<a href="http://philosophicaldisquisitions.blogspot.co.uk/2010/03/argumentation-schemes-part-1.html" target="_blank">
	Types of Argument Schemes
	</a>
	<br/>
	<a href="/E-Petition/JSP/admin/argumentSchemes.jsp" target="_self">argument Scheme list</a>
</div>
</div>

	<div class="row">
<div class="six columns offset-by-four">	
	<h3>add new scheme</h3>
	
	
	<form action="addArgumentScheme">
	
	  <table>
	  <tr >
	    <td>name</td>
	    <td><input name="name" type="text" /></td>
	  </tr>
	
	  <tr>
	    <td>description</td>
	    <td>
	    
	        <textarea class="u-full-width" name="description" ></textarea>
</td>
	  </tr>

  <tr >
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
	</form>
	
	</div>
	</div>
	</div>
</body>
</html>