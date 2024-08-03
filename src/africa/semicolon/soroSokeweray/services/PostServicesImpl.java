package africa.semicolon.soroSokeweray.services;

import africa.semicolon.soroSokeweray.data.models.Post;
import africa.semicolon.soroSokeweray.data.repositories.PostRepository;
import africa.semicolon.soroSokeweray.data.repositories.PostRepositoryImpl;

public class PostServicesImpl implements PostServices {
    private PostRepository postRepository = new PostRepositoryImpl();

    @Override
    public Post addPost(String title, String content) throws IllegalAccessException {
        Post newPost = new Post();
        if(titleExistsFor(title)){throw new IllegalAccessException("Title already exists.");}
        newPost.setTitle(title);
        newPost.setContent(content);
        postRepository.save(newPost);
        return newPost;
    }

    @Override
    public Post findPostById(int id) {
        Post newPost = new Post();
        newPost.getId();
        return postRepository.findById(newPost.getId());
    }

    public boolean titleExistsFor(String title){
        for(Post post : postRepository.findAll()){
            return post.getTitle().equalsIgnoreCase(title);
        }
        return false;
    }

}
