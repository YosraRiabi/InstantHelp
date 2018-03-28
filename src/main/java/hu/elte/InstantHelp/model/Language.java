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
import java.util.*;
/**
 *
 * @author Mohammad
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(name="name", nullable=false, length=100)
    private String name;
    
    @Column(name="code", nullable=false, length=50)
    private String code;
    
    @ManyToMany(mappedBy = "languages")
    private List<IHUser> users = new ArrayList<>();
 
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Language )) return false;
        return (id != (Long)null) && (id==(((Language) o).id));
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
