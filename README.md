Scope 
----------------------------------------------
1. total time spent on the problem to solve approx 3 Hours 
2. This is very basic spring boot app with server side implemented using Kotlin and Sqlite3 as Database .
3. In interest of time basic TDD infrastrcutre is shown with .feature file .
4. Implementation is expected to have more test cases .
5. Performance of this application can be improved using aync, non-blocking implemenation may be using flux or mono library .
6. CSV insert implemenation can be done in batches under asyn mode 
7. Application is tested using auto test written in Postman 


Development Process 
----------------------------------------------
1. created bratch ```create_test_infra``` on git  and added a unit test cases and raised a pull request and mrgeed it 
2. created new branch ```crud_ops``` and implemented business logic to pass the test cases .Raised a PR ( pull request ) and mrgered it to master 

Below are the git branches information 
$ git branch -r


![image](https://user-images.githubusercontent.com/14144934/123180829-aa3e0c80-d4be-11eb-8144-b5da1f213c59.png)




How to Build the application 
----------------------------------------------
1. download the source from Git using git clone 
2. open the application with intellij and click on maven to build application 

 ![image](https://user-images.githubusercontent.com/14144934/123178755-76f97e80-d4ba-11eb-8149-93c8b68480dd.png)
 
 
3. Dependencies sqllite3 Database - It can be installed using the link https://www.sqlite.org/download.html and dowload the souces file.Once downloaded verify the installation from command line .


![image](https://user-images.githubusercontent.com/14144934/123178954-ea02f500-d4ba-11eb-9316-48b1b8693530.png)



Integration Testing with Postman 
----------------------------------------------

![image](https://user-images.githubusercontent.com/14144934/123182688-87155c00-d4c2-11eb-8ff3-8522d4d7e612.png)



