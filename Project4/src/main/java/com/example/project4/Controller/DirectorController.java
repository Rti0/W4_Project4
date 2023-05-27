package com.example.project4.Controller;

import com.example.project4.Model.Director;
import com.example.project4.Service.DirectorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/director")
@RequiredArgsConstructor
public class DirectorController {
    private final DirectorService directorService;

    @GetMapping("/get1")
    public ResponseEntity getAll(){
    List<Director> directors=directorService.getAll();
    return ResponseEntity.status(200).body(directors);
    }


    @PostMapping("/add1")
    public ResponseEntity add(@Valid @RequestBody Director director){
        directorService.addDirector(director);
        return ResponseEntity.status(200).body("Director added");
    }


    @PutMapping("/update1/{id}")
    public ResponseEntity update(@PathVariable Integer id,@Valid @RequestBody Director director){
        directorService.updateDirector(id, director);
        return ResponseEntity.status(200).body("Director updated");
    }


    @DeleteMapping("/delete1/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        directorService.deleteDirector(id);
        return ResponseEntity.status(200).body("Director deleted");
    }
@GetMapping("/get-id1/{id}")
    public ResponseEntity getDirectorById(@PathVariable Integer id){
       Director director= directorService.getDirectorById(id);
       return ResponseEntity.status(200).body(director);

}
    @GetMapping("/get-name1/{name}")
    public ResponseEntity getDirectorByName(@PathVariable String name){
        Director director= directorService.getDirectorByName(name);
        return ResponseEntity.status(200).body(director);
    }
}
