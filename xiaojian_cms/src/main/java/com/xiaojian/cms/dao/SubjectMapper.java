package com.xiaojian.cms.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
/**
 * 
 * @ClassName: SubjectMapper 
 * @Description: 专题的mapper
 * @author: charles
 * @date: 2019年6月29日 上午10:38:17
 */
public interface SubjectMapper {

	/**
	 * 
	 * @Title: selectSubjectList 
	 * @Description:  返回所有的专题
	 * @return
	 * @return: List<Map>
	 */
	List<Map> selectSubjectList();
	/**
	 * 创建专题和文章的关联关系
	 * @Title: insert 
	 * @Description: TODO
	 * @param aid
	 * @param sid
	 * @return
	 * @return: int
	 */
	int insert(@Param("aid")Integer aid,@Param("sid")Integer sid);
	/**
	 * 查询某个专题下的所有文章
	 * @Title: selectArtilceListBySid 
	 * @Description: TODO
	 * @return
	 * @return: List<Map>
	 */
	List<Map> selectArtilceListBySid(Integer sid);
	/**
	 * 
	 * @Title: deleteBySid 
	 * @Description: TODO
	 * @param sid
	 * @return: void
	 */
	void deleteBySid(Integer sid);
}
