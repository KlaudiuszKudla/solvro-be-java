package org.example.solvrobejava.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(generator = "project_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "project_id_seq", sequenceName = "project_id_seq", allocationSize = 1)
    private Long id;
    private String name;
    @ManyToMany(fetch = FetchType.LAZY,
                cascade = {CascadeType.DETACH, CascadeType.MERGE,
                CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name = "project_developer",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "developer_id")
    )
    private List<Developer> developers;




}
