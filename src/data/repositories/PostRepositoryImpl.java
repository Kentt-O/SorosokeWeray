package data.repositories;

import data.models.Post;

import java.util.ArrayList;
import java.util.List;

public class PostRepositoryImpl implements PostRepository{
    private List<Post> posts = new ArrayList<>();

    @Override
    public Post findById(String id) {
        return getPostWith(id);
    }

    private Post getPostWith(String id) {
        for (Post post : posts){
            if(post.getId().equals(id)){
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
    public void deleteById(String id) {
        deletePostWith(id);
    }

    private void deletePostWith(String id) {
        for (Post post : posts) {
            if (post.getId().equals(id)) {
                posts.remove(post);
                break;
            }
        }
    }
}
