package com.example.spring.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class Entity26Id implements Serializable {
    private String bookType;
    private String bookTitle;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Entity26Id that = (Entity26Id) o;
        return Objects.equals(bookType, that.bookType) && Objects.equals(bookTitle, that.bookTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookType, bookTitle);
    }
}
