package com.firedev.rest;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;
import static org.mockito.Mockito.when;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import com.firedev.model.Anime;
import com.firedev.model.Attributes;
import com.firedev.model.DataResponse;
import com.firedev.model.Pesquisa;
import com.firedev.model.Especifico.AttributesCompleted;
import com.firedev.model.Especifico.Data;
import com.firedev.model.Especifico.DataObject;
import com.firedev.repository.PesquisaRepository;
import com.firedev.service.AnimeService;

import io.restassured.http.ContentType;

@WebMvcTest
@DisplayName("Testes na camada REST")
public class AnimeRestTest {
	private Anime criaOnepice() {
		Attributes atributos = new Attributes("One Piece");
		Anime testeOnePice = new Anime("12", "anime", atributos);
		return testeOnePice;
	}

	@Autowired
	private AnimeRestService animeRestService;

	@MockBean
	private AnimeService animeService;
	
	@MockBean
	private PesquisaRepository pesquisaRepository;

	@BeforeEach
	public void setup() {
		standaloneSetup(this.animeRestService);
	}

	@Test
	public void deveRetornarSucesso_QuandoBuscarFilmes() {
		Attributes atributos = new Attributes("One Piece");
		Anime anime = new Anime("12", "anime", atributos);
        List listaDeAnimes = new ArrayList();
        listaDeAnimes.add(anime);
        
		DataResponse dataresponse = new DataResponse();
		dataresponse.setData(listaDeAnimes);
		
		
		when(animeService.AnimesMaisPopulares())
			.thenReturn(dataresponse);
		given()
			.accept(ContentType.JSON)
		.when()
			.get("/animesPopulares")
		.then()
			.statusCode(HttpStatus.OK.value());
	}

	@Test
	public void deveRetornarNaoEncontrado_QuandoBuscarAnimesPopulares() {
		Attributes atributos = new Attributes("One Piece");
		Anime anime = new Anime("12", "anime", atributos);
        List listaDeAnimes = new ArrayList();
        listaDeAnimes.add(anime);
        
		DataResponse dataresponse = new DataResponse();
		dataresponse.setData(listaDeAnimes);
		
		
		when(animeService.AnimesMaisPopulares())
			.thenReturn(null);
		given()
			.accept(ContentType.JSON)
		.when()
			.get("/animesPopulares")
		.then()
			.statusCode(HttpStatus.NOT_FOUND.value());
	}

	
	@Test
	public void deveRetornarSucesso_QuandoBuscarMangasPopulares() {
		Attributes atributos = new Attributes("One Piece");
		Anime anime = new Anime("12", "anime", atributos);
        List listaDeAnimes = new ArrayList();
        listaDeAnimes.add(anime);
        
		DataResponse dataresponse = new DataResponse();
		dataresponse.setData(listaDeAnimes);
		
		
		when(animeService.MangasMaisPopulares())
			.thenReturn(dataresponse);
		given()
			.accept(ContentType.JSON)
		.when()
			.get("/mangasPopulares")
		.then()
			.statusCode(HttpStatus.OK.value());
	}
	
	@Test
	public void deveRetornarNaoEncontrado_QuandoBuscarMangasPopulares() {

		when(animeService.MangasMaisPopulares())
			.thenReturn(null);
		given()
			.accept(ContentType.JSON)
		.when()
			.get("/mangasPopulares")
		.then()
			.statusCode(HttpStatus.NOT_FOUND.value());
	}

	@Test
	public void deveRetornarSucesso_QuandoPesquisarPorUmAnime() {
		Attributes atributos = new Attributes("One Piece");
		Anime anime = new Anime("12", "anime", atributos);
        List listaDeAnimes = new ArrayList();
        listaDeAnimes.add(anime);
        
		DataResponse dataresponse = new DataResponse();
		dataresponse.setData(listaDeAnimes);
		
		when(animeService.PesquisaPorTitulo("one piece"))
			.thenReturn(dataresponse);
		given()
			.accept(ContentType.JSON)
		.when()
			.get("/titulo?search=one piece", "one piece")
		.then()
			.statusCode(HttpStatus.OK.value());
	}
	
	@Test
	public void deveRetornarNaoEncontrado_QuandoPesquisarPorUmAnime() {
		
		when(animeService.PesquisaPorTitulo("one piece"))
			.thenReturn(null);
		given()
			.accept(ContentType.JSON)
		.when()
			.get("/titulo?search=one piece", "one piece")
		.then()
			.statusCode(HttpStatus.NOT_FOUND.value());
	}

	@Test
	public void deveRetornarSucesso_QuandoFiltraCategoria() {
		Attributes atributos = new Attributes("One Piece");
		Anime anime = new Anime("12", "anime", atributos);
        List listaDeAnimes = new ArrayList();
        listaDeAnimes.add(anime);
        
		DataResponse dataresponse = new DataResponse();
		dataresponse.setData(listaDeAnimes);
		
		
		when(animeService.FiltrarPorCategoria("adventure"))
			.thenReturn(dataresponse);
		given()
			.accept(ContentType.JSON)
		.when()
			.get("/categoria?filter=adventure", "adventure")
		.then()
			.statusCode(HttpStatus.OK.value());
	}

	@Test
	public void deveRetornarNaoEncontrado_QuandoFiltraCategoria() {
		
		when(animeService.FiltrarPorCategoria("adventure"))
			.thenReturn(null);
		given()
			.accept(ContentType.JSON)
		.when()
			.get("/categoria?filter=adventure", "adventure")
		.then()
			.statusCode(HttpStatus.NOT_FOUND.value());
	}
	
	@Test
	public void deveRetornarSucesso_QuandoSelecionarUmAnime() {
		AttributesCompleted attributesCompleted = new AttributesCompleted("Samurai X", "12", "50.2", "Texto", "episodeCount");
		DataObject dataObject = new DataObject("1", "Samurai X", attributesCompleted);
		Data data = new Data(dataObject);	
		
		when(animeService.BuscarUmAnime("1"))
			.thenReturn(data);
		given()
			.accept(ContentType.JSON)
		.when()
			.get("/anime/{id}", "1")
		.then()
			.statusCode(HttpStatus.OK.value());
	}
	
	@Test
	public void deveRetornarNaoEncontrado_QuandoUmAnimeNaoForEncontrado() {
		
		when(animeService.BuscarUmAnime("1"))
			.thenReturn(null);
		given()
			.accept(ContentType.JSON)
		.when()
			.get("/anime/{id}", "1")
		.then()
			.statusCode(HttpStatus.NOT_FOUND.value());
	}
	
	@Test
	public void deveRetornarSucesso_QuandoSelecionarUmManga() {
		AttributesCompleted attributesCompleted = new AttributesCompleted("Samurai X", "12", "50.2", "Texto", "episodeCount");
		DataObject dataObject = new DataObject("1", "Samurai X", attributesCompleted);
		Data data = new Data(dataObject);	
		
		when(animeService.BuscarUmManga("1"))
			.thenReturn(data);
		given()
			.accept(ContentType.JSON)
		.when()
			.get("/manga/{id}", "1")
		.then()
			.statusCode(HttpStatus.OK.value());
	}
	
	@Test
	public void deveRetornarNaoEncontrado_QuandoUmMangaNaoForEncontrado() {
		
		when(animeService.BuscarUmManga("1"))
			.thenReturn(null);
		given()
			.accept(ContentType.JSON)
		.when()
			.get("/manga/{id}", "1")
		.then()
			.statusCode(HttpStatus.NOT_FOUND.value());
	}
	
	@Test
	public void deveRetornarSucesso_QuandoPesquisarUmEpisodioPorId() {
		AttributesCompleted attributesCompleted = new AttributesCompleted("Samurai X", "12", "50.2", "Texto", "episodeCount");
		DataObject dataObject = new DataObject("1", "Samurai X", attributesCompleted);
		Data data = new Data(dataObject);	
		
		when(animeService.BuscarUmEpisodio("1"))
			.thenReturn(data);
		given()
			.accept(ContentType.JSON)
		.when()
			.get("/episodio/{id}", "1")
		.then()
			.statusCode(HttpStatus.OK.value());
	}
	
	@Test
	public void deveRetornarNaoEncontrado_QuandoPesquisarUmEpisodioPorId() {
		
		when(animeService.BuscarUmEpisodio("1"))
			.thenReturn(null);
		given()
			.accept(ContentType.JSON)
		.when()
			.get("/episodio/{id}", "1")
		.then()
			.statusCode(HttpStatus.NOT_FOUND.value());
	}
	
	
}
