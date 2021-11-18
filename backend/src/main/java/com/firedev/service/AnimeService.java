package com.firedev.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.firedev.model.DataResponse;

/**Classe Service que cria o cliente http de maneira declarativa
* @author Guilherme Soterio
* @since Release 01 da aplicaçao
*/

@FeignClient(url= "https://kitsu.io/api/edge/" , name = "kitsu")
public interface AnimeService {
	
	/** https://kitsu.io/api/edge/trending/anime
	 * Metodo que retorna uma resposta da API com os animes mais populares.*/
	@GetMapping("trending/anime")
	DataResponse AnimesMaisPopulares();
	
	/** https://kitsu.io/api/edge/trending/manga
	 * Metodo que retorna uma resposta da API com os mangas mais populares.*/
	@GetMapping("trending/manga")
	DataResponse MangasMaisPopulares();
	
	@GetMapping("/anime?filter[categories]={categoria}")
	DataResponse FiltrarPorCategoria(@PathVariable("categoria") String categoria);

	
	@GetMapping("/anime?filter[text]={pesquisa}")
	DataResponse PesquisaPorTitulo(@PathVariable("pesquisa") String pesquisa);




}
