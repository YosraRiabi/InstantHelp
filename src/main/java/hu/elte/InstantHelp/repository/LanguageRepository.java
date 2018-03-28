/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.InstantHelp.repository;
import org.springframework.data.repository.CrudRepository;   
import hu.elte.InstantHelp.model.Language;
import java.util.List;
/**
 *
 * @author Mohammad
 */
public interface LanguageRepository extends CrudRepository<Language, String>{
    public Language findById(Long id);
    
    @Override
    public List<Language> findAll();
}
