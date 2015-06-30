<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
    
<%@ page language="java" import="model.Proposal" import="java.util.List" %>
<%@taglib prefix="s" uri="/struts-tags"%>    
    
<!DOCTYPE html>




<html>



<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>CriticalQuestion</title>
</head>


<body>

     <s:form action="answerCriticalQuestion">
     
 <s:set value="#session.proposal" var = "p"/>    
        <p align="center" >What do you think of the flowing aspects of the proposal:p<s:property value="#p.id"/> </p> 
     
<s:iterator value="#p.aspects" var = "a">

	<s:property value="#a.type" />:
	
	<s:property value="#a.value" /> 
	<br/>
				<a href="/E-Petition/JSP/proposals/a&sProposals.jsp?aid=<s:property value="#a.id"/>" target="_self" >   
		
		see attackers and supporters
   </a>
	
	
	<s:iterator value="#a.criticalQuestions" var = "c">
<table border="1">
<tr>
 <th>
	 <s:property value="#c.value" /> 

  <input type="radio"   name= <s:property value="#c.id" />  value="agree" />agree
<input type="radio"   name=<s:property value="#c.id" />  value="disagree" />disagree
<input type="radio"   name=<s:property value="#c.id" />   value="na"  checked = "checked"/>N/A
	</th>
	
	 </tr> 

	 
</table>	 
	 </s:iterator>
	 
	 



 	
<br>

	</s:iterator>




       
 
   
	  <table width="350" border="0" align="center" cellpadding="0" cellspacing="0" class="table">

	  
	  <tr align="center"  height="40">
	    <td colspan="2">
		  <input name="submit" type="submit"  value="submit"/>
	<input name="reset" type="reset"  value="reset"/>
		</td>
	  </tr>
     </table>
	</s:form>
     
     
	<a href="/E-Petition/JSP/administer/addCriticalQuestion.jsp?id=<s:property value="#p.id"/>" target="_self" > add critical question  </a> 
     
       
</body>
</html>