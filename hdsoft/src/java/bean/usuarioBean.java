
package bean;

import dao.AreaDao;
import dao.AreaDaoImpl;
import dao.TipousuarioDao;
import dao.TipousuarioDaoImpl;
import dao.UsuarioDaoImpl;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.Area;
import model.Tipousuario;
import model.Usuario;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;

@ManagedBean
@ViewScoped
public class usuarioBean implements Serializable{
    private Usuario usuario;
    private List <Usuario> LUsuario; 
    private List <Usuario> LFUsuario;
    private UsuarioDaoImpl usrDao;
    
    private List<Area> LArea;
    private AreaDao areaDao;       
    private int selArea;
    
    private List<Tipousuario> LTipousuario;
    private TipousuarioDao tipousuarioDao;    
    private int selTipo;

    public usuarioBean() {
        usuario=new Usuario();
    }
    
    @PostConstruct
    public void init(){
        areaDao = new AreaDaoImpl();
        tipousuarioDao = new TipousuarioDaoImpl();
        UsuarioDaoImpl usuarioDao = new UsuarioDaoImpl(); 
        LUsuario = usuarioDao.findAll();
        LFUsuario= usuarioDao.findAll();
        LArea = areaDao.findAll();
        LTipousuario = tipousuarioDao.findAll();
    }

    public List<Usuario> getLFUsuario() {
        return LFUsuario;
    }

    public void setLFUsuario(List<Usuario> LFUsuario) {
        this.LFUsuario = LFUsuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getLUsuario() {
        return LUsuario;
    }

    public void setLUsuario(List<Usuario> LUsuario) {
        this.LUsuario = LUsuario;
    }

    public List<Area> getLArea() {
        return LArea;
    }

    public void setLArea(List<Area> LArea) {
        this.LArea = LArea;
    }

    public AreaDao getAreaDao() {
        return areaDao;
    }

    public void setAreaDao(AreaDao areaDao) {
        this.areaDao = areaDao;
    }

    public int getSelArea() {
        return selArea;
    }

    public void setSelArea(int selArea) {
        this.selArea = selArea;
    }

    public List<Tipousuario> getLTipousuario() {
        return LTipousuario;
    }

    public void setLTipousuario(List<Tipousuario> LTipousuario) {
        this.LTipousuario = LTipousuario;
    }

    public TipousuarioDao getTipousuarioDao() {
        return tipousuarioDao;
    }

    public void setTipousuarioDao(TipousuarioDao tipousuarioDao) {
        this.tipousuarioDao = tipousuarioDao;
    }

    public int getSelTipo() {
        return selTipo;
    }

    public void setSelTipo(int selTipo) {
        this.selTipo = selTipo;
    }
    
    public void crear(){        
        UsuarioDaoImpl usuarioDao = new UsuarioDaoImpl();  
        if(validaRegistro(this.usuario.getNombreUsuario())){
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Registro ya existe");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }else{
            usuario.setArea(areaDao.findById(selArea));
            usuario.setTipousuario(tipousuarioDao.findById(selTipo));
            usuario.setPassword(UsuarioDaoImpl.MD5(this.usuario.getPassword()));
            usuarioDao.create(usuario);
            usuario=new Usuario();
            FacesMessage msg=new FacesMessage(FacesMessage.FACES_MESSAGES,"Registro realizado satisfactoriamente");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }                
    }
   
    public void eliminar(Usuario usuario) {
        this.usuario=usuario;
        if ("admin".equals(usuario.getNombreUsuario())){
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "No se puede eliminar usuario admin del sistema");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }else{
            UsuarioDaoImpl usuarioDao = new UsuarioDaoImpl();
            usuarioDao.delete(usuario);         
            this.usuario= new Usuario() ;        
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Eliminado éxitosamente");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            init();
        }
    }   
    
    public void onRowEdit(Usuario usuario) {        
        this.usuario=usuario;        
        if ("admin".equals(usuario.getNombreUsuario())){
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "No se puede Editar admin");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }else{
            UsuarioDaoImpl usuarioDao = new UsuarioDaoImpl();
            /*if (this.usuario.getEstadoString().equals("ACTIVO")){
                usuario.setEstado(1);
            }else{
                usuario.setEstado(0); 
            }*/
            usuario.setTipousuario(tipousuarioDao.findById(selTipo));
            usuario.setArea(areaDao.findById(selArea));
            usuario.setPassword(this.usuario.getPassword());
            usuarioDao.update(usuario);         
            this.usuario = new Usuario() ;        
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Editado éxitosamente");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            init();
        }        
    }     
   
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edicion Cancelada", ((Usuario) event.getObject()).getNombre());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void changePass(Usuario usuario){
        this.usuario=usuario;
        if ("admin".equals(usuario.getNombreUsuario())){
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "No se puede Editar contraseña del admin");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }else{
            UsuarioDaoImpl usuarioDao = new UsuarioDaoImpl();
            usuario.setPassword(usuarioDao.MD5(usuario.getPassword()));
            usuarioDao.update(usuario);         
            this.usuario= new Usuario() ;        
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Editado éxitosamente");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            init();
        }        
    }
    
    public boolean validaRegistro(String str){
        UsuarioDaoImpl b = new UsuarioDaoImpl();
        Usuario a=new Usuario();        
        List <Usuario> list;        
        list=b.consultaQuery("From Usuario where nombre_usuario='"+str+"'");        
        for (Usuario obj : list) {
            a=b.findById(obj.getId());
            break;
        }        
        if(a.getNombreUsuario()!=null){
            return true;
        }else{
            return false;
        }      
    }
    
    public void click() {
        RequestContext requestContext = RequestContext.getCurrentInstance();
         
        requestContext.update("form:display");
        requestContext.execute("PF('dlg').show()");
    }
}
