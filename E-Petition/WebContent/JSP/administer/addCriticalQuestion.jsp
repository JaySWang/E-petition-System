<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="/struts-dojo-tags" prefix="sx"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



 <s:action name="showProposalDetail" executeResult="true"/>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Add critical question</title>

<body>


  <br>
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="table">
	  <tr>
		<td width="80%" height="1" bgcolor="#ffffff"></td>
	  </tr>
	  <tr>
		 <td height="25" colspan="2" align="center" bgcolor="#799ae1"><span class="title">ADD CRITICAL QUESTION</span></td>
	  </tr>
	  
	  
	</table>
	
		  <p>please use "/" to separate questions for one aspect</p>
	
	
	<s:form action="addCriticalQuestion">
	 
	 
	  <table width="350" border="0" align="center" cellpadding="0" cellspacing="0" class="table">
	 
	 	 	<s:set var="p" value="#session.proposal"/>
	 <tr>
	 	 <td><s:property value="#p.topic.type"/></td>
	 
	 <td><s:property value="#p.topic.value"/></td>
	</tr>


	  <tr  height="40">
	    <td>Questions:</td>
	    <td><input name="topicCQ" type="text" /></td>
	  </tr>
	
	 <tr>
	 	 <td><s:property value="#p.situation.type"/></td>
	 
	 <td><s:property value="#p.situation.value"/></td>
	</tr>
	  <tr  height="40">
	    <td>Questions:</td>
	    <td><input name="situationCQ" type="text" /></td>
	  </tr>

<tr>
	 <td><s:property value="#p.action.type"/></td>

	 <td><s:property value="#p.action.value"/></td>
	</tr>
  <tr  height="40">
	    <td>Questions:</td>
	    <td><input name="actionCQ" type="text" /></td>
	  </tr>
	
	
	<tr>
		 <td><s:property value="#p.goal.type"/></td>
	
	 <td><s:property value="#p.goal.value"/></td>
	</tr> 
	  <tr  height="40">
	    <td>Questions:</td>
	    <td><input name="goalCQ" type="text" /></td>
	  </tr>
	  
	  
	  <tr>
	  <td><s:property value="#p.value.type"/></td>
	 <td><s:property value="#p.value.value"/></td>
	</tr> 
	    <tr  height="40">
	    <td>Questions:</td>
	    <td><input name="valueCQ" type="text" /></td>
	  </tr>

	  

	

	  
	  <tr align="center"  height="40">
	    <td colspan="2">
		  <input name="" type="submit"  value="add"/>
		  <input name="" type="reset" value="reset" />
		</td>
	  </tr>
     </table>
	</s:form>
	<br>
</body>
</html>