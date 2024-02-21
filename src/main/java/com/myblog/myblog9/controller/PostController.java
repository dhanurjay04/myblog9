package com.myblog.myblog9.controller;



import com.myblog.myblog9.Service.PostService;
import com.myblog.myblog9.payload.PostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
        PostDto dto = postService.createPost(postDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);

    }
    //http://localhost:8080/api/post/particular?id=2
    @GetMapping("/particular")
public  ResponseEntity<PostDto> getPostById(@RequestParam long id){

    PostDto dto= postService.getPostById(id);

    return new ResponseEntity<>(dto,HttpStatus.OK);
}

//http://localhpost:8080/api/post?pageNo=0&pageSize=3&sortBy=tittle
@GetMapping
public List <PostDto> getAllPost(){


    List<PostDto>  Alllist= postService.getAllPost();

    return  Alllist;
}
}
