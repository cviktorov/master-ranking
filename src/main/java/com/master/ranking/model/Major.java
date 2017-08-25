package com.master.ranking.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Major {

	private String id;
	private String name;
	private String shortName;
	private int quote;
	private int ratedStudentsCounter;
	private List<Student> ratedStudents;

	public Major(String name, String shortName, int quote) {
		this(UUID.randomUUID().toString(), name, shortName, quote, 0, new ArrayList<>());
	}

	private Major(String id, String name, String shortName, int quote, int ratedCounter, List<Student> ratedStudents) {
		this.id = id;
		this.name = name;
		this.quote = quote;
		this.ratedStudentsCounter = ratedCounter;
		this.ratedStudents = ratedStudents;
		this.setShortName(shortName);
	}

	public void rateNext(Student student) {
		student.setMajor(this);
		ratedStudents.add(student);
		ratedStudentsCounter++;

	}

	public boolean hasFreePlaces() {
		return quote > ratedStudentsCounter;
	}

	public String getId() {
		return id;
	}

	public int getRatedStudentsCounter() {
		return ratedStudentsCounter;
	}

	public void setRatedStudentsCounter(int ratedStudentsCounter) {
		this.ratedStudentsCounter = ratedStudentsCounter;
	}

	public List<Student> getRatedStudents() {
		return ratedStudents;
	}

	public void setRatedStudents(List<Student> ratedStudents) {
		this.ratedStudents = ratedStudents;
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

	public int getQuote() {
		return quote;
	}

	public void setQuote(int quote) {
		this.quote = quote;
	}

	public int getRatedCounter() {
		return ratedStudentsCounter;
	}

	public void setRatedCounter(int ratedCounter) {
		this.ratedStudentsCounter = ratedCounter;
	}

	@Override
	public String toString() {
		return shortName;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

}
