package service.impl;

import domain.User;
import mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.IUserService;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserMapper userMapper;

    public List<User> getAll(){
        return userMapper.getAllUser();
    }

    public User login(User user){
        return userMapper.selectByNameAndWord(user);
    }

    public User selectByName(User user){
        return userMapper.selectByName(user);
    }

    public void regist(User user){
        userMapper.addUser(user);
    }

}
