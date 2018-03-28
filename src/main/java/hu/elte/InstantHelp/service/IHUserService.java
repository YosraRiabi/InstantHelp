/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.InstantHelp.service;

import hu.elte.InstantHelp.model.IHUser;
import hu.elte.InstantHelp.repository.IHUserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author Mohammad
 */
@Service
public class IHUserService {
    
    @Autowired
    private IHUserRepository userRepository;
    
    public IHUser findByUsername(String username){
        return userRepository.findByUsername(username);
    }
       
    public IHUser findById(Long id){
        return userRepository.findById(id);
    }
    
    public List<IHUser> allUsers() {
        return userRepository.findAll();
    }
}
