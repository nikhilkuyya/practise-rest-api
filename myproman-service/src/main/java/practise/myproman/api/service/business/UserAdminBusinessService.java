package practise.myproman.api.service.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import practise.myproman.api.service.dao.UserDao;
import practise.myproman.api.service.entity.UserEntity;

@Service
public class UserAdminBusinessService {

    @Autowired
    private UserDao userDao;

    public UserEntity getUser(final String userUUID) {
        return userDao.getUser(userUUID);
    }
}