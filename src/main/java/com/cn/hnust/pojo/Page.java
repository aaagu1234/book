package com.cn.hnust.pojo;

import java.util.List;
public class Page<T> {

    private int curPage = 1; // ��ǰҳ
    private int pageSize = 10; // ÿҳ������
    private int totalRow; // ��������
    private int start;// ��ǰҳ��ʼ��
    private int end;// ������
    private int totalPage; // ������ҳ
    private List<T> list; //ÿҳ��ʾ���ݼ�¼�ļ��ϣ�
    
    
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