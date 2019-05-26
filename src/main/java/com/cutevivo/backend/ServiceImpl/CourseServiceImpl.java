package com.cutevivo.backend.ServiceImpl;

import com.cutevivo.backend.Entity.Course;
import com.cutevivo.backend.Entity.Note;
import com.cutevivo.backend.Repository.ChapterRepository;
import com.cutevivo.backend.Repository.CourseRepository;
import com.cutevivo.backend.Repository.NoteRepository;
import com.cutevivo.backend.Service.CourseService;
import com.cutevivo.backend.utils.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private ChapterRepository chapterRepository;


    public ResultMessage getCourseById(long courseId){
        return courseRepository.findCourseById(courseId);
    }

    public ResultMessage addCourse(Course course){
        return courseRepository.saveCourse(course);
    }

    public ResultMessage getAllCourses(){
        return courseRepository.findAllCourses();
    }

    public ResultMessage getCourseByKeyword(String keyword){
        return courseRepository.findCourseByKeyword(keyword);
    }

    //not tested
    public ResultMessage deleteCourse(Course course){
        return courseRepository.deleteCourse(course);
    }

    public ResultMessage getNotesByCourseAndChapter(long courseId, int chapterOrder){
        return noteRepository.findNoteByCourseAndChapter(courseId, chapterOrder);
    }

    public ResultMessage getChaptersByCourseId(long courseId){
        return chapterRepository.findChaptersByCourseId(courseId);
    }

    //not tested
    public double calcCourseScore(long courseId){
        ResultMessage resultMessage = noteRepository.findNotesByCourseId(courseId);
        List<Note> noteList = (List<Note>)resultMessage.getData();
        long totalThumbs = 0;
        double totalWeights = 0.0;
        for(Note note : noteList){
            totalThumbs += note.getThumbs();
            totalWeights += note.getThumbs() * note.getScore();
        }
        double averageScore = totalWeights / totalThumbs;
        return Double.parseDouble(String.format("%.1f", averageScore));
    }

    public boolean checkRepeat(String courseName){
        ResultMessage resultMessage = courseRepository.findCourseByName(courseName);
        List<Course> courseList = (List<Course>) resultMessage.getData();
        boolean result = false;
        for(Course course : courseList){
            if(courseName.equals(course.getCourseName())){
                result = true;
                break;
            }
        }
        return result;
    }


}
