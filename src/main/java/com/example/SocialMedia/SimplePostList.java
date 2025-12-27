package com.example.SocialMedia;

import java.util.ArrayList;
import java.util.List;

public class SimplePostList implements PostList{
    List<Post> listOfPost = null;

    public SimplePostList() {
        this.listOfPost = new ArrayList<>();
    }

    public SimplePostList(List<Post> listOfPost) {
        this.listOfPost = new ArrayList<Post>();
    }

    @Override
    public void setPost(Post post) {
        listOfPost.add(post);
    }

    @Override
    public List<Post> getAllPost() {
        return this.listOfPost;
    }
}
