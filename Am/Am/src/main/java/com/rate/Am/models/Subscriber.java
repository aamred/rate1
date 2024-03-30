package com.rate.Am.models;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * @author Anton Muzhytskyi
 */

@SuppressWarnings("serial")
@Entity
@Table(name="Subscribers")
@IdClass(SubscriberId.class)
public class Subscriber implements Serializable {
	
	//private static final long serialVersionUID = 1L;
	
	 @Id
	 @OneToOne
	 @JoinColumn(name = "rater_id", referencedColumnName = "rater_id")
	 private Rater rater;

	 @Id
	 @ManyToOne
	 @JoinColumn(name = "subscriber_id", referencedColumnName = "rater_id")
	 private Rater subscriber;

	 public Rater getUser() {return rater;}
	 public void setUser(Rater rater) {this.rater = rater;}

	 public Rater getSubscriber() {return subscriber;}
	 public void setSubscriber(Rater subscriber) {this.subscriber = subscriber;}
	
}
