/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.InstantHelp.service;

import hu.elte.InstantHelp.model.Language;
import hu.elte.InstantHelp.repository.LanguageRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author Mohammad
 */
@Service
public class LanguageService {
    
    @Autowired
    private LanguageRepository languageRepository;
       
       
    public Language findById(Long id){
        return languageRepository.findById(id);
    }
    
    public List<Language> allLanguages() {
        return languageRepository.findAll();
    }
}
