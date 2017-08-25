package com.master.ranking.model;

import java.util.List;
import java.util.UUID;

public class Student {

	public enum SexType{
		MALE, FEMALE
	}

	private String id;
	private String name;
	private double scoring;
	private SexType sex;
	private String university;
	private Major major;
	private List<Major> majors;

	public Student(String name, double scoring, List<Major> majors, SexType sex, String university) {
		this(UUID.randomUUID().toString(), name, scoring, majors, sex, university);
	}

	public Student(String id, String name, double scoring, List<Major> majors, SexType sex, String university) {
		this.id = id;
		this.name = name;
		this.scoring = scoring;
		this.majors = majors;
		this.sex = sex;
		this.university = university;
	}

	public Major getMajor() {
		return major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getScoring() {
		return scoring;
	}

	public void setScoring(double scoring) {
		this.scoring = scoring;
	}

	public List<Major> getMajors() {
		return majors;
	}

	public void setMajors(List<Major> majors) {
		this.majors = majors;
	}

	

	@Override
	public String toString() {
		return "Student [name=" + name + ", sex=" + sex + ", university=" + university + ", major=" + major
				+ ", majors=" + majors + "]";
	}

	public SexType getSex() {
		return sex;
	}

	public void setSex(SexType sex) {
		this.sex = sex;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

}
