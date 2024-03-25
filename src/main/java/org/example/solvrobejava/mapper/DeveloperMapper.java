package org.example.solvrobejava.mapper;

import org.example.solvrobejava.entity.Developer;
import org.example.solvrobejava.entity.DeveloperCreatorDTO;
import org.mapstruct.Mapper;

@Mapper
public abstract class DeveloperMapper {

    public abstract Developer DeveloperCreatorDTOToDeveloper(DeveloperCreatorDTO developerCreatorDTO);
}
