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



       
       <table border="1" width="350" align="center" >
		<tr>
		<th>id</th>
		<th>topic</th>
		<th>situation</th>
		<th>action</th>
		<th>goal</th>
		<th>value</th>

		<th>agree</th>
		<th>disagree</th>

	</tr>
	
	<s:set var="p" value="#session.proposal"/>

		<tr>
	
		<td><s:property value="#p.id"/></td>
	

		
		<td><s:property value="#p.topic.value"/></td>
	

	
	<td><s:property value="#p.situation.value"/></td>
	
	<td><s:property value="#p.action.value"/></td>
	
		<td><s:property value="#p.goal.value"/></td>
		
		<td><s:property value="#p.value.value"/></td>
		
	<td><s:property value="#p.agree"/></td>
		
		<td><s:property value="#p.disagree"/></td>
		
	</tr>
	
	
	
		</table>
     
     
     
     
       
</body>
</html>