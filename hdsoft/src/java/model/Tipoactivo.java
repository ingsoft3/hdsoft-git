package model;
// Generated 11/05/2016 08:31:15 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Tipoactivo generated by hbm2java
 */
@Entity
@Table(name="tipoactivo"
    ,catalog="hdsoft_bd"
)
public class Tipoactivo  implements java.io.Serializable {


     private Integer id;
     private String nombre;
     private Set activoses = new HashSet(0);

    public Tipoactivo() {
    }

	
    public Tipoactivo(String nombre) {
        this.nombre = nombre;
    }
    public Tipoactivo(String nombre, Set activoses) {
       this.nombre = nombre;
       this.activoses = activoses;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="nombre", nullable=false, length=40)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="tipoactivo")
    public Set getActivoses() {
        return this.activoses;
    }
    
    public void setActivoses(Set activoses) {
        this.activoses = activoses;
    }

@Override
    public String toString() {
        return nombre;
    }


}


