/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.InstantHelp.service;

import hu.elte.InstantHelp.model.Competence;
import hu.elte.InstantHelp.repository.CompetenceRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author Mohammad
 */
@Service
public class CompetenceService {
    
    @Autowired
    private CompetenceRepository competenceRepository;
       
       
    public Competence findById(Long id){
        return competenceRepository.findById(id);
    }
    
    public List<Competence> allCompetences() {
        return competenceRepository.findAll();
    }
}
