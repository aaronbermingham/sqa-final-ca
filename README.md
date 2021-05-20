# Demonstrating Software Quality
## Sprint Backlog
Number | Task | Estimate | Description
------------- | ------------- | ------------- | -------------
1 |Create rubric class | S | Java class for a rubric
2 |Create Criterion class | S | Java class for a criterion
3 |Create Controller class | S | Java class with methods for creating rubrics, criterions, calculation methods etc.
4 |Add method to create rubric & associated test | L | Method for creating a rubric and unit test to ensure it works correctly
6 |Add method to create criterion & associated test | L | Method for creating a criterion and a unit test to ensure it works correctly
7 |Create method to add criterion to a rubric & associated test | L | Method that adds a criterion to a rubrics with a check for number of criteria that a rubric has and a unit test to ensure it works correctly
8 |Add method to get list of all rubrics & associated test | L | Method that returns all rubrics and a unit test to ensure it works correctly
9 |Add method to get rubrics by name & associated test | M | Method that returns a rubric by name and a unit test to ensure it works correctly
10 |Add method to create new student grade & associated test | M | Method that makes a new student grade and a unit test to ensure it works correctly
11 |Add method to assign score for a criterion to a grade & associated test | M | Method that takes a score and assigns it to a specific criterion and a unit test to ensure it works correctly
12 |Add method to get all Student grades for a specific rubric & associated test | S | Method that gets all student grades and a unit test to ensure it works correctly
13 |Add method for calculating Average & associated test | L | Method that calculates an average value and a unit test to ensure it works correctly
14 |Add method for calculating Standard Deviation & associated test | M | Method that calculates a standard deviation value and a unit test to ensure it works correctly
15 |Add method for calculating Minimum & associated test | S | Method that calculates a min value from a list and a unit test to ensure it works correctly
16 |Add method for calculating Maximum & associated test | S | Method that calculates a max value from a list and a unit test to ensure it works correctly

### Selecting estimates
I have used t-shirt sizing when making the estimates for the sprint backlog. I have based this off the amount of effort that it will take to complete the tasks. Tasks are assigned estimates of XS, S, M, L etc. This approach presents a difficulty for calculating velocity but I will cover that in the Velocity section below. The tasks are prioritised in the way that I will complete them and how they need to be ordered as some tasks are dependent are others being completed first.

For example, creating the rubric, criterion and controller classes are a S. These tasks are something that I'm familiar with so are estimated accordingly. I am using these estimates to set the initial baseline of how much effort it takes to complete a task. I then size the other tasks according to the amount of effort I think they will take compared to these sizings.

The first two task that I think needs a unit test ('method to create rubric & associated test' & 'method to create criterion & associated test' &  'method to get list of all rubrics & associated test') are all estimated as L. These are the first tasks that unit tests are being created for so I think they will take more effort but as I become more familiar with the process, the estimates are smaller. So accordingly, the 'method to get rubrics by name & associated test' is estimated as a M. 

Specifically comparing task 1 for creating a rubric class (S) and task 14 for calculating a standard deviation value (L), there is a clear difference in sizing. Creating a class is a relatively simple task while calculating the standard deviation requires more effort both for the actual method and the unit test to ensure that the method works correctly.

### Velocity

## Test Driven Approach
As much as possible, I have tried to follow a test driven approach by adding unit tests to accompany any additions to the code. Any methods I've added in the controller class has a corresponding unit test to check if the method has the intended outcome. For each unit test I have tried to follow the arrange - act - assert pattern.

For example for this [commit](https://github.com/aaronbermingham/sqa-final-ca/pull/15/files/425a13d0ff81c43e40911fa2f2f586673dd650f2) I created a method to calculate a students grade based off a rubric. The method takes a rubric name and student name as parameters and then calculates the studnets total grade based on their scores in that particular rubric.

As part of this commit, I created a unit test to check if this method had the intended outcome of calculating a students total 
grade. 
### Arrange
I set up a student rubric with a list of criterion and scores for each. 
### Action
The unit test then calls the calculate student grade method and assigns the return value to a double variable. 
### Assert
This variable is then checked using assert equals to determine whether the method calculated the correct figure. In this case the value returned is 10 (3.5 + 2.5 + 4) and the assertion is correct so the unit test is passed.

## Test Coverage metric
Explanation

Screenshot

## Version Control
For this project, I am using the GitFlow process for version control. I have a master/main branch and a develop branch. When I'm making any changes or developing a new feature (e.g. create rubric class), I create a feature branch. This feature branch is then merged into the develop branch if it is approved in a code review.

Add description of branches

## Code review checklist
This is the code review checklist that I am using when deciding whether to approve a pull request.
- [x] Formatting
- [x] Associated Unit Test where applicable 
    - Follow arrange - act - assert pattern
- ~~[x] No comments~~ Comments explaining the code are now allowed where appropriate
- [x] Readability
- [x] DRY: Don't repeat yourself
- [x] Small, specific classes/methods
- [x] Ensure pull requests are merged into dev branch not main

Add link to closed pull request
