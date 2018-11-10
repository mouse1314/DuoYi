package com.duoyi.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.duoyi.model.po.Order;
import com.duoyi.model.vo.OrderVo;


/**
 * @author 浩子
 *2018年11月2日
 */
@Repository
public interface OrderMapper {

	public int insertOrder(Order order);
	public int delectOrder(int id);
	public OrderVo selectOrderById(int id);
	public List<OrderVo> selectOrders(int userid);
	public List<OrderVo> selectOrderResult(int userid);
	public int updateOrderForMoney(int id);
}
