package com.master.ranking.service;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import com.master.ranking.model.Major;
import com.master.ranking.model.Student;
import com.master.ranking.model.Student.SexType;

@ManagedBean(name = "studentService")
@ApplicationScoped
public class StudentService implements Serializable {

	private static final long serialVersionUID = 2829977301393764074L;

	@ManagedProperty("#{majorService}")
	private MajorService majorService;
	
	@ManagedProperty("#{universitiesService}")
	private UniversityService universitiesService;

	private static List<Major> majors;

	private static List<String> universities;

	public static List<Student> students;

	@PostConstruct
	public void init() {
		majors = majorService.getMajors();
		universities = universitiesService.getUniversities();
		students = Arrays.asList(
				new Student("Христо Илиев Димитров", 10.13, randomNBeweenMajors(3), SexType.MALE, randomUni()),
				new Student("Савина Димитрова Димитрова", 9.01, randomNBeweenMajors(3), SexType.FEMALE, randomUni()),
				new Student("Маргарита Антонова Кацарска", 8.43, randomNBeweenMajors(4), SexType.FEMALE, randomUni()),
				new Student("Симеон Кирилов Димитров", 9.95, randomNBeweenMajors(5), SexType.MALE, randomUni()),
				new Student("Йордан Лазаров Темелков", 9.51, randomNBeweenMajors(5), SexType.MALE, randomUni()),
				new Student("Ивайло Стефанов Иванов", 9.52, randomNBeweenMajors(3), SexType.MALE, randomUni()),
				new Student("Александър Миланов Миланов", 9.53, randomNBeweenMajors(3), SexType.MALE, randomUni()),
				new Student("Олег Златанов Златанов", 9.54, randomNBeweenMajors(3), SexType.MALE, randomUni()),
				new Student("Иван Георгиев Бодуров", 9.5, randomNBeweenMajors(3), SexType.MALE, randomUni()),
				new Student("Камен Георгиев Хърсев", 9.56, randomNBeweenMajors(3), SexType.MALE, randomUni()),
				new Student("Дянко Венцеславов Дянков", 9.57, randomNBeweenMajors(3), SexType.MALE, randomUni()),
				new Student("Ивелина Стоянова Костадинова", 9.58, randomNBeweenMajors(3), SexType.FEMALE, randomUni()),
				new Student("Любомир Емилов Любомиров", 9.59, randomNBeweenMajors(3), SexType.MALE, randomUni()),
				new Student("Кристина Анатолиева Митева", 9.6, randomNBeweenMajors(3), SexType.FEMALE, randomUni()),
				new Student("Тодор Симеонов Спасов", 10, randomNBeweenMajors(3), SexType.MALE, randomUni()));
	}

	public StudentService() {

	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		StudentService.students = students;
	}

	public MajorService getMajorService() {
		return majorService;
	}

	public void setMajorService(MajorService majorService) {
		this.majorService = majorService;
	}

	public UniversityService getUniversitiesService() {
		return universitiesService;
	}

	public void setUniversitiesService(UniversityService universitiesService) {
		this.universitiesService = universitiesService;
	}

	public List<Major> getMajors() {
		return majors;
	}

	public void setMajors(List<Major> majors) {
		StudentService.majors = majors;
	}

	public List<String> getUniversities() {
		return universities;
	}

	public void setUniversities(List<String> universities) {
		StudentService.universities = universities;
	}

	private Major major(int index) {
		return majors.get(index);
	}

	private String randomUni() {
		return universities.get(randomBetween(0, universities.size() - 1));
	}

	private List<Major> randomNBeweenMajors(int n) {
		return majors(randomNBetween(n, 0, majors.size() - 1));
	}

	public static Integer[] randomNBetween(int n, int min, int max) {
		Set<Integer> set = new HashSet<Integer>();
		while (set.size() < n) {
			set.add(randomBetween(min, max));
		}

		return set.toArray(new Integer[set.size()]);
	}

	private static int randomBetween(int minimum, int maximum) {
		Random rn = new Random();
		int range = maximum - minimum + 1;
		int randomNum = rn.nextInt(range) + minimum;
		return randomNum;
	}

	private List<Major> majors(Integer... index) {
		return Arrays.stream(index).map(this::major).collect(Collectors.toList());
	}

	public List<Student> createStudents() {
		return students;
	}

	public long getCountByUniAndMajor(int uniIndex, int majorIndex) {
		return majors.get(majorIndex).getRatedStudents().stream().filter(student -> prediUniMajor(student, uniIndex))
				.count();
	}

	boolean prediUniMajor(Student student, int uniIndex) {
		return universities.get(uniIndex).equals(student.getUniversity());
	}

	public long getCountBySexAndMajor(SexType sex, int majorIndex) {
		return majors.get(majorIndex).getRatedStudents().stream().filter(student -> student.getSex().equals(sex))
				.count();
	}

	public long getRatedCountByUni(int index) {
		return findBy(student -> student.getUniversity().equals(universities.get(index)) && student.getMajor() != null);
	}

	private long findBy(Predicate<? super Student> pred) {
		return students.stream().filter(pred).count();
	}
}
