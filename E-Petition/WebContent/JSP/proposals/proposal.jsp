<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
    
<%@ page language="java" import="model.Proposal" import="java.util.List" %>
<%@taglib prefix="s" uri="/struts-tags"%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">




 <s:action name="showProposalDetail" executeResult="true"/>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Proposal</title>
</head>


<body>



       
       <table border="1" width="350" align="center" >
		<tr>
		<th>id</th>
		<th>topic</th>
		<th>situation</th>
		<th>action</th>
		<th>goal</th>
		<th>value</th>

		

	</tr>
	
	<s:set var="p" value="#session.proposal"/>

		<tr>
	
		<td><s:property value="#p.id"/></td>
	

		
		<td><s:property value="#p.topic"/></td>
	

	
	<td><s:property value="#p.situation"/></td>
	
	<td><s:property value="#p.action"/></td>
	
		<td><s:property value="#p.goal"/></td>
		
		<td><s:property value="#p.value"/></td>

	
		
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
     </table>
	</s:form>
     
     
     
       
</body>
</html>