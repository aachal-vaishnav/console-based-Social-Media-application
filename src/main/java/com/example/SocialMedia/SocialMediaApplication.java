package com.example.SocialMedia;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

//@SpringBootApplication
public class SocialMediaApplication {

    public static void main(String[] args) {
        //SpringApplication.run(SocialMediaApplication.class, args);
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Your username");
        String username = input.next();

        User user = (User) context.getBean("user");
        user.setUserName(username);

        PostList postlist = (PostList) context.getBean("postList");

        while (true) {
            System.out.println("""
                    choose from below:
                    1.Create a Post
                    2.See All Your post
                    """);
            int userSelect = input.nextInt();
            switch (userSelect) {
                case 1: {
                    Post post = (Post) context.getBean("post");
                    input.nextLine();// buffer cleaner
                    System.out.println("Enter Caption");
                    String message = input.nextLine();
                    post.setMessage(message);
                    postlist.setPost(post);
                    user.setPostList(postlist);
                    break;
                }
                case 2: {
                    postlist.getAllPost().forEach(item -> System.out.println(item.getMessage()));
                    break;
                }
            }
        }

    }
}