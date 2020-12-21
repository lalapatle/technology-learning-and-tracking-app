package com.casestudy.tlta.entity;

import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="learning_activity")
public class LearningActivity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name = "activity_name")
	private String activity_name;
	
	@Column(name="activity_link")
	private String activity_link;
	
	@Column(name="activity_level")
	private String activity_level;
	
	@Column(name="activity_time")
	private Double activity_time;
	
	@Temporal(TemporalType.DATE)
	@Column(name="activity_realsedate")
	private Date activity_realsedate;
	
	@OneToOne
	@JoinColumn(name="assesment_id")
	private Assessment assesment;
	
	@OneToMany(mappedBy = "learningActivity",cascade = CascadeType.ALL)
	private Set<UserActivity> userActivity = new HashSet<UserActivity>();
	
	public Set<UserActivity> getUserActivity(){
		return userActivity;
	}
	
	public void setUserActivity(Set<UserActivity> groups) {
		this.userActivity = groups;
	}
	
	public void addUserActivity(UserActivity userActivity) {
		this.userActivity.add(userActivity);
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getActivity_name() {
		return activity_name;
	}
	public void setActivity_name(String activity_name) {
		this.activity_name = activity_name;
	}
	public String getActivity_link() {
		return activity_link;
	}
	public void setActivity_link(String activity_link) {
		this.activity_link = activity_link;
	}
	public String getActivity_level() {
		return activity_level;
	}
	public void setActivity_level(String activity_level) {
		this.activity_level = activity_level;
	}
	public Double getActivity_time() {
		return activity_time;
	}
	public void setActivity_time(Double activity_time) {
		this.activity_time = activity_time;
	}
	public Date getActivity_realsedate() {
		return activity_realsedate;
	}
	public void setActivity_realsedate(Date activity_realsedate) {
		this.activity_realsedate = activity_realsedate;
	}
	public Assessment getAssesment() {
		return assesment;
	}
	public void setAssesment(Assessment assesment) {
		this.assesment = assesment;
	}
	
	//No argument constructor
	public LearningActivity() {
		
	}
	
	//All arguments constructor
	public LearningActivity(Integer id, String activity_name, String activity_link, String activity_level, Double activity_time,
			Date activity_realsedate, Assessment assesment) {
		super();
		this.id = id;
		this.activity_name = activity_name;
		this.activity_link = activity_link;
		this.activity_level = activity_level;
		this.activity_time = activity_time;
		this.activity_realsedate = activity_realsedate;
		this.assesment = assesment;
	}
	
	// toString method
	@Override
	public String toString() {
		return "Activity [id=" + id + ", activity_name=" + activity_name + ", activity_link=" + activity_link
				+ ", activity_level=" + activity_level + ", activity_time=" + activity_time + ", activity_realsedate="
				+ activity_realsedate + ", assesment=" + assesment + "]";
	}
}
