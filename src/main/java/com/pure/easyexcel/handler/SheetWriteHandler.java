package com.pure.easyexcel.handler;

import com.pure.easyexcel.annotation.ResponseExcel;
import jakarta.servlet.http.HttpServletResponse;


/**
 * sheet 写出处理器.
 * @author zzx
 */
public interface SheetWriteHandler {

	/**
	 * 是否支持
	 * @param object
	 * @return
	 */
	boolean support(Object object);

	/**
	 * 校验
	 * @param responseExcel 注解
	 */
	void check(ResponseExcel responseExcel);

	/**
	 * 返回的对象
	 * @param o
	 * @param response
	 * @param responseExcel
	 */
	void export(Object o, HttpServletResponse response, ResponseExcel responseExcel);

	/**
	 * 写成对象
	 * @param o
	 * @param response
	 * @param responseExcel
	 */
	void write(Object o, HttpServletResponse response, ResponseExcel responseExcel);

}
