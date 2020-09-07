package com.sjy.sp_shiro.shiro.realms;

import com.sjy.sp_shiro.entity.User;
import com.sjy.sp_shiro.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @作者 苏健勇
 * @创建时间 2020/9/7 14:55
 * @描述
 */
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("认证========================");
        String principal = (String)authenticationToken.getPrincipal();
        String credentials = new String((char[])authenticationToken.getCredentials());
        User user = userService.selectByUserName(principal);
        if (user != null) {
            Md5Hash md5Hash = new Md5Hash(credentials, user.getSalt(), 1024);
            if (user.getUsername().equals(principal) && user.getPassword().equals(md5Hash.toString())) {
                return new SimpleAuthenticationInfo(principal, credentials, this.getName());
            }
        }
        return null;
    }
}
