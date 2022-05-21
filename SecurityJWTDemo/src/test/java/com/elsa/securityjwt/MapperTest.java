package com.elsa.securityjwt;

import com.elsa.securityjwt.domain.User;
import com.elsa.securityjwt.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootTest
public class MapperTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void testBCryptPasswordEncoder() {
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        String encode = bCryptPasswordEncoder.encode("1234");
//        String encode2 = bCryptPasswordEncoder.encode("1234");
//        System.out.println(encode);
//        System.out.println(encode2);
        System.out.println(passwordEncoder
                .matches("1234", "$2a$10$htHopE63Hjrb1o2gZDFYxuNqdsIfITRsVp1I5GlCkatP2GhdIh..C"));
    }

    @Test
    public void testUserMapper() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }
}
