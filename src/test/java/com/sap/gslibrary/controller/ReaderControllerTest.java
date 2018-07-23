//package com.sap.gslibrary.controller;
//
//import java.util.Date;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//import com.sap.gslibrary.entity.Reader;
//import com.sap.gslibrary.service.ReaderService;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureMockMvc
//public class ReaderControllerTest {
//
//	@Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ReaderService readersService;
//
//    private String userId = "I326864";
//    private String name = "Santiago";
//    private int borrowBooksCount = 2;
//    private Date lastModified = new Date();
//
//    @Before
//    public void setUp() throws Exception {
//        Reader reader = new Reader(userId, name, borrowBooksCount, lastModified);
//        readersService.insertReader(reader);
//    }
//
//    @Test
//    public void testInsertReaders() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.post("/reader/reader")
//                .param("userId", "I333666")
//                .param("name", "Kai")
//                .param("borrowBooksCount", "2"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().json("{\"userId\":\"I333666\",\"name\":\"Kai\",\"borrowBooksCount\":2}"));
////                .andExpect(MockMvcResultMatchers.content().json("{\"id\":4,\"userId\":\"I333666\",\"name\":\"Kai\",\"borrowBooksCount\":2}"));
//    }
//
//    @Test
//    public void testFindByName() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/readers/readers")
//                .param("name", name))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().json("[{\"userId\":\"I326864\",\"name\":\"Santiago\",\"borrowBooksCount\":2}]"));
////                .andExpect(MockMvcResultMatchers.content().json("[{\"id\":1,\"userId\":\"I326864\",\"name\":\"Santiago\",\"borrowBooksCount\":2}]"));
//    }
//
//    @Test
//    public void testUpdateReaders() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.put("/readers/reader")
//                .param("id", "1")
//                .param("userId", "I333666")
//                .param("name", "Kai")
//                .param("borrowBooksCount", "3"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().json("{\"id\":1,\"userId\":\"I333666\",\"name\":\"Kai\",\"borrowBooksCount\":3}"));
//    }
//
//    @Test
//    public void testDeleteById() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.delete("/readers/reader")
//                .param("id", "1"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().string(""));
//    }
//
//}
