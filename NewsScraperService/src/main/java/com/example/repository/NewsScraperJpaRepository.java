package com.example.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.example.model.NewsScraper;

@Component
 
public interface NewsScraperJpaRepository extends JpaRepository<NewsScraper, Long>{
	
	NewsScraper findByAuthorname(String Authorname);

}
