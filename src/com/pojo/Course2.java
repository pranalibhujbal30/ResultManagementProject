package com.pojo;

public class Course2 {
	
	private String course_id;
	private int total_marks;
	private String grade;
	public Course2(String course_id, int total_marks, String grade) {
		super();
		this.course_id = course_id;
		this.total_marks = total_marks;
		this.grade = grade;
	}
	public String getCourse_id() {
		return course_id;
	}
	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}
	public int getTotal_marks() {
		return total_marks;
	}
	public void setTotal_marks(int total_marks) {
		this.total_marks = total_marks;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	

}
