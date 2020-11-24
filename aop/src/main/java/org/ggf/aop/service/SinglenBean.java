package org.ggf.aop.service;

/**
 *[简要描述]: 
 * @Author ggf
 * @Date 2020/10/25 20:55
 **/
public class SinglenBean {
    private String name;

    public SinglenBean(String name) {
        this.name = name;
        System.out.println("new singleton  bean " + name);
    }

    public void test(Object original) {
        System.out.println(original);
    }
}
