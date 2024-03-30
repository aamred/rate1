package com.rate.Am.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 * @author Anton Muzhytskyi
 */

@Entity
@Table(name="Rater")
public class Rater {

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
	
	@Column(name = "status")
	private short status;          //0 - v seti 1- ne v seti 2-skrito 3-crazy
	
	@Column(name="theme")       //0-day  1-night 2-bright
	private short theme;
	
	@Column(name="notification")
	private boolean notification;
	
	@Column(name="language")
	private short language;
	
	//country
	//city
	
	
	@OneToMany(mappedBy = "requestFromId")
	private List<Request> reequestsFromRater;
	
	@OneToMany(mappedBy = "requestToId")
	private List<Request> reequestsToRater;
	
	@OneToMany(mappedBy = "messageFromId")
	private List<Message> messagesFromRater;
	
	@OneToMany(mappedBy = "messageToId")
	private List<Message> messagesToRater;
	
	@OneToMany(mappedBy = "postWriter")
	private List<Post> posts;
	
	@OneToMany(mappedBy = "rateFromId")
	private List<Rate> rateFromId;
	
	@OneToMany(mappedBy = "rateToId")
	private List<Rate> rateToId;
	
	
	@OneToMany(mappedBy = "commentAuthor")
	private List<Comment> comments;
	
	@OneToOne(mappedBy="rater")
	private Subscriber subscribersIdentificator;
	
	@OneToMany(mappedBy = "subscriber")
	private List<Subscriber> subscribers;


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

	public List<Request> getReequestsFromRater() {return reequestsFromRater;}
	public void setReequestsFromRater(List<Request> reequestsFromRater) {this.reequestsFromRater = reequestsFromRater;}

	public List<Request> getReequestsToRater() {return reequestsToRater;}
	public void setReequestsToRater(List<Request> reequestsToRater) {this.reequestsToRater = reequestsToRater;}

	public List<Message> getMessagesFromRater() {return messagesFromRater;}
	public void setMessagesFromRater(List<Message> messagesFromRater) {this.messagesFromRater = messagesFromRater;}

	public List<Message> getMessagesToRater() {return messagesToRater;}
	public void setMessagesToRater(List<Message> messagesToRater) {this.messagesToRater = messagesToRater;}

	public List<Post> getPosts() {return posts;}
	public void setPosts(List<Post> posts) {this.posts = posts;}

	public List<Rate> getRateFromId() {return rateFromId;}
	public void setRateFromId(List<Rate> rateFromId) {this.rateFromId = rateFromId;}

	public List<Rate> getRateToId() {return rateToId;}
	public void setRateToId(List<Rate> rateToId) {this.rateToId = rateToId;}

	public List<Comment> getComments() {return comments;}
	public void setComments(List<Comment> comments) {this.comments = comments;}

	public Subscriber getSubscribersIdentificator() {return subscribersIdentificator;}
	public void setSubscribersIdentificator(Subscriber subscribersIdentificator) {this.subscribersIdentificator = subscribersIdentificator;}

	public List<Subscriber> getSubscribers() {return subscribers;}
	public void setSubscribers(List<Subscriber> subscribers) {this.subscribers = subscribers;}
	
}
