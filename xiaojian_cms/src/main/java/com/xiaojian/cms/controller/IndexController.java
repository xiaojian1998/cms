package com.xiaojian.cms.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xiaojian.cms.service.ArticleService;
import com.xiaojian.cms.service.ChannelService;
import com.xiaojian.cms.service.SubjectService;

/**
 * 
 * @ClassName: IndexController 
 * @Description: 系统前端主页面
 * @author: charles
 * @date: 2019年6月25日 上午8:34:25
 */
@Controller
public class IndexController {
	
	@Resource
	private ChannelService channelService;
	
	@Resource
	private ArticleService articleService;

	@Resource
	private SubjectService subjectService;
	
	@RequestMapping(value= {"/","index",""})
	public String toIndex(Model model) {
		//查询出所有栏目
		
		List<Map> list = channelService.listChannel();
		
		model.addAttribute("list", list);
		
		
		 //查询热点文章
		List<Map> hotList = articleService.selectHotList();
		List<Map> listAct = articleService.listAct();
		
		model.addAttribute("hotList", hotList);
		model.addAttribute("lastArticles", listAct);
		
		return "/index/index";
		
	}
    //返回某个栏目下所有的分类
	@RequestMapping(value= {"getCategoryList"})
	public String toCategoryList(Integer cid,Model model) {
		 //查询所有的分类
		List<Map> list = channelService.listCategory(cid);
		model.addAttribute("list", list);
		model.addAttribute("cid", cid);
		//查询该栏目下的所有文章
		List<Map> list2 = articleService.selectListByCId(cid);
		model.addAttribute("articleList", list2);
		
		return  "/index/category";
	}
	
	
	/**
	 * 专题列表
	 * @Title: selectSubjectList 
	 * @Description: TODO
	 * @return
	 * @return: String
	 */
	
	@RequestMapping("/selectSubjectList")
	public String selectSubjectList(Model model) {
		
		
	 	List<Map> list = subjectService.selectSubjectList();
	 	
	 	model.addAttribute("subList", list);
	 	return "/index/subject";
	}
	
	
 /**
  * 根据专题查询文章
  * @Title: selectArticleListBySid 
  * @Description: TODO
  * @param model
  * @return
  * @return: String
  */
	@RequestMapping("/selectArticleListBySid")
	public String selectArticleListBySid(Model model,Integer sid) {
		
		
	 	List<Map> list = subjectService.selectArtilceListBySid(sid);
	 	model.addAttribute("articleList", list);
	 	return "/index/subject";
	}
	
	
	
	
	
	
	

	
	
	
}
