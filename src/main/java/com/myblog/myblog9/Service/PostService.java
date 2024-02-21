package com.myblog.myblog9.Service;

import com.myblog.myblog9.payload.PostDto;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto postDto);

    PostDto getPostById(long id);

    List<PostDto> getAllPost();
}
