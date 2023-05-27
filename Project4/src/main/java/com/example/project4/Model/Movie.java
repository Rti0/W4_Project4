package com.example.project4.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotEmpty
    @Size(min = 3)
    @Column(columnDefinition = "varchar(20) not null")
    private String name;


    @NotEmpty
    @Column(columnDefinition = "varchar(20) not null check(genre='Drama' or genre='Action' or genre='Comedy')")
    private String genre;

    @NotNull
    @Min(value = 1)
    @Max(value = 5)
    @Column(columnDefinition = "int not null")
    private Integer rating;


    @NotNull
    @Min(60)
    @Column(columnDefinition = "int not null")
    private Integer duration;


    @NotNull
    @Column(columnDefinition = "int not null")
    private Integer directorId;

}
