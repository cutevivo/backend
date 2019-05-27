package com.cutevivo.backend;


import com.cutevivo.backend.Entity.User;
import com.cutevivo.backend.Repository.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RepositoryTests {
    @Autowired
    private BaseRepository baseRepository;

    @Autowired
    private ChapterRepository chapterRepository;

    @Autowired
    private CollectionEntryRepository collectionEntryRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test1(){
        User user = new User();
        user.setUsername("normal");
        user.setPassword("normal");
        user.setRoles("user");
        baseRepository.save(user);
    }
}
