package kata.pp.user.service;

import kata.pp.user.model.User;

import java.util.List;

public interface UserService {

    public List<User> getAllUsers();

    public User getUserById(Long id);

    public User saveUser(User user);

    public void updateUser(User user);

    public void deleteUser(Long id);

}
