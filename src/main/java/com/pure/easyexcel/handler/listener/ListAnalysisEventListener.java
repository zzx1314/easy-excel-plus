package com.pure.easyexcel.handler.listener;

import com.alibaba.excel.event.AnalysisEventListener;
import com.pure.easyexcel.message.ErrorMessage;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;

/**
 * 事件监听器
 * @author zzx
 */
public abstract class ListAnalysisEventListener<T> extends AnalysisEventListener<T> {

    /**
     * 获取 excel 解析的对象列表
     * @return 集合
     */
    public abstract List<T> getList();

    /**
     * 获取异常校验结果
     * @return 集合
     */
    public abstract List<ErrorMessage> getErrors();

}
