package com.myblog.myblog9.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String tittle;
    private String description;

    private String content;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)

    private List<Comment> comments;



}
