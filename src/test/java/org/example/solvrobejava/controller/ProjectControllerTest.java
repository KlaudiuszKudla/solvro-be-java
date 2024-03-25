package org.example.solvrobejava.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.solvrobejava.entity.*;
import org.example.solvrobejava.service.ProjectService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@WebMvcTest(controllers = ProjectController.class)
@AutoConfigureMockMvc()
class ProjectControllerTest {

    @MockBean
    private ProjectService projectService;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    private ProjectCreatorDTO projectCreatorDTO;
    @BeforeEach
    public void init(){
        DeveloperCreatorDTO developer = DeveloperCreatorDTO.builder()
                .name("Marcin")
                .lastName("Nowak")
                .email("marcin.nowak@gmail.com")
                .specialization(Specialization.FRONTEND)
                .build();
        List<DeveloperCreatorDTO> developers = new ArrayList<>();
        developers.add(developer);
        this.projectCreatorDTO = ProjectCreatorDTO.builder()
                .name("Weather app")
                .developers(developers)
                .build();

    }

    @Test
    public void Post_Project_Created() throws Exception{
        doAnswer(invocation -> null).when(projectService).addProject(any(ProjectCreatorDTO.class));
        var project = objectMapper.writeValueAsString(projectCreatorDTO);
        ResultActions response = mockMvc.perform(post("/api/v1/project")
                        .contentType(MediaType.APPLICATION_JSON)
                .content(project))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value("PROJECT_CREATED"));
    }

    @Test
    public void testProjectCreatorDTOValidation() throws Exception {
        String invalidProjectCreatorDTO = "{\"name\":\"Test\",\"developers\":[]}";
        doAnswer(invocation -> null).when(projectService).addProject(any(ProjectCreatorDTO.class));
        ResultActions response = mockMvc.perform(post("/api/v1/project")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(invalidProjectCreatorDTO))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }





}