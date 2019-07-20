/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prueba;

import Dao.MascotaDao;
import Utilitarios.HibernateUtil;
import javax.swing.JOptionPane;
import org.hibernate.Session;

/**
 *
 * @author MARTIN
 */
public class prueba7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      int contar;
        MascotaDao mascotadao = new MascotaDao();

  Session sesion =HibernateUtil.getSessionFactory().openSession();

        contar = mascotadao.contarResgistro(sesion);
       JOptionPane.showMessageDialog(null,"cantidad de registro :" + contar );
        //System.out.println("cantidad de registro :" + cont);
    }
    
}
