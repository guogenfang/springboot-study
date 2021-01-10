package org.ggf.com.flux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

/**
 *[简要描述]: 
 * @Author ggf
 * @Date 2020/12/26 21:32
 **/
@EnableWebFlux
@SpringBootApplication
public class FluxApplication {
    public static void main(String[] args) {
        SpringApplication.run(FluxApplication.class, args);
    }
}
