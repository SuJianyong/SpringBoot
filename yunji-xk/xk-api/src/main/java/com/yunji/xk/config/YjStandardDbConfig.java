package com.yunji.xk.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @作者 苏健勇
 * @创建时间 2020/8/8 15:57
 * @描述
 */
@Configuration
@MapperScan(basePackages = {YjStandardDbConfig.BASE_PACKAGE},
        sqlSessionFactoryRef  = "yjStandardSqlSessionFactory",
        sqlSessionTemplateRef = "yjStandardSqlSessionTemplate")
public class YjStandardDbConfig {

    static final String BASE_PACKAGE = "com.yunji.xk.yjstandard.dao";

    private static final String MAPPING_LOCATION = "classpath:mappers/yjstandard/*.xml";

//    private MybatisConfiguration yjStandardGlobalConfig;

    @Primary
    @Bean("yjStandardDataSource")
    @ConfigurationProperties("spring.datasource.druid.yjstandard")
    public DataSource yjStandardDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

//    @Autowired
//    public void setYjStandardGlobalConfig(@Qualifier("globalConfig") MybatisConfiguration globalConfig) {
//        this.yjStandardGlobalConfig = globalConfig;
//    }

    @Primary
    @Bean("yjStandardSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("yjStandardDataSource") DataSource dataSource) throws Exception {
        MybatisSqlSessionFactoryBean factoryBean = new MybatisSqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPING_LOCATION));
        factoryBean.setPlugins(new Interceptor[]{
            new PaginationInterceptor()
        });
        MybatisConfiguration configuration = new MybatisConfiguration();
        configuration.setJdbcTypeForNull(JdbcType.NULL);
        configuration.setMapUnderscoreToCamelCase(true);
        configuration.setCacheEnabled(false);
        factoryBean.setConfiguration(configuration);
        return factoryBean.getObject();
    }

    @Primary
    @Bean(name="yjStandardSqlSessionTemplate")
    public SqlSessionTemplate baseSqlSessionTemplate(@Qualifier("yjStandardSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return  new SqlSessionTemplate(sqlSessionFactory); // 使用上面配置的Factory
    }

    @Primary
    @Bean(name = "yjStandardTransactionManager")
    public DataSourceTransactionManager dataSourceTransactionManager(@Qualifier("yjStandardDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
