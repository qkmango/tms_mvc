package cn.qkmango.tms.domain;

public class Room {
    private Integer id;
    private Integer number;
    private String name;
    private Integer building;

    public Room() {
    }

    public Room(Integer id, Integer number, String name, Integer building) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.building = building;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBuilding() {
        return building;
    }

    public void setBuilding(Integer building) {
        this.building = building;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", number=" + number +
                ", name='" + name + '\'' +
                ", building=" + building +
                '}';
    }
}
