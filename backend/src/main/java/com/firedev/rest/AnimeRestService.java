package com.firedev.rest;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.firedev.model.Attributes;
import com.firedev.model.DataResponse;
import com.firedev.model.Pesquisa;
import com.firedev.model.Especifico.Data;
import com.firedev.repository.PesquisaRepository;
import com.firedev.service.AnimeService;
/**
 * Classe da Camada de controller, responsavel pela logica e alocacao das rotas de acesso a API
 */
@RestController
public class AnimeRestService {

	@Autowired
	private AnimeService animeService;
	
	@Autowired
	private PesquisaRepository pesquisaRepository;
	/**
	 * Rota de acesso do animes mais populares da API
	 * @return animes mais populares
	 */
	@GetMapping("/animesPopulares")
	public ResponseEntity<DataResponse> animesPopulares() {
		DataResponse dataResponse = animeService.AnimesMaisPopulares();
		return dataResponse != null ? ResponseEntity.ok().body(dataResponse) : ResponseEntity.notFound().build(); 
	}
	/**
	 * Rota de acesso dos mangas mais populares da API
	 * @return mangas mais populares
	 */
	@GetMapping("/mangasPopulares")
	public ResponseEntity<DataResponse> mangasPopulares() {
		DataResponse dataResponse = animeService.MangasMaisPopulares();
		return dataResponse != null ? ResponseEntity.ok().body(dataResponse) : ResponseEntity.notFound().build(); 
	}
	
	/**
	 * Rota de pesquisa de animes, mangas por algum valor de entrada do usuario
	 * Tambem pega o valor da pesquisa e insere no banco de dados
	 * @param search valor textual da pesquisa
	 * @return Animes e mangas pesquisados pelo seu titulo 
	 */
	@GetMapping("/titulo{search}")
	public ResponseEntity<DataResponse> buscaTitulos(@RequestParam String search) {
		
		Pesquisa pesquisa = new Pesquisa();
		pesquisa.setBusca(search);
		pesquisa.setMoment(Instant.now());
		pesquisaRepository.insertBuscaNoBD(pesquisa);
		
		
		DataResponse dataResponse = animeService.PesquisaPorTitulo(search);
		
		return dataResponse != null ? ResponseEntity.ok().body(dataResponse) : ResponseEntity.notFound().build(); 
	}
	/**
	 * Rota de acesso a pesquisa de animes/mangas por categoria filtrada
	 * @param filter, valor do filtro por categoria, exemplo: Adventure
	 * @return animes da categoria filtrada
	 */
	@GetMapping("/categoria{filter}")
	public ResponseEntity<DataResponse> buscarCategorias(@RequestParam String filter) {
		DataResponse dataResponse = animeService.FiltrarPorCategoria(filter);
		return dataResponse != null ? ResponseEntity.ok().body(dataResponse) : ResponseEntity.notFound().build(); 
	}
	/**
	 * Rota de acesso do anime mais especifico, acessado pelo seu id
	 * @param id identificador do anime
	 * @return O Anime com mais informacoes detalhadas
	 */
	@GetMapping("/anime/{id}")
	public ResponseEntity<Data> buscaUmAnimePorId(@PathVariable String id) {
		Data data = animeService.BuscarUmAnime(id);
		return data != null ? ResponseEntity.ok().body(data) : ResponseEntity.notFound().build(); 
	}
	/**
	 * Rota de acesso do Manga especifico, acessado pelo seu id
	 * @param id
	 * @return O Manga com mais informacoes detalhadas
	 */
	@GetMapping("/manga/{id}")
	public ResponseEntity<Data> buscaMangaPorId(@PathVariable String id) {
		Data data = animeService.BuscarUmManga(id);
		return data != null ? ResponseEntity.ok().body(data) : ResponseEntity.notFound().build();
	}
	/**
	 * Rota da REST para acessar um episodio especifico
	 * @param id identificador do episodio
	 * @return Episodio especifico
	 */
	@GetMapping("/episodio/{id}")
	public ResponseEntity<Data> buscaEpisodioPorId(@PathVariable String id) {
		Data data = animeService.BuscarUmEpisodio(id);
		return data != null ? ResponseEntity.ok().body(data) : ResponseEntity.notFound().build(); 
	}
}
