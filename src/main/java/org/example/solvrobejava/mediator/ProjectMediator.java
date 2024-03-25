package org.example.solvrobejava.mediator;

import lombok.RequiredArgsConstructor;
import org.example.solvrobejava.entity.ProjectCreatorDTO;
import org.example.solvrobejava.entity.Response;
import org.example.solvrobejava.service.DeveloperService;
import org.example.solvrobejava.service.ProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProjectMediator {

    private final DeveloperService developerService;
    private final ProjectService projectService;


    public ResponseEntity<Response> addProject(ProjectCreatorDTO project) {
        return null;
    }
}
