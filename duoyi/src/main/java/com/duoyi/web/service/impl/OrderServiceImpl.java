package com.duoyi.web.service.impl;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.duoyi.dao.GoodsGeneratorMapper;
import com.duoyi.dao.OrderMapper;
import com.duoyi.dao.UserGeneratorMapper;
import com.duoyi.model.po.GoodsGenerator;
import com.duoyi.model.po.Order;
import com.duoyi.model.po.UserGenerator;
import com.duoyi.model.vo.OrderVo;
import com.duoyi.web.service.GoodsService;
import com.duoyi.web.service.OrderService;

/**
 * @author 浩子
 *2018年11月2日
 */
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderMapper orderMapper;
	@Autowired 
	private GoodsGeneratorMapper goodMapper;
	@Autowired
	private UserGeneratorMapper userMapper;
	
	@Override
	public int insertOrder(Order order) {
		
		try{
			GoodsGenerator good = goodMapper.selectByPrimaryKey(order.getGoodid());

			if(good == null){
				return 0;
			}else if (good.getResult() == 1) {
				return 2;
			}
			Date time = new Date();
			order.setTime(time);
			orderMapper.insertOrder(order);
			System.out.println("*********************"+order.getId());
//			goodMapper.updateGoodsForOrder(order.getGoodid());
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

	@Override
	public List<OrderVo> selectOrderResult(int userid) {
		try{
			List<OrderVo> list = orderMapper.selectOrderResult(userid);
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	@Transactional
	public int payMoney(Map map) {
		int goodid = (int) map.get("goodid");
		int orderid = (int) map.get("orderid");
		int price = (int) map.get("price");
		int userout = (int)map.get("userid");
		
		UserGenerator user = userMapper.getUser(userout);
		GoodsGenerator goods = goodMapper.selectByPrimaryKey(goodid);
		int userin = goods.getUserId();
		if(user.getMoney() < price){
			return 0;
		}
		
			userMapper.updateOrderForMoneyOut(userout, price);
			userMapper.updateOrderForMoneyIn(userin, price);
			orderMapper.updateOrderForMoney(orderid);
			goodMapper.updateOrderForMoney(goodid);
		
		return 1;
	}

}
