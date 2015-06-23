<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
    
<%@ page language="java" import="model.Proposal" import="java.util.List" %>
<%@taglib prefix="s" uri="/struts-tags"%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">





<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Proposal</title>
</head>


<body>


	<s:set var="p" value="#session.proposal"/>

       
       <table border="1" width="350" align="center" >
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
     
     
     
     
       
</body>
</html>