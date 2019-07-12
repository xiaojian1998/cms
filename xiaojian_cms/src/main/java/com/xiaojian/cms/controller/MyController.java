package com.xiaojian.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 *  
 * @ClassName: MyController 
 * @Description: 进入个人主页面
 * @author: charles
 * @date: 2019年6月20日 上午8:57:40
 */
@RequestMapping("my")
@Controller
public class MyController {
	
	
	@RequestMapping({"index","/",""})
	public String toIndex() {
		return "/my/index";
	}
	
	

}
