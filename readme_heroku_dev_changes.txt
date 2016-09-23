################################################################################
This is referred to the book of "Spring in Action, 4th Edition" by Craig Walls
1. You can get the digital book from Toronto Library
2. Source code of the book is located at src\test\bookSourceCode\SpringiA4_SourceCode.zip 
###############################################################################

##################### Heroku History Version #################################
git commit -m "1st Runnable Heroku Version" 
git tag -a v0.3 -m "1st Runnable Heroku Tag"
git tag
git push origin v0.3

###############################################################################
#                                                                             #
#                  Java Web Deployed on Heroku Tomcat                         #
#                                                                             #
###############################################################################

###### 1. Refercen link ######
https://devcenter.heroku.com/articles/java-webapp-runner#prerequisites

###### 2. Heroku Local Preparatio n######
1. Add tomcat plugin in pom.xml (Reference the pom.xml)
2. $> mvn clean package
3. $> java -jar target/dependency/webapp-runner.jar target/springaction.war
4. http://localhost:8080                 # Note the url without appending /bootstrap in the end
5. $> git add                            # Add any files you added or updated
6. $> git commit -m "xxxxx"   
7. $> git push origin master

####### 3. Starting Heroku Related Process ######
8. $> heroku create springaction             # Please provide name otherwise will be random name
                                             
Creating springaction... done
https://springaction.herokuapp.com/ | https://git.heroku.com/springaction.git

9. $> git remote -v                      # Code base is created in Heroku now
heroku  https://git.heroku.com/springaction.git (fetch)
heroku  https://git.heroku.com/springaction.git (push)
origin  https://github.com/RyanCA/springinaction4thedition.git (fetch)
origin  https://github.com/RyanCA/springinaction4thedition.git (push)
 
10. $> git push heroku master            # Push source to heroku and deploy it    
        
####### Reference of result ######
Counting objects: 178, done.
Delta compression using up to 4 threads.
Compressing objects: 100% (153/153), done.
Writing objects: 100% (178/178), 1.77 MiB | 603.00 KiB/s, done.
Total 178 (delta 51), reused 0 (delta 0)
remote: Compressing source files... done.
remote: Building source:
remote:
remote: -----> Java app detected
remote: -----> Installing OpenJDK 1.8...
......
......
......
remot          [INFO] Installing /tmp/build_62eac7386be498174df30d0e70746906/pom.xml to /app/tmp/cache/.m2/repository/pland/com/spittr/0.0.1-SNAPSHOT/spittr-0.0.1-SNAPSHOT.pom
remote:        [INFO] ------------------------------------------------------------------------
remote:        [INFO] BUILD SUCCESS
remote:        [INFO] ------------------------------------------------------------------------
remote:        [INFO] Total time: 18.068 s
remote:        [INFO] Finished at: 2016-09-23T02:29:11+00:00
remote:        [INFO] Final Memory: 28M/189M
remote:        [INFO] ------------------------------------------------------------------------
remote: -----> Discovering process types
remote:        Procfile declares types -> (none)
remote:
remote: -----> Compressing...
remote:        Done: 104.1M
remote: -----> Launching...
remote:        Released v3
remote:        https://springaction.herokuapp.com/ deployed to Heroku
remote:
remote: Verifying deploy... done.
To https://git.heroku.com/springaction.git
 * [new branch]      master -> master

11. $> >heroku open                      #It will launch browser along with url
heroku-cli: Installing CLI... 18.18MB/18.18MB 
   

########################## Heroku Manual ######################################
https://devcenter.heroku.com/articles/getting-started-with-java#set-up

Install heroku Environment (install 03_heroku-toolbelt_HerokuOnly.exe)

###############################################################################

######################### Heroku Operations ###################################
1.
heroku login
    
2. 
git clone https://github.com/RyanCA/bootstrap.git

3.
cd bootstrap

4. create heroku project

$> heroku create springaction             # heroku create app given name


5. If you want to remove this app
$> heroku apps:destroy -app springaction

###### Reference of Result Begin #######
 !    WARNING: This will delete secure-island-32273 including all
 !    add-ons.
 !    To proceed, type secure-island-32273 or re-run this
 !    command with --confirm secure-island-32273

secure-island-32273
Destroying secure-island-32273 (including all add-ons)... done
###### Reference of Result End #######

6. display heroku apps
$> heroku apps                             # heroku displays apps
carrental2015
secure-island-32273

7. use git push to put source code to heroku git and deploy app
(This will stop running apps, so you don't need to use command of "heroku ps:scale web=0" to stop app before deploy)
git push heroku master


8. Check app is deployed or not. Please check POM.XML and PROCFILE to see how we 
  can make web app runnable on heroku platform through heroku commands
heroku ps:scale web=1                   # Ensure that at least one instance of the app is running unless app crashed during the launch
heroku ps                               # check if any app is up
heroku logs                             # to see log if the server starts successfully
heroku logs -t                          # see tail log in real time
heroku logs -n 1500                     # heroku save 1500 line of logs at max

9. Now visit the app at the URL generated by its app name. As a handy shortcut, you can open the website as follows:
heroku open

################################################################################

###################### To be continued... ######################################
4.6 Heroku DB related
https://devcenter.heroku.com/articles/heroku-postgresql#provisioning-the-add-on

4.6.1 
heroku addons #to get all addons infomation including database)

Plan                         Name                Price
---------------------------  ------------------  -----
heroku-postgresql:hobby-dev  glowing-newly-5714  free

=== Attachments for carrental2015
Name      Add-on              Billing App
--------  ------------------  -------------
DATABASE  glowing-newly-5714  carrental2015

#If database is not there, please using below command to set it up.
4.6.1.1
heroku addons:create heroku-postgresql:hobby-dev

4.6.2 
heroku config #Check db url

=== carrental2015 Config Vars
DATABASE_URL: postgres://wmoemmlbtmyaob:Mzg3OijAltF2G6v0AWDqVrRUlt@ec2-54-83-17-
8.compute-1.amazonaws.com:5432/deghr853ufffo3
JAVA_OPTS:    -XX:+UseCompressedOops

4.6.3 check DB detail information
heroku pg:info

4.6.4 import data from Postgre dump file
https://devcenter.heroku.com/articles/heroku-postgres-import-export#import

heroku pg:psql #To run this command, Postgre DB must installed in local as pre-requisite

#######################################################################

