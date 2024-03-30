package com.rate.Am.models;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author Anton Muzhytskyi
 */

@SuppressWarnings("serial")
public class SubscriberId implements Serializable{
	
	//private static final long serialVersionUID = 1L;
	
	//vmesto long poprobovat int
	
	private Long rater;
	private Long subscriber;
	
	
	public Long getUser() {return rater;}
	public void setUser(Long rater) {this.rater = rater;}
	
	public Long getSubscriber() {return subscriber;}
	public void setSubscriber(Long subscriber) {this.subscriber = subscriber;}
	
	@Override
	public boolean equals(Object o) {
		if(this == o)
			return true;
		if(o == null || getClass() != o.getClass())
			return false;
		SubscriberId that = (SubscriberId) o;
		return Objects.equals(rater, that.rater) && Objects.equals(subscriber, that.subscriber);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(rater, subscriber);
	}
}
