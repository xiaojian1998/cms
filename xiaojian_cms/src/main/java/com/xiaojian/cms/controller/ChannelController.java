package com.xiaojian.cms.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaojian.cms.service.ChannelService;

@RequestMapping("channel")
@Controller
public class ChannelController {
	@Resource
	private ChannelService channelService;

	/**
	 * 
	 * @Title: listChannle 
	 * @Description: 返回所有的栏目
	 * @return
	 * @return: List<Map>
	 */
	@ResponseBody
	@RequestMapping("listChannle")
	public List<Map> listChannle(){
		return channelService.listChannel();
	}
	
	/**
	 * 
	 * @Title: listChannle 
	 * @Description: 返回所有的栏目
	 * @return
	 * @return: List<Map>
	 */
	@ResponseBody
	@RequestMapping("listCategory")
	public List<Map> listCategory(Integer cid){
		return channelService.listCategory(cid);
	}
}
