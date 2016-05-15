/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.ActivosDaoImpl;
import dao.TipoactivoDao;
import dao.TipoactivoDaoImpl;
import dao.UsuarioDao;
import dao.UsuarioDaoImpl;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.Activos;
import model.Tipoactivo;
import model.Usuario;
import org.primefaces.event.RowEditEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Felipe
 */
@ManagedBean
@ViewScoped
public class activosBean {
    private Activos activos;
    private List <Activos> LActivos;
    
    private List <Tipoactivo> LTipoactivo;
    private TipoactivoDao tipoactivoDao;
    private int selTipoactivo;
    
    private List <Usuario> LUsuario;
    private UsuarioDao usuarioDao;
    private int selUsuario;    

    /**
     * Creates a new instance of activosBena
     */
    public activosBean() {
        activos=new Activos();
    }
    
    @PostConstruct
    public void init(){
        tipoactivoDao=new TipoactivoDaoImpl();
        usuarioDao=new UsuarioDaoImpl();        
        ActivosDaoImpl activosDao= new ActivosDaoImpl();
        LActivos=activosDao.findAll();
        LTipoactivo=tipoactivoDao.findAll(); 
        LUsuario = usuarioDao.findAll();       
    }

    public Activos getActivos() {
        return activos;
    }

    public void setActivos(Activos activos) {
        this.activos = activos;
    }

    public List<Activos> getLActivos() {
        return LActivos;
    }

    public void setLActivos(List<Activos> LActivos) {
        this.LActivos = LActivos;
    }

    public List<Tipoactivo> getLTipoactivo() {
        return LTipoactivo;
    }

    public void setLTipoactivo(List<Tipoactivo> LTipoactivo) {
        this.LTipoactivo = LTipoactivo;
    }

    public TipoactivoDao getTipoactivoDao() {
        return tipoactivoDao;
    }

    public void setTipoactivoDao(TipoactivoDao tipoactivoDao) {
        this.tipoactivoDao = tipoactivoDao;
    }

    public int getSelTipoactivo() {
        return selTipoactivo;
    }

    public void setSelTipoactivo(int selTipoactivo) {
        this.selTipoactivo = selTipoactivo;
    }

    public List<Usuario> getLUsuario() {
        return LUsuario;
    }

    public void setLUsuario(List<Usuario> LUsuario) {
        this.LUsuario = LUsuario;
    }

    public UsuarioDao getUsuarioDao() {
        return usuarioDao;
    }

    public void setUsuarioDao(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

    public int getSelUsuario() {
        return selUsuario;
    }

    public void setSelUsuario(int setUsuario) {
        this.selUsuario = setUsuario;
    }
    
   
   
    public void eliminar(Activos activos) {
        this.activos=activos;
        ActivosDaoImpl activosDao = new ActivosDaoImpl();
        activosDao.delete(activos);
        //revisar
        this.activos= new Activos() ;        
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Eliminado éxitosamente");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        init();
    }
    
    public void abrirPdf() throws IOException {
      
      
    }
   
    public void onRowEdit(RowEditEvent event) {        
        Activos edactivos = (Activos) event.getObject();
        ActivosDaoImpl activosDao = new ActivosDaoImpl();   
        edactivos.setTipoactivo(tipoactivoDao.findById(selTipoactivo));
        edactivos.setUsuario(usuarioDao.findById(selUsuario));
        
        activosDao.update(edactivos);            
        FacesMessage msg = new FacesMessage("Editado", ((Activos)event.getObject()).getNombre());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edicion Cancelada", ((Activos) event.getObject()).getNombre());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void crear()throws JRException, net.sf.jasperreports.engine.JRException, SQLException, IOException  {    
        
        ActivosDaoImpl activosDao=new ActivosDaoImpl();
        activos.setTipoactivo(tipoactivoDao.findById(selTipoactivo));
        activos.setUsuario(usuarioDao.findById(selUsuario));
        activosDao.create(activos);
        
        GenerarReportePdf(activos.getId().toString(),"RActivos");
           
        
        FacesMessage msg=new FacesMessage(FacesMessage.FACES_MESSAGES,"Registro realizado satisfactoriamente");
        FacesContext.getCurrentInstance().addMessage(null, msg); 
        RequestContext.getCurrentInstance().addCallbackParam("id", "ACT" + activos.getId() + ".pdf");
        activos=new Activos();  
    }

    public static void GenerarReportePdf(String var1,String var2) throws JRException, net.sf.jasperreports.engine.JRException, SQLException, IOException {
        Connection cnt = DriverManager.getConnection("jdbc:mysql://localhost:3306/ppiv?user=root");//CONEXION BD
        
        String report="D://Felipe/Documents/NetBeansProjects/ppiv/src/java/reportes/"+var2+".jrxml";
        
        Map parametros = new HashMap();
        parametros.put("id",var1);//PARAMETROS        
        
        //JasperCompileManager.compileReportToFile(report,"D://Felipe/Documents/NetBeansProjects/ppiv/src/java/reportes/RActivos.jasper");
        JasperReport reporte = JasperCompileManager.compileReport(report);
        
        JasperPrint printer = JasperFillManager.fillReport(reporte, parametros, cnt);
        JasperExportManager.exportReportToPdfFile(printer, "D://Felipe/Documents/NetBeansProjects/ppiv/src/java/activosPDF/ACT"+var1+".pdf");
       
        cnt.close();
       
    }

    private static class JRException extends Exception {

        public JRException() {
        }
    }
}



