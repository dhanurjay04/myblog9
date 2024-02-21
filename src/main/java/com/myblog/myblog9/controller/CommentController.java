package com.myblog.myblog9.controller;

import com.myblog.myblog9.Service.CommentService;
import com.myblog.myblog9.payload.CommentDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")

   public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    //http://localhost:8080/api/comments?postId=1
    @PostMapping
    public ResponseEntity<CommentDto>createComment(
            @RequestBody CommentDto commentDto,
            @RequestParam long postId){


        CommentDto dto = commentService.createComment(commentDto, postId);


        return new ResponseEntity<>(dto, HttpStatus.CREATED);

    }
    @DeleteMapping("/{id}")
public ResponseEntity<String> deleteComments(@PathVariable long id){

        commentService.deleteComments(id);

return  new ResponseEntity<>("Record is deleted",HttpStatus.OK);
}
public ResponseEntity<CommentDto> updateComment(@PathVariable long id,@PathVariable long postId, @RequestBody CommentDto commentDto){

    CommentDto dto= commentService.updateComment(id,postId);


}
}
