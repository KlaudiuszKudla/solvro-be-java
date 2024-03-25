package org.example.solvrobejava.mapper;

import org.example.solvrobejava.entity.Project;
import org.example.solvrobejava.entity.ProjectCreatorDTO;
import org.mapstruct.Mapper;

@Mapper(uses = {DeveloperMapper.class})
public abstract class ProjectMapper {

    public abstract Project ProjectCreatorDTOToProject(ProjectCreatorDTO projectCreatorDTO);

}
