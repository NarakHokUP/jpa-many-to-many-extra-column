package com.example.jpamanytomany;

import com.example.jpamanytomany.model.Book;
import com.example.jpamanytomany.model.BookPublisher;
import com.example.jpamanytomany.model.Publisher;
import com.example.jpamanytomany.repository.BookRepository;
import com.example.jpamanytomany.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.transaction.Transactional;
import java.util.Date;

@EnableJpaRepositories("com.example.jpamanytomany.repository")
@SpringBootApplication
public class JpaManyToManyApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(JpaManyToManyApplication.class, args);
	}

	@Autowired
	BookRepository bookRepository;

	@Autowired
	PublisherRepository publisherRepository;

	@Transactional
	@Override
	public void run(String... strings) throws Exception {

		Book b =  new Book("B1");
		Book b2 = new Book("B2");
		Publisher p = new Publisher("P1");
		Publisher p2 = new Publisher("P2");

		//bookRepository.save(b);
		//bookRepository.save(b2);

		publisherRepository.save(p);
		publisherRepository.save(p2);

		BookPublisher bp = new BookPublisher(new Date());
		bp.setBook(b);
		bp.setPublisher(p);
		b.getBookPublishers().add(bp); //or p.getBookPublishers().add(bp);
		bookRepository.save(b);

		BookPublisher bp1 = new BookPublisher(new Date());
		bp1.setBook(b2);
		bp1.setPublisher(p2);
		b2.getBookPublishers().add(bp1);
		bookRepository.save(b2);

		BookPublisher bp2 = new BookPublisher(new Date());
		bp2.setBook(b);
		bp2.setPublisher(p2);
		b.getBookPublishers().add(bp2);
		bookRepository.save(b);
	}
}
