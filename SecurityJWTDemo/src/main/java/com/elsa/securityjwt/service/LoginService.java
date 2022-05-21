package com.elsa.securityjwt.service;

import com.elsa.securityjwt.domain.ResponseResult;
import com.elsa.securityjwt.domain.User;

public interface LoginService {
    ResponseResult login(User user);
}
