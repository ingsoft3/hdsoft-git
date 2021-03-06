
package BeanSesion;

import dao.TipousuarioDaoImpl;
import dao.UsuarioDaoImpl;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import model.Tipousuario;

import model.Usuario;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

@ManagedBean
@SessionScoped
public class MbSLogin {
    private Usuario usuario;
    private Tipousuario tipousuario;
    private Session session;
    private Transaction transaccion;
    private String nombreUsuario;
    private String password;
   
    public MbSLogin() {
        HttpSession miSession=(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        miSession.setMaxInactiveInterval(5000);        
    }
    
    public String login(){
       String resultado="/index";
        this.session=null;
        this.transaccion=null;
        try{
            UsuarioDaoImpl usuarioDao = new UsuarioDaoImpl();
            TipousuarioDaoImpl tiposuarioDao = new TipousuarioDaoImpl();
            List <Tipousuario> Ltipou;
            List <Usuario> list; 
            list=usuarioDao.consultaQuery("From Usuario where nombre_usuario='"+this.nombreUsuario+"'");
            this.session=HibernateUtil.getSessionFactory().openSession();
            this.transaccion=this.session.beginTransaction();                    
            
            for (Usuario usr : list){                
                usuario=usuarioDao.findById(usr.getId());               
            }            
            Ltipou = tiposuarioDao.consultaQuery("From Tipousuario where id="+usuario.getTipousuario().getId());
            
            for (Tipousuario tipo : Ltipou){
                tipousuario=tiposuarioDao.findById(tipo.getId());
            }
            
            if(usuario!=null){   
               // if(usuario.getEstadoString().equals("ACTIVO")){
                if(usuario.getEstado()>0){//VALIDA SI EL USUARIO ESTÁ ACTIVO                     
                    if(usuario.getPassword().equals(usuarioDao.MD5(this.password))){
                        HttpSession httpSession=(HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                        httpSession.setAttribute("nombreUsuario", this.nombreUsuario);                       
                        resultado = tipousuario.getUrl();
                    }
                }
            }               
            this.transaccion.commit();
            this.nombreUsuario=null;             
            return resultado;
            
        }catch(Exception ex){
            if(this.transaccion!=null){
                this.transaccion.rollback();
            }
            this.nombreUsuario=null;
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_FATAL,"Error acceso","Usuario o contraseña incorrecto") );
            return null;
        }
        finally{
            if(this.session!=null){
                this.session.close();
            }
        }                
    }

    
    public String cerrarSesion(){
        this.nombreUsuario=null;
        this.password=null;
        HttpSession httpSession=(HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        httpSession.invalidate();        
        return "/index";
    } 

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Transaction getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(Transaction transaccion) {
        this.transaccion = transaccion;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
