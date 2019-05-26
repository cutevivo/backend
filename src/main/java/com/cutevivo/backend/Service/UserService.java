package com.cutevivo.backend.Service;

import com.cutevivo.backend.Entity.User;
import com.cutevivo.backend.utils.ResultMessage;

import java.util.List;

public interface UserService {

    ResultMessage getUserById(long id);
    //该方法返回所有用户发布的笔记
    ResultMessage getUserNotes(long id);
    //该方法返回所有用户收藏的笔记
    ResultMessage getUserCollectedNotes(long id);
    ResultMessage addUser(User user);
    boolean checkRepeat(String username);
    ResultMessage getUserByUsername(String username);
    ResultMessage addCollectionEntry(long userId, long noteId);
}
