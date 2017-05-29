package com.master.ranking.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.master.ranking.model.Major;
import com.master.ranking.model.Student;

@ManagedBean(name = "studentService")
@ApplicationScoped
public class StudentService {

	private final static List<Student> students;

	static {
		students = Arrays.asList(new Student("Христо Илиев Димитров", 10.13, majors(0, 1)),
				new Student("Гергана Василева Атанасова", 9.55, majors(0, 2)),
				new Student("Диляна Бисерова Хаджиматева", 9.36, majors(1, 2)),
				new Student("Савина Димитрова Димитрова", 9.01, majors(0, 1)),
				new Student("Маргарита Антонова Кацарска", 8.43, majors(1, 2)),
				new Student("Симеон Кирилов Димитров", 9.95, majors(0, 2)),
				new Student("Изабел Руменова Милчева", 9.58, majors(1, 2)),
				new Student("Тодор Симеонов Спасов", 10, majors(0, 2)));
	}

	private static Major major(int index) {
		return MajorService.majors.get(index);
	}

	private static List<Major> majors(Integer... index) {
		return Arrays.stream(index).map(StudentService::major).collect(Collectors.toList());
	}

	public  List<Student> createStudents() {
		return students;
	}
}
