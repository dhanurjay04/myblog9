package com.myblog.myblog9.Service.impl;

import com.myblog.myblog9.Service.CommentService;
import com.myblog.myblog9.entity.Comment;
import com.myblog.myblog9.entity.Post;
import com.myblog.myblog9.exception.ResourceNotFoundException;
import com.myblog.myblog9.payload.CommentDto;
import com.myblog.myblog9.repository.CommentRepository;
import com.myblog.myblog9.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    private ModelMapper modelMapper;
private PostRepository postRepository;
private CommentRepository commentRepository;

    public CommentServiceImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public CommentServiceImpl(PostRepository postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }


    @Override
    public CommentDto createComment(CommentDto commentDto, long postId) {

        Post post = postRepository.findById(postId).orElseThrow(

                () -> new ResourceNotFoundException("post is not Found with "+postId)
        );

        Comment comment = new Comment();
        comment.setId(commentDto.getId());
        comment.setEmail(commentDto.getEmail());
        comment.setPost(post);
        comment.setText(commentDto.getText());

        Comment savedComment = commentRepository.save(comment);

        CommentDto dto = new CommentDto();
        dto.setId(savedComment.getId());
        dto.setEmail(savedComment.getEmail());

        dto.setText(savedComment.getText());

        return dto;
    }

    @Override
    public void deleteComments(long id) {

        commentRepository.deleteById(id);
    }

    @Override
    public CommentDto updateComment(long id, long postId) {
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new ResourceNotFoundException("post id not found with" + postId)
        );
        Comment comment = commentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("post id found with" + id)
        );





        return null;
    }
}
