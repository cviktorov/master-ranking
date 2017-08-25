package com.master.ranking.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.menu.MenuModel;

import com.master.ranking.model.Major;
import com.master.ranking.service.MajorService;
import com.master.ranking.service.RankingSystem;

@ManagedBean(name = "menuView")
@ViewScoped
public class MenuView implements Serializable {

	private static final long serialVersionUID = 2969574076389375333L;

	private MenuModel model;

	@ManagedProperty("#{rankingSystem}")
	private RankingSystem rankingSystem;

	@ManagedProperty("#{majorService}")
	private MajorService service;

	private List<Major> majors;

	@PostConstruct
	public void init() {
		majors = service.getMajors();
	}

	public MenuModel getModel() {
		return model;
	}

	public void save() {
		rankingSystem.execute();
		addMessage("Студентите са класирани", "Студентите са класирани");
	}

	public void addMessage(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public RankingSystem getRankingSystem() {
		return rankingSystem;
	}

	public void setRankingSystem(RankingSystem rankingSystem) {
		this.rankingSystem = rankingSystem;
	}

	public MajorService getService() {
		return service;
	}

	public void setService(MajorService service) {
		this.service = service;
	}

	public List<Major> getMajors() {
		return majors;
	}

	public void setMajors(List<Major> majors) {
		this.majors = majors;
	}

	public void setModel(MenuModel model) {
		this.model = model;
	}

}