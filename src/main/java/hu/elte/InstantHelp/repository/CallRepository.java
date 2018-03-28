/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.InstantHelp.repository;
import org.springframework.data.repository.CrudRepository;       
import hu.elte.InstantHelp.model.*;
import java.util.List;
/**
 *
 * @author Mohammad
 */
public interface CallRepository extends CrudRepository<Call, String>{
    public Call findById(Long id);
    
    public Call findBySender(IHUser user);
    
    public Call findByReceiver(IHUser user);
    
    @Override
    public List<Call> findAll();    
}
