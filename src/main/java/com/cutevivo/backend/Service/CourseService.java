package com.cutevivo.backend.Service;

import com.cutevivo.backend.Entity.Course;
import com.cutevivo.backend.utils.ResultMessage;

public interface CourseService {

    ResultMessage getCourseById(long courseId);
    ResultMessage getAllCourses();
    ResultMessage addCourse(Course course);
    ResultMessage getCourseByKeyword(String keyword);
    ResultMessage deleteCourse(Course course);
    ResultMessage getCourseNotes(long courseId);
    ResultMessage getChaptersByCourseId(long courseId);
    double calcCourseScore(long courseId);
    boolean checkRepeat(String courseName);

}
