package com.firedev.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.firedev.model.DataResponse;
import com.firedev.service.AnimeService;

@RestController
public class AnimeRestService {

	@Autowired
	private AnimeService animeService;

	@GetMapping("/animesPopulares")
	public ResponseEntity<DataResponse> animesPopulares() {
		DataResponse dataResponse = animeService.AnimesMaisPopulares();
		return dataResponse != null ? ResponseEntity.ok().body(dataResponse) : ResponseEntity.notFound().build(); 
	}
	
	@GetMapping("/mangasPopulares")
	public ResponseEntity<DataResponse> mangasPopulares() {
		DataResponse dataResponse = animeService.MangasMaisPopulares();
		return dataResponse != null ? ResponseEntity.ok().body(dataResponse) : ResponseEntity.notFound().build(); 
	}
	

}
