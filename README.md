# Coding Challenge - Zalando - Test Analyst

**Synopsis**

The objective of this coding challenge is to automate the following test cases on zalando’s job webpage.
1.	Test case 1
a.	Finding a job using the ‘Test analyst’ as the search criteria and location as ‘Berlin’.
b.	Filtering jobs by contract type as ‘Full Time’.
c.	Verify the search results with job-ad details.
2.	Test case 2
a.	Finding a job using the ‘Frontend Engineer’ as the search criteria and defining the success criteria.

**Tools and Frameworks used:**

1.	Automation tool: Selenium
2.	Testing framework: TestNg
3.	Programming language: Java
4.	IDE: Intellij
5.	Built with: Maven

**Pre-requisites**

1.	Operating system: Unix, Linux or windows  
2.	Java JDK 
3.	Maven 
4.	Chrome browser 

**Code Pattern and Explanation:**

1.	Page object pattern is used for a clean separation between test code and locators.
2.	Test1- ‘AssertTrue’ and ‘AssertEquals’ have been used to verify the search criterion.
3.	Test2- ‘AssertFalse’ has been used to define the success criteria ‘Frontend Engineer’ as it does not match the result on the webpage.

**Running the tests:**

To run the test from maven:
1.	Clone the repository into your local machine.
2.	Open the Terminal and cd into the project folder which has been cloned from git.
3.	Enter the following command in the Terminal: ‘mvn test’.

**Additional Information:** 

1.	The test command will run the test automatically on the chrome browser. The browser name is not passed as a maven parameter as it is hard-coded for simplicity.

2.	Additionally, by invoking the mvn test command, both the test scenarios will run in parallel. In order to provide a sequential run we can define the configuration in testNg.xml 

3.	The tests will automatically identify the operating system and based on that corresponding driver(s) will be invoked (different in case of linux or windows)  


