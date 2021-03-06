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
public class Competence {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(name="name", nullable=false, length=100)
    private String name;
    
    @Column(name="description", columnDefinition = "TEXT", nullable=true, length=500)
    private String description;
    
    @ManyToMany(mappedBy = "languages")
    private List<IHUser> users = new ArrayList<>();
 
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Competence )) return false;
        return (id != (Long)null) && (id==(((Competence) o).id));
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
