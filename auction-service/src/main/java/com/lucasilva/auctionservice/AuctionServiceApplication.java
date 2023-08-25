package com.lucasilva.auctionservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static java.util.stream.Collectors.joining;

@SpringBootApplication
public class AuctionServiceApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(AuctionServiceApplication.class);

	private final JdbcTemplate jdbcTemplate;

	public AuctionServiceApplication(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public static void main(String[] args) {
		SpringApplication.run(AuctionServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var sql = "select * from product";
		boolean doesNotHaveData = jdbcTemplate.queryForList(sql).isEmpty();
		log.info("[DATABASE] [BATCH-INSERT] database is empty? {}", doesNotHaveData);
		if(doesNotHaveData) {
			var inputStream = getDataFile();
			batchInsert(inputStream);
		}
	}

	private void batchInsert(InputStream is) throws IOException {
		var br = new BufferedReader(new InputStreamReader(is));
		var inserts = br.lines().collect(joining());
		log.info("[DATABASE] [BATCH-INSERT] inserting records...");
		jdbcTemplate.batchUpdate(inserts);
		log.info("[DATABASE] [BATCH-INSERT] inserted records!");
		is.close();
	}

	private InputStream getDataFile() {
		return this.getClass().getClassLoader().getResourceAsStream("data.sql");
	}

}
