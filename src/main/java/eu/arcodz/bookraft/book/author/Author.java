package eu.arcodz.bookraft.book.author;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import eu.arcodz.bookraft.book.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "author")
@Table(name = "author", schema = "public")
public class Author implements Serializable {

    @Id @Column
    @GeneratedValue
    @JsonIgnore
    private Long id;

    private String firstname;
    private String lastname;

    @ManyToMany(mappedBy = "authors")
    @JsonIgnoreProperties("authors")
    private Set<Book> books = new HashSet<>();

//    public void addBook(Book book){
//        this.books.add(book);
//        book.getAuthors().add(this);
//    }
//
//    public void removeBook(Book book) {
//        this.books.remove(book);
//        book.getAuthors().remove(this);
//    }
}
