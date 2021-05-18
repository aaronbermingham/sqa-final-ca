package test;
import static org.junit.Assert.assertEquals;
import org.junit.*;

import classes.Controller;
import classes.Rubric;


public class RubricTests {
	Controller cntrllr = new Controller();

	@Test
	public void testRubricCreation() {
		String s = "Rubric title";
		Rubric r = cntrllr.createRubric(s);
		assertEquals(s, r.getTitle());
	}
}
