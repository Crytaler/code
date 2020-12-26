package com.example.demo.util;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

/**
 * @ClassName generator
 * @Descriptino TODO
 * @Author myzhen
 * @Date 2020/6/22 下午2:05
 * @Version 1.0
 **/
public class generator {

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }


        public static void main(String[] args) {
            AutoGenerator mpg = new AutoGenerator();
            // 全局配置
            GlobalConfig gc = new GlobalConfig();
            String projectPath = System.getProperty("user.dir");
            //输出文件路径
            gc.setOutputDir(projectPath + "/src/main/java");
            gc.setFileOverride(true);
            // 不需要ActiveRecord特性的请改为false
            gc.setActiveRecord(false);
            // XML 二级缓存
            gc.setEnableCache(false);
            // XML ResultMap
            gc.setBaseResultMap(true);
            // XML columList
            gc.setBaseColumnList(false);
            //实体属性 Swagger2 注解
             gc.setSwagger2(true);
            // 作者
            gc.setAuthor("yongzhen");

            // 自定义文件命名，注意 %s 会自动填充表实体属性！
            gc.setControllerName("%sController");
            gc.setServiceName("I%sService");
            gc.setServiceImplName("I%sServiceImpl");
            gc.setMapperName("%sMapper");
            gc.setXmlName("%sMapper");
            mpg.setGlobalConfig(gc);


            // 数据源配置
            DataSourceConfig dsc = new DataSourceConfig();
            dsc.setDbType(DbType.MYSQL);
            dsc.setDriverName("com.mysql.cj.jdbc.Driver");
            dsc.setUsername("root");
            dsc.setPassword("629436");
            dsc.setUrl("jdbc:mysql://localhost:3306/shiro?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=Asia/Shanghai");
            mpg.setDataSource(dsc);

            // 包配置
            PackageConfig pc = new PackageConfig();
            pc.setParent("com.example.demo");
            pc.setController("controller");
            pc.setService("service");
            pc.setServiceImpl("service.impl");
            pc.setMapper("dao");
            pc.setEntity("entity");
            pc.setXml("mapper");
            mpg.setPackageInfo(pc);

            // 策略配置
            StrategyConfig strategy = new StrategyConfig();
            // 表前缀
            // strategy.setTablePrefix(new String[] { "sys_" });
            // 表名生成策略
            strategy.setNaming(NamingStrategy.underline_to_camel);
            strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//            strategy.setSuperEntityClass("你自己的父类实体,没有就不用设置!");
            strategy.setEntityLombokModel(true);
            strategy.setRestControllerStyle(true);
            // 公共父类
//            strategy.setSuperControllerClass("你自己的父类控制器,没有就不用设置!");
            // 写于父类中的公共字段
//            strategy.setSuperEntityColumns("id");
            // 需要生成的表
            strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
            strategy.setControllerMappingHyphenStyle(true);
            strategy.setTablePrefix(pc.getModuleName() + "_");
            strategy.setEntityTableFieldAnnotationEnable(true);

            mpg.setStrategy(strategy);
            // 执行生成
            mpg.execute();

    }

}
