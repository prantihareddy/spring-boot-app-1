package com.example.betterreads;

import com.example.betterreads.author.Author;
import com.example.betterreads.author.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.stereotype.Service;

@Service
public class DataLoaderService implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    //private final CassandraTemplate cassandraTemplate;

    @Autowired
    public DataLoaderService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
        //this.cassandraTemplate = cassandraTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        try {
            System.out.println("Application started");
            //System.out.println("CassandraTemplate: " + cassandraTemplate);
            //System.out.println("CqlSession: " + cassandraTemplate.getCqlOperations().getSession());
            // Test keyspace connectivity
            //boolean keyspaceExists = cassandraTemplate.getCqlOperations().execute("SELECT keyspace_name FROM system_schema.keyspaces WHERE keyspace_name = 'goodreadsdataloader'");
            //System.out.println("Keyspace check result: " + keyspaceExists);
            // Check if table exists
            //boolean tableExists = cassandraTemplate.getCqlOperations().execute("SELECT table_name FROM system_schema.tables WHERE keyspace_name = 'goodreadsdataloader' AND table_name = 'author_by_id'");
            //System.out.println("Table exists check: " + tableExists);
            // Create table if not exists
            /*String createTableCql = "CREATE TABLE IF NOT EXISTS goodreadsdataloader.author_by_id (" +
                    "author_id text PRIMARY KEY, " +
                    "author_name text, " +
                    "personal_name text)";*/
            //boolean created = cassandraTemplate.getCqlOperations().execute(createTableCql);
            //System.out.println("Table creation attempted, result: " + created);
            Author author = new Author();
            author.setId("13id");
            author.setName("Name2");
            author.setPersonalName("PersonalName2");
            authorRepository.save(author);
            System.out.println("Author saved successfully");
        } catch (Exception e) {
            System.err.println("Error in CommandLineRunner: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }
}
