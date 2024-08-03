package data.repositories;

import africa.semicolon.soroSokeweray.data.models.Post;
import africa.semicolon.soroSokeweray.data.repositories.PostRepositoryImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PostRepositoryImplTest {
    @Test
    public void repositoryCanSavePost_AndRetrievePostTest(){
        PostRepositoryImpl postRepository = new PostRepositoryImpl();
        Post samplePost = new Post();
        samplePost.setId(1);
        samplePost.setTitle("Semicolon Titans");
        samplePost.setContent("Emmanuel has always been stubborn");

        Post savedPost = postRepository.save(samplePost);
        Post retrievedPost = postRepository.findById(savedPost.getId());

        assertNotNull(retrievedPost);
        assertEquals(samplePost.getId(), retrievedPost.getId());
        assertEquals(samplePost.getTitle(), retrievedPost.getTitle());
        assertEquals(samplePost.getContent(), retrievedPost.getContent());
    }

    @Test
    public void createTwoNewPost_saveTheTwo_findAllTest(){
        PostRepositoryImpl postRepository = new PostRepositoryImpl();
        Post samplePost1 = new Post();
        samplePost1.setId(1);
        samplePost1.setTitle("Java OOP");
        samplePost1.setContent("Introduction to String Class");

        Post samplePost2 = new Post();
        samplePost2.setId(2);
        samplePost2.setTitle("Fela Kuti");
        samplePost2.setContent("Afrobeat Legend");

        postRepository.save(samplePost1);
        postRepository.save(samplePost2);

        assertEquals(2, postRepository.findAll().size());

    }
    @Test
    public void saveTwoPosts_deleteByIdTest(){
        PostRepositoryImpl postRepository = new PostRepositoryImpl();
        Post samplePost1 = new Post();
        samplePost1.setId(1);
        samplePost1.setTitle("Java OOP");
        samplePost1.setContent("Introduction to String Class");

        Post samplePost2 = new Post();
        samplePost2.setId(2);
        samplePost2.setTitle("Fela Kuti");
        samplePost2.setContent("Afrobeat Legend");

        postRepository.save(samplePost1);
        postRepository.save(samplePost2);
        postRepository.deleteById(2);

        assertEquals(1,postRepository.findAll().size());
    }

    @Test
    public void saveTwoPosts_deleteAllTest(){
        PostRepositoryImpl postRepository = new PostRepositoryImpl();
        Post samplePost1 = new Post();
        samplePost1.setId(1);
        samplePost1.setTitle("Java OOP");
        samplePost1.setContent("Introduction to String Class");

        Post samplePost2 = new Post();
        samplePost2.setId(2);
        samplePost2.setTitle("Fela Kuti");
        samplePost2.setContent("Afrobeat Legend");

        postRepository.save(samplePost1);
        postRepository.save(samplePost2);
        postRepository.deleteAll();
        assertEquals(0,postRepository.count());

    }

}