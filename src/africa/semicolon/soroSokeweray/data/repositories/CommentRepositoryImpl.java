package africa.semicolon.soroSokeweray.data.repositories;

import africa.semicolon.soroSokeweray.data.models.Comment;

import java.util.ArrayList;
import java.util.List;

public class CommentRepositoryImpl implements CommentRepository {
    private List<Comment> comments = new ArrayList<>();
    private static int commentCounter = 0;

    @Override
    public Comment findByPostId(int id) {
        return null;
    }


    @Override
    public Comment findByCommentId(int commentId) {
        for (Comment comment : comments) {
            if (comment.getId() == commentId) {
                return comment;
            }
        }
        return null;
    }

    private static int generateCommentId() {
        ++commentCounter;
        return commentCounter;
    }

    @Override
    public List<Comment> findAll() {
        return List.of();
    }

    @Override
    public String content(String content) {
        return "";
    }

    @Override
    public void deleteByCommentId() {

    }

    @Override
    public Comment save(Comment comment) {
        comment.setId(generateCommentId());
        comments.add(comment);
        return comment;
    }

    @Override
    public void deleteByPostId(int id) {

    }

    @Override
    public long count() {
        return comments.size();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

}
