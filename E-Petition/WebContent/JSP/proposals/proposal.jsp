<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
    
<%@ page language="java" import="model.Proposal" import="java.util.List" %>
<%@taglib prefix="s" uri="/struts-tags"%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">




 <s:action name="showProposalDetail" executeResult="true"/>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Proposal</title>
</head>


<body>



       
       <table border="1" width="350">
		<tr>
		<th>id</th>
		<th>topic</th>
		<th>situation</th>
		<th>action</th>
		<th>goal</th>
		<th>value</th>

	</tr>
	
	<s:set var="p" value="#request.proposal"/>

		<tr>
	
		<td><s:property value="#p.id"/></td>
	

		
		<td><s:property value="#p.topic"/></td>
	

	
	<td><s:property value="#p.situation"/></td>
	
	<td><s:property value="#p.action"/></td>
	
		<td><s:property value="#p.goal"/></td>
		
		<td><s:property value="#p.value"/></td>
		
	
		
	</tr>
	
	
	
		</table>
       
       
</body>
</html>