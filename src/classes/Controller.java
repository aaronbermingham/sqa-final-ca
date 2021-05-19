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
	
	public void addCriteriontoRubric(Rubric r, Criterion c) {
		// Check for the number of criterion associated with the rubric
		int size = r.getCriteria().size();
		System.out.println("Size before " + r.getCriteria().size());
		// Check if the number of criterion are greater or equal to 10
		if(size >= 10) {
			// Throw exception if size is greater or equal to tne
		        throw new IllegalStateException("Rubric should can only contain up to ten criterion");
		      }
		else {
			// Other wise add the criterion to the rubric 
			r.getCriteria().add(c);
			System.out.println("Size after " + r.getCriteria().size());
		}
		//return r;
	}
}
