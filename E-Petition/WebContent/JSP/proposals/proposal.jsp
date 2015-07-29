<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
    
<%@ page language="java" import="model.Proposal" import="java.util.List" %>
<%@taglib prefix="s" uri="/struts-tags"%>    
    
<!DOCTYPE html >





<html>




 <s:action name="showProposalDetail" executeResult="true"/>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Proposal</title>
</head>


<body>

	<s:set var="p" value="#session.proposal"/>

       
       <table border="1" align="center" >
		<tr>
  <s:iterator value="#p.aspects" var="a">
		
		<th><s:property value="#a.type"/></th>
		
		
</s:iterator>
</tr>
		<tr>
	
	
  <s:iterator value="#p.aspects" var="a">
		
		<td><s:property value="#a.value"/></td>
		
	
</s:iterator>
		
		
		
	</tr>

	
			
   
	
	
		</table>
		
		
		
      <p align="center" >What do you think of this proposal?  </p> 
      
     <s:form action="voteProposal">
	  <table width="350" border="0" align="center" cellpadding="0" cellspacing="0" class="table">

	  
	  <tr align="center"  height="40">
	    <td colspan="2">
		  <input name="agreeOrNot" type="submit"  value="agree"/>
	<input name="agreeOrNot" type="submit"  value="disagree"/>
		</td>
		
		</tr>
		
	  </tr>
     </table>
	</s:form>
     
     
     
       
</body>
</html>