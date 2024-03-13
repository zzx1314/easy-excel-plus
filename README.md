# 通用的EXCEL 导入和导出工具包
利用注解实现Excel导入和导出

## 导入EXCEL 使用
使用@RequestExcel，实现对数据的导入,针对SysDbFile 写校验规则可以校验数据
```java
@PostMapping("/importExcel")
	public R importExcel(@RequestExcel List<SysUser> dataList, BindingResult bindingResult) {
		List<ErrorMessage> errorMessageList = (List<ErrorMessage>) bindingResult.getTarget();
		for (SysDbFile sysDbFile : dataList) {
		    System.out.println(sysDbFile);
		}
		return R.ok("导入成功！");
	}
```

## 导出EXCEL 使用
使用@ResponseExcel，实现对数据的导出,具体可以查看@ResponseExcel的使用字段解释
```java
@ResponseExcel(name = "customHead")
	@GetMapping("/exportExcel")
	public List<SysDbFile> exportExcel(Page page, SysDbFile sysDbFile) {
		IPage<SysDbFile> listDbFile = sysDbFileService.getListDbFile(page, sysDbFile);
		return listDbFile.getRecords();
	}
```
## 通过模板导出
如果设置通过模板导出，ExcelConfigProperties 可以指定模板路径
```java
// 可以指定模板路径, 默认是excel目录
private String templatePath = "excel";
```