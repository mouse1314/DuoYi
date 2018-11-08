package com.duoyi.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
import com.duoyi.util.COSUtil;
import com.duoyi.util.StringUtils;
import com.duoyi.web.service.ResourceService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/resource")
public class ResourceController {

	@Autowired
	private static ResourceService resourceService;
	
	private static Set<String> set = new HashSet();
	private static String realpath = "/root/apache-tomcat-7.0.82/webapps/img";
	private static String url = "https://duoyi-1254133551.cos.ap-guangzhou.myqcloud.com/";

	static {
		set.add("jpg");
		set.add("jar");
		set.add("txt");
		set.add("xlxs");
		set.add("ppt");
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject getAll() {
		JSONObject json = new JSONObject();

		return json;
	}

	@RequestMapping(value = "/getAllByUserId", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject getAllByUserId() {
		JSONObject json = new JSONObject();

		return json;
	}

	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject uploadFile(HttpServletRequest req, HttpServletResponse res,
			@RequestParam(value = "file") MultipartFile file, 
			@RequestParam(value = "describe") String describe,
			@RequestParam(value = "price") Integer price) throws IllegalStateException, IOException {
		JSONObject json = new JSONObject();
		// MultipartHttpServletRequest Multireq = (MultipartHttpServletRequest)
		// MultipartFile file = Multireq.getFile("file");
		HttpSession session = req.getSession();
		int userid = (int) session.getAttribute("userid");

		if (file != null) {
			String fileName = file.getOriginalFilename();
			String ext = StringUtils.splitByPot(fileName);
			if (set.contains(ext)) {
				String newName = StringUtils.getRandomString(30) + "." + ext;
				File target = new File(realpath, newName);
				file.transferTo(target);
				String newurl = url + newName;
//				url += newName;
				Map resultMap = COSUtil.Upload(COSUtil.getCOSClient(), target,newName);
				if ((int) resultMap.get("status") == 1) {

					ResourceGenerator resourceGenerator = new ResourceGenerator(userid, newurl,
							describe, new Date(), price, 0);

					resourceService.add(resourceGenerator);
					json.put("status", 1);
					json.put("message", "添加成功");
				} else {
					json.put("status", -1);
					json.put("message", "文件上传失败，请稍后重试");
				}
			} else {
				json.put("status", -1);
				json.put("message", "不允许文件类型");
			}

		} else {
			json.put("status", -1);
			json.put("message", "未选择上传的文件");
		}

		return json;
	}

	@RequestMapping(value = "/addResource", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject addResource(@RequestBody ResourceGenerator resourceGenerator, HttpServletRequest req,
			HttpServletResponse res) {
		JSONObject json = new JSONObject();
		HttpSession session = req.getSession();
		int userid = (int) session.getAttribute("userid");

		return json;
	}

}
