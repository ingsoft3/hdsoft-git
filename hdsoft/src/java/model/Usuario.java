package model;


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="usuario"
    ,catalog="hdsoft_bd"
)
public class Usuario  implements java.io.Serializable {


     private Integer id;
     private Area area;
     private Tipousuario tipousuario;
     private String nombreUsuario;
     private String nombre;
     private String apellido;
     private String email;
     private int telefono;
     private int extension;
     private int estado;
     private String password;
     private Set incidencias = new HashSet(0);
     private Set activoses = new HashSet(0);
     private Set actividads = new HashSet(0);

    public Usuario() {
    }

	
    public Usuario(Area area, Tipousuario tipousuario, String nombreUsuario, String nombre, String apellido, String email, int telefono, int extension, int estado, String password) {
        this.area = area;
        this.tipousuario = tipousuario;
        this.nombreUsuario = nombreUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.extension = extension;
        this.estado = estado;
        this.password = password;
    }
    public Usuario(Area area, Tipousuario tipousuario, String nombreUsuario, String nombre, String apellido, String email, int telefono, int extension, int estado, String password, Set incidencias, Set activoses, Set actividads) {
       this.area = area;
       this.tipousuario = tipousuario;
       this.nombreUsuario = nombreUsuario;
       this.nombre = nombre;
       this.apellido = apellido;
       this.email = email;
       this.telefono = telefono;
       this.extension = extension;
       this.estado = estado;
       this.password = password;
       this.incidencias = incidencias;
       this.activoses = activoses;
       this.actividads = actividads;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="area", nullable=false)
    public Area getArea() {
        return this.area;
    }
    
    public void setArea(Area area) {
        this.area = area;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="tipo", nullable=false)
    public Tipousuario getTipousuario() {
        return this.tipousuario;
    }
    
    public void setTipousuario(Tipousuario tipousuario) {
        this.tipousuario = tipousuario;
    }

    
    @Column(name="nombre_usuario", nullable=false, length=15)
    public String getNombreUsuario() {
        return this.nombreUsuario;
    }
    
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    
    @Column(name="nombre", nullable=false, length=30)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    @Column(name="apellido", nullable=false, length=30)
    public String getApellido() {
        return this.apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    
    @Column(name="email", nullable=false, length=60)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    
    @Column(name="telefono", nullable=false)
    public int getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    
    @Column(name="extension", nullable=false)
    public int getExtension() {
        return this.extension;
    }
    
    public void setExtension(int extension) {
        this.extension = extension;
    }
    
    @Column(name="estado", nullable=false)
    public int getEstado() {
        return this.estado;
    }
    
    @Column(name="estadoString", nullable=false)
    public String getEstadoString() {
        if (this.estado == 1) {
            return "ACTIVO";
        }
        return "INACTIVO";
    }
    
  
    
    public void setEstado(int estado) {
        this.estado = estado;
    }

    
    @Column(name="password", nullable=false, length=500)
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="usuario")
    public Set getIncidencias() {
        return this.incidencias;
    }
    
    public void setIncidencias(Set incidencias) {
        this.incidencias = incidencias;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="usuario")
    public Set getActivoses() {
        return this.activoses;
    }
    
    public void setActivoses(Set activoses) {
        this.activoses = activoses;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="usuario")
    public Set getActividads() {
        return this.actividads;
    }
    
    public void setActividads(Set actividads) {
        this.actividads = actividads;
    }

    @Override
    public String toString() {
        return nombre;
    }
}


