/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import dao.UsuarioDaoImpl;
import model.Usuario;

/**
 *
 * @author Felipe
 */
public class ImplControlerUsuario implements IControlerUsuario{

    // instancia del dao
    UsuarioDaoImpl dao = new UsuarioDaoImpl();
    String respuesta ="Operación no éxitosa";
    
    
    @Override
    public String crearUsuario(Usuario usu) {
        
        if (usu.getId() != null && usu.getNombreUsuario() != null){ 
            respuesta ="operación éxitosa";
            dao.create(usu);            
            return respuesta;
        }
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }

    @Override
    public String elminarUsuario(Usuario usu) {
        
        dao.delete(usu);
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String editarUsuario(Usuario usu) {
        
        dao.update(usu);
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
