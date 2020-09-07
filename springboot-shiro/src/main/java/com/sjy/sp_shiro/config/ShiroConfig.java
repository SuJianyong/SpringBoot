package com.sjy.sp_shiro.config;

import com.sjy.sp_shiro.shiro.realms.ShiroRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @作者 苏健勇
 * @创建时间 2020/9/7 14:46
 * @描述 shiro配置类
 */
@Configuration
public class ShiroConfig {

    // 1 过滤器
    @Bean
    public ShiroFilterFactoryBean getShiroFilter(DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);

        // 配置公共资源
        // 配置授权资源
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("/user/login", "anon"); // 公共资源放行
        filterChainDefinitionMap.put("/user/register", "anon"); // 公共资源放行
        filterChainDefinitionMap.put("/register.jsp", "anon"); // 公共资源放行
        filterChainDefinitionMap.put("/**", "authc"); // 请求这个资源需要认证和授权
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }
    // 2 安全管理器
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(Realm shiroRealm) {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(shiroRealm);
        return defaultWebSecurityManager;
    }

    // 3 自定义realm
    @Bean
    public Realm shiroRealm() {
        return new ShiroRealm();
    }
}
