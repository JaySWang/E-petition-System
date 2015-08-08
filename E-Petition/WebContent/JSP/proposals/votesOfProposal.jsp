<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
    
<%@ page language="java" import="model.Proposal" import="java.util.List" %>
<%@taglib prefix="s" uri="/struts-tags"%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">





<html>
<head>
<meta  charset="utf-8">
 <!-- FONT
  每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每 -->
  <link href="//fonts.googleapis.com/css?family=Raleway:400,300,600" rel="stylesheet" type="text/css">

  <!-- CSS
  每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每 -->
   <link rel="stylesheet" href="/E-Petition/css/normalize.css">
  <link rel="stylesheet" href="/E-Petition/css/skeleton.css">
  
  <title>Proposal</title>
</head>


<body>
<div class="container">
	     <header class="eleven columns offset-by-three">   
      <h2>
    VOTES OF THE PROPOSAL
    </h2>
     </header>
 <div class="row">
<div class="nine columns offset-by-three"> 
	<s:set var="p" value="#session.proposal"/>

       
       <table >
       	<tr>
  <s:iterator value="#p.aspects" var="a">
		
		<th><s:property value="#a.type"/></th>
		
	
</s:iterator>
	<th>agree</th>
		<th>disagree</th>
</tr>

	<tr>
	
	
  <s:iterator value="#p.aspects" var="a">
		
		<td><s:property value="#a.value"/></td>
		
	
</s:iterator>
			
	<td><s:property value="#p.agree"/></td>
		
		<td><s:property value="#p.disagree"/></td>
		
		
	</tr>

	
	
	
	
		</table>
     
     
     <br/>
     <a href="/E-Petition/index.jsp"  target="_self" > back to proposal list  </a>
     
   </div>
   </div>  
 </div>      
</body>
</html>