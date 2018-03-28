/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.InstantHelp.repository;
import hu.elte.InstantHelp.model.Competence;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
/**
 *
 * @author Mohammad
 */
public interface CompetenceRepository extends CrudRepository<Competence, String>{
    
    public Competence findById(Long id);
    
    @Override
    public List<Competence> findAll();
}
