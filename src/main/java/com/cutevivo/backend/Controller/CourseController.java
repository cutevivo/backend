package com.cutevivo.backend.Controller;


import com.cutevivo.backend.Service.CourseService;
import com.cutevivo.backend.utils.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("course")
    public ResultMessage getCourseInfo(long courseId){
        return courseService.getCourseById(courseId);
    }

}
