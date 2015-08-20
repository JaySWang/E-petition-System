<%@ page language="java" contentType="text/html"%>
    <%@taglib prefix="s" uri="/struts-tags"%>    
    <%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>   
    
<!DOCTYPE html>
<html>
<head>
<meta  charset="utf-8">
 <!-- FONT
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
  <link href="//fonts.googleapis.com/css?family=Raleway:400,300,600" rel="stylesheet" type="text/css">

  <!-- CSS
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
   <link rel="stylesheet" href="/E-Petition/css/normalize.css">
  <link rel="stylesheet" href="/E-Petition/css/skeleton.css">
  
  <title>KCL-Epetition</title>
</head>
<body>

    <header class="eleven columns offset-by-three">   
      <h2>
    EVALUATION OF THE PROPOSAL
    </h2>
     </header>
<div class="container">
<div class="row">
 
 
<div class="six columns"> 
      <h5>
    EVALUATION RESULT OF THE PROPOSAL
    </h5>
<em>based on the following evaluation strategies:</em>
<ol>
<li> based on general votes</li>
<li> based on above and involves evaluating critical questions</li>
<li> based on above and involves evaluating attackers and supporters    </li>


</ol>

  <em>results:</em>
  
    <ol>
  <s:iterator value="#request.results" var="r">
		
		<li><s:property value="#r"/></li>
		
		
</s:iterator>
</ol>
</div>
<div class="six columns "> 
   <h5>
     VOTING STATISTIC OF THE PROPOSAL
    </h5>
       <table >
       	<tr>
       		<s:set var="p" value="#session.proposal"/>    
  <s:iterator value="#p.aspects" var="a">		
		<th><s:property value="#a.type"/></th>
</s:iterator>
	<th>agree</th>
		<th>disagree</th>
</tr>
	<tr>
  <s:iterator value="#p.aspects" var="a">
		
		<td><s:property value="#a.value" escape="false" /></td>
</s:iterator>
			
	<td><s:property value="#p.agree"/></td>
		
		<td><s:property value="#p.disagree"/></td>	
	</tr>
		</table>
		</div>
</div>




   	 	 <div class="row">
<div class="eight columns offset-by-three">  
   <h5>
    VOTING STATISTIC OF THE CRITICAL QUESTIONS
    </h5>
<s:iterator value="#p.aspects" var = "a">
	
	<h5><s:property value="#a.value" /></h5> 
	<sec:authorize ifAllGranted="ROLE_OFFICER">	
	<a href="/E-Petition/JSP/officer/addCriticalQuestion.jsp" target="_self" > add critical question </a> 	
	</sec:authorize>
	
<table>
<tr>
 <th>Question</th>  <th>agree</th>  <th>disagree</th>  <th>N/A</th>
 </tr> 
 	
		<s:iterator value="#a.criticalQuestions" var = "c">

 <tr>
 <td> 	<s:property value="#c.value" escape="false"  /> 
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
 <tr><td>
 		<a href="/E-Petition/JSP/proposals/a&sProposals.jsp?cid=<s:property value="#c.id"/>" target="_self" >   	
		attackers&supporters</a>
   </a>
 </td></tr>
 	 </s:iterator>
 
</table>	 

</s:iterator>					 
     
     </div>
     
     </div>
     
   	 	 <div class="row">
   	 	 <div class="six columns "> 
             <a href="/E-Petition/index.jsp" target="_self" ><b>back to proposal list<b></a> 
		<p>
		</p>
 		</div>

 
</div>  
  
</body>
</html>