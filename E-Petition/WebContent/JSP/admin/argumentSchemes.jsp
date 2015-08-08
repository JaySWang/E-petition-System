<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
    
<%@ page language="java" import="model.Proposal" import="java.util.List" %>
<%@taglib prefix="s" uri="/struts-tags"%>    
    
<!DOCTYPE html>
 
 
 

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
<meta  charset="utf-8">
 <!-- FONT
  每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每 -->
  <link href="//fonts.googleapis.com/css?family=Raleway:400,300,600" rel="stylesheet" type="text/css">

  <!-- CSS
  每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每 -->
  <link rel="stylesheet" href="../../css/normalize.css">
  <link rel="stylesheet" href="../../css/skeleton.css">
    <link rel="stylesheet" href="../../css/custom.css">
  
  <title>ArgumentScheme</title>
</head>



<body>
<div class="container">
<div class="row">
<div class="ten column offset-by-one" >
       <table class="u-full-width ">
		<tr>
		<th>name</th>
<th>description</th>
<th>assumptions</th>
	</tr>
	
	<s:iterator value="#request.argumentSchemes"
	var="as" status="st">

		<tr <s:if test="#st.odd">
		style="background-color:#e0e0e0"</s:if>>
	
	
	<td>
	
				
		
		<s:property value="#as.name"/>
	
	</td>
<td>
	
				
		
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
<a href="/E-Petition/JSP/admin/addCriticalQuestionTemplate.jsp?sName=<s:property value="#as.name"/>" target="_self" > add critical question templates </a> 
	
	</td>
			
	
		
	</tr>
	
	
	
	</s:iterator>
		</table>
       
 </div>
 </div>
 <nextbox>  
         <a href="/E-Petition/index.jsp" target="_self" >back to proposal list</a> 
</nextbox>
</div>

</body>
</html>