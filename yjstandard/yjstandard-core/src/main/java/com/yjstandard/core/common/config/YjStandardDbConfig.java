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
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @作者 苏健勇
 * @创建时间 2020/8/6 17:23
 * @描述
 */
@Component
@Configuration
@MapperScan(basePackages  = "com.yjstandard.core.module.yjstandard.mapper", sqlSessionTemplateRef  = "yjstandardSqlSessionFactory")
public class YjStandardDbConfig {
    @ConfigurationProperties(prefix = "spring.datasource.druid.yjstandard")
    @Bean(name = "yjstandardDatasource")
    @Primary
    public DataSource dataSource1() throws SQLException {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "yjstandardSqlSessionFactory")
    @Primary
    public SqlSessionFactory sqlSessionFactory1(@Qualifier(value = "yjstandardDatasource") DataSource dataSource,
//                                                PaginationInterceptor paginationInterceptor,
                                                @Qualifier(value = "globalConfiguration1") GlobalConfiguration globalConfiguration) throws Exception {
        MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper1/*.xml"));
//        Interceptor[] interceptors = new Interceptor[]{paginationInterceptor};
        bean.setPlugins(interceptors);
        bean.setGlobalConfig(globalConfiguration);
        return bean.getObject();
    }

    @ConfigurationProperties(prefix = "globalConfig1")
    @Bean(name = "globalConfiguration1")
    public GlobalConfiguration globalConfiguration1() {
        return new GlobalConfiguration();
    }


    @Bean(name = "yjstandardTransactionManager")
    @Primary
    public DataSourceTransactionManager dataSourceTransactionManager(@Qualifier("yjstandardDatasource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "yjstandardSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("yjstandardSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
