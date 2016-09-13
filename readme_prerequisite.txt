###This project is refered to the book of "Spring in Action, 4th Edition: Covers Spring 4" By Craig Walls###
#######################You can get the digital book from Toronto Library####################################

   PREREQUISITE:
   ############My Development Environtment#############
   java version "1.7.0_51"
   Apache Maven 3.3.3 (7994120775791599e205a5524ec3e0dfe41d4a06; 2015-04-22T07:57:37-04:00)
   Windows 10 Home Upgrade from Window 7 Home
   Tomcat 8
   
   ############Configuration need to be done manually############
   1. To enable SSL for transport security, please add below section in \apache-tomcat-8.0.3\conf\server.xml 
	    <Connector
	           protocol="org.apache.coyote.http11.Http11NioProtocol"
	           port="8443" maxThreads="200"
	           scheme="https" secure="true" SSLEnabled="true"
	           keystoreFile="${catalina.base}/conf/springinaction_keystore" keystorePass="changeit"
	           clientAuth="false" sslProtocol="TLS"/>
	           
   2. springinaction_keystore is also need to be put under the directory of \apache-tomcat-8.0.3\conf\