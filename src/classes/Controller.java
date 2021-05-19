package classes;

import java.util.ArrayList;

public class Controller {
	ArrayList<Rubric> rubricList = new ArrayList<Rubric>();

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
		rubricList.add(r);
		return rubricList;
	}

	// Get list of all rubrics
	public ArrayList<Rubric> getAllRubrics() {
		return this.rubricList;
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
}
