package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
public class Note {
    private @Id @GeneratedValue long id;
    private String title;
    private String content;

    Note() {}

    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
