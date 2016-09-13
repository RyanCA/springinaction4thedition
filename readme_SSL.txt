
######You can refer to more details on tomcat 8 server by linking to###########
http://localhost:8080/docs/ssl-howto.html

############Self-Signed Certificate############
1. Java command generate local self-signed certificate (with password changeit)
keytool -genkey -alias springinaction -keyalg RSA -keystore springinaction_keystore

######Command lines Begin######
C:\_SoftwareDev\eclipse_projects\springinaction4thedition>keytool -genkey -alias springinaction -keyalg RSA -keystore springinaction_keystore
输入密钥库口令:
再次输入新口令:
您的名字与姓氏是什么?
  [Unknown]:  FirstName
您的组织单位名称是什么?
  [Unknown]:  Pland
您的组织名称是什么?
  [Unknown]:  Com
您所在的城市或区域名称是什么?
  [Unknown]:  Toronto
您所在的省/市/自治区名称是什么?
  [Unknown]:  Ontario
该单位的双字母国家/地区代码是什么?
  [Unknown]:  Canada
CN=FirstName, OU=Pland, O=Com, L=Toronto, ST=Ontario, C=Canada是否正确?
  [否]:  y

输入 <springinaction> 的密钥口令
        (如果和密钥库口令相同, 按回车):

C:\_SoftwareDev\eclipse_projects\springinaction4thedition>

######Command lines End######

2. change the server.xml add below section and ensure the file springinaction_keystore is under directory of ${catalina.base}/conf/springinaction_keystore
    <Connector
           protocol="org.apache.coyote.http11.Http11NioProtocol"
           port="8443" maxThreads="200"
           scheme="https" secure="true" SSLEnabled="true"
           keystoreFile="${catalina.base}/conf/springinaction_keystore" keystorePass="changeit"
           clientAuth="false" sslProtocol="TLS"/>

############CSR signed certificate ############
Please check link for more:
http://localhost:8080/docs/ssl-howto.html 