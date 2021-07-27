package com.pojo;

public class Course1 {
	private String course_id;
	private int credits;
	public Course1(String course_id, int credits) {
		super();
		this.course_id = course_id;
		this.credits = credits;
	}
	public String getCourse_id() {
		return course_id;
	}
	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	

}
