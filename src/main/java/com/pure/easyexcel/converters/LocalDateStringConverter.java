package com.pure.easyexcel.converters;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.data.CellData;
import com.alibaba.excel.metadata.data.ReadCellData;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.metadata.property.ExcelContentProperty;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * LocalDateStringConverter. 时间转化器.
 * @version 1.0
 * @author zzx
 **/
public enum LocalDateStringConverter implements Converter<LocalDate> {

	/**
	 * 实例
	 */
	INSTANCE;

	@Override
	public Class supportJavaTypeKey() {
		return LocalDate.class;
	}

	@Override
	public CellDataTypeEnum supportExcelTypeKey() {
		return CellDataTypeEnum.STRING;
	}

	@Override
	public LocalDate convertToJavaData(ReadCellData<?> cellData, ExcelContentProperty contentProperty,
									   GlobalConfiguration globalConfiguration) throws ParseException {
		if (contentProperty == null || contentProperty.getDateTimeFormatProperty() == null) {
			return LocalDate.parse(cellData.getStringValue());
		}
		else {
			DateTimeFormatter formatter = DateTimeFormatter
					.ofPattern(contentProperty.getDateTimeFormatProperty().getFormat());
			return LocalDate.parse(cellData.getStringValue(), formatter);
		}
	}

	@Override
	public WriteCellData<?> convertToExcelData(LocalDate value, ExcelContentProperty contentProperty,
											   GlobalConfiguration globalConfiguration) {
		DateTimeFormatter formatter;
		if (contentProperty == null || contentProperty.getDateTimeFormatProperty() == null) {
			formatter = DateTimeFormatter.ISO_LOCAL_DATE;
		}
		else {
			formatter = DateTimeFormatter.ofPattern(contentProperty.getDateTimeFormatProperty().getFormat());
		}
		return new WriteCellData<>(value.format(formatter));
	}

}
