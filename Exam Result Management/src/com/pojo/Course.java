package com.pojo;

public class Course {
	 private String course_id;
	 private String name;
	 private String type;
	 private int sem;
	 private int credits;
	 
	 public Course() {
		 
	 }
	 
	public Course(String course_id, String name, String type, int sem, int credits) {
		super();
		this.course_id = course_id;
		this.name = name;
		this.type = type;
		this.sem = sem;
		this.credits = credits;
	}

	public String getCourse_id() {
		return course_id;
	}

	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getSem() {
		return sem;
	}

	public void setSem(int sem) {
		this.sem = sem;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	@Override
	public String toString() {
		return "Course [course_id=" + course_id + ", name=" + name + ", type=" + type + ", sem=" + sem + ", credits="
				+ credits + "]";
	}
	
	
	 
	 

}
