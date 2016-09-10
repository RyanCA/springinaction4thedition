https://github.com/RyanCA
ryan.c*.6*@gmail.com

0. ########################mvn mostly used commands###################
mvn clean
mvn compile
mvn package

#Start the server
mvn clean install tomcat:run

#Access the website
http://localhost:8080/spittr-0.0.1-SNAPSHOT

#New commands learned
mvn dependency:tree

#######################################################################

1. #######How to create a mvn WEB project and push to github###########

1.1 #Move to the right path
cd C:\_SoftwareDev\eclipse_projects

1.2 #Create maven project
###**********###
mvn archetype:generate -DgroupId=com.pland -DartifactId=springinaction4thedition -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false

1.3 #Convert maven web project to eclipse web project
    #-Dwtpversion=2.0 tells Maven to convert the project into an Eclipse web project (WAR), not the default Java project (JAR)
###**********###
cd springinaction4thedition
mvn eclipse:eclipse -Dwtpversion=2.0

1.4 #Import the project from eclipse

1.5 #Modify pom.xml file and add the dependecies you want in your project such as spring...
    #For details, refer to http://www.mkyong.com/maven/how-to-create-a-web-application-project-with-maven/
...

1.6 #access below url
###**********###
mvn package
http://localhost:8080/springinaction4thedition/

1.7 #To clean up all artifacts
mvn clean

1.8 #add it to git hub
cd C:\_SoftwareDev\eclipse_projects
git init springinaction4thedition #.git directory created
cd .\springinaction4thedition
git add .
git status
git commit -m "Initialization commit batch"

#If there is no repository on Github for your source, then you need do the following step
#1.8.1 create a repo on github through github web UI
#1.8.2 copy the url of new repo and use command below to associate local source to it
git remote add origin https://github.com/RyanCA/springinaction4thedition.git
git remote -v 
#following is the result of above git remote command
origin  https://github.com/RyanCA/springinaction4thedition.git (fetch)
origin  https://github.com/RyanCA/springinaction4thedition.git (push)

git push origin master

2. ###How to pull source from github###
#You may need the below one if it is not assoicated with remote
mkdir springinaction4thedition
git init springinaction4thedition
git remote add origin https://github.com/RyanCA/springinaction4thedition.git
git pull https://github.com/RyanCA/springinaction4thedition.git

###Note###
1. Once the repo created on Github, the name can't changed but the project name on eclipse can be changed.
For this one, the project name is called J01_Spring, later on I changed it to springinaction4thedition to keep it consistent with repo name

3. ###How to use git tag###
git tag -a v0.1 -m 'Simple Spring MVC with Maven and Eclipse'
git tag
git push origin v0.1 #push tag into git server

4. ###git clone command###
git clone https://git.heroku.com/carrental2015.git

5. ###git reverse the rm action###
git rm readme_mvn_startup.txt #This will delete a file, if you don't want to delete it, you can do the following to get it back
git reset HEAD readme_mvn_startup.txt
git checkout readme_mvn_startup.txt

#######################################################################

4. ####################Heroku related##################################
4.1 heroku reference
https://devcenter.heroku.com/articles/getting-started-with-java#set-up

4.2 use cd command move to git project (such as under springinaction4thedition project) and create heroku project
heroku create #create with system random name
heroku create carrental2015 # heroku create app given name
******************heroku ouput after above command***********************
C:\_SoftwareDev\eclipse_projects\springinaction4thedition>heroku create carrental2015
Creating carrental2015... done, stack is cedar-14
https://carrental2015.herokuapp.com/ | https://git.heroku.com/carrental2015.git
Git remote heroku added
*************************************************************************
heroku apps #heroku displays apps
git remote -v
heroku apps:destroy --app carrental2015 # heroku destroy app

4.3 use git push to put source code to heroku git and deploy app(This will stop running apps, so you don't need to use command of "heroku ps:scale web=0" to stop app before deploy)
git push heroku master
*******************************heroku ouput*******************************
remote: -----> Discovering process types
remote:        Procfile declares types -> (none)
remote:
remote: -----> Compressing... done, 62.8MB
remote: -----> Launching... done, v5
remote:        https://carrental2015.herokuapp.com/ deployed to Heroku
remote:
remote: Verifying deploy.... done.
To https://git.heroku.com/carrental2015.git
 * [new branch]      master -> master
**************************************************************************

4.4 Check app is deployed or not.
    Please check POM.XML and PROCFILE to see how we can make web app runnable on heroku platform 
    through heroku command
heroku ps #check if any app is up
heroku ps:scale web=1 #Ensure that at least one instance of the app is running unless app crashed during the launch
heroku logs #to see log if the server starts successfully

4.5 Now visit the app at the URL generated by its app name.
    As a handy shortcut, you can open the website as follows:
heroku open

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
