package practise.myproman.api.service.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import practise.myproman.api.service.component.PasswordCryptographyProvider;
import practise.myproman.api.service.entity.UserEntity;

@Repository
public class UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private PasswordCryptographyProvider cryptographyProvider;

    public UserEntity signup(UserEntity userEntity) {
        String[] encrypStrings = this.cryptographyProvider.encrypt(userEntity.getPassword());
        userEntity.setSalt(encrypStrings[0]);
        userEntity.setPassword(encrypStrings[1]);
        entityManager.persist(userEntity);
        return userEntity;
    }

    public UserEntity getUser(final String userUUID) {
        return entityManager.createNamedQuery("userByUUID", UserEntity.class).setParameter("uuid", userUUID)
                .getSingleResult();
    }

}