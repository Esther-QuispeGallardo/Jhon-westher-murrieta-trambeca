/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Utilitarios.HibernateUtil;
import entidades.Reservacita;

import interfaces.IReservacita;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author MARTIN
 */
public class ReservaCitaDao implements IReservacita{

    @Override
    public boolean guardarReservacita(Reservacita reservacita) {
             boolean respuesta=true;
      Session session =HibernateUtil.getSessionFactory().openSession();
     Transaction transaction=session.beginTransaction();
        try {
            session.save(reservacita);
             transaction.commit();
        } catch (Exception e) {
            respuesta=false;
        }
    
        session.close();
        return respuesta;
    }

    @Override
    public ArrayList<Reservacita> listarReservacita() {
              Session session =HibernateUtil.getSessionFactory().openSession();
          ArrayList<Reservacita> milista=new ArrayList<>();
        Query query=session.createQuery("FROM Reservacita as cat  inner join fetch  cat.usuario left join fetch cat.cliente  left join fetch cat.tiporeserva");
        //ejecutar la consulta y obtener la listaz
        milista=(ArrayList<Reservacita>) query.list();
         session.close();
        return milista;
    }

    @Override
    public boolean actualizarReservacita(Reservacita reservacita) {
        Session session =HibernateUtil.getSessionFactory().openSession();
        
            boolean respuesta= true;
        
        
        Transaction transaccion = session.beginTransaction();
        try{
        session.update(reservacita);
        transaccion.commit();
        } catch (Exception e) {
            System.out.println(" error"+e);
            respuesta = false;
        }
        session.close();
        return respuesta;
    }

    @Override
    public boolean eliminarReservacita(Reservacita reservacita) {
           boolean respuesta = true;
         Session session =HibernateUtil.getSessionFactory().openSession();
        Transaction transaccion = session.beginTransaction();
        try {
            session.delete(reservacita);
            transaccion.commit();
        } catch (Exception e) {
            respuesta = false;
            System.out.println("error"+e);
        }
        session.close();
        return respuesta;

    }
    
    
}
