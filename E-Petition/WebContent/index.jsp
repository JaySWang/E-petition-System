<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
    
<%@ page language="java" import="model.Proposal" import="java.util.List" %>
<%@taglib prefix="s" uri="/struts-tags"%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 
 
 
 <s:action name="showProposal" executeResult="true"/>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>KCL-Epetition</title>
</head>



<body>
<div class="pageLayout">



<div class="content">

		<h1>Welcome to KCL-Epetition</h1>
		<div id="introPageTxt">
			
	

			<p>Welcome to the KCL-Epetition system that allows the government to present 
			policy proposals to the public and lets the public submit their opinion on the policy .</p>



				<div class="itembox" id="inlinebox">
					<div class="boxheading">Current debates</div>
					<p>please click the topic below to see in detail</p>
					

				</div>
		</div>



 <table border="1" width="350">
	
	
	
	
	
	<s:iterator value="#request.proposals"
	var="p" status="st">

		<tr >
	
	
	<td>
	
				
					<a href="/E-Petition/JSP/proposals/proposal.jsp?id=<s:property value="#p.id"/>" target="_self" >   
		
		<s:property value="#p.id"/>
   </a>
	
	</td>

   
	
	<s:iterator value="#p.aspects" var ="a">
	
	<td>	
	<table >
	<tr><td bgcolor="gray" >			
					<s:property value="#a.type"/>
				</td></tr>
				
		<tr><td>			
					<s:property value="#a.value"/>
				</td></tr>
		
	</table>
	
	</td>
		
				
	
	
		</s:iterator>
	
		
	</tr>
	
	
	
	</s:iterator>
		</table>
	
	<br/>
	<br/>
	
<div class="boxheading">Add proposal
			
			<table >
	   <tr>
	   <td>
	   

<s:iterator value="#session.argumentSchemes"
	var="a">
	
	<tr>
	<td>
		<a href="/E-Petition/JSP/governmentOfficer/addProposal.jsp?sid=<s:property value="#a.id"/>" target="_self" >  	
		<s:property value="#a.name"/>
   </a>
   </td>
	</tr>
 
 	</s:iterator>

</td>
</tr>

	   </table> 
	</div>
	
</div>
       
      
       
       
</div>
</body>
</html>