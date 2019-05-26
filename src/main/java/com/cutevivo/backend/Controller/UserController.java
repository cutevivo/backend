package com.cutevivo.backend.Controller;


import com.cutevivo.backend.Entity.CollectionEntry;
import com.cutevivo.backend.Entity.Course;
import com.cutevivo.backend.Entity.Note;
import com.cutevivo.backend.Entity.User;
import com.cutevivo.backend.Service.CollectionEntryService;
import com.cutevivo.backend.Service.CourseService;
import com.cutevivo.backend.Service.NoteService;
import com.cutevivo.backend.Service.UserService;
import com.cutevivo.backend.utils.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private NoteService noteService;

    @Autowired
    private CollectionEntryService collectionEntryService;

    @RequestMapping("login")
    @ResponseBody
    public String login(String username, String password){
        ResultMessage resultMessage = userService.getUserByUsername(username);
        List<User> userList = (List<User>) resultMessage.getObject();
        if(userList.size() == 0){
            return "该用户不存在！";
        }
        User temp = userList.get(0);
        if(password.equals(temp.getPassword())){
            return String.valueOf(temp.getId());
        }
        return "密码错误！";


    }

    @RequestMapping("register")
    @ResponseBody
    public String register(String username, String password){
        if(userService.checkRepeat(username)){
            return "用户名已存在！";
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userService.addUser(user);
        ResultMessage resultMessage = userService.getUserByUsername(username);
        List<User> userList = (List<User>) resultMessage.getObject();
        User temp = userList.get(0);
        return String.valueOf(temp.getId());

    }

    @RequestMapping(value="info")
    @ResponseBody
    public ResultMessage getInfo(long userId){
        ResultMessage resultMessage = userService.getUserById(userId);
        User user = (User)resultMessage.getObject();
        return new ResultMessage(true, user, "获取用户信息成功！");

    }


}
