# Demonstrating Software Quality
## Sprint Backlog
Number | Task | Estimate | Description | Completed
------------- | ------------- | ------------- | ------------- | -------------
1 |Create rubric class | S | Java class for a rubric | &#9746;
2 |Create Criterion class | S | Java class for a criterion | &#9746;
3 |Create Controller class | S | Java class with methods for creating rubrics, criterions, calculation methods etc. | &#9746;
4 |Add method to create rubric & associated test | L | Method for creating a rubric and unit test to ensure it works correctly | &#9746;
5 |Add method to create criterion & associated test | L | Method for creating a criterion and a unit test to ensure it works correctly | &#9746;
6 |Create method to add criterion to a rubric & associated test | L | Method that adds a criterion to a rubrics with a check for number of criteria that a rubric has and a unit test to ensure it works correctly | &#9746;
7 |Add method to get list of all rubrics & associated test | L | Method that returns all rubrics and a unit test to ensure it works correctly | &#9746;
8 |Add method to get rubrics by name & associated test | M | Method that returns a rubric by name and a unit test to ensure it works correctly | &#9746;
9 |Add method to create new student grade & associated test | M | Method that makes a new student grade and a unit test to ensure it works correctly | &#9746;
10 |Add method to assign score for a criterion to a grade & associated test | M | Method that takes a score and assigns it to a specific criterion and a unit test to ensure it works correctly | &#9746;
11 |Add method to get all Student grades for a specific rubric & associated test | S | Method that gets all student grades and a unit test to ensure it works correctly | &#9744;
12 |Add method for calculating Average & associated test | L | Method that calculates an average value and a unit test to ensure it works correctly | &#9746;
13 |Add method for calculating Standard Deviation & associated test | M | Method that calculates a standard deviation value and a unit test to ensure it works correctly | &#9746;
14 |Add method for calculating Minimum & associated test | S | Method that calculates a min value from a list and a unit test to ensure it works correctly | &#9746;
15 |Add method for calculating Maximum & associated test | S | Method that calculates a max value from a list and a unit test to ensure it works correctly | &#9746;
16 |Check for test coverage | M | Use code coverage tool (Eclemma) and find any coverage gaps and close them by adding additional tests | &#9746;

### Selecting estimates
I have used t-shirt sizing when making the estimates for the sprint backlog. I have based this off the amount of effort that it will take to complete the tasks. Tasks are assigned estimates of XS, S, M, L etc. This approach presents a difficulty for calculating velocity, but I will cover that in the Velocity section below. The tasks are prioritised in the way that I will complete them and how they need to be ordered as some tasks are dependent are others being completed first.

For example, creating the rubric, criterion and controller classes are a S. These tasks are something that I'm familiar with so are estimated accordingly. I am using these estimates to set the initial baseline of how much effort it takes to complete a task. I then size the other tasks according to the amount of effort I think they will take compared to these sizings.

The first two task that I think needs a unit test ('method to create rubric & associated test' & 'method to create criterion & associated test' & ‘method to get list of all rubrics & associated test') are all estimated as L. These are the first tasks that unit tests are being created for so I think they will take more effort but as I become more familiar with the process, the estimates are smaller. So accordingly, the 'method to get rubrics by name & associated test' is estimated as a M. 

Specifically comparing task 1 for creating a rubric class (S) and task 13 for calculating a standard deviation value (M), there is a clear difference in sizing. Creating a class is a relatively simple task while calculating the standard deviation requires more effort both for the actual method and the unit test to ensure that the method works correctly. Creating the rubric class involves the standard process (instance variables, constructor, getter/setters) while calculating standard deviation is more complicated and will need a unit test as well. I've also taken into account that by the time I am working on the standard deviation task that I will have created other methods that have unit tests for calculations, so I ended up estimating it as a M rather than a L. This shows how I've taken a task that I'm familiar with completing allows me to estimate the effort and then size other more complex tasks relatively based off that first task estimation.

### Velocity
Since I used T-shirt sizing, to calculate velocity I need to translate the sizes to numbers, so I've decided to use the following:
Size | Number 
------------- | -------------  
S | 1
M | 3 
L | 5 
XL | 6

I didn't size anything at XL as I think if it's over a large it should be broken up into separate tasks. So, for this sprint, there was 5 small, 5 medium and 5 large tasks completed which works out at a velocity of 45. Having calculate this based off the completed sprint, I can look to the next sprint with this in mind. So, if the velocity is 45, it's a reasonable assumption that the next sprint will have a similar velocity. When planning this sprint, we can add tasks that are equivalent to this velocity. If there were more completed sprints in this situation, an average of the sprint velocities could be calculated allowing for more accurate planning for the coming sprint.


## Test Driven Approach
As much as possible, I have tried to follow a test-driven approach by creating unit tests before any additions to the code. Any methods I've added in the controller class are created to try and pass the corresponding unit test. For each unit test I have tried to follow the arrange - act - assert pattern.

For example, with this [commit](https://github.com/aaronbermingham/sqa-final-ca/pull/15/files/425a13d0ff81c43e40911fa2f2f586673dd650f2) I created a unit test to check the calculation of a student’s grade based off a rubric. The method is then created that takes a rubric name and student name as parameters and then calculates the students total grade based on their scores in that particular rubric.
 
### Arrange
I set up a student rubric with a list of criteria and scores for each. 
### Action
The unit test then calls the calculate student grade method and assigns the return value to a double variable. 
### Assert
This variable is then checked using assert equals to determine whether the method calculated the correct figure. In this case the value returned is 10 (3.5 + 2.5 + 4) and the assertion is correct, so the unit test is passed.

## Test Coverage metric
I am using Eclipse IDE for this project so to I have selected the code coverage tool EclEmma. This tool checks how much of the code is covered by the tests, i.e., how much of the methods have been run by the unit tests.
To run this tool, I right click the button that is circled in the picture below and select the project that I want to run the tool on.

![Screenshot (167)](https://user-images.githubusercontent.com/55384582/119115759-6ff4d180-ba1f-11eb-82fe-4fb032f7ad39.png)

This screenshot shows me the test coverage percentages as a whole and broken down for each class.
![Screenshot (166)](https://user-images.githubusercontent.com/55384582/119114891-7898d800-ba1e-11eb-8e5b-15efcb7871ca.png)

The tool also highlights the actual code to show the level of coverage:

Colour | Meaning | Example 
------------- | ------------- | ------------- 
Green | Full Coverage | ![Screenshot (169)](https://user-images.githubusercontent.com/55384582/119117427-1ee5dd00-ba21-11eb-842b-6a641d03a9cf.png) 
Yellow | Partial Coverage | ![Screenshot (170)](https://user-images.githubusercontent.com/55384582/119118356-07f3ba80-ba22-11eb-99f7-e8240ed5ea09.png)
Red | No Coverage (Line has not been executed by a test) | ![Screenshot (171)](https://user-images.githubusercontent.com/55384582/119118532-3376a500-ba22-11eb-945b-725b0d02a7a1.png)

The screenshots show the highlighting of lines of code so it easy to check where there is gaps in coverage so you can then try close the gap and increase the overall level of test coverage. In the Rubric and Criterion classes there were setter methods that didn't feature in any tests and I added tests for some of these methods to close the gap resulting in wider test coverage.

![Screenshot (174)](https://user-images.githubusercontent.com/55384582/119122226-35dafe00-ba26-11eb-9d28-3d31d1382512.png)

This has increased the test coverage for both the Rubric and Criterion class when compared to initial screenshot of coverage level above. The code for setName method in the Criterion class is now highlighted green as it has test coverage.

![Screenshot (173)](https://user-images.githubusercontent.com/55384582/119121861-d250d080-ba25-11eb-8795-6be71121d0d5.png)


## Version Control
For this project, I am using the GitFlow process for version control. I have a master/main branch and a develop branch. When I'm making any changes or developing a new feature (e.g., create rubric class), I create a feature branch. This feature branch is then merged into the develop branch if it is approved in a code review. When the sprint is complete, a release branch is created off the develop branch and then the release branch can be merged to master/main.

### Branches
I have listed all the branches here that were used for the code part of the project (there are also branches for this readme). They are in the order of how they fit in the Gitflow process i.e I first created a main branch then a develop branch and each feature branch below develop is branched off develop. All feature branches are merged into the develop branch when they are completed and have passed a code review.
####  main
The main branch, nothing is merged to this until there is a release.
####  develop
The develop branch is where all feature branches are merged into after they have passed a code review. A release branch is created off develop when the sprint is completed.
####  rubric-class
This feature branch is used to create a rubric class.
####  criterion-class
This feature branch is used to create a criterion class.
####  controller-class
Feature branch for a class that will hold all the methods for creating rubrics, criterions, calculations etc.
####  create-rubric
This feature branch has a method to create rubric objects.
####  create-criterion
This feature branch has a method to create criterion objects.
#### add-criterion-to-rubric
This is a feature branch that associates a criterion with a rubric.
####  all-rubrics
Feature branch to return all rubrics.
####  rubric-by-name
Feature branch to return a rubric by its name.
####  add-student-grade
add-student-grade is a feature branch for adding a student to a rubric so that they can then be marked for the criteria in that rubric.
#### add-criterion-score
This feature branch was created to add a score to a criterion.
####  get-rubric-grades
Feature branch created to return the grade of a student.
####  calculate-average
Feature branch to calculate average from a list of numbers.
####  standard-dev
Feature branch to calculate standard deviation from a list of numbers.
####  min-value
Feature branch to get minimum value from a list of numbers.
####  max-value
Feature branch to get maximum value from a list of numbers.
####  test-coverage
Feature branch created to close the coverage test gap after using a code coverage tool.
####  release-1.0
Release branch for the project, all changes made during the sprint that were merged to develop are now merged to this branch. Changes made to the readme file which need to be merged back to develop to ensure the changes are reflected in that branch. This branch is also merged to main for product release.

## Code review checklist
This is the code review checklist that I am using when deciding whether to approve a pull request.
- [x] Formatting
- [x] Associated Unit Test where applicable 
    - Follow arrange - act - assert pattern
- [x] Comments explaining the code are now allowed where appropriate
- [x] Readability
- [x] DRY: Don't repeat yourself
- [x] Small, specific classes/methods
- [x] Ensure pull requests are merged into dev branch not main

This is the suggested checklist that I have followed when reviewing code. In a real-world scenario, I would have added must be approved by at least two people but given that this is a one-person project I left that out! I came up with this list as they are things that I find I don't follow consistently when coding, so I think it's important that they are explicitly stated and used when reviewing a pull request. I have also added some instructions for the how unit tests should be structured so there is a consistent standard for any unit tests that are created.

Here is an example of a [pull request](https://github.com/aaronbermingham/sqa-final-ca/pull/13) that didn't meet all the checklist requirements. The reviewer points out that some of the checklist is not followed and adds a review comment and a comment in the code to point this out. In this case DRY and small/specific classes are not followed. The reviewer makes some suggestions and the person who created the PR makes the appropriate changes and pushes them. The changes satisfy the checklist requirements, and the PR is approved and allowed to be merged to the develop branch.





