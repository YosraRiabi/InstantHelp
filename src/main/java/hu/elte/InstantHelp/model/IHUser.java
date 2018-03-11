/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.InstantHelp.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 *
 * @author Mohammad
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IHUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(name="username", nullable=false, length=100)
    private String username;
    
    @Column(name="password", nullable=false, length=100)
    private String password;
       
    @Column(nullable = false)
    private boolean status;
    
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;
    
    public enum Role {
        ROLE_USER, ROLE_ADMIN
    }
}
