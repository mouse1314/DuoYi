package com.duoyi.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.duoyi.model.po.CardGenerator;

/**
 * @author 浩子
 *2018年10月23日
 */
@Controller
@RequestMapping("/card")
public class CardController {

	@PostMapping("/insertCard")
	@ResponseBody   //用户发表帖子
	public String insertCard(@RequestBody CardGenerator card){
		
		return "";
	}
}
