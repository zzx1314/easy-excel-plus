package webcase.controller;

import com.pure.easyexcel.annotation.RequestExcel;
import com.pure.easyexcel.annotation.ResponseExcel;
import com.pure.easyexcel.message.ErrorMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import webcase.dto.UserDto;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("eplus")
public class TestController {
    /**
     * 导出
     */
    @ResponseExcel(name = "test")
    @GetMapping("/exportExcel")
    public List<UserDto> exportExcel() {
        List<UserDto> result = new ArrayList<>();
        result.add(new UserDto(1, "张三", "男", 18));
        result.add(new UserDto(2, "李四", "男", 19));
        result.add(new UserDto(3, "王五", "男", 20));
        return result;
    }

    /**
     * 导入
     */
    @PostMapping("/importExcel")
    public void importExcel(@RequestExcel List<UserDto> dataList, BindingResult bindingResult) {
        List<ErrorMessage> errorMessageList = (List<ErrorMessage>) bindingResult.getTarget();
        log.info("errorMessageList:{}", errorMessageList);
        for (UserDto userDto : dataList) {
            System.out.println(userDto);
        }
    }


}
