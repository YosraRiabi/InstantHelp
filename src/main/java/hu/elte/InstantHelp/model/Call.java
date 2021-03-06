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
public class Call {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(name="startdate", nullable=false, length=50)
    private String startdate;
    
    @Column(name="enddate", nullable=true, length=50)
    private Date enddate;
    
    @Column(name="amount", nullable=true)
    private Double amount;
    
    @Column(name="type", nullable = false)
    @Enumerated(EnumType.STRING)
    private Type type;    
    public enum Type {
        Video, Audio
    }
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private IHUser sender;   
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private IHUser receiver;   
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Call )) return false;
        return (id != (Long)null) && (id==(((Call) o).id));
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
