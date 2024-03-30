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
@Table(name="Rate")
public class Rate {
	
	@Id
	@Column(name="rate_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rateId;
	
	@Column(name="datetime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date datetime;
	
	@Column(name="rate_value")
	private double rateValue;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "rate_from_id", referencedColumnName="rater_id")
	private Rater rateFromId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "rate_to_id", referencedColumnName="rater_id")
	private Rater rateToId;
	
	public Rate() {}

	public Rate(int rateId, Date datetime, double rateValue, Rater rateFromId, Rater rateToId) {
		//super();
		this.rateId = rateId;
		this.datetime = datetime;
		this.rateValue = rateValue;
		this.rateFromId = rateFromId;
		this.rateToId = rateToId;
	}

	public int getRateId() {return rateId;}
	public void setRateId(int rateId) {this.rateId = rateId;}

	public Date getDatetime() {return datetime;}
	public void setDatetime(Date datetime) {this.datetime = datetime;}

	public double getRateValue() {return rateValue;}
	public void setRateValue(double rateValue) {this.rateValue = rateValue;}

	public Rater getRateFromId() {return rateFromId;}
	public void setRateFromId(Rater rateFromId) {this.rateFromId = rateFromId;}

	public Rater getRateToId() {return rateToId;}
	public void setRateToId(Rater rateToId) {this.rateToId = rateToId;}

}
