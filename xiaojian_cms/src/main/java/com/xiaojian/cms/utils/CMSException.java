package com.xiaojian.cms.utils;

public class CMSException extends RuntimeException {

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;
	
	
	public  CMSException() {
		super();
	}

	public  CMSException(String message) {
		super(message);
	}

}
