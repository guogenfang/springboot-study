package org.ggf.aop;

import org.ggf.aop.service.TestService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 *[简要描述]: 
 * @Author ggf
 * @Date 2020/10/15 16:56
 **/
public class AopIntercepterTest extends SpringBootTestConfig {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private TestService testService;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }


    @Test
    public void performMapping() throws Exception {
        String contentAsString = mockMvc.perform(get("/perform"))
                .andReturn().getResponse().getContentAsString();
        System.out.println("get response: " + contentAsString);
    }

    @Test
    public void test2Service() {
        testService.test2();
    }

    @Test
    public void testService() {
        testService.test("ggf", 001234);
    }

}
