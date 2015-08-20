<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags"%>

  
<%@ page language="java" import="model.AspectType" import="model.ArgumentScheme" import="model.CriticalQuestion" import="java.util.List" %>


<%@ taglib uri="/struts-dojo-tags" prefix="sx"%>

<!doctype html>

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
<title>Add proposal</title>
<body>
<div class="container">
	     <header class="sixteen columns offset-by-four">   
      <h1>
      ADD PROPOSAL
    </h1>
     </header>
		  <p align="center"><s:property value="#session.attackOrSupport"/><p>
		  <p align="center"><s:property value="#session.criticalQuestionValue"/><p>
		  <br>	
	<form action="addProposal">
	
<div class="row">
<div class="six columns offset-by-four">	
 <table>
<tr>
<td>	
<s:set var="as" value="#session.argumentScheme"/>	
<s:iterator value="#as.aspectTypes"
	var="at">	 
	   <tr>
	   <td>	
  <s:property value="#at.name"/>:
  <s:property value="#at.template"/>
  </td>
</tr>
</s:iterator>
  <td>
  <br/>
  please assign values to these variables:
  <br/>
    <s:property value="#as.variables"/>:
    <textarea class="u-full-width" placeholder="use '/' to separate" name="variables" ></textarea>    
</td>
	 </td>
	 </tr>
	 
	  <tr align="center"  height="40">
	    <td colspan="2">
		  <input name="" type="submit"  value="add"/>
		  <input name="" type="reset" value="reset" />
		</td>
	  </tr>
     </table>
     
     </div>
     </div>
	</form>

</div>
</body>
</html>