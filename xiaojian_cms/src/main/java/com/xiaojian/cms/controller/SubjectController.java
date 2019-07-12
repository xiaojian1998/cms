package com.xiaojian.cms.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaojian.cms.service.ArticleService;
import com.xiaojian.cms.service.SubjectService;

@RequestMapping("subject")
@Controller
public class SubjectController {
	
	@Resource
	private SubjectService  subjectService;
	@Resource
	private ArticleService articleService;
	//查询所有专题
	@RequestMapping("/list")
	public String selectSubjectList(Model model) {
		
		
	 	List<Map> list = subjectService.selectSubjectList();
	 	
	 	model.addAttribute("subList", list);
	 	return "/admin/subject/list";
	}
	
	/**
	 *
	 * @Title: toAddArticle 
	 * @Description: 查询出所有审核过的文章,用来和专题匹配
	 * @param model
	 * @return
	 * @return: String
	 */
	@RequestMapping("toAddArticle")
	public String toAddArticle(Model model,@RequestParam(defaultValue="")String cid,@RequestParam(defaultValue="" )String catId,Integer sid) {
	
		List<Map> list = articleService.selectListByCIdCatId(cid, catId);
		//查询出已经属于该专题的文章,用来回显
		//List<Map> list = articleService.selectList(null);
		
		model.addAttribute("cid", cid);
		model.addAttribute("catId", catId);
		//专题ID
		model.addAttribute("sid", sid);
		model.addAttribute("list", list);
		
		
		return "/admin/subject/articleList";
	}
	
	
	//查询出已经属于该专题的文章,用来回显
	@ResponseBody
	@RequestMapping("selectArtilceListBySid")
	public List<Map> selectArtilceListBySid(Integer sid) {
	
		return subjectService.selectArtilceListBySid(sid);
		
	}
	
	/**
	 * 
	 * @Title: add 
	 * @Description: 向专题中添加文章
	 * @param ids
	 * @param sid
	 * @return
	 * @return: boolean
	 */
	@ResponseBody
	@RequestMapping("add")
	public boolean add(@RequestParam("ids[]")Integer ids[],Integer sid) {
	  return subjectService.insert2(ids, sid);
	}
	
	
}
