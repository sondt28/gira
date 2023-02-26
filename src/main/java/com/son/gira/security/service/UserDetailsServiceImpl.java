package com.son.gira.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.son.gira.common.exception.GiraException;
import com.son.gira.user.model.User;
import com.son.gira.user.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = repository.findByEmail(email)
							.orElseThrow(() -> new GiraException("Email not found!"));
		
		return new org.springframework.security.core.userdetails.
				User(email, email, null);
	}
	
	
}
