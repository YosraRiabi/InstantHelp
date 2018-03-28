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
public class Balance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(name="amount", nullable=true, length=50)
    private Double amount;
    
    @Column(name="depositdate", nullable=true, length=50)
    private Date depositdate;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private IHUser user;   
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Balance )) return false;
        return (id != (Long)null) && (id==(((Balance) o).id));
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    
    
}
