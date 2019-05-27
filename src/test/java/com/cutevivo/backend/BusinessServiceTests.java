package com.cutevivo.backend;

import com.cutevivo.backend.Entity.Course;
import com.cutevivo.backend.Entity.User;
import com.cutevivo.backend.Repository.CollectionEntryRepository;
import com.cutevivo.backend.Repository.CourseRepository;
import com.cutevivo.backend.Repository.NoteRepository;
import com.cutevivo.backend.Repository.UserRepository;
import com.cutevivo.backend.Service.CollectionEntryService;
import com.cutevivo.backend.Service.CourseService;
import com.cutevivo.backend.Service.NoteService;
import com.cutevivo.backend.Service.UserService;
import com.cutevivo.backend.utils.ResultMessage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=BackendApplication.class)
public class BusinessServiceTests {

    @Autowired
    private UserService userService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private NoteService noteService;

    @Autowired
    private CollectionEntryService collectionEntryService;


    /**
     * Test1至Test4测试UserService
     */
    @Test(timeout = 4000)
    public void test1(){
        User user = new User();
        user.setUsername("83747hf");
        user.setPassword("9hafkh");
        boolean flag = userService.checkRepeat("83747hf");
        assertEquals(false, flag);
    }

    @Test(timeout = 4000)
    public void test2(){
        String username = "83747hf";
        String password = "9hafkh";
        ResultMessage resultMessage = userService.getUserNotes(1);
        assertEquals(true, resultMessage.getResult());

    }

    @Test(timeout = 4000)
    public void test3(){
        String username = "regularOne";
        String password = "regularPswd";
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        assertEquals(true, userService.addUser(user).getResult());

    }

    @Test(timeout = 4000)
    public void test4(){
        assertEquals(true, userService.getUserById(2).getResult());
    }

    /**
     * Test5至Test12测试CourseService

     @Test(timeout = 4000)
     public void test5(){
     Course course = new Course();
     String courseName = "Web速成";
     String description = "The first class!";
     course.setCourseName(courseName);
     course.setDescription(description);
     ResultMessage resultMessage = courseService.addCourse(course);
     assertEquals(true, resultMessage.getResult());

     }
     */

    @Test(timeout = 4000)
    public void test6(){
        ResultMessage resultMessage = courseService.getCourseById(2);
        assertEquals(true, resultMessage.getResult());
    }

    @Test(timeout = 4000)
    public void test7(){
        ResultMessage resultMessage = courseService.getAllCourses();
        assertEquals(true, resultMessage.getResult());
    }

    @Test(timeout = 4000)
    public void test8(){
        String keyword = "Web";
        ResultMessage resultMessage = courseService.getCourseByKeyword(keyword);
        List<Course> courseList = (List<Course>)resultMessage.getData();
        assertEquals(true, resultMessage.getResult());
    }

    @Test(timeout = 4000)
    public void test9(){
        String courseName = "Web速成";
        assertEquals(false, courseService.checkRepeat(courseName));
    }

    @Test(timeout = 4000)
    public void test10(){

    }

    @Test(timeout = 4000)
    public void test11(){

    }

    @Test(timeout = 4000)
    public void test12(){

    }

    /**
     * Test13至Test16测试NoteService

     @Test(timeout = 4000)
     public void test13(){
     String header = "Web速成第一课笔记";
     String content = "随便写点东西";
     String comment = "不太想学";
     long userId = 1;
     long courseId = 1;
     Note note = new Note();
     note.setHeader(header);
     note.setComment(comment);
     note.setContent(content);
     note.setUserId(userId);
     note.setCourseId(courseId);
     ResultMessage resultMessage = noteService.addNote(note);
     assertEquals(true, resultMessage.getResult());
     }
     */
    @Test(timeout = 4000)
    public void test14(){
        long noteId = 1;
        ResultMessage resultMessage = noteService.getNoteById(noteId);
        assertEquals(true, resultMessage.getResult());
    }

    @Test(timeout = 4000)
    public void test15(){
        String keyword = "Web速成";
        ResultMessage resultMessage = noteService.getNoteByKeyword(keyword);
        assertEquals(true, resultMessage.getResult());
    }

    @Test(timeout = 4000)
    public void test16(){

    }

    /**
     *test17至21测试CollectionEntryService

     @Test(timeout = 4000)
     public void test17(){
     long userId = 1;
     long noteId = 1;
     CollectionEntry collectionEntry = new CollectionEntry();
     collectionEntry.setUserId(userId);
     collectionEntry.setNoteId(noteId);
     ResultMessage resultMessage = collectionEntryService.addCollectionEntry(collectionEntry);
     assertEquals(true, resultMessage.getResult());
     }
     */

    @Test(timeout = 4000)
    public void test18(){
        long userId = 1;
        ResultMessage resultMessage = collectionEntryService.getCollectionEntriesByUserId(userId);
        assertEquals(true, resultMessage.getResult());
    }

    @Test(timeout = 4000)
    public void test19(){
        long noteId = 1;
        ResultMessage resultMessage = collectionEntryService.getCollectionEntriesByNoteId(noteId);
        assertEquals(true, resultMessage.getResult());
    }

    @Test(timeout = 4000)
    public void test20(){
        long userId = 1;
        long noteId = 1;
        assertEquals(true, collectionEntryService.checkRepeat(userId, noteId));
    }

    @Test(timeout = 4000)
    public void test21(){

    }
}
