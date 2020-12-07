package com.casestudy.tlta.entity;

import java.sql.Time;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="activity_table")
public class Activity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="activity_id")
	private Integer activity_id;
	@Column(name="activity_link")
	private String activity_link;
	@Column(name="activity_point")
	private String activity_point;
	@Column(name="activity_type")
	private String activity_type;
	@Column(name="activity_level")
	private String activity_level;
	@Column(name="activity_time")
	private Time activity_time;
	@Column(name="activity_realsedate")
	private LocalDate activity_realsedate;
	@Column(name="assesment")
	private Assesment assesment;


	public Integer getActivity_id() {
		return activity_id;
	}
	public void setActivity_id(Integer activity_id) {
		this.activity_id = activity_id;
	}
	public String getActivity_link() {
		return activity_link;
	}
	public void setActivity_link(String activity_link) {
		this.activity_link = activity_link;
	}
	public String getActivity_point() {
		return activity_point;
	}
	public void setActivity_point(String activity_point) {
		this.activity_point = activity_point;
	}
	public String getActivity_type() {
		return activity_type;
	}
	public void setActivity_type(String activity_type) {
		this.activity_type = activity_type;
	}
	public String getActivity_level() {
		return activity_level;
	}
	public void setActivity_level(String activity_level) {
		this.activity_level = activity_level;
	}
	public Time getActivity_time() {
		return activity_time;
	}
	public void setActivity_time(Time activity_time) {
		this.activity_time = activity_time;
	}
	public LocalDate getActivity_realsedate() {
		return activity_realsedate;
	}
	public void setActivity_realsedate(LocalDate activity_realsedate) {
		this.activity_realsedate = activity_realsedate;
	}
	public Assesment getAssesment() {
		return assesment;
	}
	public void setAssesment(Assesment assesment) {
		this.assesment = assesment;
	}

	public Activity() {

	}


	public Activity(Integer activity_id, String activity_link, String activity_point, String activity_type,
			String activity_level, Time activity_time, LocalDate activity_realsedate, Assesment assesment) {
		super();
		this.activity_id = activity_id;
		this.activity_link = activity_link;
		this.activity_point = activity_point;
		this.activity_type = activity_type;
		this.activity_level = activity_level;
		this.activity_time = activity_time;
		this.activity_realsedate = activity_realsedate;
		this.assesment = assesment;
	}
	@Override
	public String toString() {
		return "Activity [activity_id=" + activity_id + ", activity_link=" + activity_link + ", activity_point="
				+ activity_point + ", activity_type=" + activity_type + ", activity_level=" + activity_level
				+ ", activity_time=" + activity_time + ", activity_realsedate=" + activity_realsedate + ", assesment="
				+ assesment + "]";
	}



}
