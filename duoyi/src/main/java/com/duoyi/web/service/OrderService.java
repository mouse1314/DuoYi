package com.duoyi.web.service;

import java.util.List;
import java.util.Map;

import com.duoyi.model.po.Order;
import com.duoyi.model.vo.OrderVo;

/**
 * @author 浩子
 *2018年11月2日
 */
public interface OrderService {

	public int insertOrder(Order order);
	public int delectOrder(int id);
	public OrderVo selectOrderById(int id); 
	public List<OrderVo> selectOrders(int userid);
	public List<OrderVo> selectOrderResult(int userid);
	public int payMoney(Map map);
	}
