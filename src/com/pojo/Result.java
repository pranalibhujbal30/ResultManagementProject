package com.pojo;

public class Result {
	
	String CNo;
	String course_id;
	int in_sem;
	int end_sem;
	int credits;
	
	public Result(String cNo, String course_id, int in_sem, int end_sem, int credits) {
		super();
		CNo = cNo;
		this.course_id = course_id;
		this.in_sem = in_sem;
		this.end_sem = end_sem;
		this.credits = credits;
	}

	public String getCNo() {
		return CNo;
	}

	public void setCNo(String cNo) {
		CNo = cNo;
	}

	public String getCourse_id() {
		return course_id;
	}

	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}

	public int getIn_sem() {
		return in_sem;
	}

	public void setIn_sem(int in_sem) {
		this.in_sem = in_sem;
	}

	public int getEnd_sem() {
		return end_sem;
	}

	public void setEnd_sem(int end_sem) {
		this.end_sem = end_sem;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}
	
	

}
