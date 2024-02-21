package com.myblog.myblog9.entity;

import com.myblog.myblog9.entity.Post;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "comments")
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    private String email;


    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;


}
