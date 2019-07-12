package com.xiaojian.cms.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaojian.cms.domain.User;
import com.xiaojian.cms.service.UserService;
import com.xiaojian.cms.utils.CMSException;
import com.xiaojian.cms.utils.Md5Util;
import com.xiaojian.cms.utils.PageUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaojian.common.utils.StringUtil;

@RequestMapping("user")
@Controller
public class UserController {

	@Resource
	private UserService userService;

	@RequestMapping("list")
	public String list(Model model, @RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "3") Integer pageSize, @RequestParam(defaultValue = "") String username) {

		PageHelper.startPage(page, pageSize);
		List<Map> list = userService.list(username);
		PageInfo<Map> info = new PageInfo<>(list);
		// 调用分页工具类,返回分页信息,里面包含bootstrap样式
		String pageInfo = PageUtil.page(page, info.getPages(), "/user/list?username=" + username, pageSize);

		model.addAttribute("list", list);
		model.addAttribute("username", username);
		model.addAttribute("pageInfo", pageInfo);
		return "admin/user/list";

	}

	// 更新
	@ResponseBody
	@RequestMapping("update")
	public boolean update(User user) {
		return userService.update(user) > 0;
	}

	// 登录
	@ResponseBody
	@RequestMapping("login")
	public boolean login(User user, HttpSession session) {
		// 根据用户名查询用户
		User user2 = userService.getByUsername(user.getUsername());
		if (null != user2) {

			// 把当前登录的用户密码加密后和实际密码比较
			if (Md5Util.md5Encoding(user.getPassword()).equals(user2.getPassword())) {
				// 把用户存入session
				session.setAttribute("user", user2);
				return true;
			}

		}
		return false;

	}

	// 注销
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "/passport/login";
	}

	// 注册
	@ResponseBody
	@RequestMapping("reg")
	public boolean reg(User user) {
		// 对密码进行加密
		user.setPassword(Md5Util.md5Encoding(user.getPassword()));
		return userService.insert(user) > 0;
	}

	// 校验用户唯一
	@ResponseBody
	@RequestMapping("checkUser")
	public boolean reg(String username) {
		User user = userService.getByUsername(username);
		return user != null;
	}

	// 去注册
	@RequestMapping("toReg")
	public String toReg() {

		return "/passport/reg";

	}

	// 去登录
	@RequestMapping("toLogin")
	public String toLoing() {

		return "/passport/login";

	}

	/**
	 * 
	 * @Title: toUpdateUser
	 * @Description: 去修改用户
	 * @return
	 * @return: String
	 */
	@RequestMapping("toUpdateUser")
	public String toUpdateUser() {

		return "/my/user/update";
	}
	/**
	 * 
	 * @Title: validatePhone 
	 * @Description: 验证手机
	 * @param value
	 * @return
	 * @return: boolean
	 */
	@ResponseBody
	@RequestMapping("validatePhone")
	public boolean validatePhone(String src) {
		
		  return StringUtil.isMobile(src);	
		}
	
	/**
	 * 
	 * @Title: validateEmail 
	 * @Description: 验证 邮箱
	 * @param value
	 * @return
	 * @return: boolean
	 */
	@ResponseBody
	@RequestMapping("validateEmail")
	public boolean validateEmail(String src) {
		
		  return StringUtil.isEmail(src);	
		}

	/**
	 * 
	 * @Title: validateNickname 
	 * @Description: 验证匿名不为空
	 * @param value
	 * @return
	 * @return: boolean
	 */
	@ResponseBody
	@RequestMapping("validateNickname")
	public boolean validateNickname(String src) {
		
		  return StringUtil.hasText(src);	
		}


	/**
	 * 
	 * @Title: updateUser
	 * @Description: 修改用户
	 * @return
	 * @return: String
	 */
	@ResponseBody
	@RequestMapping("updateUser")
	public boolean updateUser(User user, Model model,HttpSession session) {
		//如果更新成功.则更新用户的session 信息
		 if(userService.update(user)>0) {
			 //先删除在更新
			 session.removeAttribute("user");
			 //更新sesssion
			 session.setAttribute("user", user);
			 
              return true;
		 }
		return false;
	}
	
	@RequestMapping("userList")
	 public String  userList() {
		
		
		return "/my/user/userList";
	}
	
	

	
	

}
