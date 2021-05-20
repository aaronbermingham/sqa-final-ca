package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.Collections;

import org.junit.*;
import classes.Controller;
import classes.Criterion;
import classes.Rubric;

public class RubricTests {
	Controller cntrllr = new Controller();
	ArrayList<Rubric> allRubricList = new ArrayList<Rubric>();
	ArrayList<Rubric> assignedRubricList = new ArrayList<Rubric>();
	ArrayList<Criterion> criterionList1 = new ArrayList<Criterion>();
	ArrayList<Criterion> criterionList2 = new ArrayList<Criterion>();
	String s = "Rubric title";
	Rubric r = cntrllr.createRubric(s);

	// Set up rubric with students and criteria
	public ArrayList<Rubric> setUpRubric(String studentName) {
		createListofRubrics();
		String rubricTitle = "thatTitle";
		Criterion c1 = new Criterion("Criterion 1");
		Criterion c2 = new Criterion("Criterion 2");
		Criterion c3 = new Criterion("Criterion 3");
		criterionList1.add(c1);
		criterionList1.add(c2);
		criterionList1.add(c3);
		assignedRubricList = cntrllr.addStudentGrade(rubricTitle, studentName,criterionList1);
		return assignedRubricList;
	}

	@Test
	public void testRubric() {
		setUpRubric("Barry");
		Boolean found = false;

		for (Rubric r : assignedRubricList) {
			for (Criterion c : r.getCriteria()) {
				if (r.getStudentName().equalsIgnoreCase("Barry") && c.getName().equalsIgnoreCase("Criterion 1")) {
					found = true;
				}
			}
		}
		assertTrue(found);
	}

	/*
	 * Method to create list of different types of rubrics Used in multiple methods
	 * so it's more efficient to create the list once (DRY)
	 */
	public void createListofRubrics() {
		allRubricList = cntrllr.addRubricToList(r);
		Rubric r1 = new Rubric("aTitle");
		Rubric r2 = new Rubric("theTitle");
		Rubric r3 = new Rubric("thisTitle");
		Rubric r4 = new Rubric("thatTitle");
		allRubricList.add(r1);
		allRubricList.add(r2);
		allRubricList.add(r3);
		allRubricList.add(r4);
	}

	@Test
	public void testRubricCreation() {
		assertEquals(s, r.getTitle());
	}

	// Test for adding to a rubric that already has ten criterion
	@Test(expected = IllegalStateException.class)
	public void testAddRubricCriterionFail() {
		// Criterion objects
		Criterion c1 = new Criterion("TestCriterion");
		Criterion c2 = new Criterion("NewCriterion");
		// Add criterion object c1 so rubric has ten criteria
		for (int i = 0; i < 10; i++) {
			criterionList1.add(c1);
		}
		// Associate the criterion list with a rubric
		r.setCriteria(criterionList1);
		/*
		 * Attempt to add a new criterion to the rubric This should result in a
		 * exception being thrown
		 */
		cntrllr.addCriteriontoRubric(r, c2);
	}

	@Test
	public void testAddRubricCriterionSuccess() {
		// Criterion objects
		Criterion c1 = new Criterion("TestCriterion");
		Criterion c2 = new Criterion("NewCriterion");
		// Add criterion object c1 so rubric has 6 criteria
		for (int i = 0; i < 6; i++) {
			criterionList1.add(c1);
		}
		// Associate the criterion list with a rubric
		r.setCriteria(criterionList1);
		// Add new
		cntrllr.addCriteriontoRubric(r, c2);
		assertEquals(7, r.getCriteria().size());
	}

	// Test for creating a list of rubrics
	@Test
	public void testAddRubricToList() {
		ArrayList<Rubric> rubricList = new ArrayList<Rubric>();
		rubricList = cntrllr.addRubricToList(r);
		/*
		 * Check to see if the rubric was added to the list by seeing if the list size
		 * is equal to one
		 */
		assertEquals(1, rubricList.size());
	}

	// Test for getting a list of rubrics
	@Test
	public void testGetListofRubrics() {
		// Add 5 rubrics to a list
		for (int i = 0; i < 5; i++) {
			allRubricList = cntrllr.addRubricToList(r);
		}
		// Check that the method to get list of rubrics has list size equal to five
		assertEquals(5, cntrllr.getAllRubrics().size());
	}

	// Test for getting a rubric by name
	@Test
	public void testGetRubricByName() {
		// String to search for in rubric list
		String title = "thatTitle";
		// Call method that populates rubric list
		createListofRubrics();
		// Variable to hold matching rubric
		Rubric rubric;
		// Search for name
		rubric = cntrllr.getRubricByName(title);
		// Check that rubric title matches the search string
		assertTrue(title.equalsIgnoreCase(rubric.getTitle()));
	}

	@Test
	public void testAddStudentGrade() {
		// Call method that populates rubric list
		createListofRubrics();
		// boolean value to check if a student is assigned to a rubric/grade
		Boolean found = false;
		String rubricTitle = "thatTitle";
		String studentName1 = "Anne";
		String studentName2 = "Barry";
		// Add two new students grades
		assignedRubricList = cntrllr.addStudentGrade(rubricTitle, studentName1,criterionList1);
		assignedRubricList = cntrllr.addStudentGrade(rubricTitle, studentName2, criterionList2);
		// Check if the students have been assigned
		for (Rubric r : assignedRubricList) {
			if (r.getStudentName().equalsIgnoreCase("Anne")) {
				// Set found to true if they have been assigned
				found = true;
			}
		}
		assertTrue(found);
	}

	@Test
	public void testAddCriterionScore() {
		String s1 = "Anne";
		
		setUpRubric(s1);
		
		boolean found = false;
		String criterionName1 = "Criterion 1";
		String criterionName2 = "Criterion 2";
		String criterionName3 = "Criterion 3";
		String rubricName = "thattitle";
		double score1 = 3.5;
		double score2 = 2.5;
		double score3 = 4;
		cntrllr.addCriterionScore(rubricName, criterionName1, score1, s1);
		cntrllr.addCriterionScore(rubricName, criterionName2, score2, s1);
		cntrllr.addCriterionScore(rubricName, criterionName3, score3, s1);
		for (Rubric r : assignedRubricList) {
			for (Criterion c : r.getCriteria()) {
				if (r.getStudentName().equalsIgnoreCase("Anne") && c.getName().equalsIgnoreCase("Criterion 1") && c.getGrade() == 3.5) {
					found = true;
				}
			}
		}
		assertTrue(found);
	}
	
}
