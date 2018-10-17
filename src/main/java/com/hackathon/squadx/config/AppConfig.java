package com.hackathon.squadx.config;

import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackathon.squadx.client.SquadXClient;
import com.hackathon.squadx.services.CustomerTransactionsService;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.ParseContext;
import com.jayway.jsonpath.spi.json.JacksonJsonProvider;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;

import static com.jayway.jsonpath.Option.DEFAULT_PATH_LEAF_TO_NULL;

import org.springframework.context.annotation.Bean;

import javax.ws.rs.client.ClientBuilder;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.rx.RxClient;
import org.glassfish.jersey.client.rx.rxjava.RxObservable;
import org.glassfish.jersey.client.rx.rxjava.RxObservableInvoker;
import org.glassfish.jersey.client.rx.rxjava.RxObservableInvokerProvider;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.springframework.beans.factory.annotation.Autowired;


@Configuration
public class AppConfig {

	
	@Bean
	public CustomerTransactionsService getCustTranService(@Autowired SquadXClient sqClient,
			@Autowired ParseContext parseContext) {
		
		return new CustomerTransactionsService(sqClient, parseContext); 
	}
	
	@Bean
	public ParseContext jsonPath(ObjectMapper mapper) {
		return JsonPath.using(new com.jayway.jsonpath.Configuration.ConfigurationBuilder()
				.jsonProvider(new JacksonJsonProvider(mapper))
				.mappingProvider(new JacksonMappingProvider(mapper))
				.options(DEFAULT_PATH_LEAF_TO_NULL).build());
	}

}
