package com.example.betterreads;

import com.example.betterreads.Connection.DataStaxAstraProperties;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.fasterxml.jackson.databind.util.JSONWrappedObject;
import org.HdrHistogram.LinearIterator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cassandra.CqlSessionBuilderCustomizer;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, JdbcTemplateAutoConfiguration.class})
@EnableConfigurationProperties(DataStaxAstraProperties.class)
@EnableCassandraRepositories(basePackages = "com.example.betterreads.author")
public class BetterReadsDataLoaderApplication {

	//@Autowired
	//AuthorRepository authorRepository;

	@Value("${datadump.location.author}")
	private String authorDumpLocation;

	@Value("${datadump.location.works}")
	private String worksDumpLocation;

	private void initAuthors(){
		Path path= Paths.get(authorDumpLocation);
		try(var lines= Files.lines(path)){
			lines.forEach(line->{
				//Read and parse the line
				String jsonString=line.substring(line.indexOf("{"));
				//JSONWrappedObject jsonoObject=new JSONPObject(jsonString)
				JsonNode node =
						JSONPObject 
				//construct Author object
				//persist using Repository
			});

		}
		catch (IOException e){
			e.printStackTrace();
		}


	}
	private void initWorks(){

	}



	public static void main(String[] args) {
		SpringApplication.run(BetterReadsDataLoaderApplication.class, args);
	}

/*	@PostConstruct
	public void start(){
		System.out.println("Application started");
		Author author=new Author();
		author.setId("Id");
		author.setName("Name");
		author.setPersonalName("PersonalName");
		authorRepository.save(author);

	}*/

	@Bean
	public CqlSessionBuilderCustomizer sessionBuilderCustomizer(DataStaxAstraProperties astraProperties) {
		Path bundle = astraProperties.getSecureConnectBundle().toPath();
		System.out.println("Secure Connect Bundle: " + bundle);
		return builder -> builder
				.withCloudSecureConnectBundle(bundle)
				.withAuthCredentials("token", "AstraCS:FKJxhllNLGGRFKGslbBorRhE:b23f78da1313f92068a7d0fc7dfd9da66b79431ad3e411603365f20728ec6e09")
				.withKeyspace("goodreadsdataloader");
	}

}
