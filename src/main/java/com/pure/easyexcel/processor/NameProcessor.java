package com.pure.easyexcel.processor;

import java.lang.reflect.Method;

/**
 * 名称解析器
 *  @author zzx
 */
public interface NameProcessor {

	/**
	 * 解析名称
	 * @param args 拦截器对象
	 * @param method
	 * @param key 表达式
	 * @return
	 */
	String doDetermineName(Object[] args, Method method, String key);

}