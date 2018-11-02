package com.duoyi.web.service.impl;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duoyi.dao.OrderMapper;
import com.duoyi.model.po.Order;
import com.duoyi.model.vo.OrderVo;
import com.duoyi.web.service.OrderService;

/**
 * @author 浩子
 *2018年11月2日
 */
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderMapper orderMapper;
	
	@Override
	public int insertOrder(Order order) {
		
		try{
			Date time = new Date();
			order.setTime(time);
			orderMapper.insertOrder(order);
			return 1;
		}catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		
		
	}

	@Override
	public int delectOrder(int id) {

		try{
			orderMapper.delectOrder(id);
			return 1;
		}catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	@Override //根据订单id去查询订单
	public OrderVo selectOrderById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override //根据userid去查询订单
	public List<OrderVo> selectOrders(int userid) {
		try{
			List<OrderVo> list = orderMapper.selectOrders(userid);
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}

}
