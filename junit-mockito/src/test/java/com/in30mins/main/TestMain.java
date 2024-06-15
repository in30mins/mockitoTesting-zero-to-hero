package com.in30mins.main;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.in30mins.controller.GreetingsController;
import com.in30mins.service.WelcomeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(value = GreetingsController.class)
public class TestMain {
    @MockBean
    private WelcomeService welcomeService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test_main() throws Exception {
        when(welcomeService.getGreetings()).thenReturn("Hello world");
        MockHttpServletRequestBuilder req = MockMvcRequestBuilders.get("/api/v1/welcome");
        ResultActions perform = mockMvc.perform(req);
        MvcResult res = perform.andReturn();
        MockHttpServletResponse resp = res.getResponse();
        int status = resp.getStatus();
        assertEquals(200, status);
    }

    @Test
    public void test_Main1() throws Exception{
        when(welcomeService.getGreetings()).thenReturn("Hello world");
        mockMvc.perform(get("/api/v1/welcome")).andExpect(status().isOk());
    }
}
