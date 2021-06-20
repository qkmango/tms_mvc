package cn.qkmango.tms.domain;

public class Year {
    //PK，年度，如 2020
    private Integer year;
    //年度具体值 如 2020-2021
    private String name;

    public Year() {
    }

    public Year(Integer year, String name) {
        this.year = year;
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Year{" +
                "year=" + year +
                ", name='" + name + '\'' +
                '}';
    }
}
