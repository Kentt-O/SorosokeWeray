package africa.semicolon.soroSokeweray.data.repositories;

import africa.semicolon.soroSokeweray.data.models.Comment;

import java.util.List;

public interface CommentRepository {
    Comment findByPostId(int id);
    Comment findByCommentId(int commentId);
    List<Comment> findAll();
    String content(String content);
    void deleteByCommentId();
    Comment save(Comment comment);
    void deleteByPostId(int id);
    long count ();
    boolean isEmpty();
}
