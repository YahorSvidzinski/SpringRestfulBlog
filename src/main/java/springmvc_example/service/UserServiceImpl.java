package springmvc_example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springmvc_example.dao.UserDao;
import springmvc_example.model.User;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public List getListUser() {
        return userDao.getListUser();
    }

    public void saveOrUpdate(User user) {
        userDao.saveOrUpdate(user);
    }

    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

    public User findUserById(int id) {
        return userDao.findUserById(id);
    }

    @Override
    public boolean authenticate(String username, String password) {
        return Objects.equals(username,password);
    }

}