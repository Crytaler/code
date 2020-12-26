//package com.example.demo.util;
//
//import cn.hutool.json.JSONObject;
//import com.example.demo.entity.MongoFileMetaDate;
//import com.mongodb.client.MongoDatabase;
//import com.mongodb.client.gridfs.GridFSBucket;
//import com.mongodb.client.gridfs.GridFSBuckets;
//import com.mongodb.client.gridfs.GridFSDownloadStream;
//import com.mongodb.client.gridfs.model.GridFSFile;
//import org.apache.tomcat.util.http.fileupload.IOUtils;
//import org.bson.types.ObjectId;
//import org.springframework.data.mongodb.MongoDbFactory;
//import org.springframework.data.mongodb.core.query.Criteria;
//import org.springframework.data.mongodb.core.query.Query;
//import org.springframework.data.mongodb.gridfs.GridFsResource;
//import org.springframework.data.mongodb.gridfs.GridFsTemplate;
//import org.springframework.stereotype.Repository;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.InputStream;
//import java.time.LocalDateTime;
//
///**
// * @ClassName MongoFileRepo
// * @Descriptino TODO
// * @Author myzhen
// * @Date 2020/6/23 上午11:15
// * @Version 1.0
// **/
//@Repository
//public class MongoFileRepo {
//
//    private final GridFsTemplate fsTemplate;
//    private final MongoDbFactory mongoDbFactory;
//
//
//    public MongoFileRepo(GridFsTemplate fsTemplate,MongoDbFactory mongoDbFactory) {
//        this.fsTemplate = fsTemplate;
//        this.mongoDbFactory = mongoDbFactory;
//    }
//    /**
//     * 向MongoDB中保存一个文件，返回其ID
//     */
//    public String saveFile(InputStream inputStream, MongoFileMetaDate metaDate) {
//        ObjectId objectId = fsTemplate.store(inputStream, metaDate.getFileName(), metaDate);
//        return objectId.toString();
//    }
//    /**
//     * 向MongoDB中保存一个文件，返回其ID
//     */
//    public String saveFile(MultipartFile file, String comment) {
//        JSONObject object=new JSONObject();
//        try (InputStream inputStream = file.getInputStream()) {
//            MongoFileMetaDate metaDate = new MongoFileMetaDate();
//            metaDate.setFileName(file.getOriginalFilename());
//            metaDate.setComment(comment);
//            metaDate.setRelatedOrgId("");
//            metaDate.setUploadTime(LocalDateTime.now());
//            metaDate.setUploadUser("");
//            return saveFile(inputStream, metaDate);
//        } catch (Exception e) {
//            object.put("fail","上传失败！");
//            return object.toString();
//        }
//    }
//
//
//    /**
//     * 通过上传时生成的id来下载文件
//     * @param id
//     * @param response
//     * @param request
//     * @throws Exception
//     */
//    public void getFileById(String id, HttpServletResponse response, HttpServletRequest request) throws Exception {
//        System.out.println("Finding by ID: " + id);
//        GridFSFile fsFile = fsTemplate.findOne(new Query(Criteria
//                .where("_id").is(new ObjectId(id))));
//        //打开下载流对象
//        MongoDatabase db = mongoDbFactory.getDb();
//        GridFSBucket gridFSBucket = GridFSBuckets.create(db);
//        GridFSDownloadStream gridFSDownloadStream = gridFSBucket.openDownloadStream(fsFile.getObjectId());
//        //创建GridFsResource用于获取流对象
//        GridFsResource resource = new GridFsResource(fsFile, gridFSDownloadStream);
//        String fileName = fsFile.getFilename().replace(",", "");
//        //处理中文文件名乱码
//        if (request.getHeader("User-Agent").toUpperCase().contains("MSIE") ||
//                request.getHeader("User-Agent").toUpperCase().contains("TRIDENT")
//                || request.getHeader("User-Agent").toUpperCase().contains("EDGE")) {
//            fileName = java.net.URLEncoder.encode(fileName, "UTF-8");
//        } else {
//            //非IE浏览器的处理：
//            fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
//        }
//        // 通知浏览器进行文件下载
//        response.setContentType("multipart/form-data");
//        response.setHeader("Content-Disposition", "attachment;filename=\"" + fileName + "\"");
//        IOUtils.copy(resource.getInputStream(), response.getOutputStream());
//    }
//}
