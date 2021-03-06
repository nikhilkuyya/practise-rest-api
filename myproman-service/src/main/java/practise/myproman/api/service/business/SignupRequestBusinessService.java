package practise.myproman.api.service.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import practise.myproman.api.service.dao.UserDao;
import practise.myproman.api.service.entity.UserEntity;

@Service
public class SignupRequestBusinessService {

    @Autowired
    private UserDao userDao;

    @Transactional(propagation = Propagation.REQUIRED)
    public UserEntity signup(UserEntity user) {
        return userDao.signup(user);
    }
}