package com.firedev.services;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.firedev.model.DataResponse;
import com.firedev.service.AnimeService;
import com.firedev.model.Anime;
import com.firedev.model.Attributes;

@SpringBootTest
public class AnimeServiceTest {

	@Autowired
	private AnimeService animeService;
	/**
	 * Cria o objeto que representa o anime OnePice. Ele é o anime top1 dos mais populares
	 * @return anime One Piece.
	 */
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
	/**
	 * Testa a rota de animes populares
	 * 1.1- Verifica se o objeto Data resposta não é null
	 * 1.2- Verifica se a lista de animes está vazia
	 * 1.3- Verifica se o primeiro anime é o One piece(One piece = Anime top1 popular)
	 * 1.4- Verifica se o atributo type é anime. (É esse atributo que difere os animes dos mangas.)
	 */
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
	
	
	
}
