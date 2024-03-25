package org.example.solvrobejava.entity;


import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


import java.util.List;

@Getter
@Setter
@Builder
public class ProjectCreatorDTO{

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Size(min = 5, max = 50, message = "nazwa powinna mieć od 5 do 50 znaków")
    private String name;
    @Valid
    List<DeveloperCreatorDTO> developers;

}

