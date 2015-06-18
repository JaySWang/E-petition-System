<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
    
<%@ page language="java" import="model.Proposal" import="java.util.List" %>
<%@taglib prefix="s" uri="/struts-tags"%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">





<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>CriticalQuestion</title>
</head>


<body>

   <p align="center" >What do you think of the flowing aspects of the proposal?  </p> 
     
<s:iterator value="#session.aspects" var = "a">

	<s:property value="#a.type" />:
	
	<s:property value="#a.value" /> 
	
<table border="1" align="center">
<tr>
 <th>Question</th>  <th>agree</th>  <th>disagree</th>  <th>N/A</th>
 </tr> 
 	
		<s:iterator value="#a.criticalQuestions" var = "c">

 <tr>
 <td> 	<s:property value="#c.value" /> 
   </td> 
    
   <td>
   <s:property value="#c.agree" /> 
     </td>
     
      <td>
      <s:property value="#c.disagree" /> 
      </td>
      
        <td>
      <s:property value="#c.na" /> 
      </td>
 
 </tr>
 	 </s:iterator>
 
</table>	 
	
		<br/>
	
		<br/>
	
</s:iterator>


<a href="/E-Petition/JSP/proposals/votesOfProposal.jsp"  target="_self" > back to the proposal  </a>

					 

     
     
     
     
       
</body>
</html>