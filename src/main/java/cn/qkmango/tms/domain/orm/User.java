package cn.qkmango.tms.domain.orm;
import cn.qkmango.tms.common.validate.group.Query.login;

import cn.qkmango.tms.domain.bind.PermissionType;

import javax.validation.constraints.NotNull;

public class User {
    @NotNull(message = "{valid.User.id.NotNull}",groups = login.class)
    protected Integer id;

    @NotNull(message = "{valid.User.password.NotNull}",groups = login.class)
    protected String password;

    protected String name;

    @NotNull(message = "{valid.User.permissionType.NotNull}",groups = login.class)
    protected PermissionType permissionType;

    public User() {
    }

    public User(Integer id, String password, String name, PermissionType permissionType) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.permissionType = permissionType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PermissionType getPermissionType() {
        return permissionType;
    }

    public void setPermissionType(PermissionType permissionType) {
        this.permissionType = permissionType;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", permissionType=" + permissionType +
                '}';
    }
}
