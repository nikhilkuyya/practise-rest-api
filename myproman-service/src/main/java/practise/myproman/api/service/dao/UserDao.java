package practise.myproman.api.service.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import practise.myproman.api.service.entity.UserEntity;

@Repository
public class UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public UserEntity signup(UserEntity userEntity) {
        entityManager.persist(userEntity);
        return userEntity;
    }

    public UserEntity getUser(final String userUUID) {
        return entityManager.createNamedQuery("userByUUID", UserEntity.class).setParameter("uuid", userUUID)
                .getSingleResult();
    }

}