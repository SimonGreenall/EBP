package com.oracle.ebp_16.dao;


import com.oracle.ebp_16.domain.ShoppingCart;

public interface ShoppingCartMapper {
	//ֱ�Ӳ���
		public int addShoppingCart(ShoppingCart shoppingCart);
		//ɾ��������״̬
		public int deleteShoppingCart(Integer scid);
		//���� id ����
		public ShoppingCart queryShopCartByUPid(Integer uid,Integer pid);
		//�Ѵ��ڣ�����������״̬
		public int addShoppingIfExist(Integer uid,Integer pid,Integer mount);
}
