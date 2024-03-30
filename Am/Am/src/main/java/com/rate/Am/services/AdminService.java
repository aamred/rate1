package com.rate.Am.services;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

/**
 * @author Anton Muzhytskyi
 */

@Service
public class AdminService {
	
	@PreAuthorize("hasRole('admin')")
	public void doAdminStaff() {
		System.out.println("Only admin can be here");
	}

}
