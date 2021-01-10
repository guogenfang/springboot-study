package org.ggf.com.flux.service;

import lombok.extern.slf4j.Slf4j;
import org.ggf.com.flux.model.User;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 *[简要描述]: 
 * @Author ggf
 * @Date 2020/12/26 21:41
 **/
@Slf4j
@Service
public class UserServiceImpl implements UserService {
    // 预置两条数据，所以起始值从2开始
    private static final AtomicLong ID_GENERATOR = new AtomicLong(2);

    // 模拟数据库操作
    private static final Map<Integer, User> USER_MAP = new HashMap<>();

    static {
        User user1 = new User(1, "zhangsan");
        User user2 = new User(2, "lisi");
        USER_MAP.put(user1.getId(), user1);
        USER_MAP.put(user2.getId(), user2);
    }

    @Override
    public Mono<User> findById(Integer id) {
        log.info("find by id start id:{}", id);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Mono.just(USER_MAP.get(id));
    }

    public List<User> findAll() {
        return new ArrayList<>(USER_MAP.values());
    }

    @Override
    public Mono<User> save(User user) {
        return null;
    }
}
