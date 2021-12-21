package com.example.MyInterests.Category;

import com.example.MyInterests.Post.Post;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String category;

    @JsonIgnoreProperties("category")
    @OneToMany(mappedBy = "category")
    private List<Post> posts;

    public Category(Long id, String category, List<Post> posts) {
        this.id = id;
        this.category = category;
        this.posts = posts;
    }

    public Category() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
