package com.cutevivo.backend;


import com.cutevivo.backend.utils.CourseWrapper;
import com.cutevivo.backend.utils.InfoWrapper;
import com.cutevivo.backend.utils.ResultMessage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
@RunWith(SpringRunner.class)
public class UtilsTests {

    @Test
    public void test1(){
        boolean result = true;
        String data = "testdata";
        String reason = "测试中";
        ResultMessage resultMessage1 = new ResultMessage(result, reason);
        ResultMessage resultMessage2 = new ResultMessage(false, data, reason);
        ResultMessage resultMessage3 = new ResultMessage();

        resultMessage3.setResult(result);
        resultMessage3.setReason(reason);
        resultMessage3.setData(data);

        boolean returnedResult = resultMessage1.getResult();
        String returnedData = String.valueOf(resultMessage2.getData());
        String returnedReason = resultMessage3.getReason();
    }

    @Test
    public void test2(){
        InfoWrapper infoWrapper = new InfoWrapper();
        infoWrapper.setId(9);
        infoWrapper.setUsername("test1");
        infoWrapper.setPassword("test1");
        List<String> roles = new ArrayList<>();
        roles.add("user");
        infoWrapper.setRoles(roles);
        long userId = infoWrapper.getId();
        String username = infoWrapper.getUsername();
        String password = infoWrapper.getPassword();
        List<String> returnedRoles = infoWrapper.getRoles();
    }

    @Test
    public void test3(){
        CourseWrapper course = new CourseWrapper();
        course.setCourseId(10);
        course.setCourseName("The first course");
        course.setDescription("Happy day");
        course.setTeacher("xzr");
        course.setPosterUrl("http://localhost");
        course.setScore(4.5);
        course.setChapterNum(3);
        long courseId = course.getCourseId();
        String courseName = course.getCourseName();
        String des = course.getDescription();
        String teacher = course.getTeacher();
        String posterUrl = course.getPosterUrl();
        double score = course.getScore();
        int chapterNum = course.getChapterNum();
    }
}
