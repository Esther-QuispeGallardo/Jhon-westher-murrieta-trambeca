/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import Dao.TipoAtencionDao;
import entidades.Tipoatencion;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.hibernate.HibernateException;

/**
 *
 * @author Computer
 */
@ManagedBean
//@RequestScoped
@ViewScoped
public class TipoAtencionBean implements Serializable {

    /**
     * SE COMUNICA CON EL DAO
     */
    private Tipoatencion tipoAtencion;
    private boolean  banderSelect=false;

    public TipoAtencionBean() {
        this.tipoAtencion = new Tipoatencion();

    }

    public Tipoatencion getTipoatencion() {
        return tipoAtencion;
    }

    public void setTipoatencion(Tipoatencion tipoAtencion) {
        this.tipoAtencion = tipoAtencion;
    }

    public String guardarTipoatencion() {
        try {

            TipoAtencionDao tipoAtencionDao = new TipoAtencionDao();
            boolean respuesta = tipoAtencionDao.guardarTipoAtencion(tipoAtencion);
            if (respuesta) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se regidtro correctamente"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puedo registrar"));
            }
        } catch (HibernateException e) {
            ///transation.rollback();  -- regresa a la anterior
            System.out.println("Error::: " + e);
        }
        return "/RegistrarTipoatencion";
    }

    public String actualizarTipoatencion() {
        try {
            TipoAtencionDao tipoAtencionDao = new TipoAtencionDao();
            boolean respuesta = tipoAtencionDao.actualizarTipoAtencion(tipoAtencion);
            if (respuesta){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se actualizo correctamente"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puedo actualizar"));
            }
        } catch (HibernateException e) {
            ///transation.rollback();  -- regresa a la anterior
            System.out.println("Error::: " + e);
        }
        return "/RegistrarTipoatencion";

    }

    public ArrayList<Tipoatencion> listarTipoatencions() {
        ArrayList<Tipoatencion> lista = new ArrayList<>();
        TipoAtencionDao tipoAtencionDao = new TipoAtencionDao();
        lista = tipoAtencionDao.listarTipoAtencion();
        return lista;
    }

    public String eliminar() {
        TipoAtencionDao tipoAtencionDao = new TipoAtencionDao();
        boolean respuesta = tipoAtencionDao.eliminarTipoAtencion(tipoAtencion);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se elimino correctamente"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puedo eliminar"));
        }
        return "/RegistrarTipoatencion";
    }

    public String limpiar() {
        return "/RegistrarTipoatencion";
    }
    public  void selectBandera(){
        banderSelect=true;
    }

    public boolean isBanderSelect() {
        return banderSelect;
    }

    public void setBanderSelect(boolean banderSelect) {
        this.banderSelect = banderSelect;
    }
    

}
