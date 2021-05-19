package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.*;

import classes.Controller;
import classes.Criterion;
import classes.Rubric;

public class RubricTests {
	Controller cntrllr = new Controller();
	ArrayList<Rubric> rubricList = new ArrayList<Rubric>();
	ArrayList<Criterion> criterionList = new ArrayList<Criterion>();
	String s = "Rubric title";
	Rubric r = cntrllr.createRubric(s);

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
			criterionList.add(c1);
		}
		// Associate the criterion list with a rubric
		r.setCriteria(criterionList);
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
			criterionList.add(c1);
		}
		// Associate the criterion list with a rubric
		r.setCriteria(criterionList);
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
			rubricList = cntrllr.addRubricToList(r);
		}
		// Check that the method to get list of rubrics has list size equal to five
		assertEquals(5, cntrllr.getAllRubrics().size());
	}

	// Test for getting a rubric by name
	@Test
	public void testGetRubricByName() {
		// String to search for in rubric list
		String title = "thattitle";
		// Add rubrics to list
		rubricList = cntrllr.addRubricToList(r);
		Rubric r1 = new Rubric("aTitle");
		Rubric r2 = new Rubric("theTitle");
		Rubric r3 = new Rubric("thisTitle");
		Rubric r4 = new Rubric("thatTitle");
		rubricList.add(r1);
		rubricList.add(r2);
		rubricList.add(r3);
		rubricList.add(r4);
		// Variable to hold matching rubric
		Rubric rubric;
		// Search for name
		rubric = cntrllr.getRubricByName(title);
		// Check that rubric title matches the search string
		assertTrue(title.equalsIgnoreCase(rubric.getTitle()));

	}
}
