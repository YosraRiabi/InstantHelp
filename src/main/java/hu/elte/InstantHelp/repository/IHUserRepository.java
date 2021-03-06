/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.InstantHelp.repository;

import hu.elte.InstantHelp.model.IHUser;
import java.util.List;
import org.springframework.data.repository.CrudRepository;       
/**
 *
 * @author Mohammad
 */
public interface IHUserRepository extends CrudRepository<IHUser, String>{  
    
    public IHUser findById(Long id);
    
    public IHUser findByUsername(String username);
       
    @Override
    public List<IHUser> findAll();
    
}
