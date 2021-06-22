package cn.qkmango.tms.domain;

import cn.qkmango.tms.web.bind.building.BuildingType;

/**
 * 教学楼
 */
public class Building {

    private Integer id;
    //楼号，但是可以加入英文，如12A栋
    private String number;
    private String name;
    private BuildingType buildingType;

    public Building() {
    }

    public Building(Integer id, String number, String name, BuildingType buildingType) {
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
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
