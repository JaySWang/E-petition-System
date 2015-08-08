<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
    
<%@ page language="java" import="model.Proposal" import="java.util.List" %>
<%@taglib prefix="s" uri="/struts-tags"%>    
    
<!DOCTYPE html >

<html>
 <s:action name="showProposalDetail" executeResult="true"/>


<head>
<meta  charset="utf-8">
 <!-- FONT
  每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每 -->
  <link href="//fonts.googleapis.com/css?family=Raleway:400,300,600" rel="stylesheet" type="text/css">

  <!-- CSS
  每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每每 -->
   <link rel="stylesheet" href="/E-Petition/css/normalize.css">
  <link rel="stylesheet" href="/E-Petition/css/skeleton.css">
  
  <title>Proposal</title>
</head>


<body>
<div class="container">
	     <header class="sixteen columns offset-by-three">   
      <h1>
PROPOSAL DETAIL    </h1>
     </header>


	<s:set var="p" value="#session.proposal"/>

       <table>
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
		
		

	      <form action="voteProposal"> 
   <div class="row">
          <div class="four columns offset-by-four">		
      <p align="center" >What do you think of this proposal?  </p> 
      

		  <input name="agreeOrNot" type="submit"  value="agree"/>
	<input name="agreeOrNot" type="submit"  value="disagree"/>
		</div>
		</div>
	</form>
     
        <p align="center" >want to view the evaluation of this proposal?  </p> 
     
        <form action="evaluation">
   <div class="row">
          <div class="three columns offset-by-five">	
		
		<input  type="submit"  value="view"/>
</div>
		</div>
		
		
		
	</form>
     
     
     
  </div>     
</body>
</html>