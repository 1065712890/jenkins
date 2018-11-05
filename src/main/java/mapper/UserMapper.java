package mapper;

import domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    public List<User> getAllUser();

    public void addUser(User user);

    public User selectByName(User user);

    public User selectByNameAndWord(User user);
}
