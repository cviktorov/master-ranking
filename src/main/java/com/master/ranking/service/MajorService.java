package com.master.ranking.service;

import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.master.ranking.model.Major;

@ManagedBean(name = "majorService")
@ApplicationScoped
public class MajorService {

	public final static List<Major> majors;

	static {
		 majors = Arrays.asList(
				  new Major("Вградени системи", 8),
				  new Major("Дискретни и алгебрични структури", 5),
				  new Major("Вградени системи", 8)
				  );
	}

}
