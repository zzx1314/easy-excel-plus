package com.pure.easyexcel.annotation;


import com.pure.easyexcel.head.HeadGenerator;

import java.lang.annotation.*;

/**
 * @author zzx
 **/
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Sheet {

	int sheetNo() default -1;

	/**
	 * sheet name
	 * @return
	 */
	String sheetName();

	/**
	 * 包含字段
	 * @return
	 */
	String[] includes() default {};

	/**
	 * 排除字段
	 * @return
	 */
	String[] excludes() default {};

	/**
	 * 头生成器
	 * @return
	 */
	Class<? extends HeadGenerator> headGenerateClass() default HeadGenerator.class;

}
