package com.duoyi.web.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.duoyi.model.po.GoodsGenerator;
import com.duoyi.web.service.GoodsService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/goods")
public class GoodsController {
	
	@Autowired
	private GoodsService goodsService;

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject getAll(){
		JSONObject json = new JSONObject();
		
		List<GoodsGenerator> result = goodsService.getAll();
		if(result==null){
			json.put("status", 1);
			json.put("message","未能获取数据");
		}else {
			for(GoodsGenerator g : result){
				System.out.println("++" + g.toString());
			}
//			JSONArray jsonarray = JSONArray.fromObject(result);  
			json.put("status", 1);
			json.put("message","成功获取数据");
			json.put("result",result);
		}
		
		return json;
	}
	
	@RequestMapping(value = "/getAllByUserid", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject getAllByUserid(HttpServletRequest request){
		JSONObject json = new JSONObject();
		HttpSession session = request.getSession();
		int userid = (int) session.getAttribute("userid");
		List<GoodsGenerator> result = goodsService.getAllByUserid(userid);
		if(result==null){
			json.put("status", 1);
			json.put("message","未能获取数据");
		}else {
			json.put("status", 1);
			json.put("message","成功获取数据");
			json.put("result", result);
		}
		return json;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject add(@RequestBody GoodsGenerator goodsGenerator,HttpServletRequest request){
		JSONObject json = new JSONObject();
		HttpSession session = request.getSession();
		int userid = (int) session.getAttribute("userid");
//		int userid = 1;
		goodsGenerator.setUserId(userid);
		goodsGenerator.setTime(new Date());
		int result = goodsService.add(goodsGenerator);
		if(result<=0){
			json.put("status", -1);
			json.put("message","添加失败");
		}else {
			json.put("status", 1);
			json.put("message","添加成功");
		}
		return json;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject delete(@RequestParam int goodsid){
		JSONObject json = new JSONObject();
		int result = goodsService.delete(goodsid);
		if(result<=0){
			json.put("status", -1);
			json.put("message","删除失败");
		}else {
			json.put("status", 1);
			json.put("message","删除成功");
		}
		return json;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject update(@RequestBody GoodsGenerator goodsGenerator){
		JSONObject json = new JSONObject();
		
		int result = goodsService.update(goodsGenerator);
		if(result<=0){
			json.put("status", -1);
			json.put("message","编辑失败");
		}else {
			json.put("status", 1);
			json.put("message","编辑成功");
		}
		return json;
	}
	
}
