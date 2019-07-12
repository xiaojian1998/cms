package com.xiaojian.cms.service;

import static org.junit.Assert.*;

import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;

public class ArticleServiceImplTest extends SpringJunit {

	@Resource
	private ArticleService articleService;
	
	
	
	@Test
	public void testGet() {
		Map map = articleService.get(13);
		System.out.println(map);
	}

}
