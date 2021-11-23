package com.firedev.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.firedev.model.DataResponse;
import com.firedev.model.Especifico.Data;
import com.firedev.service.AnimeService;
import com.firedev.model.Anime;
import com.firedev.model.Attributes;

@DisplayName("Testes na camada Service")
@SpringBootTest
public class AnimeServiceTest {

	@Autowired
	private AnimeService animeService;

	private Anime criaOnepice() {
		Attributes atributos = new Attributes("One Piece");
		Anime testeOnePice = new Anime("12", "anime", atributos);
		return testeOnePice;
	}
	
	private Anime criaManga() {
		Attributes atributos = new Attributes("Solo Leveling");
		Anime Leveling = new Anime("54114", "manga", atributos);
		return Leveling;
	}

	
	@Test
	@DisplayName("Data API \"Animes mais populares\" quando for sucesso")
	public void testaAnimeServices() {
		DataResponse dataResponse = animeService.AnimesMaisPopulares();

		Assertions.assertThat(dataResponse.getData()).isNotNull();
	
		List<Anime> ListAnimes = dataResponse.getData();
		Assertions.assertThat(ListAnimes).isNotEmpty();
		
		Anime animeTeste = criaOnepice();
		Assertions.assertThat(ListAnimes.get(0).getId()).contains(animeTeste.getId());
		
		Assertions.assertThat(ListAnimes.get(0).getType()).contains(animeTeste.getType());
	
	}
	

	@Test
	@DisplayName("Data API \"Mangas mais populares\" quando for sucesso")
	public void testMangasWhenSuccesful() {
		DataResponse dataResponse = animeService.MangasMaisPopulares();

		Assertions.assertThat(dataResponse.getData()).isNotNull();
		
		List<Anime> ListaMangas = dataResponse.getData();
		Assertions.assertThat(ListaMangas).isNotEmpty();
		
		Anime mangaTeste = criaManga();
		Assertions.assertThat(ListaMangas.get(0).getId()).contains(mangaTeste.getId());
		
		Assertions.assertThat(ListaMangas.get(0).getType()).contains(mangaTeste.getType());
	}
	
	@Test
	@DisplayName("Data API animes buscando por nome")
	public void testaFiltroPorNome() {
		DataResponse dataResponse = animeService.PesquisaPorTitulo("one piece");
		
		Assertions.assertThat(dataResponse.getData()).isNotNull();
		
		List<Anime> ListAnimes = dataResponse.getData();
		Assertions.assertThat(ListAnimes).isNotEmpty();
		
		Anime animeTeste = criaOnepice();
		Assertions.assertThat(ListAnimes.get(0).getId()).contains(animeTeste.getId());
		
		Assertions.assertThat(ListAnimes.get(0).getType()).contains(animeTeste.getType());
	}
	
	@Test
	@DisplayName("Data API animes buscando por categoria")
	public void testaFiltroPorCategoria() {
		DataResponse dataResponse = animeService.FiltrarPorCategoria("adventure");

		Assertions.assertThat(dataResponse.getData()).isNotNull();
		
		List<Anime> ListAnimes = dataResponse.getData();
		Assertions.assertThat(ListAnimes).isNotEmpty();
		
		Attributes atributos = new Attributes("The King of Fighters: Destiny 2");
		Anime AnimeKingOfFighters = new Anime("40591", "anime", atributos);
		
		Assertions.assertThat(ListAnimes.get(0).getAttributes().getCanonicalTitle()).contains(AnimeKingOfFighters.getAttributes().getCanonicalTitle());
	}
	
	@Test
	@DisplayName("Data API anime buscando por Id")
	public void testaAnimePorId() {
		Data data = animeService.BuscarUmAnime("40591");

		Assertions.assertThat(data.getData()).isNotNull();
		
		Attributes atributos = new Attributes("The King of Fighters: Destiny 2");
		Anime AnimeKingOfFighters = new Anime("40591", "anime", atributos);
		
		assertEquals(data.getData().getAttributes().getCanonicalTitle(), AnimeKingOfFighters.getAttributes().getCanonicalTitle());
	}
	
	@Test
	@DisplayName("Data API manga buscando por Id")
	public void testaMangaPorId() {
		Data data = animeService.BuscarUmManga("15");

		Assertions.assertThat(data.getData()).isNotNull();
		
		Attributes atributos = new Attributes("Double-J");
		Anime doubleJ = new Anime("15", "manga", atributos);
		
		assertEquals(data.getData().getAttributes().getCanonicalTitle(), doubleJ.getAttributes().getCanonicalTitle());
	}
	

	@Test
	@DisplayName("Data API episodio buscando por Id")
	public void episodioPorId() {
		Data data = animeService.BuscarUmEpisodio("674");

		Assertions.assertThat(data.getData()).isNotNull();
		
		Attributes atributos = new Attributes("The Seigaku Regulars Make Their Debut!");
		Anime Seigaku = new Anime("674", "episodes", atributos);
		
		assertEquals(data.getData().getAttributes().getCanonicalTitle(), Seigaku.getAttributes().getCanonicalTitle());
	}
}
