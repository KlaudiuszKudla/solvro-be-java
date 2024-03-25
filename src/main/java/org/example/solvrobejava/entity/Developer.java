package org.example.solvrobejava.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "developer")
public class Developer {

    @Id
    @GeneratedValue(generator = "developer_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "developer_id_seq", sequenceName = "developer_id_seq", allocationSize = 1)
    private Long id;
    private String name;
    private String lastName;
    private String email;
    @Enumerated(EnumType.STRING)
    private Specialization specialization;
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE,
                    CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name = "project_developer",
            joinColumns = @JoinColumn(name = "developer_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id")
    )
    private List<Project> projects;
}
