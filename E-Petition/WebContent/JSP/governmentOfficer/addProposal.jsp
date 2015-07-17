<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags"%>

  
<%@ page language="java" import="model.AspectType" import="model.ArgumentScheme" import="java.util.List" %>


<%@ taglib uri="/struts-dojo-tags" prefix="sx"%>

<!doctype html>



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Add proposal</title>


<body>





 
 
  
	<table   width="100%" border="0" align="center" cellspacing="0" class="table">
	  <tr>
		<td width="80%" height="1" bgcolor="#ffffff"></td>
	  </tr>
	  <tr>
		 <td height="25" colspan="2" align="center" bgcolor="#799ae1"><span class="title">ADD PROPOSAL</span></td>
	  </tr>
	</table>
	
	
	
	
	
	
	<s:form action="addProposal">
	
	  <table  width="350" border="0" align="center" cellpadding="0" cellspacing="0" class="table">


<tr>
<td>
	
	 	<s:set var="as" value="#session.argumentScheme"/>
	
<s:iterator value="#as.aspectTypes"
	var="at">
	 
	   <tr>
	   <td>
	
  <s:property value="#at.name"/>:
  <s:property value="#at.template"/>
  </td>

</tr>
</s:iterator>


  <td>
  <br/>
  please assign values to these variables:
  <br/>
    <s:property value="#as.variables"/>:
  
   <input type="text" name="variables" placeholder="use '/' to separate" />
  

</td>


	 </td>
	 </tr>


	  <tr align="center"  height="40">
	    <td colspan="2">
		  <input name="" type="submit"  value="add"/>
		  <input name="" type="reset" value="reset" />
		</td>
	  </tr>
     </table>
	</s:form>
	
</body>
</html>