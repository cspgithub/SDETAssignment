# SDETAssignment

# 1st Approach:
1. Access/Visit https://github.com/cspgithub/SDETAssignment/actions
2. Click Java CI with Maven - Manual Trigger under Workflows
3. Click /Run Run Workflow
4. Click the latest run and see the excution report under Artifacts section


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

