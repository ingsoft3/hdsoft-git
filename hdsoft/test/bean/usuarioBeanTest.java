/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.AreaDao;
import dao.TipousuarioDao;
import java.util.List;
import model.Area;
import model.Tipousuario;
import model.Usuario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jm
 */
public class usuarioBeanTest {
    
    public usuarioBeanTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of init method, of class usuarioBean.
     */
    @Test
    public void testInit() {
        System.out.println("init");
        usuarioBean instance = new usuarioBean();
        instance.init();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLFUsuario method, of class usuarioBean.
     */
    @Test
    public void testGetLFUsuario() {
        System.out.println("getLFUsuario");
        usuarioBean instance = new usuarioBean();
        List<Usuario> expResult = null;
        List<Usuario> result = instance.getLFUsuario();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLFUsuario method, of class usuarioBean.
     */
    @Test
    public void testSetLFUsuario() {
        System.out.println("setLFUsuario");
        List<Usuario> LFUsuario = null;
        usuarioBean instance = new usuarioBean();
        instance.setLFUsuario(LFUsuario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsuario method, of class usuarioBean.
     */
    @Test
    public void testGetUsuario() {
        System.out.println("getUsuario");
        usuarioBean instance = new usuarioBean();
        Usuario expResult = null;
        Usuario result = instance.getUsuario();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUsuario method, of class usuarioBean.
     */
    @Test
    public void testSetUsuario() {
        System.out.println("setUsuario");
        Usuario usuario = null;
        usuarioBean instance = new usuarioBean();
        instance.setUsuario(usuario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLUsuario method, of class usuarioBean.
     */
    @Test
    public void testGetLUsuario() {
        System.out.println("getLUsuario");
        usuarioBean instance = new usuarioBean();
        List<Usuario> expResult = null;
        List<Usuario> result = instance.getLUsuario();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLUsuario method, of class usuarioBean.
     */
    @Test
    public void testSetLUsuario() {
        System.out.println("setLUsuario");
        List<Usuario> LUsuario = null;
        usuarioBean instance = new usuarioBean();
        instance.setLUsuario(LUsuario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLArea method, of class usuarioBean.
     */
    @Test
    public void testGetLArea() {
        System.out.println("getLArea");
        usuarioBean instance = new usuarioBean();
        List<Area> expResult = null;
        List<Area> result = instance.getLArea();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLArea method, of class usuarioBean.
     */
    @Test
    public void testSetLArea() {
        System.out.println("setLArea");
        List<Area> LArea = null;
        usuarioBean instance = new usuarioBean();
        instance.setLArea(LArea);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAreaDao method, of class usuarioBean.
     */
    @Test
    public void testGetAreaDao() {
        System.out.println("getAreaDao");
        usuarioBean instance = new usuarioBean();
        AreaDao expResult = null;
        AreaDao result = instance.getAreaDao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAreaDao method, of class usuarioBean.
     */
    @Test
    public void testSetAreaDao() {
        System.out.println("setAreaDao");
        AreaDao areaDao = null;
        usuarioBean instance = new usuarioBean();
        instance.setAreaDao(areaDao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSelArea method, of class usuarioBean.
     */
    @Test
    public void testGetSelArea() {
        System.out.println("getSelArea");
        usuarioBean instance = new usuarioBean();
        int expResult = 0;
        int result = instance.getSelArea();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSelArea method, of class usuarioBean.
     */
    @Test
    public void testSetSelArea() {
        System.out.println("setSelArea");
        int selArea = 0;
        usuarioBean instance = new usuarioBean();
        instance.setSelArea(selArea);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLTipousuario method, of class usuarioBean.
     */
    @Test
    public void testGetLTipousuario() {
        System.out.println("getLTipousuario");
        usuarioBean instance = new usuarioBean();
        List<Tipousuario> expResult = null;
        List<Tipousuario> result = instance.getLTipousuario();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLTipousuario method, of class usuarioBean.
     */
    @Test
    public void testSetLTipousuario() {
        System.out.println("setLTipousuario");
        List<Tipousuario> LTipousuario = null;
        usuarioBean instance = new usuarioBean();
        instance.setLTipousuario(LTipousuario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTipousuarioDao method, of class usuarioBean.
     */
    @Test
    public void testGetTipousuarioDao() {
        System.out.println("getTipousuarioDao");
        usuarioBean instance = new usuarioBean();
        TipousuarioDao expResult = null;
        TipousuarioDao result = instance.getTipousuarioDao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTipousuarioDao method, of class usuarioBean.
     */
    @Test
    public void testSetTipousuarioDao() {
        System.out.println("setTipousuarioDao");
        TipousuarioDao tipousuarioDao = null;
        usuarioBean instance = new usuarioBean();
        instance.setTipousuarioDao(tipousuarioDao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSelTipo method, of class usuarioBean.
     */
    @Test
    public void testGetSelTipo() {
        System.out.println("getSelTipo");
        usuarioBean instance = new usuarioBean();
        int expResult = 0;
        int result = instance.getSelTipo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSelTipo method, of class usuarioBean.
     */
    @Test
    public void testSetSelTipo() {
        System.out.println("setSelTipo");
        int selTipo = 0;
        usuarioBean instance = new usuarioBean();
        instance.setSelTipo(selTipo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of crear method, of class usuarioBean.
     */
    @Test
    public void testCrear() {
        System.out.println("crear");
        usuarioBean instance = new usuarioBean();
        instance.crear();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validaRegistro method, of class usuarioBean.
     */
    @Test
    public void testValidaRegistro() {
        System.out.println("validaRegistro");
        String str = "";
        usuarioBean instance = new usuarioBean();
        boolean expResult = false;
        boolean result = instance.validaRegistro(str);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of click method, of class usuarioBean.
     */
    @Test
    public void testClick() {
        System.out.println("click");
        usuarioBean instance = new usuarioBean();
        instance.click();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
