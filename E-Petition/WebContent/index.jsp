<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
    
<%@ page language="java" import="model.Proposal" import="java.util.List" %>
<%@taglib prefix="s" uri="/struts-tags"%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>KCL-Epetition</title>
</head>

 <s:action name="showProposal" namespace="/User" executeResult="true"/>

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
		
			

		<li><a href="/E-Petition/JSP/proposals/iraq.jsp" target="_blank">Should we <strong>invade Iraq?</strong></a></li>
						
<li><a href="foxhunting" target="_blank">Should the <strong>fox-hunting</strong> ban be repealed?</a></li>


	</ul>

				</div>

	
			</div>

			
		</div>

</div>
       
</div>
</body>
</html>