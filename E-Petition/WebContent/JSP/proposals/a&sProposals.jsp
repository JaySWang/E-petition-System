<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
    
<%@ page language="java" import="model.Proposal" import="java.util.List" %>
<%@taglib prefix="s" uri="/struts-tags"%>    
    
<!DOCTYPE HTML>
 
  
 
 


<html>

  
 <s:action name="getASProposals" executeResult="true"/>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>KCL-Epetition</title>
</head>



<body>
<div class="pageLayout">

	


    
<div class="content">


<p> attackers </p>
 <table>
	
	
	
	
	
	<s:iterator value="#session.attackers"
	var="attacker" status="st">

		<tr >
	
	
	<td>
	
				
					<a href="/E-Petition/JSP/proposals/proposal.jsp?id=<s:property value="#attacker.id"/>" target="_self" >   
		
		P<s:property value="#attacker.id"/>
   </a>
	
	</td>

   
	
	
	<td>	
	<table >
	<tr>
	
			<s:iterator value="#attacker.aspects" var="a">
						<th >	
						<s:property value="#a.type"/>
						</th>
	</s:iterator>
	
	
	</tr>
	
			<tr>
	
			<s:iterator value="#attacker.aspects"  var="a">
						<td align="center">	
						<s:property value="#a.value"/>
						</td>
	</s:iterator>
	
	
	</tr>
			
	</table>
	
	</td>
		
				
	
	
	
		
	</tr>
	
	
	
	</s:iterator>
		</table>
	
	
	<br/>
	
	<p>supporters</p>
	
	<table>
	
	
	
	
	
	<s:iterator value="#session.supporters"
	var="supporter">

		<tr >
	
	
	<td>
	
				
					<a href="/E-Petition/JSP/proposals/proposal.jsp?id=<s:property value="#supporter.id"/>" target="_self" >   
		
		P<s:property value="#supporter.id"/>
   </a>
	
	</td>

   
	
	
	<td>	
	<table >
	<tr>
	
			<s:iterator value="#supporter.aspects" var="a">
						<th >	
						<s:property value="#a.type"/>
						</th>
	</s:iterator>
	
	
	</tr>
	
			<tr>
	
			<s:iterator value="#supporter.aspects"  var="a">
						<td align="center">	
						<s:property value="#a.value"/>
						</td>
	</s:iterator>
	
	
	</tr>
			
	</table>
	
	</td>
		
				
	
	
	
		
	</tr>
	
	
	
	</s:iterator>
		</table>
	
	
	<br/>
	<br/>
	
	
	
	
	

	
</div>
       
      
       
       
</div>
</body>
</html>