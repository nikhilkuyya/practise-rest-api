package practise.myproman.api.service.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import practise.myproman.api.service.dao.UserDao;
import practise.myproman.api.service.entity.UserEntity;
import practise.myproman.api.service.exception.ResourceNotFoundException;

@Service
public class UserAdminBusinessService {

    @Autowired
    private UserDao userDao;

    public UserEntity getUser(final String userUUID) throws ResourceNotFoundException {
        UserEntity userEntity = userDao.getUser(userUUID);
        if (userEntity == null) {
            throw new ResourceNotFoundException("USR-001", "User not found");
        }
        return userEntity;

    }
}