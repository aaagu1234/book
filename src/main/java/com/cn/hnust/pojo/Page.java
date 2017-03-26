package com.cn.hnust.pojo;

import java.util.List;
public class Page<T> {

    private int curPage = 1; // 当前页
    private int pageSize = 10; // 每页多少行
    private int totalRow; // 共多少行
    private int start;// 当前页起始行
    private int end;// 结束行
    private int totalPage; // 共多少页
    private List<T> list; //每页显示数据记录的集合；
    
    
    public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        if (curPage < 1) {
            curPage = 1;
        } else {
            start = pageSize * (curPage - 1);
        }
        end = start + pageSize > totalRow ? totalRow : start + pageSize;
        this.curPage = curPage;
    }

    public int getStart() {
        // start=curPage*pageSize;
        return start;
    }

    public int getEnd() {

        return end;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalRow() {
        return totalRow;
    }

    public void setTotalRow(int totalRow) {
        totalPage = (totalRow + pageSize - 1) / pageSize;
        this.totalRow = totalRow;
        if (totalPage < curPage) {
            curPage = totalPage;
            start = pageSize * (curPage - 1);
            end = totalRow;
        }
        end = start + pageSize > totalRow ? totalRow : start + pageSize;
    }

    public int getTotalPage() {

        return this.totalPage;
    }

}