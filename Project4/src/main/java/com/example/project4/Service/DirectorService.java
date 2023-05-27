package com.example.project4.Service;

import com.example.project4.ApiException.ApiException;
import com.example.project4.Model.Director;

import com.example.project4.Repository.DirectorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DirectorService {
    private final DirectorRepository directorRepository;

    public List<Director> getAll() {
        return directorRepository.findAll();
    }

    public void addDirector(Director director) {
        directorRepository.save(director);
    }

    public void updateDirector(Integer id, Director director) {
        Director old = directorRepository.getDirectorById(id);
        if (old == null) {
            throw new ApiException("The Director does not exist");
        }
        old.setId(director.getId());
        old.setName(director.getName());
    }

    public void deleteDirector(Integer id) {
        Director old = directorRepository.getDirectorById(id);
        if (old == null) {
            throw new ApiException("Wrong Deleted");
        }
        directorRepository.delete(old);
    }

    public Director getDirectorById(Integer id) {
        Director director = directorRepository.getDirectorById(id);
        if (director == null) {
            throw new ApiException("Not Found");
        }
        return director;
    }

    public Director getDirectorByName(String name) {
        Director director = directorRepository.getDirectorByName(name);
        if (director == null) {
            throw new ApiException("Not Found");
        }
        return director;
    }
}
