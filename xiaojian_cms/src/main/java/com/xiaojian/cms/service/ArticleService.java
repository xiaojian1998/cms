package com.xiaojian.cms.service;

import java.util.List;
import java.util.Map;

import com.xiaojian.cms.domain.Article;

public interface ArticleService {
	/**
	 * 
	 * @Title: selecthotList 
	 * @Description:查询热点文章
	 * @param 
	 * @return
	 * @return: List<Map>
	 */
	List<Map> selectHotList();
	/*
	**
	 * 
	 * @Title: selectList 
	 * @Description:根据栏目查询所有文章
	 * @param cid 栏目ID
	 * @return
	 * @return: List<Map>
	 */
	List<Map> selectListByCId(Integer cid);
	
	/*
	**
	 * 
	 * @Title: selectListByCatId 
	 * @Description:根据栏目查询所有文章
	 * @param catid 分类ID
	 * @return
	 * @return: List<Map>
	 */
	List<Map> selectListByCatId(Integer catid);
	
	/**
	 * 
	 * @Title: update 
	 * @Description: 更新文章.-包含审核文章
	 * @param arcile
	 * @return
	 * @return: int
	 */
	int update(Article article);
	
	
	/**
	 * 
	 * @Title: selectList 
	 * @Description:按照审核状态查询
	 * @param status 文章状态
	 * @return
	 * @return: List<Map>
	 */
	List<Map> selectList(String status);
	
	/**
	 * 
	 * @Title: get 
	 * @Description: 获取单个文章
	 * @param id
	 * @return
	 * @return: List<Map>
	 */
	Map get(Integer id);
	/**
	 * 
	 * @Title: listByUserId 
	 * @Description: 根据用户id获取我的文章
	 * @param userId
	 * @return
	 * @return: List<Map>
	 */
	List<Map> listByUserId(Integer userId) ;
	
	/**
	 * 发布文章
	 * @Title: insert 
	 * @Description: TODO
	 * @param article
	 * @return
	 * @return: int
	 */
	int insert(Article article);
	/**
	 * 
	 * @Title: listAct 
	 * @Description: TODO
	 * @return
	 * @return: List<Map>
	 */
	List<Map> listAct();
	/**
	 * 
	 * @Title: hot 
	 * @Description: TODO
	 * @param atr
	 * @return
	 * @return: int
	 */
	int hot(Article article);
	
	
	List<Map> selectListByCIdCatId(String cid, String catId);
	
	
}
