package com.example.demo.util;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import org.apache.poi.ss.usermodel.Workbook;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;


/**
 * @ClassName ExportUtil
 * @Descriptino excel导出工具类
 * @Author myzhen
 * @Date 2020/7/28 下午5:29
 * @Version 1.0
 **/
public class ExportUtil {

    /**
     * 获取导出的 Workbook对象
     *
     * @param title     大标题
     * @param sheetName 页签名
     * @param object    导出实体
     * @param list      数据集合
     * @return Workbook
     */
    public static Workbook getWorkbook(String title, String sheetName, Class<?> object, List<?> list) {
        //判断导出数据是否为空
        if (list == null) {
            list = new ArrayList<>();
        }
        //获取导出参数
        ExportParams exportParams = new ExportParams(null, sheetName, ExcelType.XSSF);
        //设置导出样式
        exportParams.setStyle(ExcelStyleUtil.class);
        //输出Workbook流
        return ExcelExportUtil.exportExcel(exportParams, object, list);
    }

    /**
     * 导出Excel
     *
     * @param workbook workbook流
     * @param fileName 文件名
     * @param response 响应
     */
    public static void exportExcel(Workbook workbook, String fileName, HttpServletResponse response) {
        //输出文件
        try (OutputStream out = response.getOutputStream()) {
            //编码
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/vnd.ms-excel");
            // 下载文件的默认名称
            response.setHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes("UTF-8"), "ISO-8859-1")+".xls");
            //输出表格
            workbook.write(out);
        } catch (IOException e) {
        } finally {
            try {
                if (workbook != null) {
                    //关闭输出流
                    workbook.close();
                }
            } catch (IOException e) {
            }
        }
    }
}
