package com.rate.Am.models;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

/**
 * @author Anton Muzhytskyi
 */

@Entity
@Table(name="Comment")
public class Comment {
	
	@Id
	@Column(name="comment_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int commentId;
	
	@Column(name="datetime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date datetime;
	
	@Column(name="comment_content")
	private String commentContent;
	
	@Column(name="fire")
	private int fire;
	
	@Column(name="shit")
	private int shit;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "author", referencedColumnName="rater_id")
	private Rater commentAuthor;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "post_identificator", referencedColumnName="post_id")
	private Post postIdentificator;

	public Comment() {}
	
	public Comment(int commentId, Date datetime, String commentContent, int fire, int shit, Rater commentAuthor,
			Post postIdentificator) {
		//super();
		this.commentId = commentId;
		this.datetime = datetime;
		this.commentContent = commentContent;
		this.fire = fire;
		this.shit = shit;
		this.commentAuthor = commentAuthor;
		this.postIdentificator = postIdentificator;
	}

	public int getCommentId() {return commentId;}
	public void setCommentId(int commentId) {this.commentId = commentId;}

	public Date getDatetime() {return datetime;}
	public void setDatetime(Date datetime) {this.datetime = datetime;}

	public String getCommentContent() {return commentContent;}
	public void setCommentContent(String commentContent) {this.commentContent = commentContent;}
	
	public int getFire() {return fire;}
	public void setFire(int fire) {this.fire = fire;}

	public int getShit() {return shit;}
	public void setShit(int shit) {this.shit = shit;}

	public Rater getCommentAuthor() {return commentAuthor;}
	public void setCommentAuthor(Rater commentAuthor) {this.commentAuthor = commentAuthor;}

	public Post getPostIdentificator() {return postIdentificator;}
	public void setPostIdentificator(Post postIdentificator) {this.postIdentificator = postIdentificator;}

}
