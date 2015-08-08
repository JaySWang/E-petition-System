<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
    
<%@ page language="java" import="model.Proposal" import="java.util.List" %>
<%@taglib prefix="s" uri="/struts-tags"%>    
    
<!DOCTYPE HTML>
 
  
 
 


<html>

  
 <s:action name="getASProposals" executeResult="true"/>

<head>
<meta  charset="utf-8">
 <!-- FONT
  每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每 -->
  <link href="//fonts.googleapis.com/css?family=Raleway:400,300,600" rel="stylesheet" type="text/css">

  <!-- CSS
  每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每 -->
   <link rel="stylesheet" href="/E-Petition/css/normalize.css">
  <link rel="stylesheet" href="/E-Petition/css/skeleton.css">
  
  <title>KCL-Epetition</title>
</head>



<body>
<div class="container">

	 	 <div class="row">
<div class="eight columns offset-by-two">	



<h2> attackers </h2>
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
	
			<s:iterator value="#attacker.aspects" var="a" >
						<font size='3'> </font>
						<th>
						<s:property value="#a.type"/>:
						</th>
						
						<td>
						<s:property value="#a.value"/>
						</td>			
				</tr>
						
	</s:iterator>
	
	
	
			
			
	</table>
	
	</td>
		
				
	
	
	
		
	</tr>
	
	
	
	</s:iterator>
		</table>
	
	
	<br/>
	
	<h2>supporters</h2>
	
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
	
			<s:iterator value="#supporter.aspects" var="a" >
						<font size='3'> </font>
						<th>
						<s:property value="#a.type"/>:
						</th>
						
						<td>
						<s:property value="#a.value"/>
						</td>			
				</tr>
						
	</s:iterator>
	
	
	
			
			
	</table>
	
	</td>
		
				
	
	
	
		
	</tr>
	
	
	
	</s:iterator>
		</table>
</div>
</div>	
</div>

</body>
</html>