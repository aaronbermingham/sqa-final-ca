package classes;

//Rubric class
public class Rubric {
	public String title; // name of rubric
	public String studentName;	// name of student
	public double totalScore; // overall score for rubric
	// add list of criterion here
	
			// Constructor
			public Rubric(String title, String studentName) {
				super();
				this.title = title;
				this.studentName = studentName;
			}
	
	// Getters/Setters
	public String getTitle() {
		return title;
	}
	
	
	

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public double getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(double totalScore) {
		this.totalScore = totalScore;
	}
	
	
	
	
	
}
