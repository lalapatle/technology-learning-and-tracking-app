package com.casestudy.tlta.entity;

import java.lang.annotation.Target;
import java.sql.Time;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="assesment_activity")
public class Assesment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id ;
	@Column(name="assesment_name")
	private String assesment_name;
	@Column(name="assesment_type")
	private String assesment_type;
	@Column(name="assesment_release_date")
	private LocalDate assesment_release_date;
	@Column(name="assesment_time_duration")
	private Time assesment_time_duration;
	
	// Getter and Setter methods
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAssesment_name() {
		return assesment_name;
	}
	public void setAssesment_name(String assesment_name) {
		this.assesment_name = assesment_name;
	}
	public String getAssesment_type() {
		return assesment_type;
	}
	public void setAssesment_type(String assesment_type) {
		this.assesment_type = assesment_type;
	}
	public LocalDate getAssesment_release_date() {
		return assesment_release_date;
	}
	public void setAssesment_release_date(LocalDate assesment_release_date) {
		this.assesment_release_date = assesment_release_date;
	}
	public Time getAssesment_time_duration() {
		return assesment_time_duration;
	}
	public void setAssesment_time_duration(Time assesment_time_duration) {
		this.assesment_time_duration = assesment_time_duration;
	}
	
	// No argument constructor
	public Assesment() {
		
	}
	
	// All argument constructor
	public Assesment(Integer id, String assesment_name, String assesment_type, LocalDate assesment_release_date,
			Time assesment_time_duration) {
		super();
		this.id = id;
		this.assesment_name = assesment_name;
		this.assesment_type = assesment_type;
		this.assesment_release_date = assesment_release_date;
		this.assesment_time_duration = assesment_time_duration;
	}
	
	//toString method
	@Override
	public String toString() {
		return "Assesment [id=" + id + ", assesment_name=" + assesment_name + ", assesment_type=" + assesment_type
				+ ", assesment_release_date=" + assesment_release_date + ", assesment_time_duration="
				+ assesment_time_duration + "]";
	}
	
}
