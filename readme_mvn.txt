################################################################################
This is referred to the book of "Spring in Action, 4th Edition" by Craig Walls
1. You can get the digital book from Toronto Library
2. Source code of the book is located at src\test\bookSourceCode\SpringiA4_SourceCode.zip 
###############################################################################              
               
##################Create MVN Project from Scratch For this Project##############

1. Use MAVEN command to create a Maven Project
   mvn archetype:generate -DgroupId=com.pland -DartifactId=springinaction4thedition -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false
   
2. Convert maven web project to eclipse web project
   cd springinaction4thedition
   mvn eclipse:eclipse -Dwtpversion=2.0   #######-Dwtpversion=2.0 it tells Maven to convert the project into an Eclipse web project (WAR), not the default Java project (JAR)

3. Dependency is referred to "Spring In Action 4th Edition" By Craig Walls
   and in the Section of 1.3.1 Spring Module
                            
3. $> mvn clean package 
      (After running above command, maven dependency will appear in eclipse under the directory of Maven Dependecies, and war or jar file will be built; test cases also get executed)

4. Start Tomcat 8 Manually and put the war under its apps directory

5. Access the website
   http://localhost:8080/spittr-0.0.1-SNAPSHOT
   
###############################################################################


##################### MVN mostly used commands for a web project ###############

mvn clean package

############ MVN Dependency Analysis ############
mvn dependency::tree
mvn dependency:analyze
mvn dependency:analyze-dep-mgt

######Below commands don't run correctly due to plugins config in pom.xml######
mvn tomcat7:deploy
mvn tomcat7:undeploy
mvn tomcat7:run
mvn tomcat7:shutdown
     
################################################################################

#################Spring Web Initialization Process##############################




#################### Need more research on development#########################    
      
      MVN Tomcat Plugin only support tomcat 7, and Tomcat 7 only support servlet 3.0, detail as below:
      http://tomcat.apache.org/whichversion.html
      
      Spring framework artifacts:
      http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#dependency-management
      
      Bill of Materials to ensure the version compatability of dependency jars
      
      My experience showed up when dealing with wierd exceptions. I somehow managed to fix it because I believe it's something from mismatch jar version.
      
      HTTP vs HTTPS (If you input https, then Web Server will handle it as https request instead of http (Mentioned in "Spring In Action 4th Edition")
      
      Application of Redirect request in Submit form (Mentioned in "Spring In Action 4th Edition")
      
      Method Para in the format of (String ...)
      
      SpitterRepositoryImple must be annotated with @Component, otherwise container can't autowire SpitterRepository to relevant Controller
      
      hasCode(), equals() in Spitter.java still need to provide my version of implementation???
      
      Understand the method of shouldProcessRegistrationForm() in SpitterControllerTest.java for below part:
      verify(mockRepository, atLeastOnce()).save(unsaved);???
      
      Is Spring provide model-to-form binding in addition to form-to-model binding???
      
      Java Resource files must put under src/main/resources
      
      Procedure of css file reference in spring web project
      1. Must define resource mapping in WebConfig.java
      2. Put resource in the right directory
      3. Import those css files in jsp file
      
      namespace must be existed online???
      such as <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t" %>
      
      Hibernate session is thread safe?
      JPA EntityManager is thread safe?
      
      
      AOP Based Exception Control - @ControllerAdviser at class level and @ExceptionHandler(*.class) at method level
      Redirect and carring data across redirect
      Security - Web Security based on Filter
      
      
      RPC includes:
      RMI: Use RMI, java object must be serializied; 
           Must use java (That means it's not language independent);
           Server and Client must use same version of Java runtime to avoid weird issues;
           May blocked by firewall;
           
      What is SOA?
      SOA means many things to different people. But at the center of SOA is 
      the idea that applications can and should be designed to lean on a common 
      set of core services instead of reimplementing the same functionality for 
      each application.
      
      What you doing now?
      Write your own annotation to implement Aspect programming!!!
      OpenID
      SingleSignOn
      Heloku development
      Datasource (App Server and Libs)
      
      
      ############ Not Done Yet in this book ################################
      Thymelef not implement in this project(chapter 6.4)???
      Carrying data across redirect requests(Chapter 7.5)??? (Need to know more)
      Web Flow is not implemented(Chatper 8)???
      Spring Data Persistency not implement yet???
      Spring Non SQL not implement yet
      Spring Cache not implement yet 
###############################################################################
