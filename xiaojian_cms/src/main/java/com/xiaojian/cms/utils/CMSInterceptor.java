package com.xiaojian.cms.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.xiaojian.cms.domain.User;

/**
 * 
 * @ClassName: CMSInterceptor
 * @Description: 拦截器. 主要拦截个人后台,管理员后台的非法用户 个人不能进入 管理后台 管理员不能进入个人后台
 * @author: charles
 * @date: 2019年6月26日 下午3:42:00
 */
public class CMSInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 拦截个人后台,管理员后台
		// 获取请求的uri
		String uri = request.getRequestURI();
		// 获取当前session
		User user = (User) request.getSession().getAttribute("user");
		// 如果用户已经登录.并且请求的是个人后台,则用户不是管理员)
		if (null != user && uri.contains("my") && !user.getUsername().equals("admin")) {
			return true;// 不拦截
		} else if (null != user && uri.contains("admin") && user.getUsername().equals("admin")) {
			// 管理员登录
			return true;
		} /*
			 * else if(uri.contains("login")||uri.contains("logout") ||uri.contains("reg")
			 * ||uri.contains("index") ||uri.equals("/")) { //用户正在登录注销,注册 return true; }
			 */
		// 如果用户访问的URI 不包含MY 或admin ,就认为是访问的是前端页面.
		else if (!uri.contains("my") && !uri.contains("admin")) {
			return true;
		} else {

			request.setAttribute("error", "请以合适的账户登录....");

			request.getRequestDispatcher("/WEB-INF/view/passport/login.jsp").forward(request, response);
			return false;// 非法用户
		}

	}

}
