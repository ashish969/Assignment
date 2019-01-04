package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.NewsScraper;


@RestController
@RequestMapping("/NewsScraper")

public class NewsScraperController {
	
	 @Autowired
	    private com.example.repository.NewsScraperJpaRepository NewsScraperJpaRepository;

	    @GetMapping(value = "/all")
	    public List<NewsScraper> findAll() {
	        return NewsScraperJpaRepository.findAll();
	    }

	    @GetMapping(value = "/{Authorname}")
	    public NewsScraper findByName(@PathVariable final String Authorname){
	        return NewsScraperJpaRepository.findByAuthorname(Authorname);
	    }

	    @PostMapping(value = "/load")
	    public NewsScraper load(@RequestBody final NewsScraper NewsScraper) {
	    	NewsScraperJpaRepository.save(NewsScraper);
	        return NewsScraperJpaRepository.findByAuthorname(NewsScraper.getAuthorname());
	    }

}
