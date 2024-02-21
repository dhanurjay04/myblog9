package com.myblog.myblog9.Service;


import com.myblog.myblog9.entity.Post;
import com.myblog.myblog9.exception.ResourceNotFoundException;
import com.myblog.myblog9.payload.PostDto;
import com.myblog.myblog9.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;


    @Override
    public PostDto createPost(PostDto postDto) {

        Post post = new Post();
        post.setId(postDto.getId());
        post.setTittle(postDto.getTittle());
        post.setContent(postDto.getContent());
        post.setDescription(postDto.getDescription());
        Post savedPost = postRepository.save(post);


        PostDto dto= new PostDto();
        dto.setId(savedPost.getId());
        dto.setTittle(savedPost.getTittle());
        dto.setContent(savedPost.getContent());
        dto.setDescription(savedPost.getDescription());


        return dto;
    }

    @Override
    public PostDto getPostById(long id) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Post Found with id" + id)

        );
       PostDto dto= new PostDto();
       dto.setId(post.getId());
       dto.setTittle(post.getTittle());
       dto.setDescription(post.getDescription());
       dto.setContent(post.getContent());

       return dto;


    }



    @Override
    public List<PostDto> getAllPost() {

        List<Post> allList = postRepository.findAll();
        List<PostDto> collect = allList.stream().map(p -> mapToDto(p)).collect(Collectors.toList());
        return collect;
    }
    PostDto mapToDto(Post post){


        PostDto dto = new PostDto();
        dto.setTittle(post.getTittle());
        dto.setContent(post.getContent());
        dto.setDescription(post.getDescription());

        return  dto;

    }
    Post mapToEntity(PostDto postDto){

        Post post = new Post();
        post.setId(postDto.getId());
        post.setTittle(postDto.getTittle());
        post.setContent(postDto.getContent());
        post.setDescription(postDto.getDescription());

        return  post;
    }

}
