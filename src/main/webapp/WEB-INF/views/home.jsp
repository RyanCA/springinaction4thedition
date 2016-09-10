<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<%@ page session="false" %>
<!-- Use Tile3, remove those duplicated elements -->
<!-- 
<html>
  <head>
    <title>Spittr</title>
    <link rel="stylesheet"
          type="text/css"
          href="<c:url value="/resources/style.css" />" >
  </head>
  <body>
-->
    <h1><s:message code="spittr.welcome" /></h1>
    <!-- There are more spring tag related content in Chapter 6 -->
    <a href="<s:url value="/spittles" />"> Spittles</a> |
    <a href="<s:url value="/spitter/register" />">Register</a>

<!-- Use Tile3, remove those duplicated elements -->    
    <!-- 
  </body>
</html>
 -->