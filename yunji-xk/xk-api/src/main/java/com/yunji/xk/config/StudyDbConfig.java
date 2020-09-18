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
@MapperScan(basePackages = {StudyDbConfig.BASE_PACKAGE},
        sqlSessionFactoryRef  = "studySqlSessionFactory",
        sqlSessionTemplateRef = "studySqlSessionTemplate")
public class StudyDbConfig {

    static final String BASE_PACKAGE = "com.yunji.xk.kamailio.dao";

    private static final String MAPPING_LOCATION = "classpath:mappers/kamailio/*.xml";

//    private MybatisConfiguration studyGlobalConfig;


    @Bean("studyDataSource")
    @ConfigurationProperties("spring.datasource.druid.study")
    public DataSource studyDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

//    @Autowired
//    public void setStudyGlobalConfig(@Qualifier("globalConfig") MybatisConfiguration globalConfig) {
//        this.studyGlobalConfig = globalConfig;
//    }

    @Bean("studySqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("studyDataSource") DataSource dataSource) throws Exception {
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

    @Bean(name="studySqlSessionTemplate")
    public SqlSessionTemplate baseSqlSessionTemplate(@Qualifier("studySqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return  new SqlSessionTemplate(sqlSessionFactory); // 使用上面配置的Factory
    }

    @Primary
    @Bean(name = "studyTransactionManager")
    public DataSourceTransactionManager dataSourceTransactionManager(@Qualifier("studyDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
