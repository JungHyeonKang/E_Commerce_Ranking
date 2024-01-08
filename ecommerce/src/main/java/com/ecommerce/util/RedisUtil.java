package com.ecommerce.util;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RedisUtil {

    private final RedisTemplate<String, Object> redisTemplate;

    public void set(String key , Object value){
        redisTemplate.opsForValue().set(key, value);
    }

    public Object get(String key){
        return redisTemplate.opsForValue().get(key);
    }


}
