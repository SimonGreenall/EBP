package com.oracle.ebp_16.dao;

import java.util.List;

import com.oracle.ebp_16.domain.OrderList;

public interface OrderListMapper {
	//��ȡ��������
	public List<OrderList> getOrderList(String oid);

	/**
	 * С������������Դ��С�����ţ�����������Ʒ��������Ʒ���ۣ���Ʒ�������󶩵��ţ�״̬
	 */
	public int saveOrderListItem(OrderList orderList);

	public List<OrderList> listAllOrderlistItems(Integer oid);

	public Integer queryMaxId();

	/**
	 * �û���ѯ����ϸ��
	 * @param oid
	 * @return
	 */
	public List<OrderList> userGetOrdersList(String oid);
}
