package com.master.ranking.service;

import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.master.ranking.model.Major;

@ManagedBean(name = "majorService")
@ApplicationScoped
public class MajorService {

	private static List<Major> majors;

	public MajorService() {
		majors = Arrays.asList(new Major("Вградени системи", "ВС", 3),
				new Major("Дискретни и алгебрични структури", "ДАС", 2),
				new Major("Електронен бизнес и електронно управление", "ЕБЕУ", 1),
				new Major("Изкуствен интелект", "ИИ", 3), new Major("Информационни системи", "ИС", 2),
				new Major("Логика и алгоритми", "ЛА", 2), new Major("Механика и роботика", "МР", 1),
				new Major("Компютърна графика", "КГ", 3));
	}

	public List<Major> getMajors() {
		return majors;
	}

	public void setMajors(List<Major> majors) {
		MajorService.majors = majors;
	}

}
