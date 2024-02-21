package com.myblog.myblog9.repository;

import com.myblog.myblog9.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository  extends JpaRepository<Post,Long> {


}
