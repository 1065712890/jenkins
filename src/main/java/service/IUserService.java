package service;

import domain.User;

import java.util.List;


public interface IUserService {
    public List<User> getAll();

    public User login(User user);

    public User selectByName(User user);

    public void regist(User user);
}
