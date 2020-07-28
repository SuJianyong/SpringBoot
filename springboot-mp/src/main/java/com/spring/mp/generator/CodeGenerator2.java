package com.spring.mp.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * @作者 苏健勇
 * @创建时间 2020/7/22 11:51
 * @描述
 */
public class CodeGenerator2 {

    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();
        // =============================全局配置===============================
        mpg.setGlobalConfig(new GlobalConfig()
                // 覆盖输出到xxx目录
                .setFileOverride(true).setOutputDir(System.getProperty("user.dir")+"/src/main/java")
//                .setFileOverride(true).setOutputDir("D://wly")
                // 主键生成策略 生成BaseResultMap
                .setIdType(IdType.UUID).setBaseResultMap(true)
                // 指定作者
                .setAuthor("sujy")
                // 设置Controller、Service、ServiceImpl、Dao、Mapper文件名称，%s是依据表名转换来的
                .setControllerName("%sController").setServiceName("MP%sService").setServiceImplName("%sServiceImpl").setMapperName("%sDao").setXmlName("%sMapper"));
        // ================================数据源配置============================
        mpg.setDataSource(new DataSourceConfig()
                // 用户名、密码、驱动、url
                .setUsername("root").setPassword("root")
                .setDbType(DbType.MYSQL).setDriverName("com.mysql.cj.jdbc.Driver")
                .setUrl("jdbc:mysql://localhost:3306/study?useSSL=false&serverTimezone=GMT%2B8")
        );
        // ===============================包名配置：父包.模块.controller===============================
        mpg.setPackageInfo(new PackageConfig()
                // 父包名 模块名
                .setParent("com.spring.mp").setModuleName("user")
                // 分层包名
                .setController("controller").setService("service").setServiceImpl("service.impl").setEntity("entity").setMapper("mapper"));
        // =====================================策略配置==================================
        mpg.setStrategy(new StrategyConfig()
                // 命名策略：实体的类名和属性名按下划线转驼峰 user_info -> userInfo
                .setNaming(NamingStrategy.underline_to_camel)
                // controller生成@RestCcontroller
                .setRestControllerStyle(true));
        // 执行生成
        mpg.execute();
    }
}
