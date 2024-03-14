package webcase.dto;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class UserDto {
    private static final long serialVersionUID = 1L;

    public UserDto() {
    }

    public UserDto(Integer id, String name, String sex, Integer age) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    @ExcelIgnore
    private Integer id;

    @ExcelProperty(value = "姓名",index = 0)
    private String name;

    @ExcelProperty(value = "性别",index = 1)
    private String sex;

    @ExcelProperty(value = "年龄",index = 2)
    private Integer age;
}
