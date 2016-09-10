###This project is refered to the book of "Spring in Action, 4th Edition: Covers Spring 4" By Craig Walls###
#######################You can get the digital book from Toronto Library####################################

1. create pom.xml OR "you can use mvn command to create a mvn project"
   eg: 
   mvn archetype:generate -DgroupId=com.mycompany.app -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

2. Dependency is referred to Spring In Action 4th Edition By Craig Walls
   and int the Section of 1.3.1 Spring Module
                            
3. $> mvn clean package 
      (After runnig above command, maven dependency will appear in eclipse, and war or jar file will be built;
       test case also get executed)
      
      mvn test
      mvn tomcat7:deploy
      mvn tomcat7:undeploy
      mvn tomcat7:run
      mvn tomcat7:shutdown
      mvn dependency::tree      #It can be used to see dependency information of all the jars

      
      
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
      
      Thymelef not implement in this project???
      
      
      
      
       
       