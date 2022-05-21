package com.elsa.securityjwt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.elsa.securityjwt.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
