# Cancer Research UK Donate Functionality Tests
I built this test project using spring boot, maven and incorporated Java as the programming language using Cucumber as my BDD framework, TestNG as my testing Framework and Selenium Webdriver to automate webpages using chrome driver to test the site on Google Chrome.

Before Attempting to run tests:
- Ensure you have Java configured on your device
- Ensure you have Maven configured on your device
- Using Google Chrome browser for testing, the driver is in the following folder driver/chromedriver.exe, the version is 96 but way need to be changed depending on Chrome installed on device

## How to Run tests

To run a tests on the project you can use the following methods:

1. If you have the Cucumber for Java plugin on your IDE such as Intellij simple navigate to to the ***Donation.feature*** and click green arrow either on the entire Feature or Scenario and run the test(s)
![image](https://user-images.githubusercontent.com/60076315/142759834-642ba851-15b5-484a-80f2-d7a6f1dac5b8.png)

2. You can also run the test suite from the test runner file ***src/test/java/CRUK.test/testRunner***, by specifying that the tag that you want to run i.e. (@donate,@positive,@negative) and running the test by clicking the green arrow

![image](https://user-images.githubusercontent.com/60076315/142759908-5df69fae-e7cc-4296-a31c-71c05f6fd375.png)

3. The final way is through the command line/terminal by typing ``` mvn verify ``` you can also specify specific test tags to run too using the following command example ``` mvn verify -Dcucumber.filter.tags="@donate" ```

  ![image](https://user-images.githubusercontent.com/60076315/142760155-3a7629ef-faa0-427c-80b2-a75fbcd31ae1.png)

  Additionally using the maven verify goal will generate a Cucumber Report based on the test execution this can be viewed in the following folder **target/site/cucumber-reports** and by opening the **feature-overview.html** in your broweser will give an overview of the tests ran, successful tests, failed tests (generating a screenshot and logs on why the test failed), time taken to run tests and useful graphs too.
  
**Cucumber Reports**

![image](https://user-images.githubusercontent.com/60076315/142760990-d8787603-36a9-4c5b-9fd5-3ffa83e6deea.png)
![image](https://user-images.githubusercontent.com/60076315/142760254-3375e723-de6b-405a-9015-508ecf51eec8.png)

**Successful Test**
![image](https://user-images.githubusercontent.com/60076315/142760271-fbb20719-3810-4e85-97ef-af597f4a2d06.png)

**Failed Test**
 ![image](https://user-images.githubusercontent.com/60076315/142760374-68a598af-7f02-4c9e-a8df-14780b72b82d.png)

## Jenkins
I also created a Jenkins job on my local machine that would pulls the project from GitHub and execute the tests, generating Cucumber reports after each run
![image](https://user-images.githubusercontent.com/60076315/142760507-8a8a761c-3549-4aa9-bb1e-553d771eca66.png)
![image](https://user-images.githubusercontent.com/60076315/142760483-0ebcd512-6fc2-4352-8c8b-f968bfc54f3a.png)
![image](https://user-images.githubusercontent.com/60076315/142760541-22759a36-29bc-4ad3-8e58-3f1da51f1f3d.png)
