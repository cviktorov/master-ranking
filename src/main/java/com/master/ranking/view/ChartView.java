package com.master.ranking.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

import com.master.ranking.model.Major;
import com.master.ranking.model.Student.SexType;
import com.master.ranking.service.MajorService;
import com.master.ranking.service.StudentService;

@ManagedBean
@ViewScoped
public class ChartView implements Serializable {

	private static final long serialVersionUID = -5477802901605498217L;
	private BarChartModel barModel;

	@ManagedProperty("#{majorService}")
	private MajorService majorService;
	@ManagedProperty("#{studentService}")
	private StudentService studentService;

	private List<Major> majors;

	@PostConstruct
	public void init() {
		majors = majorService.getMajors();
		createBarModels();
	}

	public BarChartModel getBarModel() {
		return barModel;
	}

	private BarChartModel initBarModel() {
		BarChartModel model = new BarChartModel();
		ChartSeries boys = new ChartSeries();
		boys.setLabel("Момчета");

		for (int i = 0; i < majors.size(); i++) {
			boys.set(majors.get(i), studentService.getCountBySexAndMajor(SexType.MALE, i));
		}

		ChartSeries girls = new ChartSeries();
		girls.setLabel("Момичета");

		for (int i = 0; i < majors.size(); i++) {
			girls.set(majors.get(i), studentService.getCountBySexAndMajor(SexType.FEMALE, i));
		}

		model.addSeries(boys);
		model.addSeries(girls);

		return model;
	}

	private void createBarModels() {
		createBarModel();
	}

	private void createBarModel() {
		barModel = initBarModel();

		barModel.setTitle("Класиране според пола на студента");
		barModel.setLegendPosition("ne");

		Axis xAxis = barModel.getAxis(AxisType.X);
		xAxis.setLabel("Специалност");

		Axis yAxis = barModel.getAxis(AxisType.Y);
		yAxis.setLabel("Брой");
		yAxis.setMin(0);
		yAxis.setMax(10);
	}

	public MajorService getMajorService() {
		return majorService;
	}

	public void setMajorService(MajorService majorService) {
		this.majorService = majorService;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public List<Major> getMajors() {
		return majors;
	}

	public void setMajors(List<Major> majors) {
		this.majors = majors;
	}

}