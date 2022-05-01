# SDETAssignment
### Dockerized 
# 1st Approach:
1. Access/Visit https://github.com/cspgithub/SDETAssignment/actions
2. Click Java CI with Maven - Manual Trigger under Workflows
3. Click /Run Run Workflow
4. Click the latest run and see the excution report under Artifacts section

![githubactions](https://user-images.githubusercontent.com/28858542/166144072-32a471af-5754-481d-9d84-39c4da10f968.PNG)



# 2nd Approach:

1. clone the repo [https://github.com/cspgithub/SDETAssignment.git] in you local m/c
2. open 2022-java-seleniumLearning\demo\src\test\java\resources\config.properties
   2.1 change/update value for executionmode as remote
3. create/update/code and then push the code using following commands [it will trigger  "Java CI with Maven" Actions]
   3.1 git add .
   3.2 git commit -m "ur message"
   3.3 git push
4. Access https://github.com/cspgithub/SDETAssignment/actions
5. Click the latest run and see the excution report under Artifacts section

# Project Structure
-> Helper Methods under SeleniumActions class
-> Followed PajeObjectModel
-> Executed locally/remotely SeleniumHub/Node - just change execution moce value in config file thats it....
![image](https://user-images.githubusercontent.com/28858542/166144189-79e3157e-0bb6-47c6-9f31-4e05a9f6878b.png)
![image](https://user-images.githubusercontent.com/28858542/166144208-1b51e160-8618-4dc2-9941-c2eb0f13d028.png)
![image](https://user-images.githubusercontent.com/28858542/166144222-8fb269c9-e531-4b44-ad42-21b5eac7ff0b.png)
![image](https://user-images.githubusercontent.com/28858542/166144240-13a45747-4c35-40fe-8d85-bb9de4b9200d.png)
