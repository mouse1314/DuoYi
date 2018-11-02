package com.duoyi.web.service;


import com.duoyi.model.po.UserGenerator;
import com.duoyi.model.vo.UserVo;

/**
 * @author 浩子
 *
 */
public interface UserService {

	public String saveUser(UserGenerator user);
	
	public int selectPassByUsername(UserVo user);
	
	public int getUserId(String username);
	
	public int updateUser(UserGenerator user);

}
