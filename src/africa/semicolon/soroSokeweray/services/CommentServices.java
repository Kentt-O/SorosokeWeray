package africa.semicolon.soroSokeweray.services;

import africa.semicolon.soroSokeweray.data.models.Comment;

public interface CommentServices {
    String addComment(String comment);
    Comment getComment(int id);
}
