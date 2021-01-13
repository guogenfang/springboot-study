package org.ggf.aop.spel;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 *[简要描述]: 
 * @Author ggf
 * @Date 2021/1/10 19:28
 **/
public class SpELTest {

    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("6-3");
        Integer message = (Integer) exp.getValue();
        System.out.println(message);
    }
}
