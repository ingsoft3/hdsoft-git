/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;


import model.Usuario;



/**
 *
 * @author Felipe
 */
public interface IControlerUsuario {
    
    /**
     *
     * @param usu
     * @return
     */
    public String crearUsuario(Usuario usu);

    /**
     *
     * @param usu
     * @return
     */
    public String elminarUsuario(Usuario usu);
    
      /**
     *
     * @param usu
     * @return
     */
    public String editarUsuario(Usuario usu);
}
