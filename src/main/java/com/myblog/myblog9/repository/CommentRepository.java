package com.myblog.myblog9.repository;

import com.myblog.myblog9.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
