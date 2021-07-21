package com.pojo;

public class Course {
	 private String course_id;
	 private String name;
	 private String type;
	 private String sem;
	 private String credits;
	 
	 public Course() {
		 
	 }
	 
	public Course(String course_id, String name, String type, String sem,String credits) {
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

	

	@Override
	public String toString() {
		return "Course [course_id=" + course_id + ", name=" + name + ", type=" + type + ", sem=" + sem + ", credits="
				+ credits + "]";
	}

	public void setSem(String sem2) {
		// TODO Auto-generated method stub
		this.sem=sem2;
	}

	public void setCredits(String credits2) {
		// TODO Auto-generated method stub
		this.credits=credits2;
	}

	public String getSem() {
		// TODO Auto-generated method stub
		return sem;
	}

	public String getCredits() {
		// TODO Auto-generated method stub
		return credits;
	}
	
	
	 
	 

}
