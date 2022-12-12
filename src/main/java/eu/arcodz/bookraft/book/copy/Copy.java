package eu.arcodz.bookraft.book.copy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "copy")
@Table(name = "copy", schema = "public")
public class Copy implements Serializable {

    @Id @JsonIgnore @GeneratedValue
    private Long id;

    private String path;

    @Column
    @Enumerated(EnumType.STRING)
    private Formats type;


}
