package com.pure.easyexcel.annotation;

import com.pure.easyexcel.handler.listener.DefaultAnalysisEventListener;
import com.pure.easyexcel.handler.listener.ListAnalysisEventListener;

import java.lang.annotation.*;

/**
 * 上传请求注解
 * @author zzx
 **/
@Documented
@Target({ ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestExcel {
    /**
     * 前端上传文件名称file
     */
    String fileName() default "file";

    /**
     * 读取的监听器类
     * @return readListener
     */
    Class<? extends ListAnalysisEventListener<?>> readListener() default DefaultAnalysisEventListener.class;

    /**
     * 是否跳过空行
     * @return 默认跳过
     */
    boolean ignoreEmptyRow() default false;
}
