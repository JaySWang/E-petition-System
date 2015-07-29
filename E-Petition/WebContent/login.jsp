<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<!DOCTYPE html>  
<html>  
<head lang="en">  
<title>login</title> 
 <!-- FONT
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
  <link href="//fonts.googleapis.com/css?family=Raleway:400,300,600" rel="stylesheet" type="text/css">

  <!-- CSS
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
  <link rel="stylesheet" href="css/normalize.css">
  <link rel="stylesheet" href="css/skeleton.css">
    <link rel="stylesheet" href="css/custom.css">
  
 
</head>  
<body>  
<div class="container section">

    <form action ="j_spring_security_check" method="POST">  
              <div class="row">
          
                <label for="username">username</label>

          <input type ='text' name='j_username' id="username">
                      
                      <label for="password">password</label>
           <input type ='password' name='j_password' id="password"> 
       </div>
              <div class="row">
            <input name ="reset" type="reset" value="reset">  
            <input name ="submit" type="submit" value="submit"> 
            </div> 
    </form> 
    </div>
</body>  
</html>