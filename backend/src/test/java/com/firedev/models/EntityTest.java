package com.firedev.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import com.firedev.model.Anime;
import com.firedev.model.Attributes;
import com.firedev.model.DataResponse;
import com.firedev.model.Especifico.AttributesCompleted;
import com.firedev.model.Especifico.Data;
import com.firedev.model.Especifico.DataObject;


public class EntityTest {
	
	@Test
	@DisplayName("Testa entidade Anime")
    public void AnimeTest() {
		
		Attributes atributos = new Attributes("naruto");
        Anime anime = new Anime("3", "anime", atributos);
        assertEquals("naruto", anime.getAttributes().getCanonicalTitle());

    }
	
	@Test
	@DisplayName("Testa entidade Atributos")
    public void AtributosTest() {
		
		Attributes atributos = new Attributes("Samurai X");
        assertEquals("Samurai X", atributos.getCanonicalTitle());

    }
	
	@Test
	@DisplayName("Testa entidade DataResponse")
    public void DataResponseTest() {
		Attributes atributos = new Attributes("naruto");
        Anime anime = new Anime("3", "anime", atributos);
        List listaDeAnimes = new ArrayList();
        listaDeAnimes.add(anime);
        
		DataResponse dataresponse = new DataResponse();
		dataresponse.setData(listaDeAnimes);
		
        assertEquals(listaDeAnimes, dataresponse.getData());
    }
	
	@Test
	@DisplayName("Testa entidade AttributesCompleted")
    public void AttributesCompletedTest() {
		AttributesCompleted attributesCompleted = new AttributesCompleted("Samurai X", "12", "50.2", "Texto", "episodeCount");

		
        assertEquals("Samurai X", attributesCompleted.getCanonicalTitle());
    }
	
	@Test
	@DisplayName("Testa entidade data")
    public void DataTest() {
		AttributesCompleted attributesCompleted = new AttributesCompleted("Samurai X", "12", "50.2", "Texto", "episodeCount");
		DataObject dataObject = new DataObject("1", "Samurai X", attributesCompleted);
		Data data = new Data(dataObject);
		
        assertEquals("Samurai X", data.getData().getAttributes().getCanonicalTitle());
    }
	
	@Test
	@DisplayName("Testa entidade dataObject")
    public void DataObjectTest() {
		AttributesCompleted attributesCompleted = new AttributesCompleted("Samurai X", "12", "50.2", "Texto", "episodeCount");
		DataObject dataObject = new DataObject("1", "Samurai X", attributesCompleted);

		
        assertEquals("Samurai X", dataObject.getAttributes().getCanonicalTitle());
    }
	
}
