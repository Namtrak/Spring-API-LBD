//package com.example.SpringRESTAPILBD;
//
//import com.example.SpringRESTAPILBD.filters.AuthorizationStudentFilter;
//import com.example.SpringRESTAPILBD.student.Student;
//import com.example.SpringRESTAPILBD.student.StudentController;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.hamcrest.core.Is;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class StudentApplicationTests {
//    @Autowired
//    private MockMvc mockMvc;
//    @Autowired
//    private StudentController studentController;
//    @Autowired
//    private AuthorizationStudentFilter authorizationStudentFilter;
//
//    public static String asJsonString(final Object obj) {
//        try {
//            return new ObjectMapper().writeValueAsString(obj);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Test
//    void getAllStudents() throws Exception{
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/student/all").header("role", "TEACHER_ROLE"))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$").isArray())
//                .andExpect(jsonPath("$.[0].firstName", Is.is("Maria")))
//                .andDo(print());
//    }
//
//    @Test
//    void getStudent() throws Exception{
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/student/4").header("role", "TEACHER_ROLE"))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.age", Is.is(26)))
//                .andDo(print());
//    }
//
//    @Test
//    void addStudent() throws Exception {
//        mockMvc.perform( MockMvcRequestBuilders.post("/api/student").header("role", "TEACHER_ROLE")
//                .content(asJsonString(new Student(0L, "David", "Bucket", 20, new ArrayList<>(List.of("BIOLOGY", "LAW")))))
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    void updateStudent() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.put("/api/student/{id}", 0).header("role", "TEACHER_ROLE")
//                .content(asJsonString(new Student(0L, "Bella", "Donno", 20, new ArrayList<>(List.of("LAW")))))
//                .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andDo(print());
////                .andExpect(jsonPath("$.age", Is.is(20)))
////                .andReturn().getResponse().getContentAsString();
////                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value("Mateo"))
////                .andExpect(jsonPath("$.lastName", Is.is("Donno")))
////                .andExpect(jsonPath("$.age").value(20));
//    }
//
//    @Test
//    public void deleteStudent() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.delete("/api/student/{id}", 1).header("role", "TEACHER_ROLE"))
//                .andExpect(status().isOk());
//    }
//}
