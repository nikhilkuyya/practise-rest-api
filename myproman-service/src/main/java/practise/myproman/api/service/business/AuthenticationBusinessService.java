package practise.myproman.api.service.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import practise.myproman.api.service.component.PasswordCryptographyProvider;
import practise.myproman.api.service.dao.UserDao;
import practise.myproman.api.service.entity.UserEntity;
import practise.myproman.api.service.exception.AuthenticationFailedException;

@Service
public class AuthenticationBusinessService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordCryptographyProvider cryptographyProvider;

    public UserEntity login(final String email, final String password) throws AuthenticationFailedException {
        UserEntity userEntity = this.userDao.getUserByEmail(email);
        if (userEntity == null) {
            throw new AuthenticationFailedException("ATH#001", "authentication failed - userName doesn't exist");
        }

        String encryptPassword = cryptographyProvider.encrypt(password, userEntity.getSalt());
        if (encryptPassword != userEntity.getPassword()) {
            throw new AuthenticationFailedException("ATH#002", "authenication failed - userPassword doesn't match");
        }

        return userEntity;
    }
}