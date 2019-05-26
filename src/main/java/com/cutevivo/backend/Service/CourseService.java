package com.cutevivo.backend.Service;

import com.cutevivo.backend.Entity.Course;
import com.cutevivo.backend.utils.ResultMessage;

public interface CourseService {

    ResultMessage getCourseById(long courseId);
    ResultMessage getAllCourses();
    ResultMessage addCourse(Course course);
    ResultMessage updateCourse(Course course);
    ResultMessage getCourseByKeyword(String keyword);
    ResultMessage deleteCourse(Course course);
    ResultMessage getNotesByCourseAndChapter(long courseId, int chapterOrder);
    ResultMessage getChaptersByCourseId(long courseId);
    double calcCourseScore(long courseId);
    boolean checkRepeat(String courseName);

}
