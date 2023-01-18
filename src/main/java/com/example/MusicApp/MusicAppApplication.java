package com.example.MusicApp;

import com.example.MusicApp.models.User;
import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;
import java.io.IOException;

@MappedTypes({User.class})
@MapperScan("com.example.MusicApp.mapper")
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


	}
}
