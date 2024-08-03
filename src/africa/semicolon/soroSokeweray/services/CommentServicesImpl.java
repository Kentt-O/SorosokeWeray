package africa.semicolon.soroSokeweray.services;

import africa.semicolon.soroSokeweray.data.models.Comment;
import africa.semicolon.soroSokeweray.data.repositories.CommentRepository;
import africa.semicolon.soroSokeweray.data.repositories.CommentRepositoryImpl;

public class CommentServicesImpl implements CommentServices {
    private CommentRepository commentRepository = new CommentRepositoryImpl();

    @Override
    public String addComment(String comment) {
        Comment newComment = new Comment();
        newComment.setContents(comment);
        //commentRepository.save(comment);
        return comment;
    }

    @Override
    public Comment getComment(int id) {
        Comment newPost = new Comment();
        newPost.getId();
        return commentRepository.findByCommentId(newPost.getPostId());
    }
}
