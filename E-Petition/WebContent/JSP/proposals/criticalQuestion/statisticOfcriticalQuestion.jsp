<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
    
<%@ page language="java" import="model.Proposal" import="java.util.List" %>
<%@taglib prefix="s" uri="/struts-tags"%>    
    
<!DOCTYPE html >




<html>


 <script>   
		  var m="${requestScope.message}"; 
	if(m!=""){	  
  var   bln   = m;
  alert(bln);  
   requestScope.message="";
	}
  </script> 




<head>
<meta  charset="utf-8">
 <!-- FONT
  每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每 -->
  <link href="//fonts.googleapis.com/css?family=Raleway:400,300,600" rel="stylesheet" type="text/css">

  <!-- CSS
  每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每 -->
  <link rel="stylesheet" href="/E-Petition/css/normalize.css">
  <link rel="stylesheet" href="/E-Petition/css/skeleton.css">
    <link rel="stylesheet" href="/E-Petition/css/custom.css">
  
  
  <title>CriticalQuestion</title>
</head>


<body>
<div class="container">
	     <header class="eleven columns offset-by-one">   
      <h2>
    VOTES OF THE ASPECTS OF THE PROPOSAL
    </h2>
     </header>

   	 	 <div class="row">
<div class="nine columns offset-by-three">  
<s:iterator value="#session.aspects" var = "a">
	
	<h4><s:property value="#a.value" /></h4> 
	

	
<table>
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
	

	
</s:iterator>

<a href="/E-Petition/JSP/proposals/votesOfProposal.jsp"  target="_self" > to the proposal statistic  </a>
					 

     
     
     
     </div>
     </div>
  </div>     
</body>
</html>