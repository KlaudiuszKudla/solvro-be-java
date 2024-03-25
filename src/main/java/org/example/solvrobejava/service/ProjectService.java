package org.example.solvrobejava.service;

import lombok.RequiredArgsConstructor;
import org.example.solvrobejava.entity.*;
import org.example.solvrobejava.mapper.ProjectMapper;
import org.example.solvrobejava.repository.ProjectRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;
    public void addProject(ProjectCreatorDTO projectCreatorDTO) {
        Project project = projectMapper.ProjectCreatorDTOToProject(projectCreatorDTO);
        projectRepository.saveAndFlush(project);
    }
}
