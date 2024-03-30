package com.rate.Am.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

/**
 * @author Anton Muzhytskyi
 */

@Entity
@Table(name="Post")
public class Post {
	
	@Id
	@Column(name="post_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int postId;
	
	@Column(name="datetime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date datetime;
	
	@Column(name="post_content")
	private String postContent;
	
	@Column(name="fire")
	private int fire;
	
	@Column(name="shit")
	private int shit;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "writer", referencedColumnName="rater_id")
	private Rater postWriter;
	
	@OneToMany(mappedBy = "postIdentificator")
	private List<Comment> comments;
	
	
	public Post() {}

	public Post(int postId, Date datetime, String postContent, int fire, int shit, Rater postWriter,
			List<Comment> comments) {
		//super();
		this.postId = postId;
		this.datetime = datetime;
		this.postContent = postContent;
		this.fire = fire;
		this.shit = shit;
		this.postWriter = postWriter;
		this.comments = comments;
	}

	public int getPostId() {return postId;}
	public void setPostId(int postId) {this.postId = postId;}

	public Date getDatetime() {return datetime;}
	public void setDatetime(Date datetime) {this.datetime = datetime;}

	public String getPostContent() {return postContent;}
	public void setPostContent(String postContent) {this.postContent = postContent;}

	public int getFire() {return fire;}
	public void setFire(int fire) {this.fire = fire;}

	public int getShit() {return shit;}
	public void setShit(int shit) {this.shit = shit;}

	public Rater getPostWriter() {return postWriter;}
	public void setPostWriter(Rater postWriter) {this.postWriter = postWriter;}

	public List<Comment> getComments() {return comments;}
	public void setComments(List<Comment> comments) {this.comments = comments;}
	
}
