package com.elsa.securityjwt.service.impl;

import com.elsa.securityjwt.domain.LoginUser;
import com.elsa.securityjwt.domain.ResponseResult;
import com.elsa.securityjwt.domain.User;
import com.elsa.securityjwt.service.LoginService;
import com.elsa.securityjwt.utils.JwtUtil;
import com.elsa.securityjwt.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisCache redisCache;


    @Override
    public ResponseResult login(User user) {

        // AuthenticationManager authenticate 进行用户认证
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);

        // 如果没有通过，则给出对应的提示
        if(Objects.isNull(authenticate)) {
            throw new RuntimeException("登录失败");
        }

        // 认证通过，根据userid去生成一个jwt，jwt存入ResponseResult返回
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String userid = loginUser.getUser().getId().toString();
        String jwt = JwtUtil.createJWT(userid);
        Map<String, String> map = new HashMap<>();
        map.put("token", jwt);

        // 把用户信息存入redis，userid做完key
        redisCache.setCacheObject("login:" + userid, loginUser);
//        System.out.println("login:" + userid);
//        System.out.println(loginUser);
        return new ResponseResult(200, "登录成功", map);
    }
}
