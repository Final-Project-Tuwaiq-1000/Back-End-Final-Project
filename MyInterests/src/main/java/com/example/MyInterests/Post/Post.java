package com.example.MyInterests.Post;

import com.example.MyInterests.Comment.Comment;
import com.example.MyInterests.User.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String caption;
    private String image;


    @ManyToOne
    @Nullable
    @JoinColumn(name = "user_id")
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private User user;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments;


    public Post(Long id, String caption, String image, User user, List<Comment> comments) {
        this.id = id;
        this.caption = caption;
        this.image = image;
        this.user = user;
        this.comments = comments;
    }

    public Post() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Comment> getComments() {
        return comments;
    }
}
