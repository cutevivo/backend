package com.cutevivo.backend.Controller;


import com.cutevivo.backend.Entity.Chapter;
import com.cutevivo.backend.Entity.Course;
import com.cutevivo.backend.Service.CourseService;
import com.cutevivo.backend.utils.CourseWrapper;
import com.cutevivo.backend.utils.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("info")
    public ResultMessage getCourseInfo(long courseId){
        ResultMessage resultMessage1 = courseService.getChaptersByCourseId(courseId);
        ResultMessage resultMessage2 = courseService.getCourseById(courseId);
        List<Chapter> chapterList = (List<Chapter>)resultMessage1.getData();
        Course course = (Course) resultMessage2.getData();
        CourseWrapper courseWrapper = new CourseWrapper(course);
        courseWrapper.setChapterNum(chapterList.size());
        return new ResultMessage(true, courseWrapper, "获取课程信息成功！");
    }

    @RequestMapping("all")
    public ResultMessage getAllCourse(){
        return courseService.getAllCourses();
    }

}
