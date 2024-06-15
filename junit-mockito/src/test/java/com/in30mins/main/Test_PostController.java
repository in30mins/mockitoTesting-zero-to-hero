package com.in30mins.main;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.in30mins.controller.PostController;
import com.in30mins.entity.Employee;
import com.in30mins.service.EmpService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(value = PostController.class)
public class Test_PostController {
    @MockBean
    private EmpService empService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test_post() throws Exception {
        when(empService.saveEmp(ArgumentMatchers.any())).thenReturn(true);
        Employee emp = new Employee(123,"RajGopal",400000.0);
        ObjectMapper mapper = new ObjectMapper();
        String empJson = mapper.writeValueAsString(emp);
        MockHttpServletRequestBuilder req = MockMvcRequestBuilders.post("/api/v1/addEmp")
                .contentType(MediaType.APPLICATION_JSON).content(empJson);
        ResultActions per = mockMvc.perform(req);
        MvcResult res = per.andReturn();
        MockHttpServletResponse resp = res.getResponse();
        int status = resp.getStatus();
        assertEquals(201, status);
    }

    @Test
    public void test_Post() throws Exception {
        when(empService.saveEmp(ArgumentMatchers.any())).thenReturn(true);
        Employee emp = new Employee(123,"RajGopal",400000.0);
        ObjectMapper mapper = new ObjectMapper();
        String empJson = mapper.writeValueAsString(emp);

        mockMvc.perform(post("/api/v1/addEmp")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(empJson))
                .andExpect(status().isCreated());
    }

    @Test
    public void test_Post1() throws Exception {
        when(empService.saveEmp(ArgumentMatchers.any())).thenReturn(false);
        Employee emp = new Employee(123,"RajGopal",400000.0);
        ObjectMapper mapper = new ObjectMapper();
        String empJson = mapper.writeValueAsString(emp);

        mockMvc.perform(post("/api/v1/addEmp")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(empJson))
                .andExpect(status().isBadRequest());
    }
}
