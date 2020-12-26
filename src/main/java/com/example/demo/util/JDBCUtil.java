package com.example.demo.util;

import com.example.demo.entity.Jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName JDBCUtil
 * @Descriptino TODO
 * @Author myzhen
 * @Date 2020/9/22 下午8:39
 * @Version 1.0
 **/
public class JDBCUtil {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        List<Jdbc.Condition> list = new ArrayList<>();
        Jdbc jdbc = new Jdbc();
        jdbc.setTableName("jdbc");
        Jdbc.Condition conditions = new Jdbc.Condition();
        conditions.setColumn("userName");
        conditions.setType("varchar");
        conditions.setNum("100");
        conditions.setAction("DEFAULT NULL");
        conditions.setComment("用户名");

        Jdbc.Condition condition2 = new Jdbc.Condition();
        condition2.setColumn("phone");
        condition2.setType("varchar");
        condition2.setNum("20");
        condition2.setAction("NOT NULL");
        condition2.setComment("手机号");

        Jdbc.Condition condition3 = new Jdbc.Condition();
        condition3.setColumn("sex");
        condition3.setType("varchar");
        condition3.setNum("20");
        condition3.setAction("NOT NULL");
        condition3.setComment("性别");
        list.add(condition3);
        list.add(conditions);
        list.add(condition2);
        jdbc.setConditionList(list);
        StringBuilder sb = new StringBuilder();
        List<Jdbc.Condition> conditionList = jdbc.getConditionList();
        sb.append("CREATE TABLE `").append(jdbc.getTableName()).append("`(")
        .append("`ID` int(250) NOT NULL AUTO_INCREMENT, ");
        for (Jdbc.Condition condition : conditionList) {
                    sb.append("`"+condition.getColumn()+"`").append(" ").append(condition.getType())
                            .append(" (")
                            .append(condition.getNum()).append(") ").append(condition.getAction()).append(" comment '")
                            .append(condition.getComment()).append("' ,");
        }
        sb.append("PRIMARY KEY (`ID`)").append(")").append("ENGINE=InnoDB AUTO_INCREMENT=32444 DEFAULT CHARSET=utf8;");
        System.out.println(sb.toString());
      Class.forName("com.mysql.cj.jdbc.Driver");
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/zyjc?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=Asia/Shanghai";
//      String url = "jdbc:mysql://127.0.0.1:3306/mysql";
        Connection con = DriverManager.getConnection(url, "root", "629436");
        Statement statement = con.createStatement();
        boolean execute = statement.execute(sb.toString());
        System.out.println(execute);
//        while(resultSet.next()){
//            System.out.println(resultSet.getString("phone"));
//        }

//        "CREATE TABLE `zyjc_drug` (\n" +
//                "            `ID` int(250) NOT NULL AUTO_INCREMENT,\n" +
//                "  `DRUG_NAME` varchar(255) DEFAULT NULL COMMENT '药物名称',\n" +
//                "    PRIMARY KEY (`ID`)\n" +
//                ") ENGINE=InnoDB AUTO_INCREMENT=32444 DEFAULT CHARSET=utf8;"
    }

}
