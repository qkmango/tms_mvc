package cn.qkmango.tms.domain;

import cn.qkmango.tms.web.bind.building.BuildingType;

/**
 * 教学楼
 */
public class Building {

    private Integer id;
    private Integer number;
    private String name;
    private BuildingType buildingType;

    public Building() {
    }

    public Building(Integer id, Integer number, String name, BuildingType buildingType) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.buildingType = buildingType;
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

    public BuildingType getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(BuildingType buildingType) {
        this.buildingType = buildingType;
    }

    @Override
    public String toString() {
        return "Building{" +
                "id=" + id +
                ", number=" + number +
                ", name='" + name + '\'' +
                ", buildingType=" + buildingType +
                '}';
    }
}
