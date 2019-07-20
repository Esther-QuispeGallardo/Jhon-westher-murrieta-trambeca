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
import javax.swing.JOptionPane;
import org.hibernate.Session;

/**
 *
 * @author MARTIN
 */
public class prueba5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
   ArrayList<Mascota> lista = new ArrayList<>();

        MascotaDao mascotadao = new MascotaDao();

   Session sesion =HibernateUtil.getSessionFactory().openSession();

        lista = mascotadao.listarNombreMascota(sesion);
       // System.out.println("ID\t"+"NOMBRE MASCOTA\t"+"NOMBRE CLIENTE\t"+"RAZA");
        for (Mascota mascota : lista) {
            
           JOptionPane.showMessageDialog(null,"ID :"+mascota.getIdMascota() +" \nNOMBRE MASCOTA: "+ mascota.getNombreMascota()+"\nNOMBRE CLIENTE: "+mascota.getNombreCliente()+"\nRAZA: "+mascota.getRaza());
    }
        sesion.close();
    }
}
