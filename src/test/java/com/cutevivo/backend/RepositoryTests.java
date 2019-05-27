package com.cutevivo.backend;


import com.cutevivo.backend.Entity.Chapter;
import com.cutevivo.backend.Entity.CollectionEntry;
import com.cutevivo.backend.Entity.Course;
import com.cutevivo.backend.Entity.User;
import com.cutevivo.backend.Repository.*;
import com.cutevivo.backend.utils.ResultMessage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.expression.spel.support.ReflectiveMethodExecutor;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

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

    @Test
    public void test2(){
        ResultMessage resultMessage = baseRepository.findById(User.class, 1);
        User user = (User)resultMessage.getData();
        user.setUsername("VeryNewName");
        baseRepository.update(user);
    }

    @Test
    public void test3(){
        ResultMessage resultMessage = baseRepository.findById(User.class, 18);
        if(resultMessage.getResult()){
            User user = (User)resultMessage.getData();
            baseRepository.delete(user);
        }else{
            System.out.println("获取失败");
        }
    }

    @Test
    public void test4(){
        ResultMessage resultMessage = baseRepository.findByProperty(User.class, "username", "normal");
        List<User> userList = (List<User>) resultMessage.getData();
        System.out.println(userList.size());
    }

    @Test
    public void test5(){
        ResultMessage resultMessage = baseRepository.getAll(Course.class);
        List<Course> courseList = (List<Course>) resultMessage.getData();
        System.out.println(courseList.size());
    }

    @Test
    public void test6(){
        long courseId = 8;
        ResultMessage resultMessage = chapterRepository.findChaptersByCourseId(courseId);
        List<Chapter> list = (List<Chapter>) resultMessage.getData();
        System.out.println(list.size());

    }

    @Test
    public void test7(){
        long userId = 1;
        ResultMessage resultMessage = collectionEntryRepository.findCollectionEntriesByUserId(userId);
        List<CollectionEntry> collectionEntryList = (List<CollectionEntry>)resultMessage.getData();
        System.out.println(collectionEntryList.size());
    }

    @Test
    public void test8(){
        CollectionEntry collectionEntry = new CollectionEntry();
        collectionEntry.setEntryId(5);
        collectionEntry.setUserId(2);
        collectionEntry.setNoteId(2);
        ResultMessage resultMessage = collectionEntryRepository.saveCollectionEntry(collectionEntry);
        System.out.println(resultMessage.getResult());
    }

    @Test
    public void test9(){
        long noteId = 1;
        ResultMessage resultMessage = collectionEntryRepository.findCollectionEntriesByNoteId(noteId);
        List<CollectionEntry> collectionEntryList = (List<CollectionEntry>)resultMessage.getData();
        System.out.println(collectionEntryList.size());
    }


}
