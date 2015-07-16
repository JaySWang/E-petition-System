<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
    
<%@ page language="java" import="model.Proposal" import="java.util.List" %>
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



 <table border="2" width="350"  cellpadding="0" cellspacing="0">
	
	
	
	
	
	<s:iterator value="#request.proposals"
	var="p" status="st">

		<tr >
	
	
	<td>
	
				
					<a href="/E-Petition/JSP/proposals/proposal.jsp?id=<s:property value="#p.id"/>" target="_self" >   
		
		P<s:property value="#p.id"/>
   </a>
	
	</td>

   
	
	
	<td>	
	<table border="1" width="500" align="center" cellpadding="10" cellspacing="0">
	<tr>
	
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
			
	</table>
	
	</td>
		
				
	
	
	
		
	</tr>
	
	
	
	</s:iterator>
		</table>
	
	<br/>
	<br/>
	
	
	
	
	
	
	
<div class="boxheading">Add proposal
	
	

	
			
			<table >
	   <tr>
	   <td>
	   
 	

<form action="getArgumentScheme">

	
Chose a scheme：<input  list="scheme_list" name="sName" />
<datalist id="scheme_list">
<s:iterator value="#session.argumentSchemes"
	var="a">
	<option value=	"<s:property value="#a.name"/>" >
	
	
	 
	  </option>

 	</s:iterator>

</datalist>

<input type="submit" value="confirm">
	
 
 	</form>
</td>
</tr>

	   </table> 
	   
	   <br/>
<a href="/E-Petition/JSP/administer/addArgumentScheme.jsp" target="_self">add new argument Scheme</a>
						
	</div>
	
</div>
       
      
       
       
</div>
</body>
</html>