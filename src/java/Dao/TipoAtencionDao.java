/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Utilitarios.HibernateUtil;
import entidades.Tipoatencion;

import interfaces.ITipoAtencion;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author MARTIN
 */
public class TipoAtencionDao implements ITipoAtencion{

    @Override
    public boolean guardarTipoAtencion(Tipoatencion tipoatencion) {
             boolean respuesta=true;
      Session session =HibernateUtil.getSessionFactory().openSession();
     Transaction transaction=session.beginTransaction();
        try {
            session.save(tipoatencion);
             transaction.commit();
        } catch (Exception e) {
            respuesta=false;
        }
    
        session.close();
        return respuesta;
    }

    @Override
    public ArrayList<Tipoatencion> listarTipoAtencion() {
              Session session =HibernateUtil.getSessionFactory().openSession();
          ArrayList<Tipoatencion> milista=new ArrayList<>();
        Query query=session.createQuery("FROM Tipoatencion");
        //ejecutar la consulta y obtener la listaz
        milista=(ArrayList<Tipoatencion>) query.list();
         session.close();
        return milista;
    }

    @Override
    public boolean actualizarTipoAtencion(Tipoatencion tipoatencion) {
        Session session =HibernateUtil.getSessionFactory().openSession();
        
            boolean respuesta= true;
        
        
        Transaction transaccion = session.beginTransaction();
        try{
        session.update(tipoatencion);
        transaccion.commit();
        } catch (Exception e) {
            System.out.println(" error"+e);
            respuesta = false;
        }
        session.close();
        return respuesta;
    }

    @Override
    public boolean eliminarTipoAtencion(Tipoatencion tipoatencion) {
           boolean respuesta = true;
         Session session =HibernateUtil.getSessionFactory().openSession();
        Transaction transaccion = session.beginTransaction();
        try {
            session.delete(tipoatencion);
            transaccion.commit();
        } catch (Exception e) {
            respuesta = false;
            System.out.println("error"+e);
        }
        session.close();
        return respuesta;

    }
    
    
}
