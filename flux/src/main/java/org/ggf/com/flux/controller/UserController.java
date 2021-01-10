package org.ggf.com.flux.controller;

import lombok.extern.slf4j.Slf4j;
import org.ggf.com.flux.model.User;
import org.ggf.com.flux.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 *[简要描述]: 
 * @Author ggf
 * @Date 2020/12/26 21:43
 **/
@Slf4j
@RestController
@RequestMapping("/rx/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/list")
    public Flux<User> list() {
        return Flux.fromStream(Arrays.asList(new User()).stream());
    }

    @GetMapping(value = "/find/{id}")
    public Mono<User> findById(@PathVariable Long id) {
        return Mono.just(new User());
    }

    @GetMapping("/{id}")
    public Mono<User> findUserById(@PathVariable("id") Integer id) {
        log.info("moni find user by id:{}", id);
        return this.userService.findById(id);
    }

    @GetMapping("/a/{id}")
    public User commonFindUserById(@PathVariable("id") Integer id) {
        log.info("common find user by id:{}", id);
        return new User();
    }

    // WebFlux(返回的是Mono)
    @GetMapping("/2")
    private Mono<String> get2() {
        log.info("get2 start");
        Mono<String> result = Mono.fromSupplier(() -> createStr());
        log.info("get2 end.");
        return result;
    }

    @GetMapping(value = "/3", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    private Flux<String> flux() {
        Flux<String> result = Flux
                .fromStream(IntStream.range(1, 5).mapToObj(i -> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                    }
                    return "flux data--" + i;
                }));
        return result;
    }

    // 阻塞5秒钟
    private String createStr() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
        }
        return "some string";
    }
}