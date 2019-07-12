package com.xiaojian.cms.service;

import java.util.List;
import java.util.Map;

public interface ChannelService {
	/**
	 * 
	 * @Title: list 
	 * @Description: 返回有的栏目信息
	 * @return
	 * @return: List<Map>
	 */
	List<Map> listChannel();
	/**
	 * 
	 * @Title: listCategory 
	 * @Description:  根据栏目返回所有分类
	 * @param cid
	 * @return
	 * @return: List<Map>
	 */
	List<Map> listCategory(Integer cid);
}
