package com.xiaojian.cms.service;

import org.junit.Test;

import com.xiaojian.cms.utils.Md5Util;

public class Md5UtilTest {
	
	
	@Test
	public void test1() {
		
		String str = Md5Util.md5Encoding("123456");
		System.out.println(str);
		//6644486ede0af8969baa02503f797b3d
	    //6644486ede0af8969baa02503f797b3d
	}

}
