<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
    
<%@ page language="java" import="model.Proposal" import="java.util.List" %>
<%@taglib prefix="s" uri="/struts-tags"%>    
    
<!DOCTYPE html >




<html>

<script>

function more(id){

 var o = document.getElementById(id);
 
o.style.visibility="visible";
 
}




</script>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>CriticalQuestion</title>
</head>


<body>

   <p align="center" >Votes of the aspects of the proposal  </p> 
     
<s:iterator value="#session.aspects" var = "a">

	<s:property value="#a.type" />:
	
	<s:property value="#a.value" /> 
	
	<table id=<s:property value="#a.id" /> style="visibility:hidden">
<tr>
<td>
<form action="getArgumentScheme" >

Chose a scheme：<input  list="scheme_list" name="sid" />
<datalist id="scheme_list">
<s:iterator value="#session.argumentSchemes"
	var="as">
	<option
            value=	"<s:property value="#as.id"/>"
            
            > <s:property value="#as.name"/> </option>

 	</s:iterator>

</datalist>

	  <input name="attackOrSupport" type="submit"  value="attack"/>
	<input name="attackOrSupport" type="submit"  value="support"/>	
 <input name="aid" value=<s:property value="#a.id" />  type="hidden" />
 
 	</form>
 	
 	</td>
 	</tr>
 	</table>
<button type="button" onclick="more(<s:property value="#a.id" />)">more action</button>
	
	
	
	
	
<table border="1" align="center">
<tr>
 <th>Question</th>  <th>agree</th>  <th>disagree</th>  <th>N/A</th>
 </tr> 
 	
		<s:iterator value="#a.criticalQuestions" var = "c">

 <tr>
 <td> 	<s:property value="#c.value" /> 
   </td> 
    
   <td>
   <s:property value="#c.agree" /> 
     </td>
     
      <td>
      <s:property value="#c.disagree" /> 
      </td>
      
        <td>
      <s:property value="#c.na" /> 
      </td>
 
 </tr>
 	 </s:iterator>
 
</table>	 
	
	
	
	
	
	<br/>
		<br/>
	
	
</s:iterator>


<a href="/E-Petition/JSP/proposals/votesOfProposal.jsp"  target="_self" > back to the proposal statistic  </a>

					 

     
     
     
     
       
</body>
</html>