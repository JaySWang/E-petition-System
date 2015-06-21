<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
    
<%@ page language="java" import="model.Proposal" import="java.util.List" %>
<%@taglib prefix="s" uri="/struts-tags"%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 
 
 
 <s:action name="showArgumentSchemes" executeResult="true"/>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>ArgumentScheme</title>
</head>



<body>
<div class="pageLayout">




       <table border="1" width="350">
		<tr>
		<th>name</th>
<th>description</th>
<th>aspects</th>
	</tr>
	
	<s:iterator value="#request.argumentSchemes"
	var="as" status="st">

		<tr <s:if test="#st.odd">
		style="background-color:#bbbbbb"</s:if>>
	
	
	<td>
	
				
		
		<s:property value="#as.name"/>
	
	</td>
<td>
	
				
		
		<s:property value="#as.description"/>
	
	</td>
	
	<td>
	
				
		<s:iterator value="#as.aspectTypes"
	var="at" status="st">
	

	
			<s:property value="#at.name"/>
		<br></br>	

	
	</s:iterator>
	
	</td>
			
	
		
	</tr>
	
	
	
	</s:iterator>
		</table>
       
       
</div>
</body>
</html>