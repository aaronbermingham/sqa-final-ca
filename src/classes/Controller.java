package classes;

public class Controller {
	public Rubric createRubric(String name) {
		Rubric rubric = new Rubric(name);
		return rubric;
	}
	
	public Criterion createCriterion(String name) {
		Criterion criterion = new Criterion(name);
		return criterion;
	}
}
