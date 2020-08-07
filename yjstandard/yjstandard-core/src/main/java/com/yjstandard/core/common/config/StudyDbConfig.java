package com.yjstandard.core.common.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @作者 苏健勇
 * @创建时间 2020/8/7 9:19
 * @描述
 */
@Configuration
@MapperScan(basePackages = {StudyDbConfig.BASE_PACKAGE}, sqlSessionTemplateRef = "studySqlSessionFactory")
public class StudyDbConfig {

    static final String BASE_PACKAGE = "com.yjstandard.core.module.study.mapper";
    static final String MAPPING_LOCATION = "classpath:mapper/module/study/*Mapper.xml";

    @Bean(name="studyDataSource")
    @ConfigurationProperties(prefix="spring.datasource.druid.study") // prefix值必须是application.properteis中对应属性的前缀
    public DataSource baseDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name="studySqlSessionFactory")
    public SqlSessionFactory baseSqlSessionFactory(@Qualifier("studyDataSource")DataSource dataSource) throws Exception {
        // 创建Mybatis的连接会话工厂实例
        MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
        bean.setDataSource(dataSource); // 设置数据源bean
        // 添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        bean.setMapperLocations(resolver.getResources(StudyDbConfig.MAPPING_LOCATION)); // 设置mapper文件路径
        return bean.getObject();
    }

    @Bean(name="studySqlSessionTemplate")
    public SqlSessionTemplate baseSqlSessionTemplate(@Qualifier("studySqlSessionFactory")SqlSessionFactory sqlSessionFactory) {
        return  new SqlSessionTemplate(sqlSessionFactory); // 使用上面配置的Factory
    }

    @Bean(name = "studyTransactionManager")
    public DataSourceTransactionManager dataSourceTransactionManager(@Qualifier("studyDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}
