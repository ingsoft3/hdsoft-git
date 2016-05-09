package model;
// Generated 9/12/2015 08:53:02 PM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Actividad generated by hbm2java
 */
@Entity
@Table(name="actividad"
    ,catalog="ppiv"
)
public class Actividad  implements java.io.Serializable {


     private Integer id;
     private Incidencia incidencia;
     private Usuario usuario;
     private String descripcion;
     private Date fechaInicio;
     private Date fechaFin;
     private int estado;
     private String respuesta;

    public Actividad() {
    }

	
    public Actividad(Incidencia incidencia, Usuario usuario, String descripcion, int estado) {
        this.incidencia = incidencia;
        this.usuario = usuario;
        this.descripcion = descripcion;
        this.estado = estado;
    }
    public Actividad(Incidencia incidencia, Usuario usuario, String descripcion, Date fechaInicio, Date fechaFin, int estado, String respuesta) {
       this.incidencia = incidencia;
       this.usuario = usuario;
       this.descripcion = descripcion;
       this.fechaInicio = fechaInicio;
       this.fechaFin = fechaFin;
       this.estado = estado;
       this.respuesta = respuesta;
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
    @JoinColumn(name="incidencia", nullable=false)
    public Incidencia getIncidencia() {
        return this.incidencia;
    }
    
    public void setIncidencia(Incidencia incidencia) {
        this.incidencia = incidencia;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="tecnico", nullable=false)
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
    @Column(name="descripcion", nullable=false, length=500)
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="fecha_inicio", length=10)
    public Date getFechaInicio() {
        return this.fechaInicio;
    }
    
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="fecha_fin", length=10)
    public Date getFechaFin() {
        return this.fechaFin;
    }
    
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    
    @Column(name="estado", nullable=false)
    public int getEstado() {
        return this.estado;
    }
    
    public void setEstado(int estado) {
        this.estado = estado;
    }

    
    @Column(name="respuesta", length=500)
    public String getRespuesta() {
        return this.respuesta;
    }
    
    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    @Override
    public String toString() {
        return descripcion;
    }




}


