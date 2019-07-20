/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Utilitarios.HibernateUtil;
import entidades.Mascota;
import interfaces.IMascota;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author MARTIN
 */
public class MascotaDao implements IMascota{

    @Override
    public boolean guardarMascota(Mascota mascota) {
        boolean respuesta=true;
      Session session =HibernateUtil.getSessionFactory().openSession();
     Transaction transaction=session.beginTransaction();
        try {
            session.save(mascota);
             transaction.commit();
        } catch (Exception e) {
            respuesta=false;
        }
    
        session.close();
        return respuesta;
    }

    @Override
    public ArrayList<Mascota> listarMascota() {
          Session session =HibernateUtil.getSessionFactory().openSession();
          ArrayList<Mascota> milista=new ArrayList<>();
        Query query=session.createQuery("FROM Mascota");
        //ejecutar la consulta y obtener la listaz
        milista=(ArrayList<Mascota>) query.list();
        session.close();
        return milista;
    }

    @Override
    public boolean actualizar(Mascota mascota) {
        
         Session session =HibernateUtil.getSessionFactory().openSession();
        
            boolean respuesta= true;
        
        
        Transaction transaccion = session.beginTransaction();
        try{
        session.update(mascota);
        transaccion.commit();
        } catch (Exception e) {
            respuesta = false;
            System.out.println("ERORORR"+e);
        }
        session.close();
        return respuesta;
    }

    @Override
    public ArrayList<Mascota> listarRaza(Session sesion) {
         String hql = " from Mascota where raza='pastor Aleman'";        
        Query query = sesion.createQuery(hql);
        List< Mascota > lista= (List< Mascota >) query.list();
	return (ArrayList<Mascota>) lista;

    }

    @Override
    public ArrayList<Mascota> listarNombreMascota(Session sesion) {
          String hql = " from Mascota where nombreMascota='Sandor'";        
        Query query = sesion.createQuery(hql);
        List< Mascota > lista= (List< Mascota >) query.list();
	return (ArrayList<Mascota>) lista;
    }

    @Override
    public Integer contarResgistro(Session sesion) {
                 String hql = "select count(*) from Mascota";
        Query query = sesion.createQuery(hql);
        Long FilasTab=(Long) query.uniqueResult();
        Integer cont=FilasTab.intValue();
        return cont;
        
    }

    @Override
    public boolean eliminar(Mascota mascota) {
        boolean respuesta = true;
         Session session =HibernateUtil.getSessionFactory().openSession();
        Transaction transaccion = session.beginTransaction();
        try {
            session.delete(mascota);
            transaccion.commit();
        } catch (Exception e) {
            respuesta = false;
            System.out.println("error"+e);
        }
        session.close();
        return respuesta;

    }
  
    }


   