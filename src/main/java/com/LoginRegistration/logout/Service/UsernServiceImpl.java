package com.LoginRegistration.logout.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.LoginRegistration.logout.Dto.UserregistrationDto;
import com.LoginRegistration.logout.Repository.UsernRepository;
import com.LoginRegistration.logout.model.Role;
import com.LoginRegistration.logout.model.Usern;

@Service
public class UsernServiceImpl implements UsernService {
	
	@Autowired
	UsernRepository repository;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@Override
	public Usern save(UserregistrationDto registrationDto) {
		
		
		Usern usern=new Usern(registrationDto.getFirstname(),registrationDto.getLastname(),registrationDto.getEmail(),
			passwordEncoder.encode(registrationDto.getPassword()),Arrays.asList(new Role("ROlE_USER")));
		
		return repository.save(usern);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usern user=repository.findByEmail(username);
		if(user==null)
		{
			throw new UsernameNotFoundException("invalid username");
		}
		
		return new User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
	}
	

	 private Collection <? extends GrantedAuthority > mapRolesToAuthorities(Collection < Role > roles) {
	        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	    }
	
}
