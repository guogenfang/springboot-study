package org.ggf.com.flux.service;

import org.ggf.com.flux.model.User;
import reactor.core.publisher.Mono;

/**
 *[简要描述]: 
 * @Author ggf
 * @Date 2020/12/26 21:37
 **/
public interface UserService {
    Mono<User> findById(Integer id);

    Mono<User> save(User user);
}
