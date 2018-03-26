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
    
    @Column(name="fname", nullable=false, length=100)
    private String fname;    
    
    @Column(name="lname", nullable=false, length=100)
    private String lname;
        
    @Column(name="email", nullable=false, length=100)
    private String email;
    
    @Column(name="password", nullable=false, length=100)
    private String password;
    
    @Column(name="photo", nullable=true, length=100)
    private String photo;
    
    @Column(name="country", nullable=false, length=100)
    private String country;
    
    @Column(name="address", nullable=false, length=100)
    private String address;
    
    @Column(name="level", nullable=true, length=100)
    private int level;
    
    @Column(name="bankaccount", nullable=false, length=100)
    private String bankaccount;    
        
    @Column(name="available", nullable = false)
    private boolean available;
    
    @Column(name="status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;
    public enum Status {
        Active, Blocked
    }
    
    @Column(name="type", nullable = false)
    @Enumerated(EnumType.STRING)
    private Type type;    
    public enum Type {
        Normal, PreExpert, Expert
    }
    
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;    
    public enum Role {
        ROLE_USER, ROLE_ADMIN
    }
}
