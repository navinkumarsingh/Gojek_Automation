# How to run the script and see results?

Use the below steps to run the script.

  - Unzip the zipped folder.
  - Import to Eclipse or any IDE.
  - Make sure to have Chrome Driver in between 71-73 version only, as the used chromedriver.exe will support these versions only or else please change the chromedriver.exe as per browser version.
  - To run the script, navigate to testng.xml -> right click -> Run As -> TestNG Suite
  - Once execution done, to see the report please navigate to below mentioned path for customised test report 
     ###### Automation\test-output\CustomEmailable-report.html
  -   To check the logs please navigate to Automation\logs folder.
  -   

# Git commands
Step 1: Command to navigate to desired folder
   cd D:\Gojek_Automation

Step 2:
Check for changes by running the command => git status
The above cmd will display list of file changed

Step 3:
If there are any new file generated use git add --all cmd to add all the newly created files

Step 4:
After that commit your changes using below cmd
git commit -m “commit message”

Step 5:
After commiting, Push the changes
git push origin master

Step 6:
Before pushing make sure on which branch you are, by running the cmd => git branch

Step 7:
If we are on master branch then use git push origin master to push it to the master branch  

Step 8:
Use git log cmd to check the change history


