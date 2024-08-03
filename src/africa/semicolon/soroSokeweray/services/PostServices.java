package africa.semicolon.soroSokeweray.services;

import africa.semicolon.soroSokeweray.data.models.Post;

public interface PostServices {
    Post addPost(String title, String content) throws IllegalAccessException;
    Post findPostById(int id);
}
