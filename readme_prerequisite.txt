###This project is refered to the book of "Spring in Action, 4th Edition: Covers Spring 4" By Craig Walls###
#######################You can get the digital book from Toronto Library####################################

0. Prerequite:
   0.1. Tomcat 8
   0.2. Modify \apache-tomcat-8.0.3\conf\server.xml, ensure below section is uncommented to enable use SSL
	    <Connector
	           protocol="org.apache.coyote.http11.Http11NioProtocol"
	           port="8443" maxThreads="200"
	           scheme="https" secure="true" SSLEnabled="true"
	           keystoreFile="${catalina.base}/conf/springinaction_keystore" keystorePass="changeit"
	           clientAuth="false" sslProtocol="TLS"/>
	           
   0.3. springinaction_keystore is under the directory of \apache-tomcat-8.0.3\conf\