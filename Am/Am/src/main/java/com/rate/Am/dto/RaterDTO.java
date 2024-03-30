package com.rate.Am.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 * @author Anton Muzhytskyi
 */

public class RaterDTO {
	
	@Id
	@Column(name="rater_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int raterId;
	
	@NotEmpty(message = "Name shouldnot be empty")
	@Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
	@Column(name="nickname")
	private String nickname;
	
	@Column(name="password")
	private String password;
	
	@Pattern(regexp="^(\\+[0-9]{1,3}[- ]?)?\\(?[0-9]{3}\\)?[- ]?[0-9]{3}[- ]?[0-9]{4}$", message="Invalid phone number")
	@Column(name="telephone")
	private String telephone;
	
	@Column(name="enabled")
	private boolean enabled;
	
	@Column(name="faceimage")
	private String faceImage;
	
	@Column(name="bodyimage")
	private String bodyImage;
	
	@Column(name="total_rate")
	private double totalRate;
	
	@Column(name="score")
	private double score;
	
	@Column(name = "gender")
	private short gender;           //0-girl  1-boy  2-it
	
	@Column(name = "role")
	private String role;            //user   admin
	
	@Column(name = "ststus")
	private short status;          //0 - v seti 1- ne v seti 2-skrito 3-crazy
	
	@Column(name="theme")       //0-day  1-night 2-bright
	private short theme;
	
	@Column(name="notification")
	private boolean notification;
	
	@Column(name="language")
	private short language;
	
	public int getRaterId() {return raterId;}
	public void setRaterId(int raterId) {this.raterId = raterId;}

	public String getNickname() {return nickname;}
	public void setNickname(String nickname) {this.nickname = nickname;}
	
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}
	
	public String getTelephone() {return telephone;}
	public void setTelephone(String telephone) {this.telephone = telephone;}

	public boolean isEnabled() {return enabled;}
	public void setEnabled(boolean enabled) {this.enabled = enabled;}

	public String getFaceImage() {return faceImage;}
	public void setFaceImage(String faceImage) {this.faceImage = faceImage;}

	public String getBodyImage() {return bodyImage;}
	public void setBodyImage(String bodyImage) {this.bodyImage = bodyImage;}

	public double getTotalRate() {return totalRate;}
	public void setTotalRate(double totalRate) {this.totalRate = totalRate;}

	public double getScore() {return score;}
	public void setScore(double score) {this.score = score;}

	public short getGender() {return gender;}
	public void setGender(short gender) {this.gender = gender;}

	public String getRole() {return role;}
	public void setRole(String role) {this.role = role;}

	public short getStatus() {return status;}
	public void setStatus(short status) {this.status = status;}
	
	public short getTheme() {return theme;}
	public void setTheme(short theme) {this.theme = theme;}
	
	public boolean isNotification() {return notification;}
	public void setNotification(boolean notification) {this.notification = notification;}
	
	public short getLanguage() {return language;}
	public void setLanguage(short language) {this.language = language;}

}
