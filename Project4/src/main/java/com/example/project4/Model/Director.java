package com.example.project4.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    @NotEmpty
    @Size(min = 3)
    @Column(columnDefinition = "varchar(40) not null")
    private String name;

}
