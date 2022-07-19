package com.example.SpringRESTAPILBD;

import com.example.SpringRESTAPILBD.teacher.Teacher;
import com.example.SpringRESTAPILBD.teacher.TeacherController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class TeacherApplicationTests {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private TeacherController teacherController;

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void getAllTeachers() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/api/teacher/all"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.[0].firstName", Is.is("Megan")));
    }

    @Test
    void getTeacher() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/api/teacher/2"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.subjectName", Is.is("BIOLOGY")));
    }

    @Test
    void addTeacher() throws Exception {
        mockMvc.perform( MockMvcRequestBuilders
                        .post("/api/teacher")
                        .content(asJsonString(new Teacher(0L, "David", "Bucket", "BIOLOGY")))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteTeacher() throws Exception
    {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/teacher/{id}", 1) )
                .andExpect(status().isOk());
    }

    @Test
    void getTeacherClass() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/api/teacher/{id}/class", 1))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andDo(print())
                .andExpect(jsonPath("$.[0].firstName", Is.is("Henry")));
    }

    @Test
    public void deleteStudentFromClassByTeacherId() throws Exception
    {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/teacher/{teacherId}/class/{studentId}", 1, 1))
                .andExpect(status().isOk())
                .andDo(print());
    }
}
