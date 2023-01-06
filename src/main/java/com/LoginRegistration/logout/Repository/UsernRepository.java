package com.LoginRegistration.logout.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.LoginRegistration.logout.model.Usern;

@Repository
public interface UsernRepository  extends JpaRepository<Usern, Long>{
	
	Usern findByEmail(String email);
}
