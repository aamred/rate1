package com.rate.Am.security;



import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.rate.Am.models.Rater;


/**
 * @author Anton Muzhytskyi
 */

public class RaterDetails implements UserDetails{
	
	private final Rater rater;
	//private final Verification verification;

	public RaterDetails(Rater rater) {
		super();
		this.rater = rater;
		//this.verification = verification;
	}

	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(rater.getRole()));
    }

	@Override
	public String getPassword() {
		return this.rater.getPassword();
	}

	@Override
	public String getUsername() {
		return this.rater.getNickname();
	}
	
	public String getTelephone() {
		return this.rater.getTelephone();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return rater.isEnabled();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return rater.isEnabled();
	}
	
	public Rater getUser() {
		return this.rater;
	}

}
