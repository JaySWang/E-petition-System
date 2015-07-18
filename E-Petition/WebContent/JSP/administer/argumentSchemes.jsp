<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
    
<%@ page language="java" import="model.Proposal" import="java.util.List" %>
<%@taglib prefix="s" uri="/struts-tags"%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 
 
 

<html>

 <script>   
		  var m="${requestScope.message}"; 
	if(m!=""){	  
  var   bln   = m;
  alert(bln);   
	}
  </script> 
 <s:action name="showArgumentSchemes" executeResult="true"/>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>ArgumentScheme</title>
</head>



<body>
<div class="pageLayout">




       <table border="1" >
		<tr>
		<th>name</th>
<th>description</th>
<th>assumptions</th>
	</tr>
	
	<s:iterator value="#request.argumentSchemes"
	var="as" status="st">

		<tr <s:if test="#st.odd">
		style="background-color:#bbbbbb"</s:if>>
	
	
	<td>
	
				
		
		<s:property value="#as.name"/>
	
	</td>
<td width="100">
	
				
		
		<s:property value="#as.description"/>
	
	</td>
	
	<td>
	
				
		<s:iterator value="#as.aspectTypes"
	var="at" status="st">
	

	
			<s:property value="#at.name"/>:
			<s:property value="#at.template"/>
			
			<br/>
			critical Question Templates:
			
			<s:iterator value="#at.criticalQuestionTemplates"
	var="atcq" status="qst">
	<br/>
		<s:property value="#qst.index"/>.
	    <s:property value="#atcq.value"/>
				
	
	</s:iterator>
			
<br/>
<br/>	

	
	</s:iterator>
<a href="/E-Petition/JSP/administer/addCriticalQuestionTemplate.jsp?sName=<s:property value="#as.name"/>" target="_self" > add critical question templates </a> 
	
	</td>
			
	
		
	</tr>
	
	
	
	</s:iterator>
		</table>
       
       
</div>
<br/>
<a href="/E-Petition/index.jsp" target="_self" >back to proposal list</a>
</body>
</html>