package data.repositories;

import africa.semicolon.soroSokeweray.data.models.Comment;
import africa.semicolon.soroSokeweray.data.repositories.CommentRepositoryImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CommentRepositoryImplTest {
    @Test
    public void testThatCommentBucketIsEmpty(){
        CommentRepositoryImpl commentRepository = new CommentRepositoryImpl();
        assertEquals(0,commentRepository.count());
    }

    @Test
    public void userCanSetAndSaveCommentTest(){
        CommentRepositoryImpl commentRepository = new CommentRepositoryImpl();
        Comment newComment = new Comment();
        newComment.setContents("I love the game for real");
        commentRepository.save(newComment);
        assertEquals(1,commentRepository.count());
    }

    @Test
    public void userCanSaveCommentAndFindCommentWithId(){
        CommentRepositoryImpl commentRepository = new CommentRepositoryImpl();
        Comment newComment = new Comment();
        newComment.setContents("Goal!!! Iwobi scores for the super-eagles");
        commentRepository.save(newComment);
        assertEquals(1,commentRepository.findByCommentId(newComment.getId()).getId());
    }

    @Test
    public void makeThreeComment_saveThem_deleteOneById_findTheCommentsLeftWithAnIdTest(){
        CommentRepositoryImpl commentRepository = new CommentRepositoryImpl();
        Comment commentOne = new Comment();
        Comment commentTwo = new Comment();
        Comment commentThree = new Comment();

        commentOne.setContents("Manchester United is back");
        commentTwo.setContents("Any idiot can make anything complicated");
        commentThree.setContents("The transfer market is declared open");

        commentRepository.save(commentOne);
        commentRepository.save(commentTwo);
        commentRepository.save(commentThree);

        int commentIdToDelete = commentOne.getId();
        commentRepository.deleteByCommentId(commentIdToDelete);

        assertNull(commentRepository.findByCommentId(commentIdToDelete));

    }
}