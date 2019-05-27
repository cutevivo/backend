package com.cutevivo.backend;

import com.cutevivo.backend.Controller.CourseController;
import com.cutevivo.backend.Controller.NoteController;
import com.cutevivo.backend.Controller.UserController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


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

    }
}
