package practise.myproman.api.service.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "user_auth_tokens", schema = "proman")
@NamedQueries({
        @NamedQuery(name = "userAuthTokenByAccessToken", query = "select ut from UserAuthTokenEntity ut where ut.accessToken = :accessToken ") })
public class UserAuthTokenEntity implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private long id;
    private UserEntity user;
    private String accessToken;
    private String loginAt;

}