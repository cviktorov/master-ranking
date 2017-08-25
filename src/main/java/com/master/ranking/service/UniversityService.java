package com.master.ranking.service;

import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "universitiesService")
@ApplicationScoped
public class UniversityService {

	private static List<String> universities;

	public UniversityService() {
		universities = Arrays.asList("СУ", "ТУ", "ВВВУ", "ВТУ", "НБУ", "УНСС");
	}

	public List<String> getUniversities() {
		return universities;
	}

	public void setUniversities(List<String> universities) {
		UniversityService.universities = universities;
	}

}
