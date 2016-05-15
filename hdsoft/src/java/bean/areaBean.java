/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.AreaDaoImpl;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.Area;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author 
 */
@ManagedBean
@ViewScoped
public class areaBean {
    private Area area;
    private List <Area> LArea;

    /**
     * Creates a new instance of areaBean
     */
    public areaBean() {
         area=new Area();
    }
    
    @PostConstruct
    public void init(){
        AreaDaoImpl areaDao = new AreaDaoImpl(); 
        LArea = areaDao.findAll();        
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public List<Area> getLArea() {
        return LArea;
    }

    public void setLArea(List<Area> LArea) {
        this.LArea = LArea;
    }
    
    public void crear(){        
        AreaDaoImpl areaDao = new AreaDaoImpl();   
        if(validaRegistro(this.area.getNombre())){
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Información","Registro ya existe");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }else{
            areaDao.create(area);
            area=new Area();
            FacesMessage msg=new FacesMessage(FacesMessage.FACES_MESSAGES,"Registro realizado satisfactoriamente");
            FacesContext.getCurrentInstance().addMessage(null, msg);  
        }        
    }
    
   
    public void eliminar(Area area) {
        this.area=area;       
        AreaDaoImpl areaDao = new AreaDaoImpl();       
        areaDao.delete(area);
        this.area=new Area();   
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Información","Eliminado éxitosamente");
        FacesContext.getCurrentInstance().addMessage(null, msg);        
        init();
    }
    
    public void onRowEdit(RowEditEvent event) { 
        Area edarea= (Area) event.getObject();
        AreaDaoImpl areaDao=new AreaDaoImpl();
        areaDao.update(edarea);             
        FacesMessage msg = new FacesMessage("Editado",((Area) event.getObject()).getNombre());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edicion Cancelada", ((Area) event.getObject()).getNombre());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public boolean validaRegistro(String str){
        AreaDaoImpl b = new AreaDaoImpl();
        Area a=new Area();        
        List <Area> list;
        
        list=b.consultaQuery("From Area where nombre='"+str+"'");        
        for (Area obj : list) {
            a=b.findById(obj.getId());
            break;
        }
        
        if(a.getNombre()!=null){
            return true;
        }else{
            return false;
        }
    }
    
}
