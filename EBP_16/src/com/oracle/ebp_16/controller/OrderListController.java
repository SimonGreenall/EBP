package com.oracle.ebp_16.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oracle.ebp_16.domain.OrderList;
import com.oracle.ebp_16.service.OrderListService;

@Controller
public class OrderListController {
	@Resource
	OrderListService orderListService;
	
	@RequestMapping(value="queryAllOrderList")
	public String getOrdersList(Model model,String oid){
		System.out.println("getorderslist     oid is "+oid);
		try {
			List<OrderList> orderList = orderListService.getOrdersList(oid);
			model.addAttribute("orderList",orderList);
			System.out.println("orderList    "+orderList);
			return "user/ShowOrdersList";
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("getOrdersList����û�л�ȡ����������");
			return "user/ShowOrdersList";
		}
	}
	
	/**
	 * �û���ѯ����ϸ��
	 * @param model
	 * @param oid
	 * @return
	 */
	@RequestMapping(value="/my/userQueryAllOrderList")
	public String userGetOrdersList(Model model,String oid){
		System.out.println();
		System.out.println("�û���ѯ��������");
		System.out.println("getorderslist     oid is "+oid);
		try {
			List<OrderList> orderList = orderListService.userGetOrdersList(oid);
			model.addAttribute("orderList",orderList);
			System.out.println("orderList    "+orderList);
			return "my/myShowAllOrders";
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("getOrdersList����û�л�ȡ����������");
			return "my/myShowAllOrders";
		}
	}
}
