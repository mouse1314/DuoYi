package com.duoyi.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.duoyi.model.po.GoodsGenerator;
import com.duoyi.model.po.PhotoGenerator;
import com.duoyi.util.COSUtil;
import com.duoyi.util.StringUtils;
import com.duoyi.web.service.GoodsService;
import com.duoyi.web.service.PhotoService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/goods")
public class GoodsController {
	
	private static String url = "https://duoyi-1254133551.cos.ap-guangzhou.myqcloud.com/";
	private static String realpath = "/root/apache-tomcat-7.0.82/webapps/img/";
//	private static String realpath = "D:/test";
	
	@Autowired
	private GoodsService goodsService;
	@Autowired
	PhotoService photoService;

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
	
	@RequestMapping(value = "/getOne", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject getOne(@RequestParam int goodsid){
		JSONObject json = new JSONObject();
//		HttpSession session = request.getSession();
//		int userid = (int) session.getAttribute("userid");
		
		GoodsGenerator result = goodsService.getOne(goodsid);
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
	public JSONObject add(HttpServletRequest request,
			@RequestParam(value = "img") CommonsMultipartFile[] imgs, 
			@RequestParam(value = "name") String name,
			@RequestParam(value = "price") float price,
			@RequestParam(value = "describe") String describe){
		JSONObject json = new JSONObject();
		HttpSession session = request.getSession();
		int goodid = 0;
		int i = 0;
		int userid = (int) session.getAttribute("userid");
//		int userid = 1;
		List<String> urlList = new ArrayList<String>();
		System.out.println("!!!!没进入吗！！！！");
		GoodsGenerator goodsGenerator = new GoodsGenerator(name,price,describe);
		goodsGenerator.setUserId(userid);
		goodsGenerator.setTime(new Date());
		
		for(MultipartFile img : imgs) {
			
			if (img != null) {
				String imgName = img.getOriginalFilename();
				String ext = StringUtils.splitByPot(imgName);
				if(ext.equals("jpg")||ext.equals("png")){
					
					String newName = StringUtils.getRandomString(20) + "." + ext;
					File target = new File(realpath, newName);
					try {
						img.transferTo(target);
					} catch (IllegalStateException | IOException e) {
						e.printStackTrace();
						json.put("status", -1);
						json.put("message","图片转换错误");
						return json;
						
					}
					String newurl = url + newName;
					urlList.add(newurl);
					System.out.println("+++++++++++++++++++" + url);
					Map resultMap = COSUtil.Upload(COSUtil.getCOSClient(), target,newName);
					if ((int) resultMap.get("status") == 1) {
						if(i==0){
							int result = goodsService.add(goodsGenerator);
							goodid = goodsGenerator.getId();
//							System.out.println("新加入的id为" + goodsGenerator.getId());
							if(result<=0){
								json.put("status", -1);
								json.put("message","添加失败");
							}else {
//								photoService.insert(new PhotoGenerator(goodsGenerator.getId(), newurl));
								json.put("status", 1);
								json.put("message","添加成功");
							}
							i++;
						}
						
						
					}else {
						json.put("status", -1);
						json.put("message","上传图片失败");
						return json;
					}
				}else {
					json.put("status", -1);
					json.put("message","图片格式错误");
					return json;
				}
			}else {
				json.put("status", -1);
				json.put("message","图片为空");
				return json;
			}
		}
		
		for(String inurl : urlList){
			photoService.insert(new PhotoGenerator(goodid, inurl));
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
