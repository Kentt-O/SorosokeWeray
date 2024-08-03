package africa.semicolon.soroSokeweray.web;

import africa.semicolon.soroSokeweray.data.models.Post;
import africa.semicolon.soroSokeweray.services.PostServices;
import africa.semicolon.soroSokeweray.services.PostServicesImpl;

public class PostController {
    private PostServices postServices = new PostServicesImpl();

    public String createPost(String title, String content){
        Post newPost = postServices.addPost(title, content);
        return "Post created successfully with ID: " + newPost.getId();
    }

    public Post getPost(int postId){
        return postServices.findPostById(postId);
    }
}
