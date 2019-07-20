/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;


import Utilitarios.HibernateUtil;
import entidades.Mascota;
import entidades.Personal;
import interfaces.IPersonal;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author MARTIN
 */
public class PersonalDao implements IPersonal{

    @Override
    public boolean guardarPersonal(Personal personal) {
                boolean respuesta=true;
      Session session =HibernateUtil.getSessionFactory().openSession();
     Transaction transaction=session.beginTransaction();
        try {
            session.save(personal);
             transaction.commit();
        } catch (Exception e) {
            respuesta=false;
        }
    
        session.close();
        return respuesta;
        }

    @Override
    public ArrayList<Personal> listarPersonal() {
          Session session =HibernateUtil.getSessionFactory().openSession();
          ArrayList<Personal> milista=new ArrayList<>();
        Query query=session.createQuery("FROM Personal");
        //ejecutar la consulta y obtener la listaz
        milista=(ArrayList<Personal>) query.list();
        session.close();
        return milista;
      }

    @Override
    public boolean actualizarPersonal(Personal personal) {
        Session session =HibernateUtil.getSessionFactory().openSession();
        
            boolean respuesta= true;
        
        
        Transaction transaccion = session.beginTransaction();
        try{
        session.update(personal);
        transaccion.commit();
        } catch (Exception e) {
            respuesta = false;
        }
        session.close();
        return respuesta;
       }

    @Override
    public boolean eliminarPersonal(Personal personal) {
          boolean respuesta = true;
         Session session =HibernateUtil.getSessionFactory().openSession();
        Transaction transaccion = session.beginTransaction();
        try {
            session.delete(personal);
            transaccion.commit();
        } catch (Exception e) {
            respuesta = false;
            System.out.println("error"+e);
        }
        session.close();
        return respuesta;

    }
       }

  
    

