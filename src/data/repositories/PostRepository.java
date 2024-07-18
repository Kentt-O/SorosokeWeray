package data.repositories;

import data.models.Post;

import java.util.List;

public interface PostRepository {
    Post findById(String id);
    List<Post> findAll();
    long count();
    void deleteAll();
    Post save(Post post);
    void deleteById(String id);


}
