package com.vwake.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vwake.records.OperationRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@ContextConfiguration(classes = {ProblemDetailsController.class})
@WebAppConfiguration
class ProblemDetailsControllerTest {

    @Autowired
    MockMvc mockMvc;


    @Test
    public void testPostOperation() throws Exception {
        OperationRequest operationRequest =
                new OperationRequest(100.00,10.0);
        ObjectMapper objectMapper = new ObjectMapper();
        mockMvc.perform(MockMvcRequestBuilders.post("/error/post")
                .content(objectMapper.writeValueAsString(operationRequest))
                .contentType(MediaType.APPLICATION_JSON)
                ).andDo(MockMvcResultHandlers.print())
                .andExpectAll(status().isBadRequest(),
                        jsonPath("$.title").value(HttpStatus.BAD_REQUEST.getReasonPhrase()),
                        jsonPath("$.status").value(HttpStatus.BAD_REQUEST.value()),
                        jsonPath("$.detail").value("Free sale is not allowed"),
                        jsonPath("$.instance").value("discount"))
                .andReturn();
    }

}