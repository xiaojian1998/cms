package com.xiaojian.cms.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.xiaojian.cms.domain.User;

public interface UserService {
	/**
	 * 
	 * @Title: list 
	 * @Description: 列表
	 * @param username
	 * @return
	 * @return:List<Map>
	 */
	List<Map> list(@Param("username") String username);

	/**
	 * 
	 * @Title: getByUsername 
	 * @Description: 根据用户名查询用户
	 * @param username
	 * @return
	 * @return: User
	 */
	User getByUsername(@Param("username")String username);
	
	/**
	 * 
	 * @Title: insert 
	 * @Description: 注册
	 * @param user
	 * @return
	 * @return: int
	 */
	int insert(User user);
	
	/**
	 *  
	 * @Title: update 
	 * @Description: 更新
	 * @param user
	 * @return
	 * @return: int
	 */
	int update(User user);

	List<Map> asss(Integer id);
	
	
}
