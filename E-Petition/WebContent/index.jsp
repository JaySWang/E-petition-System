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

			

			<div id="boxcontainer">

				<div class="itembox" id="inlinebox">
					<div class="boxheading">Current debates</div>
					<p>please click the link below to give your opinion:</p>
					
					<ul>
		
			

		<li><a href="/E-Petition/JSP/governmentOfficer/addProposal.jsp" target="_blank">add proposal</a></li>
						
<li><a href="foxhunting" target="_blank">Should the <strong>fox-hunting</strong> ban be repealed?</a></li>


	</ul>

				</div>

	
			</div>

			
		</div>

</div>
       
       <table border="1" width="350">
		<tr>
		<th>id</th>
		<th>topic</th>
		<th>situation</th>
		<th>action</th>
		<th>goal</th>
		<th>value</th>

	</tr>
	
	<s:iterator value="#request.proposals"
	var="p" status="st">

		<tr <s:if test="#st.odd">
		style="background-color:#bbbbbb"</s:if>>
	
		<td><s:property value="#p.id"/></td>
	
	<td><s:property value="#p.topic"/></td>
	
	<td><s:property value="#p.situation"/></td>
	
	<td><s:property value="#p.action"/></td>
	
		<td><s:property value="#p.goal"/></td>
		
		<td><s:property value="#p.value"/></td>
		
	
		
	</tr>
	
	
	
	</s:iterator>
		</table>
       
       
</div>
</body>
</html>