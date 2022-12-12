package eu.arcodz.bookraft.book.publisher;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import eu.arcodz.bookraft.book.Book;
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
@Entity(name = "publisher")
@Table(name = "publisher", schema = "public")
public class Publisher implements Serializable {

    @Id @GeneratedValue @JsonIgnore
    private Long id;

    private String name;
    private String ref;
    private String logo;

    @OneToMany(mappedBy = "publisher")
    @JsonIgnoreProperties("publisher")
    private Set<Book> books;

}
