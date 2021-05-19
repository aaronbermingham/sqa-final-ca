package classes;

import java.util.ArrayList;

public class Rubric {
	public String title;
	public String studentName;
	public double totalScore;
	public ArrayList<Criterion> criteria;

	public Rubric(String title) {
		super();
		this.title = title;
	}

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

	public ArrayList<Criterion> getCriteria() {
		return criteria;
	}

	public void setCriteria(ArrayList<Criterion> criteria) {
		this.criteria = criteria;
	}
	

}
