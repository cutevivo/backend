package com.cutevivo.backend.Repository;

import com.cutevivo.backend.Entity.User;
import com.cutevivo.backend.utils.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    @Autowired
    BaseRepository baseRepository;

    public ResultMessage saveUser(User user){
        return baseRepository.save(user);
    }

    public ResultMessage findUserById(long id){
        return baseRepository.findById(User.class, id);
    }

    public ResultMessage findUserByUsername(String username){
        return baseRepository.findByProperty(User.class, "username", username);
    }


}
