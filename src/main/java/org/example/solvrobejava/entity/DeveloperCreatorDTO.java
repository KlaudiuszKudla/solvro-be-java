package org.example.solvrobejava.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DeveloperCreatorDTO {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Size(min = 5,max = 50, message = "Imie powinno mieć od 5 do 50 znaków")
    private String name;
    @Size(min = 5,max = 50, message = "Nazwisko powinno mieć od 5 do 50 znaków")
    private String lastName;
    @Email(message = "Niepoprawny format email")
    private String email;
    private Specialization specialization;
}
