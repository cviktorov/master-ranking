package com.master.ranking.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.ItemSelectEvent;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;

import com.master.ranking.model.Major;
import com.master.ranking.service.MajorService;
import com.master.ranking.service.StudentService;
import com.master.ranking.service.UniversityService;

@ManagedBean
@ViewScoped
public class ChartView2 implements Serializable {

	private static final long serialVersionUID = -9039707838634297967L;
	private BarChartModel animatedModel2;
	private PieChartModel pieModel1;

	@ManagedProperty("#{majorService}")
	private MajorService majorService;
	@ManagedProperty("#{universitiesService}")
	private UniversityService universitiesService;

	private List<Major> majors;

	private List<String> universities;

	@PostConstruct
	public void init() {
		majors = majorService.getMajors();
		universities = universitiesService.getUniversities();
		createAnimatedModels(null);
		createPieModels();
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
		this.majors = majors;
	}

	public List<String> getUniversities() {
		return universities;
	}

	public void setUniversities(List<String> universities) {
		this.universities = universities;
	}

	public BarChartModel getAnimatedModel2() {
		return animatedModel2;
	}

	public PieChartModel getPieModel1() {
		return pieModel1;
	}

	private void createAnimatedModels(Integer uniIndex) {
		animatedModel2 = initBarModel(uniIndex);

		if (uniIndex != null) {
			animatedModel2.setTitle(universities.get(uniIndex));
		} else {
			animatedModel2.setTitle("");
		}

		animatedModel2.setAnimate(true);
		animatedModel2.setLegendPosition("ne");
		Axis yAxis = animatedModel2.getAxis(AxisType.Y);
		yAxis.setMin(0);
		yAxis.setMax(10);
	}

	private BarChartModel initBarModel(Integer uniIndex) {
		BarChartModel model = new BarChartModel();

		StudentService ss = new StudentService();
		ChartSeries boys = new ChartSeries();
		boys.setLabel("Студенти");

		for (int i = 0; i < majors.size(); i++) {
			long count = uniIndex == null ? 0 : ss.getCountByUniAndMajor(uniIndex, i);
			boys.set(majors.get(i), count);
		}

		model.addSeries(boys);

		return model;
	}

	private void createPieModels() {
		createPieModel1();
	}

	private void createPieModel1() {
		pieModel1 = new PieChartModel();

		StudentService ss = new StudentService();
		for (int i = 0; i < universities.size(); i++) {
			pieModel1.set(universities.get(i), ss.getRatedCountByUni(i));
		}

		pieModel1.setTitle("Класиране според университета");
		pieModel1.setLegendPosition("w");
	}

	public void itemSelect(ItemSelectEvent event) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item selected",
				"Item Index: " + event.getItemIndex() + ", Series Index:" + event.getSeriesIndex());

		createAnimatedModels(event.getItemIndex());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	
}