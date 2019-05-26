package com.cutevivo.backend.ServiceImpl;

import com.cutevivo.backend.Entity.Note;
import com.cutevivo.backend.Entity.User;
import com.cutevivo.backend.Repository.NoteRepository;
import com.cutevivo.backend.Repository.UserRepository;
import com.cutevivo.backend.Service.UserService;
import com.cutevivo.backend.utils.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private NoteRepository noteRepository;

    public ResultMessage getUserById(long id){
        return userRepository.findUserById(id);
    }

    public ResultMessage getUserNotes(long id){
        return noteRepository.findNotesByUserId(id);
    }

    public ResultMessage getUserCollectedNotes(long id){
        List<Long> noteIds = noteRepository.findUserCollectedNotes(id);
        List<Note> result = new ArrayList<>();
        if(noteIds.size()>0){
            for(long l : noteIds){
                ResultMessage temp = noteRepository.findNoteById(l);
                Note note = (Note) temp.getObject();
                result.add(note);
            }
        }
        return new ResultMessage(true, result, "获取用户收藏笔记成功！");
    }

    public ResultMessage addUser(User user){
        return userRepository.saveUser(user);
    }

    public boolean checkRepeat(String username){
        ResultMessage resultMessage = userRepository.findUserByUsername(username);
        List<User> userList = (List<User>)resultMessage.getObject();
        boolean result = false;
        for(User user : userList){
            if(username.equals(user.getUsername())){
                result = true;
                break;
            }
        }
        return result;
    }

    public ResultMessage getUserByUsername(String username){
        return userRepository.findUserByUsername(username);
    }

}
