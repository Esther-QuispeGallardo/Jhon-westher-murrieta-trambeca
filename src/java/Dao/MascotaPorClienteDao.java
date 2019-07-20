/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Utilitarios.HibernateUtil;
import entidades.Mascotaporcliente;
import interfaces.IMascotaPorCliente;
import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author MARTIN
 */
public class MascotaPorClienteDao implements IMascotaPorCliente{

    @Override
    public boolean guardarMascotaPorCliente(Mascotaporcliente mascotaporcliente) {
           boolean respuesta=true;
      Session session =HibernateUtil.getSessionFactory().openSession();
     Transaction transaction=session.beginTransaction();
        try {
            session.save(mascotaporcliente);
             transaction.commit();
        } catch (Exception e) {
            respuesta=false;
        }
    
        session.close();
        return respuesta;
    
    }

    @Override
    public ArrayList<Mascotaporcliente> listarMascotaPorCliente() {
        Session session =HibernateUtil.getSessionFactory().openSession();
          ArrayList<Mascotaporcliente> milista=new ArrayList<>();
        Query query=session.createQuery("FROM Mascotaporcliente as cat  inner join fetch  cat.mascota inner join fetch cat.cliente ");
        //ejecutar la consulta y obtener la listaz
        milista=(ArrayList<Mascotaporcliente>) query.list();
        session.close();
        return milista; 
    }

    @Override
    public boolean actualizar(Mascotaporcliente mascotaporcliente) {
                
         Session session =HibernateUtil.getSessionFactory().openSession();
        
            boolean respuesta= true;
        
        
        Transaction transaccion = session.beginTransaction();
        try{
        session.update(mascotaporcliente);
        transaccion.commit();
        } catch (Exception e) {
            respuesta = false;
            System.out.println("ERORORR"+e);
        }
        session.close();
        return respuesta;
    }

    @Override
    public boolean eliminar(Mascotaporcliente mascotaporcliente) {
         boolean respuesta = true;
         Session session =HibernateUtil.getSessionFactory().openSession();
        Transaction transaccion = session.beginTransaction();
        try {
            session.delete(mascotaporcliente);
            transaccion.commit();
        } catch (Exception e) {
            respuesta = false;
            System.out.println("error"+e);
        }
        session.close();
        return respuesta;
    }
  
    }


   