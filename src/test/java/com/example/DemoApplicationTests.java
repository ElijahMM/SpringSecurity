package com.example;

import com.example.Models.User;
import com.example.TestUtils.TestData;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DemoApplicationTests {


    @Autowired
    MockMvc mockMvc;
    private String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtaWhhaSIsImV4cCI6MTQ5MTkxODEyOX0.TQJcR_iWrM39r7GmJDRV73r8-8soNofMemCB_6NpdU4jFvC0Z43V-3QFtP4lALKkkXtyOAjJoBj8pJP28R670Q";

    @Test
    public void testTest() {
        String str = "Junit is working fine";
        assertEquals("Junit is working fine", str);
    }
    /*
    @Test
    public void testGetAllUsersAndExpectStatusOk() throws Exception {
        this.mockMvc.perform(get("/api/user/all")
                .header("Authorization", token)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void testCreateNewUserAndExpectStatusCreated() throws Exception {

        User user = TestData.getDummyUser();
        Gson gson = new Gson();
        String json = gson.toJson(user);

        this.mockMvc.perform(post("/api/user/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().string("User created"))
                .andReturn();
    }

    @Test
    public void testGetUserAndExpectStatusOK() throws Exception {
        this.mockMvc.perform(get("/api/user/byID/1")
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", token))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }
*/
}
