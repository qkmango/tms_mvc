package cn.qkmango.tms.domain;


/**
 * 分页实体类，包含当前页码page、每页条数limit、略过的记录条数
 */
public class Pagination {

    protected Integer page = 1;
    protected Integer limit = 20;
    protected Integer skipCount = 0;

    public Pagination() {
    }

    public Pagination(Integer page, Integer limit) {
        this.page = page;
        this.limit = limit;
        this.skipCount = (page-1)*limit;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.skipCount = (page-1)*limit;
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.skipCount = (page-1)*limit;
        this.limit = limit;
    }

    public Integer getSkipCount() {
        return skipCount;
    }

    public void setSkipCount() {
        this.skipCount = (page-1)*limit;
    }

    @Override
    public String toString() {
        return "Pagination{" +
                "page=" + page +
                ", limit=" + limit +
                ", skipCount=" + skipCount +
                '}';
    }
}
