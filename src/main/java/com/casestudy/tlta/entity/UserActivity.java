package com.casestudy.tlta.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users_activity")
public class UserActivity {
	
	@Id
	@Column(name = "user_activity_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userActivityId;
	
	@ManyToOne()
	@JoinColumn(name = "user_id")
	private RegisterUser login;
	
	@ManyToOne()
	@JoinColumn(name = "activity_id")
	private LearningActivity learningActivity;

	@Column(name = "status")
	private String status = "register";
	
	@Column(name = "certificate")
	private String certificate;

	public Integer getUserActivityId() {
		return userActivityId;
	}

	public void setUserActivityId(Integer userActivityId) {
		this.userActivityId = userActivityId;
	}

	public RegisterUser getLogin() {
		return login;
	}

	public void setLogin(RegisterUser login) {
		this.login = login;
	}

	public LearningActivity getLearningActivity() {
		return learningActivity;
	}

	public void setLearningActivity(LearningActivity learningActivity) {
		this.learningActivity = learningActivity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCertificate() {
		return certificate;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}

	
	
	
}