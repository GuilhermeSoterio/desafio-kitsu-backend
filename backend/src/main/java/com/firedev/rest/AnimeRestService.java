package com.firedev.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.firedev.model.DataResponse;
import com.firedev.model.Especifico.Data;
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
	

	@GetMapping("/titulo{search}")
	public ResponseEntity<DataResponse> buscaTitulos(@RequestParam String search) {
		DataResponse dataResponse = animeService.PesquisaPorTitulo(search);
		return dataResponse != null ? ResponseEntity.ok().body(dataResponse) : ResponseEntity.notFound().build(); 
	}
	
	@GetMapping("/categoria{filter}")
	public ResponseEntity<DataResponse> buscarCategorias(@RequestParam String filter) {
		DataResponse dataResponse = animeService.FiltrarPorCategoria(filter);
		return dataResponse != null ? ResponseEntity.ok().body(dataResponse) : ResponseEntity.notFound().build(); 
	}

	@GetMapping("/anime/{id}")
	public ResponseEntity<Data> buscaUmAnimePorId(@PathVariable String id) {
		Data data = animeService.BuscarUmAnime(id);
		return data != null ? ResponseEntity.ok().body(data) : ResponseEntity.notFound().build(); 
	}
	
	@GetMapping("/manga/{id}")
	public ResponseEntity<Data> buscaMangaPorId(@PathVariable String id) {
		Data data = animeService.BuscarUmManga(id);
		return data != null ? ResponseEntity.ok().body(data) : ResponseEntity.notFound().build();
	}
	
	@GetMapping("/episodio/{id}")
	public ResponseEntity<Data> buscaEpisodioPorId(@PathVariable String id) {
		Data data = animeService.BuscarUmEpisodio(id);
		return data != null ? ResponseEntity.ok().body(data) : ResponseEntity.notFound().build(); 
	}
}
