//package com.example.demo;
//
//import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
//import cn.afterturn.easypoi.excel.entity.ExportParams;
//import cn.afterturn.easypoi.excel.entity.params.ExcelExportEntity;
//import cn.afterturn.easypoi.excel.export.ExcelExportService;
//import com.example.demo.dao.UserInfoMapper;
//import com.example.demo.dto.DocDO;
//import com.example.demo.entity.Jdbc;
//import com.example.demo.entity.UserInfo;
//import com.example.demo.entity.yxbt;
//import com.example.demo.repository.YxbtRepository;
//import com.example.demo.shiro.entity.*;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.solr.client.solrj.SolrClient;
//import org.apache.solr.client.solrj.SolrQuery;
//import org.apache.solr.client.solrj.SolrServerException;
//import org.apache.solr.client.solrj.response.QueryResponse;
//import org.apache.solr.client.solrj.response.UpdateResponse;
//import org.apache.solr.common.SolrDocument;
//import org.apache.solr.common.SolrDocumentList;
//import org.apache.xmlbeans.impl.xb.xsdschema.Public;
//import org.json.JSONObject;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.domain.Page;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.aggregation.Aggregation;
//import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
//import org.springframework.data.mongodb.core.aggregation.LookupOperation;
//import org.springframework.data.solr.core.SolrTemplate;
//import org.springframework.data.solr.core.query.FilterQuery;
//import org.springframework.data.solr.core.query.Query;
//import org.springframework.data.solr.core.query.SimpleQuery;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.solr.core.SolrTemplate;
//import org.springframework.data.solr.core.query.*;
//import org.springframework.data.solr.core.query.result.GroupEntry;
//import org.springframework.data.solr.core.query.result.GroupPage;
//import org.springframework.data.solr.core.query.result.GroupResult;
//import org.springframework.stereotype.Component;
//
//import java.io.FileOutputStream;
//import java.sql.*;
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.List;
//
//import java.io.IOException;
//import java.util.*;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//class SpringbootElkApplicationTests {
//
//    @Autowired
//    UserInfoMapper userInfoMapper;
//    @Autowired
//    private MongoTemplate mongoTemplate;
//    @Autowired
//    private SolrTemplate solrTemplate;
//
//    @Autowired
//    private SolrClient solrClient;
//    @Autowired
//    private YxbtRepository yxbtRepository;
//
//    @Test
//    public void contextLoads() {
//    }
//
//    @Test
//    public void test() {
////        ArrayList<UserInfo> list = new ArrayList<>();
////        UserInfo condion = new UserInfo();
////        condion.setType("or");
////        condion.setColumn("user_id");
////        condion.setRelation("=");
////        condion.setCondition("1");
////        list.add(condion);
////        UserInfo condion1 = new UserInfo();
////        condion1.setType("and");
////        condion1.setColumn("login_name");
////        condion1.setRelation("=");
////        condion1.setCondition("zhangfei");
////        list.add(condion1);
////
////        UserInfo condion3 = new UserInfo();
////        condion3.setType("<>");
////        condion3.setColumn("user_name");
////        condion3.setRelation("=");
////        condion3.setCondition("张飞");
////        list.add(condion3);
////        QueryWrapper<UserInfo> wrapper = new QueryWrapper<>();
////
////        for (UserInfo user : list) {
////                wrapper.eq(user.getType().equals("and"),"u."+user.getColumn(),user.getCondition());
////        }
//////        for (UserInfo userInfo : list) {
//////            if(Objects.equals("<>",userInfo.getType())){
//////                wrapper.ne("u."+userInfo.getColumn(),userInfo.getCondition());
//////            }
//////        }
////        for (UserInfo users : list) {
////                wrapper.or().eq(Objects.equals("or",users.getType()),"u."+users.getColumn(),users.getCondition());
////        }
////
////
////
////
////        Page<Map<String, Object>> page = new Page<>(1, 2);
//////        List<UserInfo> userInfos = userInfoMapper.selectList(wrapper);
////        Page<UserInfo> page1 = userInfoMapper.selectUserInfo(page,wrapper);
////        System.out.println(page1.getTotal());
////        System.out.println(page1.getRecords());
////        System.out.println(page1.getCurrent());
//    }
//    /**
//     * 保存
//     */
//    @Test
//    public void test1() {
//
//        yxbt yxbt = new yxbt();
//        yxbt.setId(1);
//        yxbt.setConceptId("1000003");
//        yxbt.setConceptChineseName("技术-Java");
//        yxbtRepository.save(yxbt);
//    }
//
//    @Test
//    public void test10() throws Exception{
////        Query query = new SimpleQuery();
////        query.addCriteria(Criteria.where("content").contains("一个"));
////        Page<DocDO> ans = solrTemplate.query("test", query, DocDO.class);
////        System.out.println("multiQuery: " + ans.getContent());
//        List<ExcelExportEntity> entityList = new ArrayList<>();
//        //构造抬头
//        ExcelExportEntity excelUserNameEntity = new ExcelExportEntity("用户名", "userName");
//        excelUserNameEntity.setNeedMerge(true);
//        entityList.add(excelUserNameEntity);
//        ExcelExportEntity excelFileNameEntity = new ExcelExportEntity("文件名称", "fileName");
//        excelFileNameEntity.setNeedMerge(true);
//        entityList.add(excelFileNameEntity);
//
//        ExcelExportEntity excelFileTypeEntity = new ExcelExportEntity("文件类型", "fileType");
//        excelFileTypeEntity.setNeedMerge(true);
//        entityList.add(excelFileTypeEntity);
//        ExcelExportEntity excelFileSizeEntity = new ExcelExportEntity("文件大小", "fileSize");
//        excelFileSizeEntity.setNeedMerge(true);
//        entityList.add(excelFileSizeEntity);
//        ExcelExportEntity excelPhotoTimeEntity = new ExcelExportEntity("拍摄时间", "photoTime");
//        excelPhotoTimeEntity.setNeedMerge(true);
//        entityList.add(excelPhotoTimeEntity);
//        ExcelExportEntity excelCheckStateEntity = new ExcelExportEntity("审核状态", "checkState");
//        excelCheckStateEntity.setNeedMerge(true);
//        entityList.add(excelCheckStateEntity);
//
//        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
//        List<Map<String, Object>> list1 = new ArrayList<Map<String, Object>>();
//
//        // 第一个表数据构造
//        Map<String,Object> map1 = new HashMap<>();
//        map1.put("userName","李工");
//        map1.put("fileName","2019111_11.jpg");
//        map1.put("fileType","图片");
//        map1.put("fileSize","123KB");
//        map1.put("photoTime","2019-11-11 11:11:11");
//        map1.put("checkState","未审核");
//        Map<String,Object> map2 = new HashMap<>();
//        map2.put("userName","邱工");
//        map2.put("fileName","66666.jpg");
//        map2.put("fileType","图片");
//        map2.put("fileSize","123KB");
//        map2.put("photoTime","2019-11-11 11:11:11");
//        map2.put("checkState","未审核");
//        list.add(map1);
//        list.add(map2);
//
//        //第二个表数据构造
//        Map<String,Object> map3 = new HashMap<>();
//        map3.put("userName","李工");
//        map3.put("fileName","2019111_11.mp4");
//        map3.put("fileType","视频");
//        map3.put("fileSize","123MB");
//        map3.put("photoTime","2019-11-11 11:11:11");
//        map3.put("checkState","已审核");
//        Map<String,Object> map4 = new HashMap<>();
//        map4.put("userName","夏冰冰");
//        map4.put("fileName","xiabingbing.mp4");
//        map4.put("fileType","视频");
//        map4.put("fileSize","166MB");
//        map4.put("photoTime","2019-11-11 11:11:11");
//        map4.put("checkState","已审核");
//        list1.add(map3);
//        list1.add(map4);
//        // sheet1设置
//        Map<String, Object> sheet1ExportMap = new HashMap<>();
//        sheet1ExportMap.put(NormalExcelConstants.CLASS, ExcelExportEntity.class);
//        sheet1ExportMap.put(NormalExcelConstants.DATA_LIST, list);
//        sheet1ExportMap.put(NormalExcelConstants.PARAMS, new ExportParams("遥信表", "遥信"));
//        //这边为了方便，sheet1和sheet2用同一个表头(实际使用中可自行调整)
//        sheet1ExportMap.put(NormalExcelConstants.MAP_LIST, entityList);
//
//        //Sheet2设置
//        Map<String, Object> sheet2ExportMap = new HashMap<>();
//        sheet2ExportMap.put(NormalExcelConstants.CLASS, ExcelExportEntity.class);
//        sheet2ExportMap.put(NormalExcelConstants.DATA_LIST, list1);
//        sheet2ExportMap.put(NormalExcelConstants.PARAMS, new ExportParams("遥测表", "遥测"));
//        //这边为了方便，sheet1和sheet2用同一个表头(实际使用中可自行调整)
//        sheet2ExportMap.put(NormalExcelConstants.MAP_LIST, entityList);
//
//        // 将sheet1、sheet2使用得map进行包装
//        List<Map<String, Object>> sheetsList = new ArrayList<>();
//        sheetsList.add(sheet1ExportMap);
//        sheetsList.add(sheet2ExportMap);
//
//        // 执行方法
//        Workbook workbook = new HSSFWorkbook();
//
//        for(Map<String,Object> map : sheetsList) {
//            ExcelExportService server = new ExcelExportService();
//            ExportParams param = (ExportParams) map.get("params");
//            @SuppressWarnings("unchecked")
//            List<ExcelExportEntity> entity = (List<ExcelExportEntity>) map.get("mapList");
//            Collection<?> data = (Collection<?>) map.get("data");
//            server.createSheetForMap(workbook, param, entity, data);
//        }
//
//        FileOutputStream fos = new FileOutputStream("/Users/mayongzhen/Downloads/abc.xlsx");
//        workbook.write(fos);
//        fos.close();
//
//
//    }
//
//    @Test
//    public void test3() {
////        String userId="1";
//////        LookupOperation as = LookupOperation.newLookup().from("role")
//////                .localField("roleId")
//////                .foreignField("roleId")
//////                .as("roleList");
//////        //主表
//////        Criteria ordercri = Criteria.where("userId").is(userId);
//////        AggregationOperation match = Aggregation.match(ordercri);
//////
////////        //次表
////////        Criteria ordercri1 = Criteria.where("User.userId").is("000000000");
////////        AggregationOperation match1 = Aggregation.match(ordercri1);
//////////        UnwindOperation unwind = Aggregation.unwind("groups");
//////
//////        Aggregation aggregation = Aggregation.newAggregation(match,as);
//////        List<UserRole> account = mongoTemplate.aggregate(aggregation, "userRole", UserRole.class).getMappedResults();
//////        System.out.println(account);
////        LookupOperation as = LookupOperation.newLookup().from("permission")
////                .localField("permissionId")
////                .foreignField("permissionId")
////                .as("permissionList");
////        //主表
////        ArrayList<String> list = new ArrayList<>();
////        list.add("2");
//////        list.add("1");
////        Criteria ordercri = Criteria.where("roleId").in(list);
////        AggregationOperation match = Aggregation.match(ordercri);
////
////        Aggregation aggregation = Aggregation.newAggregation(match,as);
////        List<RolePermission> role = mongoTemplate.aggregate(aggregation, "rolePermission", RolePermission.class).getMappedResults();
////        for (RolePermission rolePermission : role) {
////            rolePermission.getPermissionList().stream().distinct().findAny().ifPresent(x-> System.out.println(x));
////        }
//    }
//    @Test
//    public void test8()throws SQLException, ClassNotFoundException{
//        List<Jdbc.Condition> list = new ArrayList<>();
//        Jdbc jdbc = new Jdbc();
//        jdbc.setTableName("jdbc");
//        Jdbc.Condition conditions = new Jdbc.Condition();
//        conditions.setColumn("userName");
//        conditions.setType("varchar");
//        conditions.setNum("100");
//        conditions.setAction("DEFAULT NULL");
//        conditions.setComment("用户名");
//
//        Jdbc.Condition condition2 = new Jdbc.Condition();
//        condition2.setColumn("phone");
//        condition2.setType("varchar");
//        condition2.setNum("20");
//        condition2.setAction("NOT NUL");
//        condition2.setComment("手机号");
//        list.add(conditions);
//        list.add(condition2);
//        jdbc.setConditionList(list);
//        StringBuilder sb = new StringBuilder();
//        List<Jdbc.Condition> conditionList = jdbc.getConditionList();
//        sb.append("CREATE TABLE ").append(jdbc.getTableName()).append("(")
//                .append("`ID` int(250) NOT NULL AUTO_INCREMENT, ");
//        for (Jdbc.Condition condition : conditionList) {
//            sb.append("'"+condition.getColumn()+"'").append(" ").append(condition.getType())
//                    .append(" (")
//                    .append(condition.getNum()).append(") ").append(condition.getAction()).append(" comment '")
//                    .append(condition.getComment()).append("' ,");
//        }
//        sb.append("PRIMARY KEY (`ID`)").append(")").append("ENGINE=InnoDB AUTO_INCREMENT=32444 DEFAULT CHARSET=utf8;");
//        System.out.println(sb.toString());
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        String url = "jdbc:mysql://localhost:3306/zyjc?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=Asia/Shanghai";
////      String url = "jdbc:mysql://127.0.0.1:3306/mysql";
//        Connection con = DriverManager.getConnection(url, "root", "629436");
//        Statement statement = con.createStatement();
//        ResultSet resultSet = statement.executeQuery(sb.toString());
//        while(resultSet.next()){
//            System.out.println(resultSet.getString("phone"));
//        }
//    }
//
//
//
//
//
//
//
//}
//
