/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.InstantHelp.service;

import hu.elte.InstantHelp.model.*;
import hu.elte.InstantHelp.repository.CallRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author Mohammad
 */
@Service
public class CallService {
    
    @Autowired
    private CallRepository callRepository;
       
       
    public Call findById(Long id){
        return callRepository.findById(id);
    }
    public Call findBySender(IHUser user){
        return callRepository.findBySender(user);
    }
    public Call findByReceiver(IHUser user){
        return callRepository.findByReceiver(user);
    }
    public List<Call> allCalls() {
        return callRepository.findAll();
    }
}
