package com.firedev.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.firedev.model.DataResponse;
import com.firedev.model.Especifico.Data;
import com.firedev.model.Especifico.DataObject;

/**Classe Service que cria o cliente http de maneira declarativa
* @author Guilherme Soterio
*/

@FeignClient(url= "https://kitsu.io/api/edge/" , name = "kitsu")
public interface AnimeService {
	
	/**
	 * Metodo que retorna uma resposta da API com os animes mais populares.*/
	@GetMapping("trending/anime")
	DataResponse AnimesMaisPopulares();
	
	/** 
	 * Metodo que retorna uma resposta da API com os mangas mais populares.*/
	@GetMapping("trending/manga")
	DataResponse MangasMaisPopulares();
	
	/**
	 * Metodo que retorna o filtro de categorias
	 * @param categoria
	 * @return Objeto da resposta dos animes da categoria
	 */
	@GetMapping("/anime?filter[categories]={categoria}")
	DataResponse FiltrarPorCategoria(@PathVariable("categoria") String categoria);
	/**
	 * Metodo que retorna o resultado pesquisa realizada pelo usuario
	 * @param pesquisa
	 * @return Objeto da resposta dos animes pesquisados
	 */
	@GetMapping("/anime?filter[text]={pesquisa}")
	DataResponse PesquisaPorTitulo(@PathVariable("pesquisa") String pesquisa);
	/**
	 * Metodo que retorna um anime pelo seu identificador
	 * @param idDoAnime identificador do anime
	 * @return um anime especifico e mais detalhado
	 */
	@GetMapping("/anime/{idDoAnime}")
	Data BuscarUmAnime(@PathVariable("idDoAnime") String idDoAnime);
	/**
	 * Metodo que retorna um manga pelo seu identificador
	 * @param idDoManga identificador de manga
	 * @return retorna o manga especifico e mais detalhado
	 */
	@GetMapping("/manga/{idDoManga}")
	Data BuscarUmManga(@PathVariable("idDoManga") String idDoManga);
	/**
	 * Metodo que retorna o episodio especifico de algum anime
	 * @param idDoEpisodio identificador do episodio
	 * @return um episodio mais especifico
	 */
	@GetMapping("/episodes/{idDoEpisodio}")
	Data BuscarUmEpisodio(@PathVariable("idDoEpisodio") String idDoEpisodio);
	
	
	
}
