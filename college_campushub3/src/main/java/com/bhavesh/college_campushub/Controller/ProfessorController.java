package com.bhavesh.college_campushub.Controller;

import com.bhavesh.college_campushub.Services.ProfessorService;
import com.bhavesh.college_campushub.entity.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    // Create
    @PostMapping
    public Professor createProfessor(@RequestBody Professor professor){
        return professorService.saveProfessor(professor);
    }

    // Get All
    @GetMapping
    public List<Professor> getAllProfessors(){
        return professorService.getAllProfessors();
    }

    // Get By Id
    @GetMapping("/{id}")
    public Optional<Professor> getProfessorById(@PathVariable String id){
        return professorService.getProfessorById(id);
    }

    // Update
    @PutMapping("/{id}")
    public Professor updateProfessor(@PathVariable String id,
                                     @RequestBody Professor professor){
        return professorService.updateProfessor(id, professor);
    }

    // Delete
    @DeleteMapping("/{id}")
    public String deleteProfessor(@PathVariable String id){

        professorService.deleteProfessor(id);

        return "Professor Deleted Successfully";
    }
}