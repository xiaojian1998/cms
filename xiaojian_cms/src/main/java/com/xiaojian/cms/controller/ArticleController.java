package com.xiaojian.cms.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.xiaojian.cms.domain.Article;
import com.xiaojian.cms.domain.User;
import com.xiaojian.cms.service.ArticleService;
import com.xiaojian.cms.service.UserService;
import com.xiaojian.cms.utils.PageUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 
 * @ClassName: ArticleController
 * @Description: 文章的控制类
 * @author: charles
 * @date: 2019年6月20日 上午9:15:50
 */

@RequestMapping("article")
@Controller
public class ArticleController {
	@Resource
	private ArticleService articleService;
	@Resource
	private UserService userService;
	
	/**
	 * 跳转到管理员文章审核列表
	 * @Title: checkList 
	 * @Description: TODO
	 * @return
	 * @return: String
	 */
	@RequestMapping("checkList")
	public String checkList(Model model,  @RequestParam(defaultValue="1")Integer page, @RequestParam(defaultValue="")  String status) {
		Integer pageSize=5;
		PageHelper.startPage(page, pageSize);
		List<Map> list = articleService.selectList(status);	
		PageInfo<Map> info = new PageInfo<>(list);
		
		String pageInfo = PageUtil.page(page, info.getPages(), "/article/checkList?status="+status,pageSize);
		model.addAttribute("status", status);
		model.addAttribute("list", list);
		model.addAttribute("pageInfo", pageInfo);
		
		
		return "/admin/article/checkList";
	}
	
	

	/**
	 * 
	 * @Title: toPublish
	 * @Description: 跳转到发布文章
	 * @return
	 * @return: String
	 */
	@RequestMapping("toPublish")
	public String toPublish() {

		return "/my/article/publish";

	}

	// 发布文章
	@ResponseBody
	@RequestMapping("publish")
	public boolean publish(MultipartFile  file ,  Article article,HttpSession session) throws IllegalStateException, IOException {
        //文件上传
		if(null!=file && !file.isEmpty()) {
			String path ="d:/pic/";//文件上传的目标路径
			//获取上传文件的原始名称 1.jpg
			String filename = file.getOriginalFilename();
			//防止文件重名.
		 String name = UUID.randomUUID() + filename.substring(filename.lastIndexOf("."));
			
		 File file2 = new File(path+ name);
		 //把文件写入硬盘
		 file.transferTo(file2);
		 //数据库存储文件的名称
		 article.setPicture(name);
			
		}
		User user = (User) session.getAttribute("user");
		article.setUserId(user.getId());
		
		return articleService.insert(article) > 0;

	}

	
	
	// 查看我的文章

	@RequestMapping("listByUserId")
	public String publish(Model model,HttpSession session) {
		
		
		//从session获取当前登录的人ID
		User user = (User) session.getAttribute("user");
		if(null!=user) {
			List<Map> list = articleService.listByUserId(user.getId());
			
			
			model.addAttribute("list", list);
		}
		
		
		return "/my/article/list";

	}
	
	//管理员查看单个文章明细
		@RequestMapping("get")
		public String get(Integer id,Model model) {
			
			Map map= articleService.get(id);
			model.addAttribute("article", map);
			return "/admin/article/detail";
		}
	
	//审核文章
		@ResponseBody
		@RequestMapping("pass")
		public boolean pass(Article article) {
			
			return articleService.update(article)>0;
		}
		
		
	//查看单个文章明细
	@RequestMapping("getDetail")
	public String getDetail(Integer id,Model model) {
		
		Map map= articleService.get(id);
		model.addAttribute("article", map);
		return "/my/article/detail";
	}

	
	//在首页查看文章明细
		@RequestMapping("/index/getDetail")
		public String getDetail2(Integer id,Model model) {
			
			Map map= articleService.get(id);
			model.addAttribute("article", map);
			return "/index/article/detail";
		}
		
		
		 //返回某个分类下下所有的文章
		@RequestMapping(value= {"selectListByCatId"})
		public String toCategoryList(Integer catid,Model model) {
			 //查询所有的分类
			List<Map> list = articleService.selectListByCatId(catid);
			
			model.addAttribute("articleList", list);
			
			return  "/index/article/articleBycategory";
		}
		
		 //返回热点文章
		@RequestMapping(value= {"selectHotList"})
		public String toHostList(Model model) {
			 //查询所有的分类
			List<Map> list = articleService.selectHotList();
			List<Map> listAct = articleService.listAct();
			
			model.addAttribute("hotList", list);
			model.addAttribute("lastArticles", listAct);
			
			return  "/index/index";
		}
		 //更新
		@ResponseBody
		@RequestMapping("hot")
		public boolean update(Article article) {
		
			return articleService.hot(article)>0;	
		}
		/**
		 * 
		 * @Title: toUpdate 
		 * @Description: TODO
		 * @param id
		 * @param model
		 * @return
		 * @return: String
		 */
		// 单个文章明细
		@RequestMapping("toUpdate")
		public String toUpdate(Integer id, Model model) {

			Map map = articleService.get(id);
			model.addAttribute("article", map);
			return "/my/article/update";
		}
		// 修改发布文章
				@ResponseBody
				@RequestMapping("update")
				public boolean update(MultipartFile file, Article article, HttpSession session, Integer[] sid)
						throws IllegalStateException, IOException {
					// 文件上传
					if (null != file && !file.isEmpty()) {
						String path = "d:/pic/";// 文件上传的目标路径
						// 获取上传文件的原始名称 1.jpg
						String filename = file.getOriginalFilename();
						// 防止文件重名.
						String name = UUID.randomUUID() + filename.substring(filename.lastIndexOf("."));

						File file2 = new File(path + name);
						// 把文件写入硬盘
						file.transferTo(file2);
						// 数据库存储文件的名称
						article.setPicture(name);

					}
					User user = (User) session.getAttribute("user");
					article.setUserId(user.getId());

					return articleService.update(article)>0;

				}
				
				
				
				
				
				
			
				
				
				
				
				
				

		
}
