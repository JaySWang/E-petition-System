<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="GB18030"%>
    <%@taglib prefix="s" uri="/struts-tags"%>    
    
<!DOCTYPE html>



<html>




<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>KCL-Epetition</title>
</head>
<body>

<div>

based on the following evaluation strategies:
<ol>
<li> basic</li>
<li> based on critical questions</li>
<li> involves attackers and supporters    </li>


</ol>
    
    <ol>
  <s:iterator value="#request.results" var="r">
		
		<li><s:property value="#r"/></li>
		
		
</s:iterator>
</ol>

</div>


       
</body>
</html>