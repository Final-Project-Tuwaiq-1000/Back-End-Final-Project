package com.example.MyInterests.User;


import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Column(unique = true)
    private String userName ;
    private String password ;
    @Column(unique = true)
    private String email ;
    private String moreInfo ;
    private String personalImg;

    public User(Long id, String userName, String password, String email, String moreInfo, String personalImg) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.moreInfo = moreInfo;
        this.personalImg = personalImg;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMoreInfo() {
        return moreInfo;
    }

    public void setMoreInfo(String moreInfo) {
        this.moreInfo = moreInfo;
    }

    public String getPersonalImg() {
        return personalImg;
    }

    public void setPersonalImg(String personalImg) {
        this.personalImg = personalImg;
    }
}
