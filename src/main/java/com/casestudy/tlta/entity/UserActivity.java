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
@Table(name = "user_activity")
public class UserActivity {
	
	@Id
	@Column(name = "user_activity_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private LearningActivity userActivityId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private Login login;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "activity_id")
	private LearningActivity learningActivity;
	
	@Column(name = "status")
	private String status = "register";
	
	@Column(name = "certificate")
	private String certificate;

	public LearningActivity getUserActivityId() {
		return userActivityId;
	}

	public void setUserActivityId(LearningActivity userActivityId) {
		this.userActivityId = userActivityId;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
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
