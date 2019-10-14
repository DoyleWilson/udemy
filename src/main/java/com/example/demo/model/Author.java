package com.example.demo.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor()
@ToString
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String authorFName;
    private String authorSName;
    @ManyToMany(mappedBy = "authors")
    private Set<Book> authorBooks = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(id, author.id) &&
                Objects.equals(authorFName, author.authorFName) &&
                Objects.equals(authorSName, author.authorSName) &&
                Objects.equals(authorBooks, author.authorBooks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, authorFName, authorSName, authorBooks);
    }
}
