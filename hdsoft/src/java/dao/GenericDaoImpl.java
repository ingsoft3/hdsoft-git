/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.criterion.Projections;
import util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.context.internal.ThreadLocalSessionContext;
/**
 * @author Felipe
 * @param <T>
 * @param <E>
 */
public class GenericDaoImpl<T, E extends Serializable> implements GenericDao<T, E> {
    private final Class<T> clazz;
    protected Session session;
    protected Transaction tx;

    /**
     *
     */
    @SuppressWarnings("unchecked")
    
    public GenericDaoImpl() {
        this.clazz = (Class<T>)((ParameterizedType)this.getClass().getGenericSuperclass())
                            .getActualTypeArguments()[0];
        
        this.session = HibernateUtil.getSessionFactory().openSession();
        ThreadLocalSessionContext.bind(session);
    }
    
    public E create(T entity) {
        E id;
        try {
            startOperation();
            id = (E) session.save(entity);
            tx.commit();
        } catch (Exception e) {
            id = null;
            tx.rollback();
            throw e;           
        }       
        return  id;
    }
    
    public void delete(T entity) {
        try {
            startOperation();
            session.delete(entity);
            tx.commit();
        } catch (HibernateException e) {
            tx.rollback();
            throw e;
        }  
        
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public void update(T entity) {
        try {
            startOperation();
            session.merge(entity);
            tx.commit();
        } catch (HibernateException e) {
            tx.rollback();
            throw e;
        } 

        //HibernateUtil.getSession().saveOrUpdate(entity);
        //entity = (T) HibernateUtil.getSession().merge(entity);
    }
    @SuppressWarnings("unchecked")
    public List<T> findAll() {
        List <T> list;
        try {
            startOperation();
            list = session.createCriteria(clazz).list();
            tx.commit();
        } catch (HibernateException e) {
            list = null ;
            tx.rollback();
            throw e;
        } 
        
        return list;
    }
    
    @SuppressWarnings("unchecked")
    public List<T> findList(int pageNo, int pageSize) {
        List <T> list;
        try {
            startOperation();
            list = session.createCriteria(clazz)
                          .setFirstResult((pageNo - 1) * pageSize)
                          .setMaxResults(pageSize)
                          .list();
            tx.commit();
        } catch (HibernateException e) {
            list = null ;
            tx.rollback();
            throw e;
        }  

        return list;
    }
    public int getCountOfAll() {
        Long count;
        try {
            startOperation();
            count = (Long) HibernateUtil.getSession()
                                           .createCriteria(clazz)
                                           .setProjection(Projections.rowCount())
                                           .uniqueResult();
            tx.commit();
       } catch (HibernateException e) {
            count = null; 
            tx.rollback();
            throw e;
        } 
        
        if (null == count) {
            return 0;
        } else {
            return count.intValue();
        }
    }
    
    @SuppressWarnings("unchecked")
    public T findById(Serializable id) {
        T obj=null;
        try {           
            startOperation();
            obj = (T) session.load(clazz, id);              
            tx.commit();
        } catch (HibernateException e) {            
            obj = null;           
            tx.rollback();          
        }      
        return  obj;
    }

    protected void startOperation() throws HibernateException {
        session = HibernateUtil.getSession();
        tx = session.beginTransaction();
        
    }
    
    public List <T> consultaQuery(String query){
        List <T> list;
        
        try{
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            list = session.createQuery(query).list();
            tx.commit();
        }catch(HibernateException e){
            list=null;
            tx.rollback();
            throw e;
        }
        return list;       
    }
    
   
    
       
    public void ejecutaQuery(String query){
              
        try{
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            //session.merge(query, tx);
            //session.createSQLQuery(query);
            //session.createQuery("Update Login Set logeado='admin' Where 1=1").executeUpdate();
            tx.commit();
        }catch(HibernateException e){
            tx.rollback();
            throw e;
        }             
    }
    
    public static String MD5(String md5) {
       try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());            
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < array.length; ++i) {
              sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) { } 
        return null;
    }
}