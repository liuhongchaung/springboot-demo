package com.example.demo.utils;

import com.alibaba.excel.EasyExcel;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ExcelUtil {

    /**
     * 导出表格
     * @param objects 导出的List
     * @param clazz 导出的类
     * @param response
     * @param templatePath 读取的文件路径
     * @throws IOException
     */
    public static void exportExcel(List<?> objects, Class clazz, HttpServletResponse response, String templatePath) throws IOException {
        InputStream inputStream = ExcelUtil.class.getResourceAsStream(templatePath);
        //设置响应头
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        //向Excel中填充数据
        EasyExcel.write(response.getOutputStream(), clazz).withTemplate(inputStream).sheet(0).doFill(objects);
    }

}
