package com.xiaojian.cms.dao;

import java.util.List;
import java.util.Map;

/**
 * 
 * @ClassName: ChannelMapper 
 * @Description: 栏目mapper
 * @author: charles
 * @date: 2019年6月20日 上午9:47:04
 */
public interface ChannelMapper {
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
