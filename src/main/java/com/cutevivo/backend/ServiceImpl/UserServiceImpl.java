package com.cutevivo.backend.ServiceImpl;

import com.cutevivo.backend.Entity.User;
import com.cutevivo.backend.Repository.NoteRepository;
import com.cutevivo.backend.Repository.UserRepository;
import com.cutevivo.backend.Service.UserService;
import com.cutevivo.backend.utils.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<Long> getUserCollectedNotes(long id){
        return noteRepository.findUserCollectedNotes(id);
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
