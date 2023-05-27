package com.example.project4.Repository;

import com.example.project4.Model.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DirectorRepository extends JpaRepository<Director,Integer> {

    Director getDirectorById(Integer id);
    Director getDirectorByName(String name);
}
