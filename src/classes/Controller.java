package classes;

import java.util.ArrayList;

public class Controller {
	// List for all rubrics
	ArrayList<Rubric> allRubricList = new ArrayList<Rubric>();
	/*
	 * List for specific rubric that are assigned to a student e.g. Rubric for
	 * Software Quality Assignment CA 2 for students Anne and Barry
	 */
	ArrayList<Rubric> assignedRubricList = new ArrayList<Rubric>();

	public Rubric createRubric(String name) {
		Rubric rubric = new Rubric(name);
		return rubric;
	}

	public Criterion createCriterion(String name) {
		Criterion criterion = new Criterion(name);
		return criterion;
	}

	public void addCriteriontoRubric(Rubric r, Criterion c) {
		// Check for the number of criterion associated with the rubric
		int size = r.getCriteria().size();
		// Check if the number of criterion are greater or equal to 10
		if (size >= 10) {
			// Throw exception if size is greater or equal to tne
			throw new IllegalStateException("Rubric should can only contain up to ten criterion");
		} else {
			// Other wise add the criterion to the rubric
			r.getCriteria().add(c);
		}
	}

	// Add a rubric to a list of rubrics
	public ArrayList<Rubric> addRubricToList(Rubric r) {
		// Add a new rubric to the list
		allRubricList.add(r);
		return allRubricList;
	}

	// Get list of all rubrics
	public ArrayList<Rubric> getAllRubrics() {
		return this.allRubricList;
	}

	// Get rubric by name
	public Rubric getRubricByName(String s) {
		// Get all rubrics to check
		ArrayList<Rubric> rubricList = getAllRubrics();
		// Variable to hold matching rubric
		Rubric rubric = null;
		// Loop through rubric list
		for (Rubric r : rubricList) {
			// check if the rubric title matches the passed string
			if (r.getTitle().equalsIgnoreCase(s)) {
				// Set rubric equal to the matching rubric from the list
				rubric = r;
			}
		}
		return rubric;
	}

	public ArrayList<Rubric> addStudentGrade(String rubricName, String studentName,
			ArrayList<Criterion> criterionList) {
		// get correct rubric
		Rubric r = getRubricByName(rubricName);
		String title = r.getTitle();
		Rubric studentRubric = new Rubric(title);
		// add student to that rubric
		studentRubric.setStudentName(studentName);
		studentRubric.setCriteria(criterionList);
		// Add the rubric that is associated with a student to the list
		assignedRubricList.add(studentRubric);
		// return the assigned rubric list
		return assignedRubricList;
	}

	public void addCriterionScore(String rubricName, String criterionName, double score, String studentName) {
		// Loop through assigned rubrics and the rubrics associated criteria
		int count = 0;
		for (Rubric r : assignedRubricList) {
			for (Criterion c : r.getCriteria()) {
				// Check for correct criterion name, correct student name and that the score is
				// not > 5
				if ((r.getTitle().equalsIgnoreCase(rubricName)) && (r.getStudentName().contains(studentName))
						&& (c.getName().equalsIgnoreCase(criterionName)) && (score <= 5)) {
					c.setGrade(score);
				}
			}
		}
	}

	public double calculateStudentGrade(String rubricName, String studentName) {
		double grade = 0;
		for (Rubric r : assignedRubricList) {
			if (r.getStudentName().equalsIgnoreCase(studentName) && r.getTitle().equalsIgnoreCase(rubricName)) {
				for (Criterion c : r.getCriteria()) {
					grade += c.getGrade();
				}
			}
		}
		return grade;
	}
	
	// Method to calculate average
	public double average(ArrayList<Double> numList) {
		// Variable to hold average value
		double average = 0;
		// Variable to hold the sum of a list of numbers
		double sum = 0;
		// Iterate through list adding the numbers together
		for (Double d : numList) {
			sum += d;
		}
		// Divide the sum by the size of the list
		average = sum / numList.size();
		return average;
	}
	
	// Method to calculate standard deviation
	public double stdDev(ArrayList<Double> nums) {
		// Variable to hold standard deviation value
		double stdDev = 0.0;
		double sum = 0.0;
		// Call average method 
		double average = average(nums);
		/*
		 * Subtract the average
		 * from each number in the list to the power
		 * of two divided by the size of the list 
		 * and sum them
		 */
		for (Double d: nums) {
			sum += (Math.pow(d - average,2))/nums.size();
		}
		/* Get the square root of the 
		 * sum result to find the standard deviation
		 */
		stdDev = Math.sqrt(sum);
		return stdDev;
	}
}
