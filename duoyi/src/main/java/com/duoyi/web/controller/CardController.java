package com.duoyi.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.duoyi.model.po.CardGenerator;
import com.duoyi.web.service.CardService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author 浩子 2018年10月23日
 */
@Controller
@RequestMapping("/card")
public class CardController {

	@Autowired
	private CardService cardService;

	@PostMapping("/insertCard")
	@ResponseBody // 用户发表帖子
	public JSONObject insertCard(@RequestBody CardGenerator card, HttpServletRequest request) {
		HttpSession session = request.getSession();
		card.setUserId((int) session.getAttribute("userid"));
		JSONObject json = new JSONObject();
		String message = cardService.insertCard(card);
		json.put("status", 1);
		json.put("message", message);
		return json;
	}

	@PostMapping("/findUserCard")
	@ResponseBody // 查看用户发表的贴子
	public JSONObject findUserCard(HttpServletRequest request) {
		HttpSession session = request.getSession();
		int userid = (int) session.getAttribute("userid");
		List<CardGenerator> list = cardService.findUserCard(userid);
		JSONObject json = new JSONObject();
		json.put("status", 1);
		json.put("result", list);
		return json;
	}

	@PostMapping("/findAllCard")
	@ResponseBody // 查看所有发表的贴子
	public JSONObject findAllCard() {
		List<CardGenerator> list = cardService.findAllCards();
		JSONObject json = new JSONObject();
		json.put("status", 1);
		json.put("result", list);
		return json;
	}

	@PostMapping("/updateCard")
	@ResponseBody // 修改发表的贴子
	public JSONObject updateCard(@RequestBody CardGenerator card) {
		String message = cardService.updateCardByCardId(card);
		JSONObject json = new JSONObject();
		json.put("status", 1);
		json.put("message", message);
		return json;
	}
	
	@PostMapping("/delectCard")
	@ResponseBody // 删除发表的贴子
	public JSONObject delectCard(@RequestBody CardGenerator card) {
		String message = cardService.delectCard(card.getId());
		JSONObject json = new JSONObject();
		json.put("status", 1);
		json.put("message", message);
		return json;
	}
}
