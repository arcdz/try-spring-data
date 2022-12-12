//package eu.arcodz.bookraft.configs;
//
//import eu.arcodz.bookraft.book.Book;
//import eu.arcodz.bookraft.book.BookRepository;
//import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
//import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//
//@Component
//public class SpringDataRestCustomization implements RepositoryRestConfigurer {
//
//    @Override
//    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
//        config.withEntityLookup()
//                .forRepository(BookRepository.class)
//                .withIdMapping(Book::getTitle)
//                .withLookup(BookRepository::findByTitle);
//    }
//}
//// nu am idee ce face