package com.xiaojian.cms.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xiaojian.cms.dao.ChannelMapper;

@Service
public class ChannelServiceImpl implements ChannelService {
	@Resource
	private ChannelMapper channelMapper  ;

	@Override
	public List<Map> listChannel() {
		// TODO Auto-generated method stub
		return channelMapper.listChannel();
	}

	@Override
	public List<Map> listCategory(Integer cid) {
		// TODO Auto-generated method stub
		return channelMapper.listCategory(cid);
	}

}
