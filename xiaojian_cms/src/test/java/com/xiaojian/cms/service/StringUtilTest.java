package com.xiaojian.cms.service;

import org.junit.Test;

import com.xiaojian.common.utils.StringUtil;

public class StringUtilTest {

	
	@Test
	public void test1() {
	
		String term = StringUtil.toUniqueTerm("spring Mvc");
		
		System.out.println(term);
	}
}
