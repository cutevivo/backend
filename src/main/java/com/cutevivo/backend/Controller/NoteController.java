package com.cutevivo.backend.Controller;

import com.cutevivo.backend.Entity.Course;
import com.cutevivo.backend.Entity.Note;
import com.cutevivo.backend.Service.CourseService;
import com.cutevivo.backend.Service.NoteService;
import com.cutevivo.backend.Service.UserService;
import com.cutevivo.backend.utils.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("note")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @Autowired
    private UserService userService;

    @Autowired
    private CourseService courseService;

    @RequestMapping("info")
    @ResponseBody
    public ResultMessage fetchNote(long noteId){
        ResultMessage resultMessage = noteService.getNoteById(noteId);
        Note note = (Note)resultMessage.getData();
        return new ResultMessage(true, note, "获取笔记信息成功！");
    }

    @RequestMapping("collect")
    @ResponseBody
    public ResultMessage collectNote(long userId, long noteId){
        //新增收藏条目的过程中，笔记的thumbs+1
        userService.addCollectionEntry(userId, noteId);
        ResultMessage resultMessage1 = noteService.getNoteById(noteId);
        Note note = (Note) resultMessage1.getData();
        long courseId = note.getCourseId();
        //重新计算课程的总评分
        double newScore = courseService.calcCourseScore(courseId);
        ResultMessage resultMessage2 = courseService.getCourseById(courseId);
        Course course = (Course) resultMessage2.getData();
        course.setScore(newScore);
        return courseService.updateCourse(course);
    }

    @RequestMapping("list")
    @ResponseBody
    public ResultMessage getNotesByCourseAndChapter(long courseId, int chapterId){
        return courseService.getNotesByCourseAndChapter(courseId, chapterId);
    }

    @RequestMapping("add")
    @ResponseBody
    public ResultMessage addNote(){
        Note note = new Note();
        /*
         * 使用前端的数据装配note
         */
        long courseId = note.getCourseId();
        double newScore = courseService.calcCourseScore(courseId);
        ResultMessage resultMessage2 = courseService.getCourseById(courseId);
        Course course = (Course) resultMessage2.getData();
        course.setScore(newScore);
        courseService.updateCourse(course);
        return noteService.addNote(note);
    }


}
