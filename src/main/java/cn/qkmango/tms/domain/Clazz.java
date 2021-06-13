package cn.qkmango.tms.domain;

public class Clazz {

    private Integer id;
    private Integer specialized;
    private String name;

    public Clazz() {
    }

    public Clazz(Integer id, Integer specialized, String name) {
        this.id = id;
        this.specialized = specialized;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSpecialized() {
        return specialized;
    }

    public void setSpecialized(Integer specialized) {
        this.specialized = specialized;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "id=" + id +
                ", specialized=" + specialized +
                ", name='" + name + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }
}
