package cn.qkmango.tms.domain;

public class User {
    protected Integer id;
    protected String password;
    protected String name;
    protected Integer userPower = 0;

    public User() {
    }

    public User(Integer id, String password, String name, Integer userPower) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.userPower = userPower;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getUserPower() {
        return userPower;
    }

    public void setUserPower(Integer userPower) {
        this.userPower = userPower;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", userPower=" + userPower +
                '}';
    }
}
