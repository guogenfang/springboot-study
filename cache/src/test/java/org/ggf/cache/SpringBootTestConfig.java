package org.ggf.cache;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(value = {
        "dubbo.enabled=false",
        "spring.datasource.tomcat.initial-size=1",
        "spring.aop.auto=false"
},webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

abstract class SpringBootTestConfig {

}
