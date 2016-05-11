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
@Table(name="activos"
    ,catalog="hdsoft_bd"
)
public class Activos  implements java.io.Serializable {


     private Integer id;
     private Tipoactivo tipoactivo;
     private Usuario usuario;
     private String nombre;
     private String serial;
     private String modelo;
     private String fabricante;
     private String sistemaoperativo;
     private String descripcion;
     private Set incidencias = new HashSet(0);

    public Activos() {
    }

	
    public Activos(Tipoactivo tipoactivo, Usuario usuario, String nombre, String serial, String modelo, String fabricante) {
        this.tipoactivo = tipoactivo;
        this.usuario = usuario;
        this.nombre = nombre;
        this.serial = serial;
        this.modelo = modelo;
        this.fabricante = fabricante;
    }
    public Activos(Tipoactivo tipoactivo, Usuario usuario, String nombre, String serial, String modelo, String fabricante, String sistemaoperativo, String descripcion, Set incidencias) {
       this.tipoactivo = tipoactivo;
       this.usuario = usuario;
       this.nombre = nombre;
       this.serial = serial;
       this.modelo = modelo;
       this.fabricante = fabricante;
       this.sistemaoperativo = sistemaoperativo;
       this.descripcion = descripcion;
       this.incidencias = incidencias;
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
    @JoinColumn(name="tipo", nullable=false)
    public Tipoactivo getTipoactivo() {
        return this.tipoactivo;
    }
    
    public void setTipoactivo(Tipoactivo tipoactivo) {
        this.tipoactivo = tipoactivo;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="usuario", nullable=false)
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
    @Column(name="nombre", nullable=false, length=30)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    @Column(name="serial", nullable=false, length=50)
    public String getSerial() {
        return this.serial;
    }
    
    public void setSerial(String serial) {
        this.serial = serial;
    }

    
    @Column(name="modelo", nullable=false, length=30)
    public String getModelo() {
        return this.modelo;
    }
    
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    
    @Column(name="fabricante", nullable=false, length=30)
    public String getFabricante() {
        return this.fabricante;
    }
    
    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    
    @Column(name="sistemaoperativo", length=30)
    public String getSistemaoperativo() {
        return this.sistemaoperativo;
    }
    
    public void setSistemaoperativo(String sistemaoperativo) {
        this.sistemaoperativo = sistemaoperativo;
    }

    
    @Column(name="descripcion", length=100)
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="activos")
    public Set getIncidencias() {
        return this.incidencias;
    }
    
    public void setIncidencias(Set incidencias) {
        this.incidencias = incidencias;
    }

    @Override
    public String toString() {
        return nombre;
    }
}

