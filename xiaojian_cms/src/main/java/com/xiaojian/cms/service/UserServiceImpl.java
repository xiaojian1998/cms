package com.xiaojian.cms.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xiaojian.cms.dao.UserMapper;
import com.xiaojian.cms.domain.User;
@Service
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserMapper userMapper;

	@Override
	public List<Map> list(String username) {
		return userMapper.list(username);
	}

	@Override
	public User getByUsername(String username) {
		return userMapper.getByUsername(username);
	}

	@Override
	public int insert(User user) {
		return userMapper.insert(user);
	}

	@Override
	public int update(User user) {
		return userMapper.update(user);
	}

	@Override
	public List<Map> asss(Integer id) {
		// TODO Auto-generated method stub
		return userMapper.asss(id);
	}

}
