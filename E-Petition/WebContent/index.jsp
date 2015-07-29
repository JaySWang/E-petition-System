<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
    
<%@ page language="java" import="model.Proposal" import="java.util.List" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>   

<%@taglib prefix="s" uri="/struts-tags"%>    
    
<!DOCTYPE HTML>
 
  
 

<html>
 <script>   
		  var m="${requestScope.message}"; 
	if(m!=""){	  
  var   bln   = m;
  alert(bln);  
   requestScope.message="";
	}
  </script> 
  
 <s:action name="showProposal" executeResult="true"/>

<head>

<meta  charset="utf-8">
 <!-- FONT
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
  <link href="//fonts.googleapis.com/css?family=Raleway:400,300,600" rel="stylesheet" type="text/css">

  <!-- CSS
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
  <link rel="stylesheet" href="css/normalize.css">
  <link rel="stylesheet" href="css/skeleton.css">

 



<title>KCL E-Petition</title>
</head>



<body>
<div class="container">

	


    

		<h1>Welcome to KCL E-Petition</h1>
	<!-- 	   <a href="/E-Petition/JSP/admin/admin.jsp">admin page</a>   
       <a href="/E-Petition/JSP/officer/officer.jsp">officer page</a>  -->
     
        <sec:authorize ifAnyGranted="ROLE_USER,ROLE_OFFICER,ROLE_ADMIN">  <a href="/E-Petition/logout">logout</a></sec:authorize>
     
       <sec:authorize ifNotGranted="ROLE_USER,ROLE_OFFICER,ROLE_ADMIN">   <a href="/E-Petition/login.jsp">login</a></sec:authorize>
     
      <br>    
		hi, 
    <sec:authentication property ="name"/> !  
      
     
 
<!-- <sec:authorize ifAllGranted="ROLE_USER">user可以访问</sec:authorize>
<sec:authorize ifAllGranted="ROLE_OFFICER">officer可以访问</sec:authorize>
 -->
		
		 <div class="row">
      <div class="one-half column" >
		

			<p>Welcome to the KCL-Epetition system that allows the government to present 
			policy proposals to the public and lets the public submit their opinion on the policy .</p>



					<h4>Current debates</h4>
					<p>please click the topic below to see in detail</p>
					

				</div>
		</div>


<table class="u-full-width">
	
	
	<s:iterator value="#request.proposals"
	var="p" status="st">
 <tr>
	<td rowspan="2">	
					<a href="/E-Petition/JSP/proposals/proposal.jsp?id=<s:property value="#p.id"/>" target="_self" >   
		
		P<s:property value="#p.id"/>
   </a>	
	</td>

  <s:iterator value="#p.aspects" var="a">
						<th >	
						<s:property value="#a.type"/>
						</th>
	</s:iterator> 
</tr>

<tr>

			<s:iterator value="#p.aspects"  var="a">
						<td align="center">	
						<s:property value="#a.value"/>
						</td>
	</s:iterator>


</tr>
</s:iterator>


	
	</table>
	
	
	<br/>
	<br/>
	
	
	
	
	
	
<sec:authorize ifAllGranted="ROLE_OFFICER">	
<div class="boxheading">Add proposal
	
	

	

			
			<table >
	   <tr>
	   <td>
	   
 	

<form action="getArgumentScheme">

	
Chose a scheme：
<Select name="sName">
<s:iterator value="#session.generalProposalSchemes"
	var="a">
	<option> <s:property value="#a.name"/>
	 
	  </option>

 	</s:iterator>

</Select>



<input type="submit" value="confirm">
<input type="hidden" name="returnMsg" value="addProposal">	
 
 	</form>
</td>
</tr>

	   </table> 

	   
	
	</div>
	</sec:authorize>
	
</div>
       
       

      <br/>
	   
	   <sec:authorize ifAllGranted="ROLE_ADMIN">
<a href="/E-Petition/JSP/admin/addArgumentScheme.jsp" target="_self">add new argument Scheme</a>
			
			</sec:authorize>		
			
			    <br/>
   <a href="/E-Petition/applet/hello.html" target="_blank">evaluation</a>   


</body>
</html>