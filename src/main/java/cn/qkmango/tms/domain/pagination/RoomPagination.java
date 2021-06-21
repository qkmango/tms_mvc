package cn.qkmango.tms.domain.pagination;

/**
 * room分页对象
 */
public class RoomPagination extends Pagination{

    private Integer id;
    private Integer number;
    private String name;
    private Integer building;

    public RoomPagination() {
    }

    public RoomPagination(Integer page, Integer limit, Boolean pagination, Integer id, Integer number, String name, Integer building) {
        super(page, limit, pagination);
        this.id = id;
        this.number = number;
        this.name = name;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "RoomPagination{" +
                "page=" + page +
                ", limit=" + limit +
                ", skipCount=" + skipCount +
                ", id=" + id +
                ", number=" + number +
                ", name='" + name + '\'' +
                ", building=" + building +
                '}';
    }
}
