/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Utilitarios.HibernateUtil;
import entidades.Usuario;

import interfaces.IUsuario;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author MARTIN
 */
public class UsuarioDao implements IUsuario{

    @Override
    public boolean guardarUsuario(Usuario usuario) {
             boolean respuesta=true;
      Session session =HibernateUtil.getSessionFactory().openSession();
     Transaction transaction=session.beginTransaction();
        try {
            session.save(usuario);
             transaction.commit();
        } catch (Exception e) {
            respuesta=false;
        }
    
        session.close();
        return respuesta;
    }

    @Override
    public ArrayList<Usuario> listarUsuario() {
              Session session =HibernateUtil.getSessionFactory().openSession();
          ArrayList<Usuario> milista=new ArrayList<>();
        Query query=session.createQuery("FROM Usuario as cat  inner join fetch  cat.personal left join fetch cat.cliente");
        //ejecutar la consulta y obtener la listaz
        milista=(ArrayList<Usuario>) query.list();
         session.close();
        return milista;
    }

    @Override
    public boolean actualizarUsuario(Usuario usuario) {
        Session session =HibernateUtil.getSessionFactory().openSession();
        
            boolean respuesta= true;
        
        
        Transaction transaccion = session.beginTransaction();
        try{
        session.update(usuario);
        transaccion.commit();
        } catch (Exception e) {
            System.out.println(" error"+e);
            respuesta = false;
        }
        session.close();
        return respuesta;
    }

    @Override
    public boolean eliminarUsuario(Usuario usuario) {
           boolean respuesta = true;
         Session session =HibernateUtil.getSessionFactory().openSession();
        Transaction transaccion = session.beginTransaction();
        try {
            session.delete(usuario);
            transaccion.commit();
        } catch (Exception e) {
            respuesta = false;
            System.out.println("error"+e);
        }
        session.close();
        return respuesta;

    }
    
    
}
