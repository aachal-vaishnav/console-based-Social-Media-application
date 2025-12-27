package com.example.SocialMedia;

public interface User {
    void setUserName(String username);
    String getUserName();

    void setPostList(PostList postList);
    PostList getPostList();
}
