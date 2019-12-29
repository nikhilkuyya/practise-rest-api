package practise.myproman.api.service.entity;

import java.io.Serializable;
import java.time.ZonedDateTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "users", schema = "proman")
@NamedQueries({ @NamedQuery(name = "userByUUID", query = "select user from UserEntity user where user.uuid = :uuid") })
public final class UserEntity implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int id;

    @Column(name = "uuid")
    @NotNull
    @Size(max = 64)
    private String uuid;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleEntity role;

    @Version
    @NonNull
    @Column(name = "version", length = 19, nullable = false)
    private long version;

    @NonNull
    @Column(name = "email")
    @Size(max = 200)
    private String email;

    @NonNull
    @Column(name = "password")
    @ToStringExclude
    private String password;

    @NonNull
    @Column(name = "salt")
    @Size(max = 200)
    @ToStringExclude
    private String salt;

    @NonNull
    @Column(name = "first_name")
    @Size(max = 50)
    private String firstName;

    @NonNull
    @Column(name = "last_name")
    @Size(max = 50)
    private String lastName;

    @Column(name = "mobile_phone")
    @NonNull
    @Size(max = 50)
    private String mobilePhone;

    @NonNull
    @Column(name = "status")
    private int status;

    @Column(name = "failed_login_count")
    private int failedLoginCount;

    @Column(name = "last_password_change_at")
    private ZonedDateTime lastPasswordChangeAt;

    @Column(name = "last_login_at")
    private ZonedDateTime lastLoginAt;

    @Column(name = "created_by")
    @NonNull
    @Size(max = 100)
    private String createdBy;

    @Column(name = "modified_by")
    @Size(max = 100)
    private String modifiedBy;

    @Column(name = "created_at")
    @NonNull
    private ZonedDateTime createdAt;

    @Column(name = "modified_at")
    private ZonedDateTime modifiedAt;

    @Override
    public boolean equals(final Object obj) {
        return new EqualsBuilder().append(this, obj).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this).hashCode();
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(final String uuid) {
        this.uuid = uuid;
    }

    public RoleEntity getRole() {
        return role;
    }

    public void setRole(final RoleEntity role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(final String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(final int status) {
        this.status = status;
    }

    public int getFailedLoginCount() {
        return failedLoginCount;
    }

    public void setFailedLoginCount(final int failedLoginCount) {
        this.failedLoginCount = failedLoginCount;
    }

    public ZonedDateTime getLastPasswordChangeAt() {
        return lastPasswordChangeAt;
    }

    public void setLastPasswordChangeAt(final ZonedDateTime lastPasswordChangeAt) {
        this.lastPasswordChangeAt = lastPasswordChangeAt;
    }

    public ZonedDateTime getLastLoginAt() {
        return lastLoginAt;
    }

    public void setLastLoginAt(final ZonedDateTime lastLoginAt) {
        this.lastLoginAt = lastLoginAt;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(final String salt) {
        this.salt = salt;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(final Long version) {
        this.version = version;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(final String createdBy) {
        this.createdBy = createdBy;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(final ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(final String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public ZonedDateTime getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(final ZonedDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

}