<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<!-- This page doesn't need to be involved into session, so doesn't need to 
create session related objects. Better for performance -->
<%@ page session="false" %>

<!-- Use Tile3, remove those duplicated elements -->
<!-- 
<html>
  <head>
    <title>Spittr</title>
    <link rel="stylesheet"
          type="text/css"
          href="<c:url value="/resources/style.css" />" >
 -->          
    <!-- Added to input our own css or other 3rd party css files -->      
    <link href="<c:url value="/resources/plandstrap.0.0.1/css/plandstrap.css" />" rel="stylesheet">

<!-- Use Tile3, remove those duplicated elements -->
<!--   
  </head> 
    
  <body>
-->
    <h1>Register</h1>
    <!-- ###### Form has not action, so the post will be post back to the same 
    URL refer to Spring in Action 4th Edition right before section of 5.4.1 -->
    <!-- This is the version before introducing From Validation -->
    <!--
    <form method="POST">
      First Name: <input type="text" name="firstName" /><br/>
      Last Name: <input type="text" name="lastName" /><br/>
      Username: <input type="text" name="username" /><br/>
      Password: <input type="password" name="password" /><br/>
      <input type="submit" value="Register" />
    </form>
    -->
    
    <!-- commandName mapping to the the key of spitter in controller model -->
    <!-- enctype attribute is for config multipart request 
         enctype attribute set to multipart/form-data. 
         This tells the browser to submit the form as multipart data instead of form data. 
         Each field has its own part in the multipart request -->
         
    <sf:form method="POST" 
             commandName="spitter" 
             enctype="multipart/form-data" > 
             
      <sf:label path="firstName" cssErrorClass="error">First Name: </sf:label> <sf:input type="text" path="firstName" /> <sf:errors path="firstName" cssClass="error" /><br/>
      <sf:label path="lastName" cssErrorClass="error">Last Name: </sf:label>  <sf:input type="text" path="lastName" /> <sf:errors path="lastName" cssClass="error" /><br/>
      <sf:label path="email" cssErrorClass="error">Email: </sf:label>  <sf:input type="email" path="email" /> <sf:errors path="email" cssClass="error" /><br/> <!-- Starting from Spring 3.1, it supports HTML 5 specific text type such as email, data -->
      <sf:label path="username" cssErrorClass="error">Username: </sf:label>  <sf:input type="text" path="username" /> <sf:errors path="username" cssClass="error" /><br/>
      <sf:label path="password" cssErrorClass="error">Password: </sf:label>  <sf:input type="password" path="password" /> <sf:errors path="password" cssClass="error" /><br/>
      <!--  config multipart request  -->
      <label>Profile Picture</label>: <input type="file" name="profilePicture"  accept="image/jpeg,image/png,image/gif" /><br/>
      <input type="submit" value="Register" />
    </sf:form>

<!-- Use Tile3, remove those duplicated elements -->
<!--     
  </body>
  
</html>
 -->
