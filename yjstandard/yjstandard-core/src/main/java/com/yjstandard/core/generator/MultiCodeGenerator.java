package com.yjstandard.core.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @作者 苏健勇
 * @创建时间 2020/8/6 14:51
 * @描述
 */
public class MultiCodeGenerator {

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
        // controller com.liveneo.system.web.controller
        //
//        String[] models = {"ls-dao","ls-dao","ls-service","ls-backend"};
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath);
        gc.setAuthor("SuJianyong");
        gc.setOpen(false);

        gc.setBaseResultMap(true);
        gc.setServiceName("%sService");
        gc.setDateType(DateType.ONLY_DATE);
        // gc.setSwagger2(true); 实体属性 Swagger2 注解
        mpg.setGlobalConfig(gc);

        //包名配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setModuleName(scanner("模块名"));
        packageConfig.setParent("com.yjstandard");
        mpg.setPackageInfo(packageConfig);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
//        dsc.setUrl("jdbc:mysql://localhost:3306/study?useSSL=false&serverTimezone=GMT%2B8");
//        dsc.setUrl("jdbc:mysql://localhost:3306/yjstandardex?useSSL=false&serverTimezone=GMT%2B8");
        dsc.setUrl("jdbc:mysql://localhost:3306/study?useSSL=false&serverTimezone=GMT%2B8");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        dsc.setDbType(DbType.MYSQL);
        dsc.setTypeConvert(new MySqlTypeConvert() {
            @Override
            public IColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
                String t = fieldType.toLowerCase();
                if (t.contains("tinyint")) {
                    return DbColumnType.BYTE;
                } else {

                    return super.processTypeConvert(globalConfig, fieldType);
                }
            }
        });
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("");
        pc.setEntity("com.yjstandard.core.module." + packageConfig.getModuleName() + ".entity");
        pc.setMapper("com.yjstandard.core.module."  + packageConfig.getModuleName() + ".mapper");
        pc.setService("com.yjstandard.core.module."  + packageConfig.getModuleName() + ".service");
        pc.setServiceImpl("com.yjstandard.core.module."  + packageConfig.getModuleName() + ".service.impl");
        pc.setController("com.yjstandard.app.controller." + packageConfig.getModuleName());
        mpg.setPackageInfo(pc);

        // 自定义配置

        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        // String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/yjstandard-core/src/main/resources/mapper/module/"
                        + packageConfig.getModuleName() + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        focList.add(new FileOutConfig("/templates/controller.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/yjstandard-app/src/main/java/com/yjstandard/app/controller/"
                        + packageConfig.getModuleName() + "/" + tableInfo.getEntityName() + "Controller" + StringPool.DOT_JAVA;
            }
        });
        focList.add(new FileOutConfig("/templates/service.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/yjstandard-core/src/main/java/com/yjstandard/core/module/"
                        + packageConfig.getModuleName() + "/service/" + tableInfo.getEntityName() + "Service" + StringPool.DOT_JAVA;
            }
        });
        focList.add(new FileOutConfig("/templates/serviceImpl.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/yjstandard-core/src/main/java/com/yjstandard/core/module/"
                        + packageConfig.getModuleName() + "/service/impl/" + tableInfo.getEntityName() + "ServiceImpl" + StringPool.DOT_JAVA;
            }
        });
        focList.add(new FileOutConfig("/templates/mapper.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/yjstandard-core/src/main/java/com/yjstandard/core/module/"
                        + packageConfig.getModuleName() + "/mapper/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_JAVA;
            }
        });
        focList.add(new FileOutConfig("/templates/entity.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/yjstandard-core/src/main/java/com/yjstandard/core/module/"
                        + packageConfig.getModuleName() + "/entity/" + tableInfo.getEntityName() + StringPool.DOT_JAVA;
            }
        });
        /*
        cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // 判断自定义文件夹是否需要创建
                checkDir("调用默认方法创建的目录");
                return false;
            }
        });
        */
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // templateConfig.setEntity("templates/entity2.java");
        // templateConfig.setService();
        // templateConfig.setController();

        templateConfig.setEntity(null);
        templateConfig.setController(null);
        templateConfig.setService(null);
        templateConfig.setServiceImpl(null);
        templateConfig.setMapper(null);
        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
//        strategy.setTablePrefix("sc_");
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//        strategy.setSuperEntityClass("com.xxx.xx.base.mybatiesplus.BaseEntity");
        strategy.setEntityLombokModel(true);
//        strategy.setSuperServiceClass("com.xxx.xx.base.mybatiesplus.IBaseService");
//        strategy.setSuperServiceImplClass("com.xxx.xx.base.mybatiesplus.impl.BaseServiceImpl");
        strategy.setRestControllerStyle(true);
        // 公共父类
//        strategy.setSuperControllerClass("com.xxx.xx.pc.base.controller.BaseController");
        // 写于父类中的公共字段
//        strategy.setSuperEntityColumns("id", "create_by", "create_time", "update_by", "update_time");
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        //使用驼峰mapper映射名
        strategy.setControllerMappingHyphenStyle(false);
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();

    }
}
