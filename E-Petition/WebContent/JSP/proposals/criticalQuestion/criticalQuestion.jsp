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
<meta  charset="utf-8">
 <!-- FONT
  每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每 -->
  <link href="//fonts.googleapis.com/css?family=Raleway:400,300,600" rel="stylesheet" type="text/css">

  <!-- CSS
  每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每 -->
  <link rel="stylesheet" href="../../css/normalize.css">
  <link rel="stylesheet" href="../../css/skeleton.css">
  
  <title>CriticalQuestion</title>
</head>


<body>


<form action="getArgumentScheme" id="aOrSForm" target="_blank">
 <input id="aOrsInput" name="attackOrSupport"  type="hidden" />
 <input id="cidInput" name="cid"   type="hidden" />
 <input name="returnMsg" value="addProposal"  type="hidden">	
 <input  id="sInput"  name="sName"   type="hidden"/>
 </form>
 
 <form action="answerCriticalQuestion">
<div class="container">
<div class="row">
<div class="eleven column offset-by-one" >
<s:set value="#session.proposal" var = "p"/>    
        <p align="center" ><h4>What do you think of the flowing aspects of the proposal:p<s:property value="#p.id"/></h4> </p> 
</div>
</div>


<div class="row">
      <div class="twelve columns " >
<s:iterator value="#p.aspects" var = "a">

<div class="row">
      <div class="one-half column" >
	<h5><s:property value="#a.value" /> </h5>
		</div>
	
<div class="one-half column" >
	<ol>	
	<s:iterator value="#a.criticalQuestions" var = "c">
<li><table class="u-full-width ">
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
		
		
		<table  id=<s:property value="#c.id"/>  style="visibility:hidden">
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

Chose a schemeㄩ
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
</table></li>
		 </s:iterator>
		 		 </ol>
	 		</div> 
 </div> 
	</s:iterator>


       
 
  <div class="row">  
      <div class="two column offset-by-four" >

		  <input name="submit" type="submit"  value="submit"/>
	<input name="reset" type="reset"  value="reset"/>

     </div>
     </div>
     
       <sec:authorize ifAllGranted="ROLE_ADMIN">
	<a href="/E-Petition/JSP/admin/addCriticalQuestion.jsp?id=<s:property value="#p.id"/>" target="_self" > add critical question  </a> 
     </sec:authorize>	
      </div> 
       </div>
       
        
 </div>  

 </form>
</body>
</html>