package eu.arcodz.bookraft.book;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import eu.arcodz.bookraft.book.author.Author;
import eu.arcodz.bookraft.book.copy.Copy;
import eu.arcodz.bookraft.book.publisher.Publisher;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "book")
@Table(name = "book", schema = "public")
public class Book implements Serializable {

    @Id @GeneratedValue @JsonIgnore
    private Long id;

    @Column(unique = true, nullable = false)
    private String title;

    private String description;

    @ManyToOne
    @JoinColumn(name = "publisher_id", nullable = false)
    @JsonIgnoreProperties("books")
    private Publisher publisher;

    @ManyToMany
    @JoinTable(name = "book_author",
            joinColumns = @JoinColumn(name = "book_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    @JsonIgnoreProperties("books")
    private Set<Author> authors;

    @Enumerated(EnumType.STRING)
    private Language lang;

    @OneToMany
    @JoinTable(name = "book_file",
            joinColumns = @JoinColumn(name = "book_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "file_id"))
    @JsonIgnoreProperties("books")
    private Set<Copy> copies;

}

