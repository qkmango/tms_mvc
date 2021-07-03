package cn.qkmango.tms.domain;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

public class Room {
    private Integer id;
    @Range(min = 101,max = 999,message = "{valid.Room.number.Range}")
    private Integer number;
    private String name;
    @NotNull(message = "{valid.Room.building.NotNull}")
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
