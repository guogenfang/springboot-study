package org.ggf.aop.controller;

import org.ggf.aop.TimesListen;
import org.ggf.aop.User;
import org.ggf.aop.service.TestService;
import org.ggf.aop.spel.LogAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 *[简要描述]: 
 * @Author ggf
 * @Date 2020/10/16 14:06
 **/
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    public static void main(String[] args) {
        User user = new User("Deniro", 13);
        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext context = new StandardEvaluationContext(user);
        Expression expression = parser.parseExpression("name");
        String result = expression.getValue(context, String.class);
        System.out.println("result:" + result);
    }

    @GetMapping("/perform")
    @TimesListen
    public String perform() {
        testService.test("ggf", 0001121);
        return "fffff";
    }

    @ModelAttribute(name = "user")
    public User getUser() {
        User u = new User();
        u.setAge(12);
        u.setName("ggf");
        return u;
    }

    @GetMapping("user")
    @LogAnnotation(operation = "查询", log = "#{user.id}")
    public Object get(@ModelAttribute(name = "user") User user, HttpServletRequest request) {
        request.setAttribute("user", user);
        return user;
    }
}
