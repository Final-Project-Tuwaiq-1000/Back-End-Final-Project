package com.example.MyInterests.Comment;

import com.example.MyInterests.Post.Post;
import com.example.MyInterests.Post.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PostRepository postRepository;

    public List<Comment> getComments(){
        return commentRepository.findAll();
    }

    public ResponseEntity<String> addComment(Comment comment){
        Long post_id = comment.getPost().getId();
        Post post = postRepository.getById(post_id);
        if (post !=null){
            comment.setPost(post);
            commentRepository.save(comment);
            return ResponseEntity.ok().body("Saved Successfully");
        }
        else {
            return ResponseEntity.badRequest().body("Not Saved");
        }
    }
}
