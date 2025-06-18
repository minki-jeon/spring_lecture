package com.example.spring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class Entity25Id implements Serializable {
    private static final long serialVersionUID = 5922950269025689987L;
    @Column(name = "name", nullable = false, length = 30)
    private String name;

    @Column(name = "class_name", nullable = false, length = 10)
    private String className;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Entity25Id entity = (Entity25Id) o;
        return Objects.equals(this.name, entity.name) &&
                Objects.equals(this.className, entity.className);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, className);
    }

}