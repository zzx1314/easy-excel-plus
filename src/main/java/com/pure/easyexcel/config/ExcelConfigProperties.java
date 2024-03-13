package com.pure.easyexcel.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;


/**
 * 配置文件
 * c
 */
@Data
@ConfigurationProperties(prefix = ExcelConfigProperties.PREFIX)
public class ExcelConfigProperties {

	static final String PREFIX = "excel";

	/**
	 * 模板路径
	 */
	private String templatePath = "excel";

}
