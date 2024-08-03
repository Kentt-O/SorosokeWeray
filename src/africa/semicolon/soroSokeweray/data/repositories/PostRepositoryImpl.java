package africa.semicolon.soroSokeweray.data.repositories;

import africa.semicolon.soroSokeweray.data.models.Post;

import java.util.ArrayList;
import java.util.List;

public class PostRepositoryImpl implements PostRepository{
    private List<Post> posts = new ArrayList<>();

    @Override
    public Post findById(int id) {
        return getPostWith(id);
    }

    private Post getPostWith(int id) {
        for (Post post : posts){
            if(post.getId() ==id){
                return post;
            }
        }
        return null;
    }

    @Override
    public List<Post> findAll() {
        return posts;
    }

    @Override
    public long count() {
        return posts.size();
    }

    @Override
    public void deleteAll() {
        posts.clear();
    }

    @Override
    public Post save(Post post) {
       posts.add(post);
       return post;
    }

    @Override
    public void deleteById(int id) {
        deletePostWith(id);
    }


    private void deletePostWith(int id) {
        for (Post post : posts) {
            if (post.getId() == id) {
                posts.remove(post);
                break;
            }
        }
    }
}
