package com.example.demo.util;

import com.example.demo.entity.ZyjcUser;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @ClassName ExportPdf
 * @Descriptino TODO
 * @Author myzhen
 * @Date 2020/6/23 上午9:44
 * @Version 1.0
 **/
public class ExportPdf {

    public static void ExportPdf(HttpServletRequest request, HttpServletResponse response, List<ZyjcUser> users) throws Exception {
        //告诉浏览器用什么软件可以打开此文件
        response.setHeader("content-Type", "application/pdf");
        //下载文件的默认名称
        //去掉后变为预览模式
//        response.setHeader("Content-Disposition", "attachment;filename=XXX.pdf");
        //设置中文
        BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        Font FontChinese = new Font(bfChinese, 12, Font.NORMAL);

        Document document = new Document();
        PdfWriter.getInstance(document, response.getOutputStream());
        // 打开文档
        document.open();
        //设置文档标题
        document.addTitle("PDF");
        //设置文档作者
        document.addAuthor("yongzhen");
        document.addCreationDate();
        //设置关键字
        document.addKeywords("iText");
        document.addLanguage("中文");
        //表头
        PdfPTable title = new PdfPTable(5);
        title.addCell(new Paragraph("ID", FontChinese));
        title.addCell(new Paragraph("用户名", FontChinese));
        title.addCell(new Paragraph("密码", FontChinese));
        title.addCell(new Paragraph("性别", FontChinese));
        title.addCell(new Paragraph("年龄", FontChinese));
        document.add(title);


        //插入数据
        for (ZyjcUser user : users) {
            PdfPTable table = new PdfPTable(5);
            BaseColor baseColor = new BaseColor(0xCC, 0xCC, 0xCC);
            PdfPCell pdfPCell1 = new PdfPCell(new Paragraph(user.getId(), FontChinese));
            PdfPCell pdfPCell2 = new PdfPCell(new Paragraph(user.getUserName(), FontChinese));
            PdfPCell pdfPCell3 = new PdfPCell(new Paragraph(user.getPassword(), FontChinese));
            PdfPCell pdfPCell4 = new PdfPCell(new Paragraph(user.getGender(), FontChinese));
            PdfPCell pdfPCell5 = new PdfPCell(new Paragraph(user.getAge(), FontChinese));
//            table.addCell(new Paragraph(user.getUserName(), FontChinese));
//            table.addCell(new Paragraph(user.getPassword(), FontChinese));
//            table.addCell(new Paragraph(user.getGender(), FontChinese));
//            table.addCell(new Paragraph(user.getAge(), FontChinese));
            pdfPCell1.setBackgroundColor(baseColor);
            setStyle(pdfPCell1);
            setStyle(pdfPCell2);
            setStyle(pdfPCell3);
            table.addCell(pdfPCell1);
            table.addCell(pdfPCell2);
            table.addCell(pdfPCell3);
            table.addCell(pdfPCell4);
            table.addCell(pdfPCell5);
            table.setHorizontalAlignment(Element.ALIGN_CENTER);
            document.add(table);
        }
        document.close();
    }

    /**
     * 设置样式
     * @param cell
     */
    private static void setStyle(PdfPCell cell){
//        cell.setFixedHeight(size);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);//设置水平居中
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);//设置垂直居中
    }
}
