<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="/struts-dojo-tags" prefix="sx"%>
<!DOCTYPE html>



 <s:action name="getArgumentScheme" executeResult="true"/>


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

<title>Add critical question</title>

<body>

<div class="container">
	     <header class="sixteen columns offset-by-three">   
      <h1>
    ADD CRITICAL QUESTION TEMPLATES
    </h1>
     </header>
     
	
		
	
	
	<form action="addCriticalQuestionTemplate">
	 
	 <div class="row">
<div class="six columns offset-by-four">
  <p>please use "/" to separate questions for one aspect</p>
	  <table>
	 
	 	 	<s:set var="as" value="#session.argumentScheme"/>
	 	 	
	 	 	
	 		 	 	 <s:iterator value="#as.aspectTypes" var="at">
	 <tr>
	 
	 	 <td ><s:property value="#at.name"/></td>
	 
	 <td><s:property value="#at.template"/></td>
	</tr>
	
	 <tr  height="40">
	    <td>Questions template:</td>
	    <td><textarea name=<s:property value="#at.name"/> ></textarea></td>
	  </tr>
	  
</s:iterator>
     </table>
     </div>
     </div>
     
          <div class="row">
          <div class="four columns offset-by-five">
    
       <input name="" type="submit"  value="add"/>
		  <input name="" type="reset" value="reset" />
    </div>
    </div>
    
	</form>
	<br>
	</div>
</body>
</html>