package com.pure.easyexcel.aop;

import com.alibaba.excel.util.DateUtils;
import com.pure.easyexcel.annotation.ResponseExcel;
import com.pure.easyexcel.processor.NameProcessor;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.Date;
import java.util.Objects;

/**
 * DynamicNameAspect. 动态切面.
 * @version 1.0
 * @author zzx
 **/
@Aspect
@RequiredArgsConstructor
public class DynamicNameAspect {

	public static final String EXCEL_NAME_KEY = "__EXCEL_NAME_KEY__";

	private final NameProcessor processor;

	@Before("@annotation(excel)")
	public void around(JoinPoint point, ResponseExcel excel) {
		MethodSignature ms = (MethodSignature) point.getSignature();

		String name = excel.name();
		// 当配置的 excel 名称为空时，取当前时间
		if (!StringUtils.hasText(name)) {
			name = DateUtils.format(new Date(),"yyyyMMddHHmmss");
		}
		else {
			name = processor.doDetermineName(point.getArgs(), ms.getMethod(), excel.name());
		}

		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
		Objects.requireNonNull(requestAttributes).setAttribute(EXCEL_NAME_KEY, name, RequestAttributes.SCOPE_REQUEST);
	}

}
