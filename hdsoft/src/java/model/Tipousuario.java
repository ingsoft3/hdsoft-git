package model;
// Generated 24/11/2015 08:20:00 PM by Hibernate Tools 4.3.1


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
 * Tipousuario generated by hbm2java
 */
@Entity
@Table(name="tipousuario"
    ,catalog="ppiv"
)
public class Tipousuario  implements java.io.Serializable {


     private Integer id;
     private String nombre;
     private Set usuarios = new HashSet(0);

    public Tipousuario() {
    }

	
    public Tipousuario(String nombre) {
        this.nombre = nombre;
    }
    public Tipousuario(String nombre, Set usuarios) {
       this.nombre = nombre;
       this.usuarios = usuarios;
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

@OneToMany(fetch=FetchType.LAZY, mappedBy="tipousuario")
    public Set getUsuarios() {
        return this.usuarios;
    }
    
    public void setUsuarios(Set usuarios) {
        this.usuarios = usuarios;
    }

 @Override
    public String toString() {
        return nombre;
    }

}


