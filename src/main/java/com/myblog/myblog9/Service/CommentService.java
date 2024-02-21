package com.myblog.myblog9.Service;

import com.myblog.myblog9.payload.CommentDto;

public interface CommentService {

    CommentDto createComment(CommentDto commentDto, long postId);


    void deleteComments(long id);


    CommentDto updateComment(long id, long postId);
}
