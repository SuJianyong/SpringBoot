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
import org.springframework.context.annotation.Primary;
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
@MapperScan(basePackages = {YjstandardDbConfig.BASE_PACKAGE}, sqlSessionTemplateRef = "yjstandardSqlSessionFactory")
public class YjstandardDbConfig {

    static final String BASE_PACKAGE = "com.yjstandard.core.module.yjstandard.mapper";
    static final String MAPPING_LOCATION = "classpath:mapper/module/yjstandard/*Mapper.xml";

    @Bean("yjstandardDataSource")
    @Primary
    @ConfigurationProperties("spring.datasource.yjstandard")
    public DataSource yjstandardDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name="yjstandardSqlSessionFactory")
    @Primary
    public SqlSessionFactory baseSqlSessionFactory(@Qualifier("yjstandardDataSource")DataSource dataSource) throws Exception{
        // 创建Mybatis的连接会话工厂实例
        MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
        bean.setDataSource(dataSource); // 设置数据源bean
        // 添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        bean.setMapperLocations(resolver.getResources(YjstandardDbConfig.MAPPING_LOCATION)); // 设置mapper文件路径
        return bean.getObject();
    }

    @Bean(name="yjstandardSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate baseSqlSessionTemplate(@Qualifier("yjstandardSqlSessionFactory")SqlSessionFactory sqlSessionFactory) {
        return  new SqlSessionTemplate(sqlSessionFactory); // 使用上面配置的Factory
    }

    @Bean(name = "yjstandardTransactionManager")
    @Primary
    public DataSourceTransactionManager dataSourceTransactionManager(@Qualifier("yjstandardDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}
