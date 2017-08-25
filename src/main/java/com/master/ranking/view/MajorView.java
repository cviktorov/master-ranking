package com.master.ranking.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.master.ranking.model.Major;
import com.master.ranking.service.MajorService;

@ManagedBean(name = "MajorView")
@ViewScoped
public class MajorView {

	private List<Major> majors;

	@ManagedProperty("#{majorService}")
	private MajorService service;
	
	@PostConstruct
	public void init() {
		majors = service.getMajors();
	}

	public List<Major> getMajors() {
		return majors;
	}

	public void setMajors(List<Major> majors) {
		this.majors = majors;
	}

	public MajorService getService() {
		return service;
	}

	public void setService(MajorService service) {
		this.service = service;
	}

}
