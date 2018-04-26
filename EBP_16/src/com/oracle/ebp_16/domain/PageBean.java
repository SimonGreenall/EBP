package com.oracle.ebp_16.domain;
import java.util.List;

public class PageBean<T> {
	// ���ݵĲ����������õĲ���
	private int currentPage; // ��ǰҳ
	private int pageSize; // ÿҳ��ʾ��������¼

	// ��ѯ���ݿ�
	private List<T> recordList; // ��ҳ�������б�
	private int recordCount; // �ܼ�¼��

	// ����
	private int pageCount; // ��ҳ��
	private int beginPageIndex; // ҳ���б�Ŀ�ʼ������������
	private int endPageIndex; // ҳ���б�Ľ���������������

	public PageBean() {
	}

	/**
	 * ֻ����4����Ҫ�����ԣ����Զ��ļ��������3�����Ե�ֵ
	 *
	 * @param currentPage
	 * @param pageSize
	 * @param recordList
	 * @param recordCount
	 */
	public PageBean(int currentPage, int pageSize, List recordList, int recordCount) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.recordList = recordList;
		this.recordCount = recordCount;

		// ���� pageCount
		pageCount = (recordCount + pageSize - 1) / pageSize;

		// ���� beginPageIndex �� endPageIndex
		// >> ��ҳ��С�ڵ���10ҳʱ��ȫ����ʾ
		if (pageCount <= 10) {
			beginPageIndex = 1;
			endPageIndex = pageCount;
		}
		// >> ��ҳ�����10ҳʱ����ֻ��ʾ��ǰҳ�����Ĺ�10��ҳ��
		else {
			// Ĭ����ʾ ǰ4ҳ + ��ǰҳ + ��5ҳ
			beginPageIndex = currentPage - 4;
			endPageIndex = currentPage + 5;

			// ���ǰ�治��4��ҳ��ʱ������ʾǰ10ҳ
			if (beginPageIndex < 1) {
				beginPageIndex = 1;
				endPageIndex = 10;
			}
			// ������治��5��ҳ��ʱ������ʾ��10ҳ
			else if (endPageIndex > pageCount) {
				endPageIndex = pageCount;
				beginPageIndex = pageCount - 9;
			}
		}
	}

	public void SetPageBean(int currentPage, int pageSize, List<T> recordList, int recordCount) {
		// ���� pageCount
		pageCount = (recordCount + pageSize - 1) / pageSize;
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