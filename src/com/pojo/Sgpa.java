package com.pojo;

public class Sgpa {
	
	private String CNo;
	private String name;
	private String division;
	private int semester;
	private float sgpa;
	public Sgpa(String cNo, String name, String division, int semester, float sgpa) {
		super();
		CNo = cNo;
		this.name = name;
		this.division = division;
		this.semester = semester;
		this.sgpa = sgpa;
	}
	public String getCNo() {
		return CNo;
	}
	public void setCNo(String cNo) {
		CNo = cNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	public float getSgpa() {
		return sgpa;
	}
	public void setSgpa(float sgpa) {
		this.sgpa = sgpa;
	}
	
	
	

}
