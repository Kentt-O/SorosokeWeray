package data.repositories;

import data.models.Post;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PostRepositoryImplTest {
    @Test
    public void repositoryCanSavePost_AndRetrievePostTest(){
        PostRepositoryImpl postRepository = new PostRepositoryImpl();
        Post samplePost = new Post();
        samplePost.setId("001");
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
        samplePost1.setId("001");
        samplePost1.setTitle("Java OOP");
        samplePost1.setContent("Introduction to String Class");

        Post samplePost2 = new Post();
        samplePost2.setId("002");
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
        samplePost1.setId("001");
        samplePost1.setTitle("Java OOP");
        samplePost1.setContent("Introduction to String Class");

        Post samplePost2 = new Post();
        samplePost2.setId("002");
        samplePost2.setTitle("Fela Kuti");
        samplePost2.setContent("Afrobeat Legend");

        postRepository.save(samplePost1);
        postRepository.save(samplePost2);
        postRepository.deleteById("002");

        assertEquals(1,postRepository.findAll().size());
    }

    @Test
    public void saveTwoPosts_deleteAllOnceTest(){
        PostRepositoryImpl postRepository = new PostRepositoryImpl();
        Post samplePost1 = new Post();
        samplePost1.setId("001");
        samplePost1.setTitle("Java OOP");
        samplePost1.setContent("Introduction to String Class");

        Post samplePost2 = new Post();
        samplePost2.setId("002");
        samplePost2.setTitle("Fela Kuti");
        samplePost2.setContent("Afrobeat Legend");

        postRepository.save(samplePost1);
        postRepository.save(samplePost2);
        postRepository.deleteAll();
        assertEquals(0,postRepository.count());

    }


}