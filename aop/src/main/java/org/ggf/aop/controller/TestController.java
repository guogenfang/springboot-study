package org.ggf.aop.controller;

import org.ggf.aop.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *[简要描述]: 
 * @Author ggf
 * @Date 2020/10/16 14:06
 **/
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/perform")
    public String perform() {
        testService.test("ggf", 0001121);
        return "fffff";
    }
}
