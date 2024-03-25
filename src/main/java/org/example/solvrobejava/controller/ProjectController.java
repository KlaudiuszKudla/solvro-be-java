package org.example.solvrobejava.controller;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.solvrobejava.entity.*;
import org.example.solvrobejava.mediator.ProjectMediator;
import org.example.solvrobejava.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/api/v1/project")
public class ProjectController {

    private final ProjectService projectService;
    @PostMapping
    public ResponseEntity<Response> addProject(@RequestBody @Valid ProjectCreatorDTO project){
        this.projectService.addProject(project);
        return ResponseEntity.status(HttpStatus.CREATED).body(new Response(Code.PROJECT_CREATED));
    }





//    @GetMapping
//    public ResponseEntity<List<Project>> getProjects
}
