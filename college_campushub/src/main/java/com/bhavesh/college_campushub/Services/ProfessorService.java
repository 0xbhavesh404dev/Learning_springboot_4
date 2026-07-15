package com.bhavesh.college_campushub.Services;

import com.bhavesh.college_campushub.Repository.ProfessorRepository;
import com.bhavesh.college_campushub.entity.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    // Create
    public Professor saveProfessor(Professor professor){
        return professorRepository.save(professor);
    }

    // Get All
    public List<Professor> getAllProfessors(){
        return professorRepository.findAll();
    }

    // Get By Id
    public Optional<Professor> getProfessorById(String id){
        return professorRepository.findById(id);
    }

    // Update
    public Professor updateProfessor(String id, Professor updatedProfessor){

        Optional<Professor> optionalProfessor = professorRepository.findById(id);

        if(optionalProfessor.isPresent()){

            Professor professor = optionalProfessor.get();

            professor.setName(updatedProfessor.getName());
            professor.setEmail(updatedProfessor.getEmail());
            professor.setPhone(updatedProfessor.getPhone());
            professor.setDesignation(updatedProfessor.getDesignation());
            professor.setDepartment(updatedProfessor.getDepartment());

            return professorRepository.save(professor);
        }

        return null;
    }

    // Delete
    public void deleteProfessor(String id){
        professorRepository.deleteById(id);
    }
}