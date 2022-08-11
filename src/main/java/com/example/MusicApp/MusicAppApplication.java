package com.example.MusicApp;

import com.example.MusicApp.models.Artist;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Properties;


@EnableTransactionManagement
@SpringBootApplication(scanBasePackages = "com.example.MusicApp")
@PropertySource(value = "classpath:application.properties")
@EntityScan("com.example.MusicApp")
public class MusicAppApplication {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) throws IOException {
		SpringApplication.run(MusicAppApplication.class, args);

//		Artist artist = new Artist();
//		artist.setId(1);
//		artist.setName("Beatles");
//		artist.setPicture("picture");
//
//		//create object mapper class object
//		ObjectMapper mapper = new ObjectMapper();
//		//to print string in json format
//		mapper.enable(SerializationFeature.INDENT_OUTPUT);
//		//convert object into string
//		String artJson = mapper.writeValueAsString(artist);
//		//print json string
//		System.out.println(artJson);
//
//		//convert json string into artist object
//		Artist art = mapper.readValue(artJson.getBytes(), Artist.class);
//		//print values from art object
//		System.out.println(art.getId());
//		System.out.println(art.getName());
//		System.out.println(art.getPicture());


	}
}
