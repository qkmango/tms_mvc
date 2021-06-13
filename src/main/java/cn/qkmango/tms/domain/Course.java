package cn.qkmango.tms.domain;

/**
 * 课程实体类
 */
public class Course {

    private Integer id;
    private String name;
    private Integer credit;
    private String address;
    private Integer specialized;

    public Course() {
    }

    public Course(Integer id, String name, Integer credit, String address, Integer specialized) {
        this.id = id;
        this.name = name;
        this.credit = credit;
        this.address = address;
        this.specialized = specialized;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getSpecialized() {
        return specialized;
    }

    public void setSpecialized(Integer specialized) {
        this.specialized = specialized;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", credit=" + credit +
                ", address='" + address + '\'' +
                ", specialized=" + specialized +
                '}';
    }
}
