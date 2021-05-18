# Demonstrating Software Quality
## Sprint Backlog
Task | Estimate
------------ | -------------
Create rubric class | S
Create Criterion class | S
Create Controller class | S
Add method to create rubric & associated test | L
Add method to get list of all rubrics & associated test | L
Add method to get rubrics by name & associated test | M
Add method to create new student grade & associated test | M
Add method to assign score for a criterion to a grade & associated test | M
Add method to get all Student grades for a specific rubric & associated test | S
Add method for calculating Average & associated test | L
Add method for calculating Standard Deviation & associated test | M
Add method for calculating Minimum & associated test | S
Add method for calculating Maximum & associated test | S

### Selecting estimates
I have used t-shirt sizing when making the estimates for the sprint backlog. I have based this off the amount of effort that it will take to complete the tasks. 

For example, creating the rubric, criterion and controller classes are a S. These tasks are something that I'm familiar with so are estimated accordingly. The first two task that I think needs a unit test ('method to create rubric & associated test' & 'method to get list of all rubrics & associated test') are both estimated as L. These are the first tasks that unit tests are being created for so I think they will take more effort but as I become more familiar with the process, the estimates are smaller.

## Test Driven Approach
As much as possible, I have tried to follow a test driven approach by adding unit tests with any new code. 

Link to specific commit + explanation

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
- [x] No comments
- [x] Readability
- [x] DRY: Don't repeat yourself
- [x] Small, specific classes/methods
- [x] Ensure pull requests are merged into dev branch not main

Add link to closed pull request
