package com.example.SocialMedia;

public class SimpleUser implements User {

    String userName;
    PostList postList;

    @Override
    public void setUserName(String username) {
        this.userName = username;
    }

    @Override
    public String getUserName() {
        return this.userName;
    }

    @Override
    public void setPostList(PostList postList) {
        this.postList = postList;
    }

    @Override
    public PostList getPostList() {
        return this.postList;
    }
}
