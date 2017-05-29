package com.master.ranking.model;

import java.util.List;
import java.util.UUID;

public class Student {

	private String id;
	private String name;
	private double scoring;
	private List<Major> majors;

	public Student(String name, double scoring, List<Major> majors) {
		this(UUID.randomUUID().toString(), name, scoring, majors);
	}

	public Student(String id, String name, double scoring, List<Major> majors) {
		this.id = id;
		this.name = name;
		this.scoring = scoring;
		this.majors = majors;
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

}
