/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.InstantHelp.model;

import java.util.*;
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
    
    @OneToMany(mappedBy = "IHUser", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Balance> balances= new ArrayList<>();
    
    public void addBalance(Balance balance) {
        balances.add(balance);
        balance.setUser(this);
    }
 
    public void removeBalance(Balance balance) {
        balances.remove(balance);
        balance.setUser(null);
    }
    
    @OneToMany(mappedBy = "IHUser", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Call> calls= new ArrayList<>();
    public void addCallSender(Call call) {
        calls.add(call);
        call.setSender(this);
    } 
    public void removeCallSender(Call call) {
        calls.remove(call);
        call.setSender(null);
    }
    public void addCallReceiver(Call call) {
        calls.add(call);
        call.setReceiver(this);
    } 
    public void removeCallReceiver(Call call) {
        calls.remove(call);
        call.setReceiver(null);
    }
    
    @ManyToMany(cascade = { 
        CascadeType.PERSIST, 
        CascadeType.MERGE
    })
    @JoinTable(name = "language_has_user",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "language_id")
    )
    private List<Language> languages = new ArrayList<>();
    public void addLanguage(Language language) {
        languages.add(language);
        language.getUsers().add(this);
    }
    public void removeLanguage(Language language) {
        languages.remove(language);
        language.getUsers().remove(this);
    }
    
    @ManyToMany(cascade = { 
        CascadeType.PERSIST, 
        CascadeType.MERGE
    })
    @JoinTable(name = "competence_has_user",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "competence_id")
    )
    private List<Competence> competences = new ArrayList<>();
    public void addCompetence(Competence competence) {
        competences.add(competence);
        competence.getUsers().add(this);
    }
    public void removeCompetence(Competence competence) {
        competences.remove(competence);
        competence.getUsers().remove(this);
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IHUser )) return false;
        return (id != (Long)null) && (id==(((IHUser) o).id));
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
