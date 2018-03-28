/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.InstantHelp.service;

import hu.elte.InstantHelp.model.Balance;
import hu.elte.InstantHelp.repository.BalanceRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author Mohammad
 */
@Service
public class BalanceService {
    
    @Autowired
    private BalanceRepository balanceRepository;
       
       
    public Balance findById(Long id){
        return balanceRepository.findById(id);
    }
    
    public List<Balance> allBalances() {
        return balanceRepository.findAll();
    }
}
