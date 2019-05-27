package com.cutevivo.backend;

import com.cutevivo.backend.Controller.CourseController;
import com.cutevivo.backend.Controller.NoteController;
import com.cutevivo.backend.Controller.UserController;
import com.cutevivo.backend.Entity.Course;
import com.cutevivo.backend.Entity.Note;
import com.cutevivo.backend.utils.ResultMessage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@SpringBootTest
@RunWith(SpringRunner.class)
public class ControllerTests {

    @Autowired
    private CourseController courseController;

    @Autowired
    private NoteController noteController;

    @Autowired
    private UserController userController;

    @Test
    public void test1(){
        long courseId = 8;
        ResultMessage resultMessage = courseController.getCourseInfo(courseId);
        System.out.println(resultMessage.getData() == null);
    }

    @Test
    public void test2(){
        ResultMessage resultMessage = courseController.getAllCourse();
        List<Course> courseList = (List<Course>)resultMessage.getData();
        System.out.println(courseList.size());
    }

    @Test
    public void test3(){
        long noteId = 1;
        ResultMessage resultMessage = noteController.fetchNote(noteId);
        System.out.println(resultMessage.getReason());
    }

    @Test
    public void test4(){
        long userId = 3;
        long noteId = 3;
        ResultMessage resultMessage = noteController.collectNote(userId, noteId);
        System.out.println(resultMessage.getReason());
    }

    @Test
    public void test5(){
        long courseId = 8;
        int chapterOrder = 1;
        ResultMessage resultMessage = noteController.getNotesByCourseAndChapter(courseId, chapterOrder);
        System.out.println(resultMessage.getReason());
    }

    @Test
    public void test6(){
        long userId = 1;
        ResultMessage resultMessage = userController.getInfo(userId);
        System.out.println(resultMessage.getReason());
    }

    @Test
    public void test7(){
        String username = "admin";
        String password = "admin";
        ResultMessage resultMessage = userController.login(username, password);
        System.out.println(resultMessage.getReason());
    }

    @Test
    public void test8(){
        String username1 = "regularOne";
        String username2 = "NoneElsessss";
        String password = "admin";
        ResultMessage resultMessage1 = userController.register(username1, password);
        ResultMessage resultMessage2 = userController.register(username2, password);
        System.out.println(resultMessage1.getReason());
        System.out.println(resultMessage2.getReason());
    }

    @Test
    public void test9(){
        long userId = 1;
        ResultMessage resultMessage1 = userController.getCollectedNotes(userId);
        ResultMessage resultMessage2 = userController.getWrittenNotes(userId);
        System.out.println(resultMessage1.getReason());
        System.out.println(resultMessage2.getReason());
    }
}
