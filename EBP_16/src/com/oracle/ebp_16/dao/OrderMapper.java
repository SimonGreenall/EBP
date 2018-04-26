package com.oracle.ebp_16.dao;

import java.util.List;

import com.oracle.ebp_16.domain.Order;
import com.oracle.ebp_16.domain.Orders;
import com.oracle.ebp_16.domain.SelectOrdersBean;


public interface OrderMapper {
	/*
	 * �û�
	 */
	//����uid��ȡ����
	public List<Order> getOrders(String uid);
	
	public int saveOrder(Order order);
	
	public List<Order> listAllOrders(Integer uid);
	
	public Integer queryMaxId();
	
	
	/*
	 * 
	 * ����Ա
	 */
	//��ѯ���ж��������Ӳ�ѯ��
	public List<Orders> getAllOrders(int index,int pageSize);
	public int getAllOrdersCount();
	//����ʱ���ҳ��ѯ����
	public List<Orders> getOrdersByTime(String begin,String end,int index,int pageSize);
	//����ʱ���ѯ��������
	public int getOrdersCountByTime(String begin,String end);

	//���ݹؼ��ֶ� sname sidCard soid ��ҳ��ѯ����
	public List<Orders> getOrdersByKeys(SelectOrdersBean sob);
	//���ݹؼ��ֶ� sname sidCard soid ��ѯ��������
	public int getOrdersCountByKeys(SelectOrdersBean sob);
	
	
}
