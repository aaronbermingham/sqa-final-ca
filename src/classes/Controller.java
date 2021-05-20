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

	public ArrayList<Rubric> addStudentGrade(String rubricName, String studentName) {
		// get correct rubric
		Rubric r = getRubricByName(rubricName);
		String title = r.getTitle();
		Rubric studentRubric = new Rubric(title);
		// add student to that rubric
		studentRubric.setStudentName(studentName);
		// Add the rubric that is associated with a student to the list
		assignedRubricList.add(studentRubric);
		// return the assigned rubric list
		return assignedRubricList;
	}
}
