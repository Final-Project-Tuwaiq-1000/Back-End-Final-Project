package com.example.MyInterests.Post;

import com.example.MyInterests.User.User;
import com.example.MyInterests.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Post> getPosts(){
        return postRepository.findAll();
    }

    public ResponseEntity<String> createPost(Post post){
        Long user_id = post.getUser().getId();
        User user = userRepository.getById(user_id);
        System.out.println(userRepository.getById(user_id).getEmail());

        if (user !=null){
            post.setUser(user);
            postRepository.save(post);
            return ResponseEntity.ok().body("Saved Successfully");
        }
        else {
            return ResponseEntity.badRequest().body("Not Saved");
        }
    }
    public Post getPost(String id){
        Long post_id = Long.parseLong(id);
        return postRepository.findById(post_id).orElse(null);
    }

    public void deletePost(String id){
        Long post_id = Long.parseLong(id);
        postRepository.deleteById(post_id);
    }
}
