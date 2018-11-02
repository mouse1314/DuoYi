package com.duoyi.model.vo;

import com.duoyi.model.po.GoodsGenerator;
import com.duoyi.model.po.Order;

/**订单的扩展类，一个订单对应一个商品
 * @author 浩子
 *2018年11月2日
 */
public class OrderVo extends Order {
	
	private GoodsGenerator good;

	
	public GoodsGenerator getGood() {
		return good;
	}

	public void setGood(GoodsGenerator good) {
		this.good = good;
	}
	
}
