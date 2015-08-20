<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="/struts-dojo-tags" prefix="sx"%>
<!DOCTYPE html>



 <s:action name="showArgumentSchemeDetail" executeResult="true"/>


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
    ADD CRITICAL QUESTION
    </h1>
     </header>

	
	
	<form action="addCriticalQuestion">
	 
	 	 <div class="row">
<div class="six columns offset-by-four">
		  <p>you can use "/" to separate questions for each aspect</p>

	  <table>
	 
	 	 	<s:set var="p" value="#session.proposal"/>
	 	 	
	 	 	
	 		 	 	 <s:iterator value="#p.aspects" var="a">
	 <tr>
	 
	 	 <td><s:property value="#a.type"/></td>
	 
	 <td><s:property value="#a.value"/></td>
	</tr>
	
	 <tr  height="40">
	    <td>Questions:</td>
	    <td><textarea name=<s:property value="#a.type"/>></textarea></td>
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
</div>
</body>
</html>