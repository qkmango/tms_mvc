package cn.qkmango.tms.domain.paginstion;

/**
 * room分页对象
 */
public class RoomPagination extends Pagination{

    private Integer number;
    private String name;
    private Integer building;

    public RoomPagination() {
    }

    public RoomPagination(Integer page, Integer limit, String name, Integer number, Integer building) {
        super(page, limit);
        this.name = name;
        this.number = number;
        this.building = building;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getBuilding() {
        return building;
    }

    public void setBuilding(Integer building) {
        this.building = building;
    }

    @Override
    public String toString() {
        return "RoomPagination{" +
                "page=" + page +
                ", limit=" + limit +
                ", skipCount=" + skipCount +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", building=" + building +
                '}';
    }
}
