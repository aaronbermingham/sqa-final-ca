package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import classes.Controller;
import classes.Criterion;

public class CriterionTests {
	Controller cntrllr = new Controller();

	@Test
	public void testCriterionCreation() {
		String s = "Criterion title";
		Criterion c = cntrllr.createCriterion(s);
		assertEquals(s, c.getName());
	}
}
