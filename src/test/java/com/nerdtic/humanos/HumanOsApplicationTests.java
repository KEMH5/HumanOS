package com.nerdtic.humanos;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.crypto.KeyGenerator;
import java.security.NoSuchAlgorithmException;

@SpringBootTest
class HumanOsApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void generateSignKey() throws NoSuchAlgorithmException {
        var keyGen = KeyGenerator.getInstance("HmacSHA256");
        var secretKey = Keys.hmacShaKeyFor(SignatureAlgorithm.HS256.toString().getBytes());
        System.out.println(secretKey.toString());
    }


}
