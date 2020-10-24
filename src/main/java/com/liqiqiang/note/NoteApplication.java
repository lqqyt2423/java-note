package com.liqiqiang.note;

import com.google.gson.Gson;
import com.liqiqiang.note.entity.Note;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NoteApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(NoteApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(NoteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		this.logger.info("command begin run");

		Gson gson = new Gson();
		this.logger.info(gson.toJson(1));
		this.logger.info(gson.toJson("hello world"));
		this.logger.info(gson.toJson(null));
		this.logger.info(gson.toJson(new Note("content")));
	}

}
