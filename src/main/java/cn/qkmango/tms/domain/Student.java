package cn.qkmango.tms.domain;


import cn.qkmango.tms.web.bind.PermissionType;

/**
 * 学生实体类
 *
 * 继承自父类 User 的属性
 *     protected Integer id;
 *     protected String password;
 *     protected String name;
 *
 */
public class Student extends User {

    //性别
    private Integer sex;
    //生日
    private String birth;
    //所属班级
    private Integer clazz;

    public Student() { }

    public Student(Integer id, String password, String name, PermissionType permissionType, Integer sex, String birth, Integer clazz) {
        super(id, password, name, permissionType);
        this.sex = sex;
        this.birth = birth;
        this.clazz = clazz;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public Integer getClazz() {
        return clazz;
    }

    public void setClazz(Integer clazz) {
        this.clazz = clazz;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sex=" + sex +
                ", birth='" + birth + '\'' +
                ", clazz=" + clazz +
                ", id=" + id +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
