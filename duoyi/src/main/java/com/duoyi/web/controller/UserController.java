package com.duoyi.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.duoyi.model.po.ResourceGenerator;
import com.duoyi.model.po.UserGenerator;
import com.duoyi.model.vo.UserVo2;
import com.duoyi.util.COSUtil;
import com.duoyi.util.StringUtils;
import com.duoyi.web.service.UserService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/user")
public class UserController {

	private static String realpath = "/root/apache-tomcat-7.0.82/webapps/img";
	private static String url = "https://duoyi-1254133551.cos.ap-guangzhou.myqcloud.com/";

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/get", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject get(HttpServletRequest request) {
		JSONObject json = new JSONObject();
		HttpSession session = request.getSession();
		int userid = (int) session.getAttribute("userid");
		// int userid = 1;
		UserVo2 user = userService.getUser(userid);
		System.out.println(user);
		json.put("status", 1);
		json.put("result", user);
		return json;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject update(@RequestBody UserGenerator user, HttpServletRequest request) {
		JSONObject json = new JSONObject();
		HttpSession session = request.getSession();
		int userid = (int) session.getAttribute("userid");
		// int userid = 2 ;
		user.setId(userid);
		int result = userService.updateUser(user);
		if (result <= 0) {
			json.put("status", -1);
			json.put("message", "编辑失败");
		} else {
			json.put("status", 1);
			json.put("message", "编辑成功");
		}

		return json;
	}

	@RequestMapping(value = "/img", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject upload(HttpServletRequest req, HttpServletResponse res, @RequestParam(value = "img") MultipartFile img)
			throws IllegalStateException, IOException {
		JSONObject json = new JSONObject();
		HttpSession session = req.getSession();
		int userid = (int) session.getAttribute("userid");
		String fileName = img.getOriginalFilename();
		String ext = StringUtils.splitByPot(fileName);
		
		if (img != null) {
			if (ext.equals("jpg") || ext.equals("png")) {
				String newName = StringUtils.getRandomString(30) + "." + ext;
				File target = new File(realpath, newName);
				img.transferTo(target);
				String newurl = url + newName;
				Map resultMap = COSUtil.Upload(COSUtil.getCOSClient(), target, newName);
				if ((int) resultMap.get("status") == 1) {
					
					userService.updateImg(newurl);
					json.put("status", 1);
					json.put("message", "上传成功");
				} else {
					json.put("status", -1);
					json.put("message", "图片上传失败，请稍后重试");
				}
			} else {
				json.put("status", -1);
				json.put("message", "不允许图片类型");
			}
		} else {
			json.put("status", -1);
			json.put("message", "未选择上传的文件");
		}
		
		return json;

	}

}
