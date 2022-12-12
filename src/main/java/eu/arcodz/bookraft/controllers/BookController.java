package eu.arcodz.bookraft.controllers;

import eu.arcodz.bookraft.book.Book;
import eu.arcodz.bookraft.book.BookRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RepositoryRestController
public class BookController {

    private final BookRepository repository;

    public BookController(BookRepository repository) {
        this.repository = repository;
    }

    @GetMapping("books/search/recommendations")
    public @ResponseBody ResponseEntity<?> getBooks(){
        List<Book> producers = repository.findByTitleIsLike("x");
        // do some intermediate processing, logging, etc. with the producers

        CollectionModel<Book> resources = CollectionModel.of(producers); // for single :EntityModel<T> or RepresentationModel<T>
        resources.add(linkTo(methodOn(BookController.class).getBooks()).withSelfRel());
        // add other links as needed
        return ResponseEntity.ok(resources);
    }
}
