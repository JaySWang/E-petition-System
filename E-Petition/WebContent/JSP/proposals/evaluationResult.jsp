<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="GB18030"%>
    <%@taglib prefix="s" uri="/struts-tags"%>    
    
<!DOCTYPE html>
<html>
<head>
<meta  charset="utf-8">
 <!-- FONT
  �C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C -->
  <link href="//fonts.googleapis.com/css?family=Raleway:400,300,600" rel="stylesheet" type="text/css">

  <!-- CSS
  �C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C�C -->
   <link rel="stylesheet" href="/E-Petition/css/normalize.css">
  <link rel="stylesheet" href="/E-Petition/css/skeleton.css">
  
  <title>KCL-Epetition</title>
</head>
<body>

    <header class="eleven columns offset-by-three">   
      <h2>
    EVALUATION RESULT OF THE PROPOSAL
    </h2>
     </header>

<div class="container">
 <div class="row">
<div class="six column offset-by-three"> 

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

</div>
</div>    
</body>
</html>