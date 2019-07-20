/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Utilitarios.HibernateUtil;
import entidades.Tiporeserva;
import interfaces.ITipoReseva;


import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author MARTIN
 */
public class TipoReservaDao implements ITipoReseva{

    @Override
    public boolean guardarTiporeserva(Tiporeserva tiporeserva) {
             boolean respuesta=true;
      Session session =HibernateUtil.getSessionFactory().openSession();
     Transaction transaction=session.beginTransaction();
        try {
            session.save(tiporeserva);
             transaction.commit();
        } catch (Exception e) {
            respuesta=false;
        }
    
        session.close();
        return respuesta;
    }

    @Override
    public ArrayList<Tiporeserva> listarTiporeserva() {
              Session session =HibernateUtil.getSessionFactory().openSession();
          ArrayList<Tiporeserva> milista=new ArrayList<>();
        Query query=session.createQuery("FROM Tiporeserva");
        //ejecutar la consulta y obtener la listaz
        milista=(ArrayList<Tiporeserva>) query.list();
         session.close();
        return milista;
    }

    @Override
    public boolean actualizarTiporeserva(Tiporeserva tiporeserva) {
        Session session =HibernateUtil.getSessionFactory().openSession();
        
            boolean respuesta= true;
        
        
        Transaction transaccion = session.beginTransaction();
        try{
        session.update(tiporeserva);
        transaccion.commit();
        } catch (Exception e) {
            System.out.println(" error"+e);
            respuesta = false;
        }
        session.close();
        return respuesta;
    }

    @Override
    public boolean eliminarTiporeserva(Tiporeserva tiporeserva) {
           boolean respuesta = true;
         Session session =HibernateUtil.getSessionFactory().openSession();
        Transaction transaccion = session.beginTransaction();
        try {
            session.delete(tiporeserva);
            transaccion.commit();
        } catch (Exception e) {
            respuesta = false;
            System.out.println("error"+e);
        }
        session.close();
        return respuesta;

    }
    
    
}
