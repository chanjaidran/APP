package com.LoginRegistration.logout.Service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.LoginRegistration.logout.Dto.UserregistrationDto;
import com.LoginRegistration.logout.model.Usern;

public interface UsernService extends UserDetailsService {

	Usern save(UserregistrationDto registrationDto);
}
