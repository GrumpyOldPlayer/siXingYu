package cn.itcast.oa.domain;

import java.util.List;

/**
 * ��ҳ�����е�һҳ����Ϣ
 *
 * @author tyg
 */
public class PageBean {

    // ָ���Ļ���ҳ�����
    private int currentPage; // ��ǰҳ
    private int pageSize; // ÿҳ��ʾ������

    // ��ѯ��ݿ�
    private int recordCount; // �ܼ�¼��
    private List recordList; // ��ҳ������б�

    // ����
    private int pageCount; // ��ҳ��
    private int beginPageIndex; // ҳ���б�Ŀ�ʼ�����
    private int endPageIndex; // ҳ���б�Ľ��������

    /**
     * ֻ����ǰ4����Ҫ�����ԣ����Զ��ļ��������3�������ֵ
     *
     * @param currentPage
     * @param pageSize
     * @param recordCount
     * @param recordList
     */
    public PageBean(int currentPage, int pageSize, int recordCount, List recordList) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.recordCount = recordCount;
        this.recordList = recordList;

        // ������ҳ��
        pageCount = (recordCount + pageSize - 1) / pageSize;

        // ���� beginPageIndex �� endPageIndex
        // >> ��ҳ�����10ҳ����ȫ����ʾ
        if (pageCount <= 10) {
            beginPageIndex = 1;
            endPageIndex = pageCount;
        }
        // >> ��ҳ�����10ҳ������ʾ��ǰҳ����Ĺ�10��ҳ��
        else {
            // ��ǰҳ����Ĺ�10��ҳ�루ǰ4�� + ��ǰҳ + ��5����
            beginPageIndex = currentPage - 4;
            endPageIndex = currentPage + 5;
            // ��ǰ���ҳ�벻��4��ʱ������ʾǰ10��ҳ��
            if (beginPageIndex < 1) {
                beginPageIndex = 1;
                endPageIndex = 10;
            }
            // �������ҳ�벻��5��ʱ������ʾ��10��ҳ��
            if (endPageIndex > pageCount) {
                endPageIndex = pageCount;
                beginPageIndex = pageCount - 10 + 1;
            }
        }
    }

    public List getRecordList() {
        return recordList;
    }

    public void setRecordList(List recordList) {
        this.recordList = recordList;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }

    public int getBeginPageIndex() {
        return beginPageIndex;
    }

    public void setBeginPageIndex(int beginPageIndex) {
        this.beginPageIndex = beginPageIndex;
    }

    public int getEndPageIndex() {
        return endPageIndex;
    }

    public void setEndPageIndex(int endPageIndex) {
        this.endPageIndex = endPageIndex;
    }

}
