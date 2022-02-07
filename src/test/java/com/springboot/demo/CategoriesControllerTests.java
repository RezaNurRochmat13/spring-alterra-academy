package com.springboot.demo;

import com.springboot.demo.controller.CategoriesController;
import com.springboot.demo.repository.CategoryRepository;
import net.minidev.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@WebMvcTest
@AutoConfigureMockMvc
public class CategoriesControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CategoryRepository categoryRepository;

    @MockBean
    private CategoriesController categoriesController;

    @Test
    public void getAllCategories() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
        .get("/api/categories")
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON);

        MvcResult response = mockMvc
        .perform(requestBuilder)
        .andReturn();

        assertEquals(200, response.getResponse().getStatus());

    }

    @Test
    public void postCreateCategoryWithPayload() throws Exception {
        JSONObject payload = new JSONObject();

        payload.put("name", "Magazine");
        payload.put("description", "");

        RequestBuilder requestBuilder = MockMvcRequestBuilders
        .post("/api/categories")
        .contentType(MediaType.APPLICATION_JSON)
        .content(payload.toJSONString())
        .accept(MediaType.APPLICATION_JSON);

        MvcResult response = mockMvc
        .perform(requestBuilder)
        .andReturn();

        assertEquals(200, response.getResponse().getStatus());
    }

    @Test
    public void postCreateCategoryWithoutPayload() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
        .post("/api/categories")
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON);

        MvcResult response = mockMvc
        .perform(requestBuilder)
        .andReturn();

        assertEquals(400, response.getResponse().getStatus());
    }
}
