package com.master.ranking.service;

import java.util.List;
import java.util.NoSuchElementException;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import com.master.ranking.model.Major;
import com.master.ranking.model.Student;

@ManagedBean(name = "rankingSystem")
@ApplicationScoped
public class RankingSystem {

	private static boolean rated;

	private static List<Student> students;

	@ManagedProperty("#{studentService}")
	private StudentService studentService;

	@PostConstruct
	public void init() {
		students = studentService.getStudents();
	}

	public static boolean isRated() {
		return rated;
	}

	public static void setRated(boolean rated) {
		RankingSystem.rated = rated;
	}

	public static List<Student> getStudents() {
		return students;
	}

	public static void setStudents(List<Student> students) {
		RankingSystem.students = students;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public void execute() {
		if (!rated) {
			students.sort((s1, s2) -> Double.compare(s2.getScoring(), s1.getScoring()));
			students.forEach(this::rate);
			rated = true;
		}
	}

	private void rate(Student student) {
		Major ratedMajor = null;

		try {
			ratedMajor = student.getMajors().stream().filter(Major::hasFreePlaces).findFirst().get();
			ratedMajor.rateNext(student);
		} catch (NoSuchElementException e) {
			// do not rate student
		}

	}

}
