package com.cutevivo.backend.Controller;


import com.cutevivo.backend.Entity.CollectionEntry;
import com.cutevivo.backend.Entity.Course;
import com.cutevivo.backend.Entity.Note;
import com.cutevivo.backend.Entity.User;
import com.cutevivo.backend.Service.CollectionEntryService;
import com.cutevivo.backend.Service.CourseService;
import com.cutevivo.backend.Service.NoteService;
import com.cutevivo.backend.Service.UserService;
import com.cutevivo.backend.utils.InfoWrapper;
import com.cutevivo.backend.utils.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
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

    @RequestMapping(value = "login")
    @ResponseBody
    public ResultMessage login(String username, String password){
        ResultMessage resultMessage = userService.getUserByUsername(username);
        List<User> userList = (List<User>) resultMessage.getData();
        if(userList.size() == 0){
            return new ResultMessage(false, "用户名已存在！");
        }
        User temp = userList.get(0);
        if(password.equals(temp.getPassword())){
            return new ResultMessage(true, String.valueOf(temp.getId()), "登录成功");
        }
        return new ResultMessage(false, "密码错误！");


    }

    @RequestMapping("register")
    @ResponseBody
    public ResultMessage register(String username, String password){
        if(userService.checkRepeat(username)){
            return new ResultMessage(false,"用户名已存在！");
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setRoles("user");
        userService.addUser(user);
        ResultMessage resultMessage = userService.getUserByUsername(username);
        List<User> userList = (List<User>) resultMessage.getData();
        User temp = userList.get(0);
        return new ResultMessage(true, String.valueOf(temp.getId()), "注册成功！");

    }

    @RequestMapping("info")
    @ResponseBody
    public ResultMessage getInfo(long userId){
        ResultMessage resultMessage = userService.getUserById(userId);
        User user = (User)resultMessage.getData();
        InfoWrapper infoWrapper = new InfoWrapper();
        infoWrapper.setId(user.getId());
        infoWrapper.setUsername(user.getUsername());
        infoWrapper.setPassword(user.getPassword());
        List<String> roles = new ArrayList<>();
        roles.add("user");
        infoWrapper.setRoles(roles);
        return new ResultMessage(true, infoWrapper, "获取用户信息成功！");

    }

    @RequestMapping("written_notes")
    @ResponseBody
    public ResultMessage getWrittenNotes(long userId){
        return userService.getUserNotes(userId);
    }

    @RequestMapping("collected_notes")
    @ResponseBody
    public ResultMessage getCollectedNotes(long userId){
        return userService.getUserCollectedNotes(userId);
    }


}
