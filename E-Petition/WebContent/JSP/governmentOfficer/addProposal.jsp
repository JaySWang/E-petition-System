<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="/struts-dojo-tags" prefix="sx"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Add proposal</title>

<ul>
		<li><a href="/E-Petition/JSP/administer/addArgumentScheme.jsp" target="_self">add new argument Scheme</a></li>
						</ul>
<body>

		  <script>   
		  var m="${requestScope.message}"; 
	if( m!=""){	  
  var   bln   = m;
  alert(bln);   
	}
  </script> 

<!-- 	  <script>   {
	var a='<%=request.getParameter("id")%> ';
       
       
       alert(a);
		  
		   
	}
  </script> 
  
<%=request.getParameter("id")%> 
 -->
 
 
  <br>
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="table">
	  <tr>
		<td width="80%" height="1" bgcolor="#ffffff"></td>
	  </tr>
	  <tr>
		 <td height="25" colspan="2" align="center" bgcolor="#799ae1"><span class="title">ADD PROPOSAL</span></td>
	  </tr>
	</table>
	
	
	
	<s:form action="addProposal">
	  <table width="350" border="0" align="center" cellpadding="0" cellspacing="0" class="table">
	 
	  <tr  height="40">
	    <td>topic</td>
	    <td><input name="topic" type="text" /></td>
	  </tr>
	
	  <tr  height="40">
	    <td>situation</td>
	    <td><input name="situation" type="text" /></td>
	  </tr>

  <tr  height="40">
	    <td>action</td>
	    <td><input name="action" type="text" /></td>
	  </tr>
	 
	  <tr  height="40">
	    <td>goal</td>
	    <td><input name="goal" type="text" /></td>
	  </tr>
	  
	    <tr  height="40">
	    <td>value</td>
	    <td><input name="value" type="text" /></td>
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