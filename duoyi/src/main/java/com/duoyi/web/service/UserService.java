package com.duoyi.web.service;


import com.duoyi.model.po.UserGenerator;
import com.duoyi.model.vo.UserVo;

/**
 * @author 浩子
 *
 */
public interface UserService {

	public boolean saveUser(UserGenerator user);
	
	public int selectPassByUsername(UserVo user);
}
