<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
 <%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>   
    
<%@ page language="java" import="model.Proposal" import="java.util.List" %>
<%@taglib prefix="s" uri="/struts-tags"%>    
    
<!DOCTYPE html>




<html>

<script>

function more(id){

 var o = document.getElementById(id);
 
o.style.visibility="visible";
 
}


function attack(cid,sName){

document.getElementById("aOrsInput").value="attack";
document.getElementById("cidInput").value=cid;
document.getElementById("sInput").value=document.getElementsByClassName(cid).item(0).value;

document.getElementById("aOrSForm").submit();

} 

function support(cid){
document.getElementById("aOrsInput").value="support";
document.getElementById("cidInput").value=cid;
document.getElementById("sInput").value=document.getElementsByClassName(cid).item(0).value;

document.getElementById("aOrSForm").submit();

}


</script>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>CriticalQuestion</title>
</head>


<body>


<form action="getArgumentScheme" id="aOrSForm" target="_blank">


 <input id="aOrsInput" name="attackOrSupport"  type="hidden" />
 <input id="cidInput" name="cid"   type="hidden" />
 <input name="returnMsg" value="addProposal"  type="hidden">	
 <input  id="sInput"  name="sName"   type="hidden"/>
 </form>


     <s:form action="answerCriticalQuestion">
     
 <s:set value="#session.proposal" var = "p"/>    
        <p align="center" >What do you think of the flowing aspects of the proposal:p<s:property value="#p.id"/> </p> 
     
<s:iterator value="#p.aspects" var = "a">

	<s:property value="#a.type" />:
	
	<s:property value="#a.value" /> 
	<br/>
	
	
	
	<s:iterator value="#a.criticalQuestions" var = "c">
<table border="1">
<tr>
 <th>
	 <s:property value="#c.value" /> 

  <input type="radio"   name= <s:property value="#c.id"/>  value="agree" />agree
<input type="radio"   name=<s:property value="#c.id"/>  value="disagree" />disagree
<input type="radio"   name=<s:property value="#c.id"/>   value="na"  checked = "checked"/>N/A
	</th>
	
	 </tr> 
<tr>
<td>
<button type="button" onclick="more(<s:property value="#c.id" />)">more action</button>
		
		
		<table  id=<s:property value="#c.id"/>  width="350" style="visibility:hidden">
<tr>
<tr>
<td>
	
		<a href="/E-Petition/JSP/proposals/a&sProposals.jsp?cid=<s:property value="#c.id"/>" target="_self" >   
		
		attackers&supporters
   </a>
   
</td>
</tr>

<tr>
<td>

Chose a scheme£º
<Select class=<s:property value="#c.id"/>  >
<s:iterator value="#session.notGeneralProposalSchemes"
	var="as">
	<option>
           <s:property value="#as.name"/>
          </option>  
             
 	</s:iterator>

</Select>
<button type="button" onclick="attack(<s:property value="#c.id" />)">attack</button>
<button type="button" onclick="support(<s:property value="#c.id" />)">support</button>

 
 	
 	</td>
 	</tr>
 	</table>
</td>
</tr>
	 
</table>	 
	 </s:iterator>
	 
	 
		
	
		

<br>
	</s:iterator>




       
 
   
	  <table width="350" border="0" align="center" cellpadding="0" cellspacing="0" class="table">

	  
	  <tr align="center"  height="40">
	    <td colspan="2">
		  <input name="submit" type="submit"  value="submit"/>
	<input name="reset" type="reset"  value="reset"/>
		</td>
	  </tr>
     </table>
	</s:form>
     
       <sec:authorize ifAllGranted="ROLE_ADMIN">
	<a href="/E-Petition/JSP/admin/addCriticalQuestion.jsp?id=<s:property value="#p.id"/>" target="_self" > add critical question  </a> 
     </sec:authorize>	
       
</body>
</html>