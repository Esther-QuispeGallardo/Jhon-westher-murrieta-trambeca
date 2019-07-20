/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import Dao.PersonalDao;
import entidades.Personal;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.hibernate.HibernateException;

/**
 *
 * @author MARTIN
 */
@ManagedBean(name = "PersonalBean")
@ViewScoped
public class PersonalBean  implements Serializable{
     Personal personal;
      private boolean  banderaSelect=false;

    /**
     * Creates a new instance of MascotaBean
     */
    public PersonalBean() {
  this.personal=new Personal();
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }
    public String guardarPersonal() {

     try {

            PersonalDao personalDao = new PersonalDao();
            boolean respuesta= personalDao.guardarPersonal(personal);
            if(respuesta){
                FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("correcto", "regidtro exitoso"));
            }else{
                FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("error", "no se puedo registrar"));
            }
        } catch (HibernateException e) {
            ///transation.rollback();  -- regresa a la anterior
            System.out.println("Error::: " + e);
        }
        return "/RegistrarPersonal";
    }

    public String actualizarPersonal() {

    
        try {
             PersonalDao personalDao = new PersonalDao();
            boolean respuesta = personalDao.actualizarPersonal(personal);
            if(respuesta){
                FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("correcto", "regidtro exitoso"));
            }else{
                FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("error", "no se puedo registrar"));
            }
        } catch (Exception e) {
            
            System.out.println("");
        }
        return "/RegistrarPersonal";
    }

    public ArrayList<Personal> listar() {

        ArrayList<Personal> lista = new ArrayList<>();

        PersonalDao personalDao = new PersonalDao();
        lista = personalDao.listarPersonal();

        return lista;

    }
    public  String limpiar(){
        return "/RegistrarPersonal";
    }
     public  void selectBandera(){
        banderaSelect=true;
    }
    public String eliminarPersonal(){
         PersonalDao dao = new PersonalDao();
            boolean respuesta= dao.eliminarPersonal(personal);
            if(respuesta){
                
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Correcto","Registro Borrado con exito"));
            }else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error","No se pudo eliminar"));
            }
            return "/RegistrarPersonal";
        
    }

    public boolean isBanderaSelect() {
        return banderaSelect;
    }

    public void setBanderaSelect(boolean banderaSelect) {
        this.banderaSelect = banderaSelect;
    }
    
}
