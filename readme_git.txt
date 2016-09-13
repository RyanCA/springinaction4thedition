################################################################################
This is referred to the book of "Spring in Action, 4th Edition" by Craig Walls
You can get the digital book from Toronto Library
###############################################################################

############################## Git Repository Location #########################
https://github.com/RyanCA

############################## Git Manual ######################################
https://git-scm.com/book/en/v2

############################## If project in Git ##############################
git clone https://github.com/RyanCA/springinaction4thedition.git

############################# If project in local only ########################

1. Refer to "Create MVN Project from Scratch For this Project" in readme_mvn.txt to 
create the project and develop it

2. Use git commands below to push resources into git
 
cd ......\eclipse_projects
git init springinaction4thedition # .git directory created in local
cd .\springinaction4thedition
git add .                         # Add all resources from UNTRACKED To TRACKED
git status                        # Check resources info before commit
git commit -m "Init commit batch" # resources updated from TRACKED to STATGED
git push origin master
 
################################################################################
If no repository for your project on Github, then you need do following steps
################################################################################
2.1 create a repo on github through github web UI

2.2 copy the url of new repo and use below commands to associate local and git server 
git remote add origin https://github.com/RyanCA/springinaction4thedition.git
git remote -v                     # Check if add remote successfully or not
origin  https://github.com/RyanCA/springinaction4thedition.git (fetch)
origin  https://github.com/RyanCA/springinaction4thedition.git (push)

################################################################################

################################# Git Notes ####################################
1. Once the repo created on Github, the name can't changed but the project name on eclipse can be changed.
   Eg: the project name is called J01_Spring, later on I changed it to springinaction4thedition to keep it consistent with repo name

############################### Git tag ########################################
git tag -a v0.1 -m 'Simple Spring MVC with Maven and Eclipse'
git tag
git push origin v0.1              # Push tags into git server

git tag                           # List all tags
git show -v0.1                    # Show specific Tag

################################################################################

############################# Git reverse rm action ############################
# Refer to page 57 of progit-en.1084.pdf or https://git-scm.com/book/en/v2
git rm readme_mvn_startup.txt     #This will delete a file, if you don't want to delete it, you can do the following to get it back
git reset HEAD readme_mvn_startup.txt
git checkout readme_mvn_startup.txt

###############################################################################

git log
git log --oneline or --decorate or --graph or --all
git diff 
git remote -v
git remote add <shortname> <url>
git remote add pb https://github.com/paulboone/ticgit

git fetch pb
git pull
git clone
git remote show origin
git push

git remote rename name1 name2
git remote rm name

# Refer to page 90 of progit-en.1084.pdf or https://git-scm.com/book/en/v2  
git branch xxx
git checkout xxx

#Branch related
git checkout -b heroku_local
git status
git add ...
git put origin heroku_local

