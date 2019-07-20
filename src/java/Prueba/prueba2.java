/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prueba;

import Dao.MascotaDao;
import Utilitarios.HibernateUtil;
import entidades.Mascota;
import java.util.ArrayList;
import org.hibernate.Session;

/**
 *
 * @author MARTIN
 */
public class prueba2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
              ArrayList<Mascota> lista=new ArrayList<>();
        MascotaDao mascotadao=new MascotaDao();
        Session sesion =HibernateUtil.getSessionFactory().openSession();
       lista = mascotadao.listarMascota();
       for(Mascota mascota:lista){
           System.out.println(mascota.getNombreMascota());
           
       }
       sesion.close();
    }
    
}
