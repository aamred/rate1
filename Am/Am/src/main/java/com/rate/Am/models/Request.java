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
@Table(name="Request")
public class Request {

	@Id
	@Column(name="request_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int requestId;
	
	@Column(name="datetime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date datetime;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "request_from_id", referencedColumnName="rater_id")
	private Rater requestFromId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "request_to_id", referencedColumnName="rater_id")
	private Rater requestToId;
	
	public Request() {}

	public Request(int requestId, Date datetime, Rater requestFromId, Rater requestToId) {
		//super();
		this.requestId = requestId;
		this.datetime = datetime;
		this.requestFromId = requestFromId;
		this.requestToId = requestToId;
	}

	public int getRequestId() {return requestId;}
	public void setRequestId(int requestId) {this.requestId = requestId;}

	public Date getDatetime() {return datetime;}
	public void setDatetime(Date datetime) {this.datetime = datetime;}

	public Rater getRequestFromId() {return requestFromId;}
	public void setRequestFromId(Rater requestFromId) {this.requestFromId = requestFromId;}

	public Rater getRequestToId() {return requestToId;}
	public void setRequestToId(Rater requestToId) {this.requestToId = requestToId;}
	
}
