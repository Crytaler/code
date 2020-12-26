//package com.example.demo.controller;
//
//import cn.hutool.json.JSONObject;
//import com.example.demo.entity.FileMetadata;
//import com.example.demo.util.MongoFileRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.InputStream;
//import java.sql.Timestamp;
//import java.time.LocalDateTime;
//
///**
// * @ClassName FileController
// * @Descriptino TODO
// * @Author myzhen
// * @Date 2020/6/23 上午11:17
// * @Version 1.0
// **/
//@RestController
//@RequestMapping("file")
//public class FileController {
//
//    @Autowired
//    private MongoFileRepo mongoFileRepo;
//
//    /**
//     * 文件上传
//     * @param file
//     * @return
//     */
//    @RequestMapping("/upload")
//    public String httpUpload(@RequestParam("file") MultipartFile file) throws IOException {
//
//        InputStream inputStream = file.getInputStream();
//        JSONObject object=new JSONObject();
//        String comment = "上传文件测试";//备注
//        FileMetadata fileMetadata = new FileMetadata();
//        fileMetadata.setAssociateId("10086");
//        fileMetadata.setUploadTime(Timestamp.valueOf(LocalDateTime.now()));//上传时间
//        fileMetadata.setFileOrder(1);//排序
//        fileMetadata.setComment(comment);
//        fileMetadata.setYear(2019);//年份
//        fileMetadata.setFileOriginName(file.getOriginalFilename());//文件名
//        fileMetadata.setOperator("会飞的鱼");//操作人
//        // 下面这三个应该是什么？
//        fileMetadata.setFileType(null);
//        fileMetadata.setFileDisplayName(null);
//        fileMetadata.setAssociateObjectClass(null);
//        try{
//            String id = mongoFileRepo.saveFile(file, comment);
//            fileMetadata.setId(id);
//            System.out.println("fileMetadata=========="+fileMetadata);
////            fileMetadataRepo.save(fileMetadata);
//            object.put("result","文件上传成功");
//        }catch (Exception e){
//            object.put("result","文件失败");
//        }
//        return object.toString();
//    }
//
//    /**
//     * 文件下载
//     * @param id
//     * @param response
//     * @param request
//     * @throws Exception
//     */
//    @RequestMapping("/downLoad")
//    public void downLoad(String id, HttpServletResponse response, HttpServletRequest request) throws Exception{
//        mongoFileRepo.getFileById(id,response,request);
//    }
//}
