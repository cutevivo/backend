package com.cutevivo.backend.ServiceImpl;

import com.cutevivo.backend.Entity.CollectionEntry;
import com.cutevivo.backend.Entity.Note;
import com.cutevivo.backend.Entity.User;
import com.cutevivo.backend.Repository.CollectionEntryRepository;
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

    @Autowired
    private CollectionEntryRepository collectionEntryRepository;

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
                Note note = (Note) temp.getData();
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
        List<User> userList = (List<User>)resultMessage.getData();
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

    public ResultMessage addCollectionEntry(long userId, long noteId){
        CollectionEntry collectionEntry = new CollectionEntry();
        collectionEntry.setUserId(userId);
        collectionEntry.setNoteId(noteId);
        ResultMessage resultMessage = noteRepository.findNoteById(noteId);
        if(resultMessage.getData() != null) {
            Note note = (Note) resultMessage.getData();
            note.setThumbs(note.getThumbs() + 1);
            noteRepository.updateNote(note);
            return collectionEntryRepository.saveCollectionEntry(collectionEntry);
        }else{
            return new ResultMessage(false, "笔记不存在！");
        }
    }


}
