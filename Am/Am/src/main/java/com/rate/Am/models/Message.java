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
@Table(name="Message")
public class Message {
	
	@Id
	@Column(name="message_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int messageId;
	
	@Column(name="datetime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date datetime;
	
	@Column(name="message_content")
	private String messageContent;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "message_from_id", referencedColumnName="rater_id")
	private Rater messageFromId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "message_to_id", referencedColumnName="rater_id")
	private Rater messageToId;
	
	public Message() {}

	public Message(int messageId, Date datetime, String messageContent, Rater messageFromId, Rater messageToId) {
		//super();
		this.messageId = messageId;
		this.datetime = datetime;
		this.messageContent = messageContent;
		this.messageFromId = messageFromId;
		this.messageToId = messageToId;
	}

	public int getMessageId() {return messageId;}
	public void setMessageId(int messageId) {this.messageId = messageId;}

	public Date getDatetime() {return datetime;}
	public void setDatetime(Date datetime) {this.datetime = datetime;}

	public String getMessageContent() {return messageContent;}
	public void setMessageContent(String messageContent) {this.messageContent = messageContent;}

	public Rater getMessageFromId() {return messageFromId;}
	public void setMessageFromId(Rater messageFromId) {this.messageFromId = messageFromId;}

	public Rater getMessageToId() {return messageToId;}
	public void setMessageToId(Rater messageToId) {this.messageToId = messageToId;}

}
