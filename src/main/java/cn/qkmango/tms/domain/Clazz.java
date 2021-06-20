package cn.qkmango.tms.domain;

public class Clazz {

    private Integer id;
    private String name;
    private Integer clazz;
    private Integer year;

    public Clazz() {
    }

    public Clazz(Integer id, String name, Integer clazz, Integer year) {
        this.id = id;
        this.name = name;
        this.clazz = clazz;
        this.year = year;
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

    public Integer getClazz() {
        return clazz;
    }

    public void setClazz(Integer clazz) {
        this.clazz = clazz;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", clazz=" + clazz +
                ", year=" + year +
                '}';
    }
}
