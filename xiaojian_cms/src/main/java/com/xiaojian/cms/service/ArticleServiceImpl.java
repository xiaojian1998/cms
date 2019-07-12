package com.xiaojian.cms.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xiaojian.cms.dao.ArticleMapper;
import com.xiaojian.cms.domain.Article;
@Service
public  class ArticleServiceImpl implements ArticleService {

	@Resource
	private ArticleMapper articleMapper;
	@Override
	public int insert(Article article) {
		return articleMapper.insert(article);
	}
	@Override
	public List<Map> listByUserId(Integer userId) {
		return articleMapper.listByUserId(userId);
	}
	@Override
	public 	Map get(Integer id) {
		return articleMapper.get(id);
	}
	@Override
	public int update(Article article) {
		return articleMapper.update(article);
	}
	@Override
	public List<Map> selectList(String status) {
		return articleMapper.selectList(status);
	}
	@Override
	public List<Map> selectListByCId(Integer cid) {
		return articleMapper.selectListByCId(cid);
	}
	@Override
	public List<Map> selectListByCatId(Integer catid) {
		return articleMapper.selectListByCatId(catid);
	}
	@Override
	public List<Map> selectHotList() {
		// TODO Auto-generated method stub
		return articleMapper.selectHotList();
	}
	@Override
	public List<Map> listAct() {
		// TODO Auto-generated method stub
		return articleMapper.listAct();
	}
	@Override
	public int hot(Article article) {
		// TODO Auto-generated method stub
		return articleMapper.hot(article);
	}
	/**
	 * 
	 * @Title: selectListByCIdCatId 
	 * @Description: 根据栏目或分类查询所有文章
	 * @param cid
	 * @param catId
	 * @return
	 * @return: List<Map>
	 */
	@Override
	public List<Map> selectListByCIdCatId(String cid, String catId) {
		// TODO Auto-generated method stub
		return articleMapper.selectListByCIdCatId(cid, catId);
	}
	
	

}
