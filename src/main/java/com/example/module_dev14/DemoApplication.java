package com.example.module_dev14;

import com.example.module_dev14.crud.NoteRepository;
import com.example.module_dev14.crud.NoteService;
import com.example.module_dev14.entity.Note;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

@Configuration
@ComponentScan(basePackages = {"com.example.module_dev14"})
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		Note newNote1 = new Note("title1","Content1");
		Note newNote2 = new Note("title2","Content2");
		Note newNoteUpdate = new Note("title3","Content3");
		newNoteUpdate.setId(1);

		NoteService noteService = new NoteService(new NoteRepository());
		noteService.add(newNote1);
		noteService.add(newNote2);

		System.out.println(noteService.getById(1));

		System.out.println(noteService.listAll());
		noteService.update(newNoteUpdate);
		System.out.println(noteService.listAll());

		noteService.deleteById(1);
		System.out.println(noteService.listAll());
	}

}
