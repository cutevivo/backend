package com.cutevivo.backend;

import com.cutevivo.backend.Entity.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EntityTests {

    @Test
    public void test1(){
        Chapter chapter = new Chapter();
        chapter.setChapterId(1);
        chapter.setCourseId(8);
        chapter.setChapterName("First");
        chapter.setChapterOrder(1);
        long chapterId = chapter.getChapterId();
        long courseId = chapter.getCourseId();
        String chapterName = chapter.getChapterName();
        int chapterOrder = chapter.getChapterOrder();
    }

    @Test
    public void test2(){
        CollectionEntry collectionEntry = new CollectionEntry();
        collectionEntry.setEntryId(5);
        collectionEntry.setUserId(1);
        collectionEntry.setNoteId(1);
        long entryId = collectionEntry.getEntryId();
        long userId = collectionEntry.getUserId();
        long noteId = collectionEntry.getNoteId();

    }

    @Test
    public void test3(){
        Course course = new Course();
        course.setCourseId(10);
        course.setCourseName("The first course");
        course.setDescription("Happy day");
        course.setTeacher("xzr");
        course.setPosterUrl("http://localhost");
        course.setScore(4.5);
        long courseId = course.getCourseId();
        String courseName = course.getCourseName();
        String des = course.getDescription();
        String teacher = course.getTeacher();
        String posterUrl = course.getPosterUrl();
        double score = course.getScore();
    }

    @Test
    public void test4(){
        Note note = new Note();
        note.setNoteId(5);
        note.setUserId(1);
        note.setCourseId(8);
        note.setThumbs(100);
        note.setContent("G");
        note.setComment("wtf");
        note.setHeader("feelings");
        note.setChapterOrder(3);
        long noteId = note.getNoteId();
        long userId = note.getUserId();
        long courseId = note.getCourseId();
        long thumbs = note.getThumbs();
        String content = note.getContent();
        String comment = note.getComment();
        String header = note.getHeader();
        int chapterOrder = note.getChapterOrder();
    }

    @Test
    public void test5(){
        User user = new User();
        user.setId(9);
        user.setUsername("test1");
        user.setPassword("test1");
        user.setRoles("user");
        long userId = user.getId();
        String username = user.getUsername();
        String password = user.getPassword();
        String roles = user.getRoles();
    }
}
