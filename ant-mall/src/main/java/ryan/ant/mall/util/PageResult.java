package ryan.ant.mall.util;

import java.io.Serializable;
import java.util.List;

public class PageResult implements Serializable {
    //总记录数
    private int totalCount;
    //每页记录数
    private int pageSize;
    //总页数
    private int totalPage;
    //当前记录
    private int curPage;
    //列表数据
    private List<?> list;

    public PageResult(List<?> list, int totalCount, int pageSize, int curPage) {
        this.list = list;
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.curPage = curPage;
        this.totalPage = (int) Math.ceil((double) totalCount / pageSize);
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }
}
